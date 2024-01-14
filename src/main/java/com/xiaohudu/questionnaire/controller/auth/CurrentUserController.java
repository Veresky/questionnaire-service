package com.xiaohudu.questionnaire.controller.auth;

import com.xiaohudu.questionnaire.entity.SysModule;
import com.xiaohudu.questionnaire.entity.SysRole;
import com.xiaohudu.questionnaire.entity.SysUser;
import com.xiaohudu.questionnaire.service.sys.SysRoleModuleService;
import com.xiaohudu.questionnaire.service.sys.SysUserRoleService;
import com.xiaohudu.questionnaire.service.sys.SysUserService;
import com.xiaohudu.questionnaire.utils.Result;
import com.xiaohudu.questionnaire.utils.ServletContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class CurrentUserController {
  @Autowired
  private SysUserService sysUserService;
  @Autowired
  private SysUserRoleService sysUserRoleService;
  @Autowired
  private SysRoleModuleService sysRoleModuleService;
  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  /**
   * 当前用户
   * @param token
   * @return Result
   */
  @PostMapping(path = "currentUser")
  public Result currentUser(@RequestHeader("token") String token) {
    SysUser sysUser = sysUserService.getByUserName(ServletContextUtils.getUsername());
    sysUser.setSalt(null);
    sysUser.setPassword(null);
    List<SysRole> sysRoleList = sysUserRoleService.listByUserId(sysUser.getId());
    List<SysModule> sysModuleTree = sysRoleModuleService.treeBySysRoleList(sysRoleList);

    Map<String, Object> map = new HashMap<>();
    map.put("sysUser", sysUser);
    map.put("sysRole", sysRoleList);
    map.put("sysModule", sysModuleTree);

    return Result.success(map);
  }
}
