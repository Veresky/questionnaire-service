package com.xiaohudu.questionnaire.constant;

public class Constant {
  /**
   * redis中存储token、微信token、接口权限
   */
  public final static String REDIS_TOKEN_KEY_PREFIX = "QUESTIONNAIRE_TOKEN:";
  public final static int REDIS_TOKEN_EXPIRE = 3; // 单位：小时
  public final static String REDIS_WX_TOKEN_KEY = "QUESTIONNAIRE_WX_TOKEN";
  public final static int REDIS_WX_TOKEN_EXPIRE = 60 * 2 - 10; // 单位：分钟
  public final static String REDIS_SYS_PERMISSION_KEY = "QUESTIONNAIRE_SYS_PERMISSION";

  /**
   * date格式化
   */
  public final static String DATE_FORMAT_PATTERN_1 = "yyyy-MM-dd HH:mm:ss.SSS";
  public final static String DATE_FORMAT_PATTERN_2 = "yyyy-MM-dd HH:mm:ss";
  public final static String DATE_FORMAT_PATTERN_3 = "yyyy-MM-dd";

  /**
   * 中文数字映射表
   */
  public final static String[] CHINESE_NUMBER_MAP = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
}
