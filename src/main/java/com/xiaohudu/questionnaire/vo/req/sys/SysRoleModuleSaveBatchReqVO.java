package com.xiaohudu.questionnaire.vo.req.sys;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class SysRoleModuleSaveBatchReqVO {
  @NotBlank(message = "角色ID不能为空")
  private String roleId;
  @NotEmpty(message = "模块ID列表不能为空")
  private List<String> moduleIdList;
}
