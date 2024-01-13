package com.xiaohudu.questionnaire.utils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.xiaohudu.questionnaire.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class WXUtils {
  private static String appId;
  private static String appSecret;
  private static String baseUrl;
  private static StringRedisTemplate stringRedisTemplate;
  private static RestTemplate restTemplate;

  @Autowired
  public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
    WXUtils.stringRedisTemplate = stringRedisTemplate;
  }

  @Autowired
  public void setRestTemplate(RestTemplate restTemplate) {
    WXUtils.restTemplate = restTemplate;
  }

  @Value("${wx.app-id}")
  public void setAppId(String appId) {
    WXUtils.appId = appId;
  }

  @Value("${wx.app-secret}")
  public void setAppSecret(String appSecret) {
    WXUtils.appSecret = appSecret;
  }

  @Value("${wx.base-url}")
  public void setBaseUrl(String baseUrl) {
    WXUtils.baseUrl = baseUrl;
  }

  public static String getWXToken() {
    String token = stringRedisTemplate.opsForValue().get(Constant.REDIS_WX_TOKEN_KEY);

    if (token == null) {
      String url = baseUrl + "cgi-bin/token?appid=" + appId + "&secret=" + appSecret + "&grant_type=client_credential";
      String wxTokenResultStr = restTemplate.getForObject(url, String.class);
      JSONObject wxTokenResult = JSON.parseObject(wxTokenResultStr);
  
      String accessToken = wxTokenResult.getString("access_token");
      Integer errcode = wxTokenResult.getInteger("errcode");
  
      if (errcode == null || errcode == 0) {
        stringRedisTemplate.opsForValue().set(Constant.REDIS_WX_TOKEN_KEY, accessToken, Constant.REDIS_WX_TOKEN_EXPIRE, TimeUnit.MINUTES);
        token = accessToken;
      } else {
        throw new RuntimeException("get wx token fail: " + wxTokenResultStr);
      }
    }

    return token;
  }
}
