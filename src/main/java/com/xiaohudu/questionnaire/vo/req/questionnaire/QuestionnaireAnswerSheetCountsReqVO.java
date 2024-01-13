package com.xiaohudu.questionnaire.vo.req.questionnaire;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class QuestionnaireAnswerSheetCountsReqVO {
  @NotBlank(message = "问卷ID不能为空")
  private String questionnaireId;
}
