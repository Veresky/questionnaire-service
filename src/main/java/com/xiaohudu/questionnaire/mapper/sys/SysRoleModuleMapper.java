package com.xiaohudu.questionnaire.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaohudu.questionnaire.entity.SysModule;
import com.xiaohudu.questionnaire.entity.SysRole;
import com.xiaohudu.questionnaire.entity.SysRoleModule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleModuleMapper extends BaseMapper<SysRoleModule> {
  List<SysModule> selectListBySysRoleList(List<SysRole> sysRoleList);
}
