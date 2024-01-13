package com.xiaohudu.questionnaire.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohudu.questionnaire.entity.SysRole;
import com.xiaohudu.questionnaire.entity.SysUserRole;
import com.xiaohudu.questionnaire.vo.req.sys.SysUserRolePageByUserReqVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
  IPage<SysRole> selectPageByUserId(Page<SysRole> page, SysUserRolePageByUserReqVO sysUserRolePageByUserReqVO);

  int insertBatch(List<SysUserRole> sysUserRoleList);

  List<SysRole> selectListByUserId(String userId);
}
