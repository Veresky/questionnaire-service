package com.xiaohudu.questionnaire.controller.sys;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaohudu.questionnaire.entity.SysDictItem;
import com.xiaohudu.questionnaire.service.sys.SysDictItemService;
import com.xiaohudu.questionnaire.utils.Result;
import com.xiaohudu.questionnaire.vo.req.IdReqVO;
import com.xiaohudu.questionnaire.vo.req.sys.SysDictItemReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sys/dictItem")
public class SysDictItemController {
  @Autowired
  private SysDictItemService sysDictItemService;

  /**
   * 列表
   * @param sysDictItemReqVO
   * @return Result
   */
  @PostMapping(path = "list")
  public Result list(@RequestBody SysDictItemReqVO sysDictItemReqVO) {
    LambdaQueryWrapper<SysDictItem> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    lambdaQueryWrapper
            .eq(SysDictItem::getDictId, sysDictItemReqVO.getDictId())
            .orderByAsc(SysDictItem::getSortNo);
    List<SysDictItem> sysDictItemList = sysDictItemService.list(lambdaQueryWrapper);
    return Result.success(sysDictItemList);
  }

  /**
   * 详情
   * @param idReqVO
   * @return Result
   */
  @PostMapping(path = "detail")
  public Result detail(@Validated @RequestBody IdReqVO idReqVO) {
    SysDictItem sysDictItem = sysDictItemService.getById(idReqVO.getId());
    return Result.success(sysDictItem);
  }

  /**
   * 编辑
   * @param sysDictItem
   * @return Result
   */
  @PostMapping(path = "edit")
  public Result edit(@Validated @RequestBody SysDictItem sysDictItem) {
    sysDictItemService.saveOrUpdate(sysDictItem);
    return Result.success();
  }

  /**
   * 删除
   * @param idReqVO
   * @return Result
   */
  @PostMapping(path = "delete")
  public Result delete(@Validated @RequestBody IdReqVO idReqVO) {
    sysDictItemService.removeById(idReqVO.getId());
    return Result.success();
  }
}
