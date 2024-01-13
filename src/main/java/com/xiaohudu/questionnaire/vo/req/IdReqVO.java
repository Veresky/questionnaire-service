package com.xiaohudu.questionnaire.vo.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class IdReqVO {
  @NotBlank(message = "ID不能为空")
  private String id;
}
