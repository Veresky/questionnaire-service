package com.xiaohudu.questionnaire.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionnaireQuestionOption extends BaseEntity {
  @NotBlank(message = "问卷ID不能为空")
  private String questionnaireId;
  @NotBlank(message = "题目ID不能为空")
  private String questionId;
  @NotBlank(message = "名称不能为空")
  private String name;
  private Integer inputable;
  private Integer sortNo;
}
