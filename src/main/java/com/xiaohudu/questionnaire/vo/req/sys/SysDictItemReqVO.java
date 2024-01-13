package com.xiaohudu.questionnaire.vo.req.sys;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SysDictItemReqVO {
  @NotBlank(message = "字典ID不能为空")
  private String dictId;
}
