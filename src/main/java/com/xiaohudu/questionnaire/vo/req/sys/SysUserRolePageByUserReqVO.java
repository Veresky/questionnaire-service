package com.xiaohudu.questionnaire.vo.req.sys;

import com.xiaohudu.questionnaire.vo.req.PageReqVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserRolePageByUserReqVO extends PageReqVO {
  @NotBlank(message = "用户ID不能为空")
  private String userId;
  private String roleName;
  private String roleCode;
}
