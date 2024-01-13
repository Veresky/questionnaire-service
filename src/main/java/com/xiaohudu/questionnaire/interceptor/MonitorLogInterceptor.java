package com.xiaohudu.questionnaire.interceptor;

import com.xiaohudu.questionnaire.entity.MonitorLog;
import com.xiaohudu.questionnaire.service.monitor.MonitorLogService;
import com.xiaohudu.questionnaire.utils.ServletContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalDateTime;

public class MonitorLogInterceptor implements HandlerInterceptor {
  @Autowired
  private MonitorLogService monitorLogService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    request.setAttribute("time", LocalDateTime.now());

    return true;
  }
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    LocalDateTime startTime = (LocalDateTime)request.getAttribute("time");
    Duration duration = Duration.between(startTime, LocalDateTime.now());

    MonitorLog monitorLog = new MonitorLog();
    monitorLog.setPath(request.getServletPath());
    monitorLog.setMethod(request.getMethod());
    monitorLog.setStartTime(startTime);
    monitorLog.setDuration(duration.toMillis());
    monitorLog.setCode(ServletContextUtils.getResultCode());
    monitorLog.setIp(request.getRemoteHost());

    monitorLogService.save(monitorLog);
  }
}