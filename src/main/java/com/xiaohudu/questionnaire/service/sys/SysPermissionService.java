package com.xiaohudu.questionnaire.service.sys;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohudu.questionnaire.constant.Constant;
import com.xiaohudu.questionnaire.entity.*;
import com.xiaohudu.questionnaire.mapper.sys.SysPermissionMapper;
import com.xiaohudu.questionnaire.vo.req.sys.SysPermissionPageReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysPermissionService extends ServiceImpl<SysPermissionMapper, SysPermission> {
  @Autowired
  private SysPermissionMapper sysPermissionMapper;
  @Autowired
  private StringRedisTemplate stringRedisTemplate;
  @Autowired
  private SysRolePermissionService sysRolePermissionService;

  public IPage<SysPermission> page(Page<SysPermission> page, SysPermissionPageReqVO sysPermissionPageReqVO) {
    LambdaQueryWrapper<SysPermission> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    lambdaQueryWrapper
            .like(sysPermissionPageReqVO.getName() != null, SysPermission::getName, sysPermissionPageReqVO.getName())
            .like(sysPermissionPageReqVO.getPath() != null, SysPermission::getPath, sysPermissionPageReqVO.getPath())
            .orderByDesc(SysPermission::getUpdateTime, SysPermission::getCreateTime);

    return sysPermissionMapper.selectPage(page, lambdaQueryWrapper);
  }

  public void setPathListToRedis() {
    List<String> sysPermissionPathList = sysPermissionMapper.selectList(null).stream().map(v -> v.getPath()).collect(Collectors.toList());
    stringRedisTemplate.opsForValue().set(Constant.REDIS_SYS_PERMISSION_KEY, JSON.toJSONString(sysPermissionPathList));
  }

  @Transactional(rollbackFor = Exception.class)
  public void removeWithRelationByIds(List<String> ids) {
    if (this.removeByIds(ids)) {
      LambdaQueryWrapper<SysRolePermission> sysRolePermissionLambdaQueryWrapper = new LambdaQueryWrapper<>();
      sysRolePermissionLambdaQueryWrapper.in(SysRolePermission::getPermissionId, ids);
      sysRolePermissionService.remove(sysRolePermissionLambdaQueryWrapper);
    }
  }

}
