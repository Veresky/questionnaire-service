package com.xiaohudu.questionnaire.controller.sys;

import com.xiaohudu.questionnaire.entity.SysModule;
import com.xiaohudu.questionnaire.service.sys.SysModuleService;
import com.xiaohudu.questionnaire.utils.Result;
import com.xiaohudu.questionnaire.vo.req.IdReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sys/module")
public class SysModuleController {
  @Autowired
  private SysModuleService sysModuleService;

  /**
   * 树
   * @return Result
   */
  @PostMapping(path = "tree")
  public Result tree() {
    List<SysModule> tree = sysModuleService.tree();
    return Result.success(tree);
  }

  /**
   * 详情
   * @param idReqVO
   * @return Result
   */
  @PostMapping(path = "detail")
  public Result detail(@Validated @RequestBody IdReqVO idReqVO) {
    SysModule sysModule = sysModuleService.getById(idReqVO.getId());
    return Result.success(sysModule);
  }

  /**
   * 编辑
   * @param sysModule
   * @return Result
   */
  @PostMapping(path = "edit")
  public Result edit(@Validated @RequestBody SysModule sysModule) {
    sysModuleService.mySaveOrUpdate(sysModule);
    return Result.success();
  }

  /**
   * 删除
   * @param idReqVO
   * @return Result
   */
  @PostMapping(path = "delete")
  public Result delete(@Validated @RequestBody IdReqVO idReqVO) {
    sysModuleService.removeWithRelationById(idReqVO.getId());
    return Result.success();
  }
}
