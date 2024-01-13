package com.xiaohudu.questionnaire.controller.common;

import com.xiaohudu.questionnaire.utils.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("common")
public class ConfigController {
  @Value("${file.base-url}")
  private String fileBaseUrl;

  /**
   * 配置信息
   * @return Result
   */
  @PostMapping(path = "config")
  public Result config() {
    Map<String, String> map = new HashMap<String, String>();
    
    map.put("fileBaseUrl", fileBaseUrl);

    return  Result.success(map);
  }

}
