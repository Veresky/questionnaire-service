package com.xiaohudu.questionnaire.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware {
  private static ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext context) throws BeansException {
    applicationContext = context;
  }

  /**
   * 获取 applicationContext
   * @return
   */
  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }
  /**
   * 通过 name 获取 Bean.
   * @param name
   * @return
   */
  public static Object getBean(String name) {
    return getApplicationContext().getBean(name);
  }

  /**
   * 通过 class 获取 Bean.
   * @param clazz
   * @param <T>
   * @return
   */
  public static <T> T getBean(Class<T> clazz) {
    return (T) getApplicationContext().getBean(clazz);
  }

  /**
   * 通过 name 以及 Clazz 获取 Bean
   * @param name
   * @param clazz
   * @param <T>
   * @return
   */
  public static <T> T getBean(String name, Class<T> clazz) {
    return (T) getApplicationContext().getBean(name, clazz);
  }

}
