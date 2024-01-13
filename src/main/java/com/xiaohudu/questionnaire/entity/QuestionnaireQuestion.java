package com.xiaohudu.questionnaire.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionnaireQuestion extends BaseEntity {
  @NotBlank(message = "问卷ID不能为空")
  private String questionnaireId;
  @NotBlank(message = "标题不能为空")
  private String title;
  private String type;
  private Integer required;
  private Integer sortNo;
  @TableField(exist = false)
  private List<QuestionnaireQuestionOption> questionOptionList;
}
