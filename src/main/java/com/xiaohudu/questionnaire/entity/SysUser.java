package com.xiaohudu.questionnaire.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntity {
  @NotBlank(message = "账号不能为空")
  private String username;
  @NotBlank(message = "名称不能为空")
  private String realname;
  private String password;
  private String salt;
  private String state;
}
