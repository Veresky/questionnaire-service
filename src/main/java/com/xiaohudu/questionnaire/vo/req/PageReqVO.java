package com.xiaohudu.questionnaire.vo.req;

import lombok.Data;

@Data
public class PageReqVO {
  private int current = 1;
  private int size = 10;
}
