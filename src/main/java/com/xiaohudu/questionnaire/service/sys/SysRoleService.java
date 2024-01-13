package com.xiaohudu.questionnaire.service.sys;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohudu.questionnaire.entity.*;
import com.xiaohudu.questionnaire.mapper.sys.SysRoleMapper;
import com.xiaohudu.questionnaire.vo.req.sys.SysRolePageReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysRoleService extends ServiceImpl<SysRoleMapper, SysRole> {
  @Autowired
  private SysRoleMapper sysRoleMapper;
  @Autowired
  private SysRoleModuleService sysRoleModuleService;
  @Autowired
  private SysRolePermissionService sysRolePermissionService;

  public IPage<SysRole> page(Page<SysRole> page, SysRolePageReqVO sysRolePageReqVO) {
    LambdaQueryWrapper<SysRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    lambdaQueryWrapper
            .eq(sysRolePageReqVO.getRoleCode() != null, SysRole::getRoleCode, sysRolePageReqVO.getRoleCode())
            .like(sysRolePageReqVO.getRoleName() != null, SysRole::getRoleName, sysRolePageReqVO.getRoleName())
            .orderByDesc(SysRole::getUpdateTime, SysRole::getCreateTime);

    return sysRoleMapper.selectPage(page, lambdaQueryWrapper);
  }

  @Transactional(rollbackFor = Exception.class)
  public void removeWithRelationById(String id) {
    if (this.removeById(id)) {
      LambdaQueryWrapper<SysRoleModule> sysRoleModuleLambdaQueryWrapper = new LambdaQueryWrapper<>();
      sysRoleModuleLambdaQueryWrapper.eq(SysRoleModule::getRoleId, id);
      sysRoleModuleService.remove(sysRoleModuleLambdaQueryWrapper);
      LambdaQueryWrapper<SysRolePermission> sysRolePermissionLambdaQueryWrapper = new LambdaQueryWrapper<>();
      sysRolePermissionLambdaQueryWrapper.eq(SysRolePermission::getRoleId, id);
      sysRolePermissionService.remove(sysRolePermissionLambdaQueryWrapper);
    }
  }
}
