package com.xiaohudu.questionnaire.controller.common;

import com.xiaohudu.questionnaire.utils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("common")
public class CurrentTimeController {

  /**
   * 当前时间戳
   * @return Result
   */
  @PostMapping(path = "currentTime")
  public Result currentTime() {
    return  Result.success(System.currentTimeMillis());
  }

}
