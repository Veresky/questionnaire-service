package com.xiaohudu.questionnaire.vo.req.sys;

import com.xiaohudu.questionnaire.vo.req.PageReqVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysRolePermissionPageByRoleReqVO extends PageReqVO {
  @NotBlank(message = "角色ID不能为空")
  private String roleId;
  private String name;
  private String path;
}
