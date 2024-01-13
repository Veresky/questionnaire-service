package com.xiaohudu.questionnaire.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohudu.questionnaire.entity.SysRole;
import com.xiaohudu.questionnaire.vo.req.sys.SysRolePageReqVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
  IPage<SysRole> selectPage(Page<SysRole> page, SysRolePageReqVO sysRolePageReqVO);
}
