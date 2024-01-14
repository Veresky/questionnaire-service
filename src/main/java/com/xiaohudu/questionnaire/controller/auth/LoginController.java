package com.xiaohudu.questionnaire.controller.auth;

import com.alibaba.fastjson2.JSON;
import com.xiaohudu.questionnaire.constant.Constant;
import com.xiaohudu.questionnaire.constant.ResultCode;
import com.xiaohudu.questionnaire.entity.SysRole;
import com.xiaohudu.questionnaire.entity.SysUser;
import com.xiaohudu.questionnaire.service.sys.SysRolePermissionService;
import com.xiaohudu.questionnaire.service.sys.SysUserRoleService;
import com.xiaohudu.questionnaire.service.sys.SysUserService;
import com.xiaohudu.questionnaire.utils.Result;
import com.xiaohudu.questionnaire.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@CrossOrigin(origins = "https://questionnaire-client-320a500d3b93.herokuapp.com")
@RestController
@RequestMapping("auth")
public class LoginController {
  @Autowired
  private SysUserService sysUserService;
  @Autowired
  private SysUserRoleService sysUserRoleService;
  @Autowired
  private SysRolePermissionService sysRolePermissionService;
  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  /**
   * 登录
   * @param request
   * @param body
   * @return Result
   */
  @PostMapping(path = "login")
  public Result login(HttpServletRequest request, @RequestBody SysUser body) {
    if (StringUtils.isBlank(body.getUsername()) || StringUtils.isBlank(body.getPassword())) {
      return Result.fail(ResultCode.BAD_REQUEST, "账号或密码不能为空");
    }

    String username = body.getUsername();
    String password = body.getPassword();

    SysUser sysUser = sysUserService.getByUserName(username);

    if (sysUser == null) {
      return Result.fail(ResultCode.BAD_REQUEST_USERNAME_PASSWORD);
    } else {
      String encodedPassword = Utils.encodePassword(password, sysUser.getSalt());
      if (!encodedPassword.equals(sysUser.getPassword())) {
        return Result.fail(ResultCode.BAD_REQUEST_USERNAME_PASSWORD);
      } else {
        String token = Utils.randomUUID();

        List<SysRole> sysRoleList = sysUserRoleService.listByUserId(sysUser.getId());
        if (sysRoleList.size() == 0) {
          return Result.fail(ResultCode.NO_ROLE);
        }
        List<String> sysPermissionPathList = sysRolePermissionService.pathListBySysRoleList(sysRoleList);
        Map<String, Object> tokenRedisRet = new HashMap<>();
        tokenRedisRet.put("username", username);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constant.DATE_FORMAT_PATTERN_2);
        tokenRedisRet.put("createTime", LocalDateTime.now().format(formatter));
        tokenRedisRet.put("ip", request.getRemoteHost());
        tokenRedisRet.put("sysPermissionPathList", sysPermissionPathList);
        stringRedisTemplate.opsForValue().set(Constant.REDIS_TOKEN_KEY_PREFIX + token, JSON.toJSONString(tokenRedisRet), Constant.REDIS_TOKEN_EXPIRE, TimeUnit.HOURS);

        Map<String, Object> loginRet = new HashMap<>();
        loginRet.put("token", token);
        return Result.success(loginRet);
      }
    }
  }

  @PostMapping(path = "logout")
  public Result logout(@RequestHeader("token") String token) {
    stringRedisTemplate.delete(Constant.REDIS_TOKEN_KEY_PREFIX + token);
    return Result.success();
  }
}
