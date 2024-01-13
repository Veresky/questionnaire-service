package com.xiaohudu.questionnaire.controller.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohudu.questionnaire.entity.SysPermission;
import com.xiaohudu.questionnaire.entity.SysRolePermission;
import com.xiaohudu.questionnaire.service.sys.SysRolePermissionService;
import com.xiaohudu.questionnaire.utils.Result;
import com.xiaohudu.questionnaire.vo.req.sys.SysRolePermissionPageByRoleReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sys/rolePermission")
public class SysRolePermissionController {
  @Autowired
  private SysRolePermissionService sysRolePermissionService;

  /**
   * 分页 - byRole
   * @param sysRolePermissionPageByRoleReqVO
   * @return Result
   */
  @PostMapping(path = "pageByRole")
  public Result pageByRole(@RequestBody SysRolePermissionPageByRoleReqVO sysRolePermissionPageByRoleReqVO) {
    IPage<SysPermission> iPage = sysRolePermissionService.pageByRoleId(new Page<>(sysRolePermissionPageByRoleReqVO.getCurrent(), sysRolePermissionPageByRoleReqVO.getSize()), sysRolePermissionPageByRoleReqVO);
    return Result.success(iPage);
  }

  /**
   * 批量保存
   * @param sysRolePermissionList
   * @return Result
   */
  @PostMapping(path = "saveBatch")
  public Result saveBatch(@RequestBody List<SysRolePermission> sysRolePermissionList) {
    sysRolePermissionService.saveBatch(sysRolePermissionList);
    return Result.success();
  }

  /**
   * 批量删除
   * @param ids
   * @return Result
   */
  @PostMapping(path = "removeByIds")
  public Result removeByIds(@RequestBody List<String> ids) {
    sysRolePermissionService.removeByIds(ids);
    return Result.success();
  }
}
