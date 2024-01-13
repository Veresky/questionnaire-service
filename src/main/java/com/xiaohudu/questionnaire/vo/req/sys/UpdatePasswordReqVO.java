package com.xiaohudu.questionnaire.vo.req.sys;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UpdatePasswordReqVO {
  @NotBlank(message = "旧密码不能为空")
  private String oldPassword;
  @NotBlank(message = "新密码不能为空")
  private String newPassword;
}
