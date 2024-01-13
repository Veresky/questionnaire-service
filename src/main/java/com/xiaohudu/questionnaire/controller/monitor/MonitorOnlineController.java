package com.xiaohudu.questionnaire.controller.monitor;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.xiaohudu.questionnaire.constant.Constant;
import com.xiaohudu.questionnaire.utils.Result;
import com.xiaohudu.questionnaire.utils.ServletContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("monitor/online")
public class MonitorOnlineController {
  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  /**
   * 列表
   * @return Result
   */
  @PostMapping(path = "list")
  public Result list(@RequestHeader("token") String token) {
    Set<String> keys = stringRedisTemplate.keys(Constant.REDIS_TOKEN_KEY_PREFIX + "*");
    List<String> onlineListString = stringRedisTemplate.opsForValue().multiGet(keys);

    List<JSONObject> onlineList = new ArrayList<>();
    for (int i = 0; i < onlineListString.size(); i++) {
      String online = onlineListString.get(i);
      JSONObject onlineObj = JSON.parseObject(online);
      onlineObj.remove("sysPermissionPathList");
      onlineObj.put("isCurrentUser", ServletContextUtils.getUsername().equals(onlineObj.get("username")) && ((String)keys.toArray()[i]).contains(token));
      onlineList.add(onlineObj);
    }

    return Result.success(onlineList);
  }
}
