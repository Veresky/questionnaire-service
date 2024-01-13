package com.xiaohudu.questionnaire.controller.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohudu.questionnaire.entity.SysDict;
import com.xiaohudu.questionnaire.service.sys.SysDictService;
import com.xiaohudu.questionnaire.utils.Result;
import com.xiaohudu.questionnaire.vo.req.IdReqVO;
import com.xiaohudu.questionnaire.vo.req.sys.SysDictPageReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sys/dict")
public class SysDictController {
  @Autowired
  private SysDictService sysDictService;

  /**
   * 分页
   * @param sysDictPageReqVO
   * @return Result
   */
  @PostMapping(path = "page")
  public Result page(@RequestBody SysDictPageReqVO sysDictPageReqVO) {
    IPage<SysDict> iPage = sysDictService.page(new Page<>(sysDictPageReqVO.getCurrent(), sysDictPageReqVO.getSize()), sysDictPageReqVO);
    return Result.success(iPage);
  }

  /**
   * 详情
   * @param idReqVO
   * @return Result
   */
  @PostMapping(path = "detail")
  public Result detail(@Validated @RequestBody IdReqVO idReqVO) {
    SysDict sysDict = sysDictService.getById(idReqVO.getId());
    return Result.success(sysDict);
  }

  /**
   * 编辑
   * @param sysDict
   * @return Result
   */
  @PostMapping(path = "edit")
  public Result edit(@Validated @RequestBody SysDict sysDict) {
    sysDictService.saveOrUpdate(sysDict);
    return Result.success();
  }

  /**
   * 删除
   * @param idReqVO
   * @return Result
   */
  @PostMapping(path = "delete")
  public Result delete(@Validated @RequestBody IdReqVO idReqVO) {
    sysDictService.removeWithSysDictItemById(idReqVO.getId());
    return Result.success();
  }

  /**
   * 全部字典（包含字典项）
   * @return Result
   */
  @PostMapping(path = "all")
  public Result all() {
    return Result.success(sysDictService.all());
  }
}
