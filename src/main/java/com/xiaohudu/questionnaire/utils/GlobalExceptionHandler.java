package com.xiaohudu.questionnaire.utils;

import com.xiaohudu.questionnaire.constant.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
  /**
   * 处理未捕获的 Exception
   * @param
   * @return Result
   */
  @ExceptionHandler(Exception.class)
  public Result handleException(Exception e) {
    log.error(e.getMessage(), e);
    return Result.fail(ResultCode.SERVER_ERROR, e.getMessage());
  }

  /**
   * 处理数据校验异常 MethodArgumentNotValidException
   * @param e
   * @return Result
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    String message = e.getBindingResult().getFieldErrors().stream()
            .map(r -> r.getDefaultMessage())
            .collect(Collectors.joining(";"));

    return Result.fail(ResultCode.BAD_REQUEST, message);
  }
}
