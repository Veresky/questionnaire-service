package com.xiaohudu.questionnaire.controller.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohudu.questionnaire.entity.SysRole;
import com.xiaohudu.questionnaire.service.sys.SysRoleService;
import com.xiaohudu.questionnaire.utils.Result;
import com.xiaohudu.questionnaire.vo.req.IdReqVO;
import com.xiaohudu.questionnaire.vo.req.sys.SysRolePageReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sys/role")
public class SysRoleController {
  @Autowired
  private SysRoleService sysRoleService;

  /**
   * 分页
   * @param sysRolePageReqVO
   * @return Result
   */
  @PostMapping(path = "page")
  public Result page(@RequestBody SysRolePageReqVO sysRolePageReqVO) {
    IPage<SysRole> iPage = sysRoleService.page(new Page<>(sysRolePageReqVO.getCurrent(), sysRolePageReqVO.getSize()), sysRolePageReqVO);
    return Result.success(iPage);
  }

  /**
   * 详情
   * @param idReqVO
   * @return Result
   */
  @PostMapping(path = "detail")
  public Result detail(@Validated @RequestBody IdReqVO idReqVO) {
    SysRole sysRole = sysRoleService.getById(idReqVO.getId());
    return Result.success(sysRole);
  }

  /**
   * 编辑
   * @param sysRole
   * @return Result
   */
  @PostMapping(path = "edit")
  public Result edit(@Validated @RequestBody SysRole sysRole) {
    sysRoleService.saveOrUpdate(sysRole);
    return Result.success();
  }

  /**
   * 删除
   * @param idReqVO
   * @return Result
   */
  @PostMapping(path = "delete")
  public Result delete(@Validated @RequestBody IdReqVO idReqVO) {
    sysRoleService.removeWithRelationById(idReqVO.getId());
    return Result.success();
  }
}
