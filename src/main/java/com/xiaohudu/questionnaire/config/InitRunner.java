package com.xiaohudu.questionnaire.config;

import com.xiaohudu.questionnaire.service.sys.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class InitRunner {
  @Autowired
  private SysPermissionService sysPermissionService;

  /**
   * 初始化数据
   */
  @PostConstruct
  public void init() {
    initRedis();
  }

  private void initRedis() {
    sysPermissionService.setPathListToRedis();
  }
}
