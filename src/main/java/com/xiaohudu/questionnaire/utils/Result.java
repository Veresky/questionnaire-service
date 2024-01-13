package com.xiaohudu.questionnaire.utils;

import com.xiaohudu.questionnaire.constant.ResultCode;
import lombok.Data;

@Data
public class Result {
  private int code;
  private String msg;
  private Object data;

  public static Result success() {
    ServletContextUtils.setResultCode(ResultCode.SUCCESS.code);

    Result result = new Result();
    result.setCode(ResultCode.SUCCESS.code);
    result.setMsg(ResultCode.SUCCESS.msg);
    return result;
  }

  public static Result success(Object data) {
    Result result = Result.success();
    result.setData(data);
    return result;
  }

  public static Result fail(int code) {
    ServletContextUtils.setResultCode(code);

    Result result = new Result();
    result.setCode(code);
    return result;
  }

  public static Result fail(int code, Object data) {
    Result result = Result.fail(code);
    result.setData(data);
    return result;
  }

  public static Result fail(int code, String msg) {
    Result result = Result.fail(code);
    result.setMsg(msg);
    return result;
  }

  public static Result fail(int code, String msg, Object data) {
    Result result = Result.fail(code);
    result.setMsg(msg);
    result.setData(data);
    return result;
  }

  public static Result fail(ResultCode resultCode) {
    Result result = Result.fail(resultCode.code, resultCode.msg);
    return result;
  }

  public static Result fail(ResultCode resultCode, Object data) {
    Result result = Result.fail(resultCode);
    result.setData(data);
    return result;
  }

  public static Result fail(ResultCode resultCode, String msg) {
    Result result = Result.fail(resultCode.code);
    result.setMsg(msg);
    return result;
  }

  public static Result fail(ResultCode resultCode, String msg, Object data) {
    Result result = Result.fail(resultCode.code, msg);
    result.setData(data);
    return result;
  }
}
