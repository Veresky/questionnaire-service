package com.xiaohudu.questionnaire.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysRolePermission extends BaseEntity {
  private String roleId;
  private String permissionId;
}
