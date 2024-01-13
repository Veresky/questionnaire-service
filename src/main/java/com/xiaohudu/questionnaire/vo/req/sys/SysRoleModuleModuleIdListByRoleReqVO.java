package com.xiaohudu.questionnaire.vo.req.sys;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SysRoleModuleModuleIdListByRoleReqVO {
  @NotBlank(message = "角色ID不能为空")
  private String roleId;
}
