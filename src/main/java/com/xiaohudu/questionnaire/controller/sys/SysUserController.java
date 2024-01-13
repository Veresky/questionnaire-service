package com.xiaohudu.questionnaire.controller.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohudu.questionnaire.constant.ResultCode;
import com.xiaohudu.questionnaire.entity.SysUser;
import com.xiaohudu.questionnaire.service.sys.SysUserService;
import com.xiaohudu.questionnaire.utils.Result;
import com.xiaohudu.questionnaire.vo.req.IdReqVO;
import com.xiaohudu.questionnaire.vo.req.sys.SysUserPageReqVO;
import com.xiaohudu.questionnaire.vo.req.sys.UpdatePasswordReqVO;
import com.xiaohudu.questionnaire.vo.res.sys.SysUserResVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sys/user")
public class SysUserController {
  @Autowired
  private SysUserService sysUserService;

  /**
   * 分页
   * @param sysUserPageReqVO
   * @return Result
   */
  @PostMapping(path = "page")
  public Result page(@RequestBody SysUserPageReqVO sysUserPageReqVO) {
    IPage<SysUserResVO> iPage = sysUserService.page(new Page<>(sysUserPageReqVO.getCurrent(), sysUserPageReqVO.getSize()), sysUserPageReqVO);
    return Result.success(iPage);
  }

  /**
   * 详情
   * @param idReqVO
   * @return Result
   */
  @PostMapping(path = "detail")
  public Result detail(@Validated @RequestBody IdReqVO idReqVO) {
    SysUser sysUser = sysUserService.getById(idReqVO.getId());
    sysUser.setSalt(null);
    sysUser.setPassword(null);

    return Result.success(sysUser);
  }

  /**
   * 编辑
   * @param sysUser
   * @return Result
   */
  @PostMapping(path = "edit")
  public Result edit(@Validated @RequestBody SysUser sysUser) {
    // 新增
    if (StringUtils.isBlank(sysUser.getId()) && StringUtils.isBlank(sysUser.getPassword())) {
      return Result.fail(ResultCode.BAD_REQUEST, "密码不能为空");
    }

    sysUserService.mySaveOrUpdate(sysUser);
    return Result.success();
  }

  /**
   * 删除
   * @param idReqVO
   * @return Result
   */
  @PostMapping(path = "delete")
  public Result delete(@Validated @RequestBody IdReqVO idReqVO) {
    sysUserService.removeWithRelationById(idReqVO.getId());
    return Result.success();
  }

  /**
   * 修改密码
   * @param updatePasswordReqVO
   * @return Result
   */
  @PostMapping(path = "updatePassword")
  public Result updatePassword(@Validated @RequestBody UpdatePasswordReqVO updatePasswordReqVO) {
    return sysUserService.updatePassWord(updatePasswordReqVO) ? Result.success() : Result.fail(ResultCode.BAD_REQUEST_OLD_PASSWORD);
  }

  /**
   * 重置密码
   * @param idReqVO
   * @return Result
   */
  @PostMapping(path = "resetPassword")
  public Result resetPassword(@Validated @RequestBody IdReqVO idReqVO) {
    String newPassword = sysUserService.resetPassword(idReqVO.getId());
    return Result.success(newPassword);
  }
}
