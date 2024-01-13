package com.xiaohudu.questionnaire.service.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohudu.questionnaire.entity.*;
import com.xiaohudu.questionnaire.mapper.sys.SysRolePermissionMapper;
import com.xiaohudu.questionnaire.vo.req.sys.SysRolePermissionPageByRoleReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysRolePermissionService extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> {
  @Autowired
  private SysRolePermissionMapper sysRolePermissionMapper;

  public IPage<SysPermission> pageByRoleId(Page<SysPermission> page, SysRolePermissionPageByRoleReqVO sysRolePermissionPageByRoleReqVO) {
    return sysRolePermissionMapper.selectPageByRoleId(page, sysRolePermissionPageByRoleReqVO);
  }

  public List<String> pathListBySysRoleList(List<SysRole> sysRoleList) {
    List<SysPermission> sysPermissionList = sysRolePermissionMapper.selectListBySysRoleList(sysRoleList);
    return sysPermissionList.stream().map(v -> v.getPath()).collect(Collectors.toList());
  }

  public void saveBatch(List<SysRolePermission> sysRolePermissionList) {
    sysRolePermissionMapper.insertBatch(sysRolePermissionList);
  }
}
