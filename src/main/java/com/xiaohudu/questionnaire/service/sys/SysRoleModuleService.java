package com.xiaohudu.questionnaire.service.sys;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohudu.questionnaire.entity.SysModule;
import com.xiaohudu.questionnaire.entity.SysRole;
import com.xiaohudu.questionnaire.entity.SysRoleModule;
import com.xiaohudu.questionnaire.mapper.sys.SysRoleModuleMapper;
import com.xiaohudu.questionnaire.utils.Utils;
import com.xiaohudu.questionnaire.vo.req.sys.SysRoleModuleSaveBatchReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SysRoleModuleService extends ServiceImpl<SysRoleModuleMapper, SysRoleModule> {
  @Autowired
  private SysRoleModuleMapper sysRoleModuleMapper;
  @Autowired
  private SysModuleService sysModuleService;

  public List<String> moduleIdListByRoleId(String roleId) {
    LambdaQueryWrapper<SysRoleModule> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    lambdaQueryWrapper.eq(SysRoleModule::getRoleId, roleId);

    List<SysRoleModule> sysRoleModuleList = sysRoleModuleMapper.selectList(lambdaQueryWrapper);
    List<String> moduleIdList = new ArrayList<>();

    for (SysRoleModule sysRoleModule : sysRoleModuleList) {
      moduleIdList.add(sysRoleModule.getModuleId());
    }

    return moduleIdList;
  }

  @Transactional(rollbackFor = Exception.class)
  public void updateBatch(SysRoleModuleSaveBatchReqVO sysRoleModuleSaveBatchReqVO) {
    String roleId = sysRoleModuleSaveBatchReqVO.getRoleId();
    List<String> moduleIdList = sysRoleModuleSaveBatchReqVO.getModuleIdList();

    LambdaQueryWrapper<SysRoleModule> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    lambdaQueryWrapper.eq(SysRoleModule::getRoleId, roleId);
    sysRoleModuleMapper.delete(lambdaQueryWrapper);

    List<SysRoleModule> sysRoleModuleList = new ArrayList<>();

    for (String moduleId : moduleIdList) {
      SysRoleModule sysRoleModule = new SysRoleModule();
      sysRoleModule.setModuleId(moduleId);
      sysRoleModule.setRoleId(roleId);
      sysRoleModuleList.add(sysRoleModule);
    }

    this.saveBatch(sysRoleModuleList);
  }

  public List<SysModule> treeBySysRoleList(List<SysRole> sysRoleList) {
    List<SysModule> sysModuleList = sysRoleModuleMapper.selectListBySysRoleList(sysRoleList);
    List<String> sysModuleIdsRet = new ArrayList<>();

    sysModuleList.forEach(v -> {
      Arrays.asList(v.getIdPath().split(",")).forEach(vv -> {
        if (!sysModuleIdsRet.contains(vv)) {
          sysModuleIdsRet.add(vv);
        }
      });
    });

    LambdaQueryWrapper<SysModule> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    lambdaQueryWrapper.in(SysModule::getId, sysModuleIdsRet).orderByAsc(SysModule::getSortNo);

    return Utils.list2Tree(sysModuleService.list(lambdaQueryWrapper), null);
  }

}
