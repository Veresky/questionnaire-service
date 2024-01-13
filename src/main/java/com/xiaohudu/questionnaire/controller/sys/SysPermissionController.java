package com.xiaohudu.questionnaire.controller.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohudu.questionnaire.entity.SysPermission;
import com.xiaohudu.questionnaire.service.sys.SysPermissionService;
import com.xiaohudu.questionnaire.utils.Result;
import com.xiaohudu.questionnaire.vo.req.IdReqVO;
import com.xiaohudu.questionnaire.vo.req.sys.SysPermissionPageReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sys/permission")
public class SysPermissionController {
  @Autowired
  private SysPermissionService sysPermissionService;

  /**
   * 分页
   * @param sysPermissionPageReqVO
   * @return Result
   */
  @PostMapping(path = "page")
  public Result page(@RequestBody SysPermissionPageReqVO sysPermissionPageReqVO) {
    IPage<SysPermission> iPage = sysPermissionService.page(new Page<>(sysPermissionPageReqVO.getCurrent(), sysPermissionPageReqVO.getSize()), sysPermissionPageReqVO);
    return Result.success(iPage);
  }

  /**
   * 详情
   * @param idReqVO
   * @return Result
   */
  @PostMapping(path = "detail")
  public Result detail(@Validated @RequestBody IdReqVO idReqVO) {
    SysPermission sysPermission = sysPermissionService.getById(idReqVO.getId());
    return Result.success(sysPermission);
  }

  /**
   * 编辑
   * @param sysPermission
   * @return Result
   */
  @PostMapping(path = "edit")
  public Result edit(@Validated @RequestBody SysPermission sysPermission) {
    sysPermissionService.saveOrUpdate(sysPermission);
    sysPermissionService.setPathListToRedis();
    return Result.success();
  }

  /**
   * 批量删除
   * @param ids
   * @return Result
   */
  @PostMapping(path = "removeByIds")
  public Result removeByIds(@RequestBody List<String> ids) {
    sysPermissionService.removeWithRelationByIds(ids);
    return Result.success();
  }
}
