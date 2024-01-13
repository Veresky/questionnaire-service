package com.xiaohudu.questionnaire.service.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohudu.questionnaire.entity.SysRole;
import com.xiaohudu.questionnaire.entity.SysUserRole;
import com.xiaohudu.questionnaire.mapper.sys.SysUserRoleMapper;
import com.xiaohudu.questionnaire.vo.req.sys.SysUserRolePageByUserReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleService extends ServiceImpl<SysUserRoleMapper, SysUserRole> {
  @Autowired
  private SysUserRoleMapper sysUserRoleMapper;

  public IPage<SysRole> pageByUserId(Page<SysRole> page, SysUserRolePageByUserReqVO sysUserRolePageByUserReqVO) {
    return sysUserRoleMapper.selectPageByUserId(page, sysUserRolePageByUserReqVO);
  }

  public void saveBatch(List<SysUserRole> sysUserRoleList) {
    sysUserRoleMapper.insertBatch(sysUserRoleList);
  }

  public List<SysRole> listByUserId(String userId) {
    return sysUserRoleMapper.selectListByUserId(userId);
  }
}
