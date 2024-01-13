package com.xiaohudu.questionnaire.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionnaireAnswer extends BaseEntity {
  @NotBlank(message = "答卷ID不能为空")
  private String answerSheetId;
  @NotBlank(message = "题目ID不能为空")
  private String questionId;
  private String optionId;
  private String input;
}
