package com.xiaohudu.questionnaire.vo.req.monitor;

import com.xiaohudu.questionnaire.vo.req.PageReqVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MonitorLogPageReqVO extends PageReqVO {
  private String createBy;
  private String code;
}
