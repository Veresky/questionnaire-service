package com.xiaohudu.questionnaire.service.sys;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohudu.questionnaire.entity.SysModule;
import com.xiaohudu.questionnaire.entity.SysRoleModule;
import com.xiaohudu.questionnaire.mapper.sys.SysModuleMapper;
import com.xiaohudu.questionnaire.mapper.sys.SysRoleModuleMapper;
import com.xiaohudu.questionnaire.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysModuleService extends ServiceImpl<SysModuleMapper, SysModule> {
  @Autowired
  private SysModuleMapper sysModuleMapper;
  @Autowired
  private SysRoleModuleMapper sysRoleModuleMapper;
  public List<SysModule> tree() {
    LambdaQueryWrapper<SysModule> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    lambdaQueryWrapper.orderByAsc(SysModule::getSortNo);

    List<SysModule> sysModuleList = sysModuleMapper.selectList(lambdaQueryWrapper);
    return Utils.list2Tree(sysModuleList, null);
  }

  public void mySaveOrUpdate(SysModule sysModule) {
    if (StringUtils.isBlank(sysModule.getId())) { // 新增
      sysModuleMapper.myInsert(sysModule);
    } else { // 修改
      sysModule.setIdPath(sysModule.getParentIdPath() == null ? sysModule.getId() : sysModule.getParentIdPath() + "," + sysModule.getId());
      this.updateById(sysModule);
    }
  }

  @Transactional(rollbackFor = Exception.class)
  public void removeWithRelationById(String id) {
    if (this.removeById(id)) {
      LambdaQueryWrapper<SysModule> sysModuleLambdaQueryWrapper = new LambdaQueryWrapper<>();
      sysModuleLambdaQueryWrapper.like(SysModule::getIdPath, id);
      List<SysModule> sysModuleList = sysModuleMapper.selectList(sysModuleLambdaQueryWrapper);
      List<String> sysModuleIds = sysModuleList.stream().map(v -> v.getId()).collect(Collectors.toList());
      sysModuleMapper.delete(sysModuleLambdaQueryWrapper);

      LambdaQueryWrapper<SysRoleModule> sysRoleModuleLambdaQueryWrapper = new LambdaQueryWrapper<>();
      sysRoleModuleLambdaQueryWrapper.in(SysRoleModule::getModuleId, sysModuleIds);
      sysRoleModuleMapper.delete(sysRoleModuleLambdaQueryWrapper);
    }
  }

}
