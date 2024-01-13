package com.xiaohudu.questionnaire.vo.req.sys;

import com.xiaohudu.questionnaire.vo.req.PageReqVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysRolePageReqVO extends PageReqVO {
  private String roleName;
  private String roleCode;
}
