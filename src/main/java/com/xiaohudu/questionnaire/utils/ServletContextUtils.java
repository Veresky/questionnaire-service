package com.xiaohudu.questionnaire.utils;

import javax.servlet.ServletContext;

public class ServletContextUtils {
  public static ServletContext getServletContext() {
    return (ServletContext) ApplicationContextUtil.getBean("servletContext");
  }

  public static void setResultCode(Integer resultCode) {
    getServletContext().setAttribute("resultCode", resultCode);
  }

  public static Integer getResultCode() {
    return (Integer) getServletContext().getAttribute("resultCode");
  }

  public static void setUsername(String username) {
    getServletContext().setAttribute("username", username);
  }

  public static String getUsername() {
    return (String) getServletContext().getAttribute("username");
  }

}
