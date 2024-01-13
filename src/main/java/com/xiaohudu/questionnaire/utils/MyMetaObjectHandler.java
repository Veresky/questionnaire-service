package com.xiaohudu.questionnaire.utils;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
  @Override
  public void insertFill(MetaObject metaObject) {
    String username = ServletContextUtils.getUsername();

    if (username != null) {
      this.setFieldValByName("createBy", username, metaObject);
    }

    this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    String username = ServletContextUtils.getUsername();

    if (username != null) {
      this.setFieldValByName("updateBy", username, metaObject);
    }
    this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
  }
}
