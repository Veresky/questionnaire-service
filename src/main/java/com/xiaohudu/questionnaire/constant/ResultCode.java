package com.xiaohudu.questionnaire.constant;

public enum ResultCode {
  /* 成功状态码 */
  SUCCESS(200, "成功"),

  /* 用户错误：4XX */
  BAD_REQUEST(400, "参数有误"),
  BAD_REQUEST_USERNAME_PASSWORD(400, "账号或密码有误"),
  BAD_REQUEST_OLD_PASSWORD(400, "旧密码有误"),
  BAD_TOKEN(401, "请登录"),
  NO_ROLE(402, "没有赋予角色，请联系管理员"),
  NO_PERMISSION(403, "没有相关权限，请联系管理员"),
  NO_SYSTEM_PERMISSION(403401, "没有系统权限，请联系管理员"),

  /* 服务错误：5XX */
  SERVER_ERROR(500, "系统异常"),
  THIRD_SERVER_ERROR(501, "第三方系统异常");

  public final int code;
  public final String msg;

  ResultCode(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}
