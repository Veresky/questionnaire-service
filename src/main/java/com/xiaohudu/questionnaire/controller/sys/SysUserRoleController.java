package com.xiaohudu.questionnaire.controller.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohudu.questionnaire.entity.SysRole;
import com.xiaohudu.questionnaire.entity.SysUserRole;
import com.xiaohudu.questionnaire.service.sys.SysUserRoleService;
import com.xiaohudu.questionnaire.utils.Result;
import com.xiaohudu.questionnaire.vo.req.sys.SysUserRolePageByUserReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sys/userRole")
public class SysUserRoleController {
  @Autowired
  private SysUserRoleService sysUserRoleService;

  /**
   * 分页 - byUser
   * @param sysUserRolePageByUserReqVO
   * @return Result
   */
  @PostMapping(path = "pageByUser")
  public Result pageByUser(@RequestBody SysUserRolePageByUserReqVO sysUserRolePageByUserReqVO) {
    IPage<SysRole> iPage = sysUserRoleService.pageByUserId(new Page<>(sysUserRolePageByUserReqVO.getCurrent(), sysUserRolePageByUserReqVO.getSize()), sysUserRolePageByUserReqVO);
    return Result.success(iPage);
  }

  /**
   * 批量保存
   * @param sysUserRoleList
   * @return Result
   */
  @PostMapping(path = "saveBatch")
  public Result saveBatch(@RequestBody List<SysUserRole> sysUserRoleList) {
    sysUserRoleService.saveBatch(sysUserRoleList);
    return Result.success();
  }

  /**
   * 批量删除
   * @param ids
   * @return Result
   */
  @PostMapping(path = "removeByIds")
  public Result removeByIds(@RequestBody List<String> ids) {
    sysUserRoleService.removeByIds(ids);
    return Result.success();
  }
}
