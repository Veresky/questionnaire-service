package com.xiaohudu.questionnaire.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohudu.questionnaire.entity.SysPermission;
import com.xiaohudu.questionnaire.entity.SysRole;
import com.xiaohudu.questionnaire.entity.SysRolePermission;
import com.xiaohudu.questionnaire.vo.req.sys.SysRolePermissionPageByRoleReqVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {
  IPage<SysPermission> selectPageByRoleId(Page<SysPermission> page, SysRolePermissionPageByRoleReqVO sysRolePermissionPageByRoleReqVO);
  List<SysPermission> selectListBySysRoleList(List<SysRole> sysRoleList);
  int insertBatch(List<SysRolePermission> sysRolePermissionList);
}
