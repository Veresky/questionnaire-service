package com.xiaohudu.questionnaire.service.monitor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohudu.questionnaire.entity.MonitorLog;
import com.xiaohudu.questionnaire.mapper.monitor.MonitorLogMapper;
import com.xiaohudu.questionnaire.vo.req.monitor.MonitorLogPageReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitorLogService extends ServiceImpl<MonitorLogMapper, MonitorLog> {
  @Autowired
  private MonitorLogMapper monitorLogMapper;

  public IPage<MonitorLog> page(Page<MonitorLog> page, MonitorLogPageReqVO monitorLogPageReqVO) {
    LambdaQueryWrapper<MonitorLog> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    lambdaQueryWrapper
            .eq(monitorLogPageReqVO.getCreateBy() != null, MonitorLog::getCreateBy, monitorLogPageReqVO.getCreateBy())
            .eq(monitorLogPageReqVO.getCode() != null, MonitorLog::getCode, monitorLogPageReqVO.getCode())
            .orderByDesc(MonitorLog::getStartTime);

    return monitorLogMapper.selectPage(page, lambdaQueryWrapper);
  }
}
