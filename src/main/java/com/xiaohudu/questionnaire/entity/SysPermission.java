package com.xiaohudu.questionnaire.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysPermission extends BaseEntity {
  @NotBlank(message = "接口名称不能为空")
  private String name;
  @NotBlank(message = "接口地址不能为空")
  private String path;
  private String description;
  @TableField(exist = false)
  private String rolePermissionId;
}
