package com.xiaohudu.questionnaire.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class MonitorLog extends BaseEntity {
  private String path;
  private String method;
  private Integer code;
  private LocalDateTime startTime;
  private Long duration;
  private String ip;
}
