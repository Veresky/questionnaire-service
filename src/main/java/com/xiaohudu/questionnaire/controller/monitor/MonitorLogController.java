package com.xiaohudu.questionnaire.controller.monitor;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohudu.questionnaire.entity.MonitorLog;
import com.xiaohudu.questionnaire.service.monitor.MonitorLogService;
import com.xiaohudu.questionnaire.utils.Result;
import com.xiaohudu.questionnaire.vo.req.IdReqVO;
import com.xiaohudu.questionnaire.vo.req.monitor.MonitorLogPageReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("monitor/log")
public class MonitorLogController {
  @Autowired
  private MonitorLogService monitorLogService;

  /**
   * 分页
   * @param monitorLogPageReqVO
   * @return Result
   */
  @PostMapping(path = "page")
  public Result page(@RequestBody MonitorLogPageReqVO monitorLogPageReqVO) {
    IPage<MonitorLog> iPage = monitorLogService.page(new Page<>(monitorLogPageReqVO.getCurrent(), monitorLogPageReqVO.getSize()), monitorLogPageReqVO);
    return Result.success(iPage);
  }

  /**
   * 详情
   * @param idReqVO
   * @return Result
   */
  @PostMapping(path = "detail")
  public Result detail(@Validated @RequestBody IdReqVO idReqVO) {
    MonitorLog monitorLog = monitorLogService.getById(idReqVO.getId());
    return Result.success(monitorLog);
  }
}
