package com.xiaohudu.questionnaire.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionnaireAnswerSheet extends BaseEntity {
  @NotBlank(message = "问卷不能为空")
  private String questionnaireId;
  private String ip;
  private String channel;
  @TableField(exist = false)
  private List<QuestionnaireAnswer> answerList;
}
