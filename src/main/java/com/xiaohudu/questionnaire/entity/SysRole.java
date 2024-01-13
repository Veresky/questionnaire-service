package com.xiaohudu.questionnaire.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseEntity {
  @NotBlank(message = "角色名称不能为空")
  private String roleName;
  @NotBlank(message = "角色编码不能为空")
  private String roleCode;
  private String description;
  @TableField(exist = false)
  private String userRoleId;
}
