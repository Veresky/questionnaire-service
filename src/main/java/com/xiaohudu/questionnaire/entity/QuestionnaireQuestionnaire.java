package com.xiaohudu.questionnaire.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionnaireQuestionnaire extends BaseEntity {
  @NotBlank(message = "标题不能为空")
  private String title;
  private String description;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
  private String submitTip;
  private String state;
  private Integer collectionLimit;
  @TableField(exist = false)
  private List<QuestionnaireQuestion> questionList;
  @TableField(exist = false)
  private LocalDateTime now;
  @TableField(exist = false)
  private Long answerSheetCount;
}
