package com.xiaohudu.questionnaire.vo.req.sys;

import com.xiaohudu.questionnaire.vo.req.PageReqVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysPermissionPageReqVO extends PageReqVO {
  private String name;
  private String path;
}
