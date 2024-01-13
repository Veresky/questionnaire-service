package com.xiaohudu.questionnaire.service.sys;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohudu.questionnaire.entity.MonitorLog;
import com.xiaohudu.questionnaire.entity.SysDict;
import com.xiaohudu.questionnaire.entity.SysUser;
import com.xiaohudu.questionnaire.entity.SysUserRole;
import com.xiaohudu.questionnaire.mapper.sys.SysUserMapper;
import com.xiaohudu.questionnaire.utils.ServletContextUtils;
import com.xiaohudu.questionnaire.utils.Utils;
import com.xiaohudu.questionnaire.vo.req.sys.SysUserPageReqVO;
import com.xiaohudu.questionnaire.vo.req.sys.UpdatePasswordReqVO;
import com.xiaohudu.questionnaire.vo.res.sys.SysUserResVO;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> {
  @Autowired
  private SysUserMapper sysUserMapper;
  @Autowired
  private SysRoleService sysRoleService;
  @Autowired
  private SysUserRoleService sysUserRoleService;

  public IPage<SysUserResVO> page(Page<SysUser> page, SysUserPageReqVO sysUserPageReqVO) {
    LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    lambdaQueryWrapper
            .like(sysUserPageReqVO.getUsername() != null, SysUser::getUsername, sysUserPageReqVO.getUsername())
            .like(sysUserPageReqVO.getRealname() != null, SysUser::getRealname, sysUserPageReqVO.getRealname())
            .orderByDesc(SysUser::getUpdateTime, SysUser::getCreateTime);

    return sysUserMapper.selectPage(page, lambdaQueryWrapper).convert(sysUser -> {
      SysUserResVO sysUserResVO = new SysUserResVO();
      BeanUtils.copyProperties(sysUser, sysUserResVO);

      return sysUserResVO;
    });
  }

  public void mySaveOrUpdate(SysUser sysUser) {
    // 新增
    if (StringUtils.isBlank(sysUser.getId())) {
      setNewSaltAndPassWord(sysUser, sysUser.getPassword());
    }

    this.saveOrUpdate(sysUser);
  }

  /**
   * 更新密码
   * @param updatePasswordReqVO
   * @return
   */
  public boolean updatePassWord(UpdatePasswordReqVO updatePasswordReqVO) {
    SysUser sysUser = getByUserName(ServletContextUtils.getUsername());

    if (Utils.encodePassword(updatePasswordReqVO.getOldPassword(), sysUser.getSalt()).equals(sysUser.getPassword())) {
      SysUser sysUserRet = new SysUser();
      sysUserRet.setId(sysUser.getId());
      setNewSaltAndPassWord(sysUserRet, updatePasswordReqVO.getNewPassword());

      this.updateById(sysUserRet);
      return true;
    } else {
      return false;
    }
  }

  /**
   * 重置密码
   * @param userId
   * @return
   */
  public String resetPassword(String userId) {
    String newPassword = RandomStringUtils.randomAlphanumeric(6);
    SysUser sysUserRet = new SysUser();
    sysUserRet.setId(userId);
    setNewSaltAndPassWord(sysUserRet, DigestUtils.md5DigestAsHex(newPassword.getBytes()).toUpperCase());

    this.updateById(sysUserRet);

    return newPassword;
  }

  @Transactional(rollbackFor = Exception.class)
  public void removeWithRelationById(String id) {
    if (this.removeById(id)) {
      LambdaQueryWrapper<SysUserRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
      lambdaQueryWrapper.eq(SysUserRole::getUserId, id);
      sysUserRoleService.remove(lambdaQueryWrapper);
    }
  }

  public SysUser getByUserName(String username) {
    LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    lambdaQueryWrapper.eq(SysUser::getUsername, username);
    return sysUserMapper.selectOne(lambdaQueryWrapper);
  }

  /**
   * 设置新盐值和密码
   * @param sysUser
   * @param password
   */
  private void setNewSaltAndPassWord(SysUser sysUser, String password) {
    String salt = RandomStringUtils.randomAlphanumeric(6);
    sysUser.setSalt(salt);
    sysUser.setPassword(Utils.encodePassword(password, salt));
  }
}
