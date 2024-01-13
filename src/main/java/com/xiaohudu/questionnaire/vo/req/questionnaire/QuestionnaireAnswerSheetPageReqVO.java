package com.xiaohudu.questionnaire.vo.req.questionnaire;

import com.xiaohudu.questionnaire.vo.req.PageReqVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionnaireAnswerSheetPageReqVO extends PageReqVO {
  @NotBlank(message = "问卷ID不能为空")
  private String questionnaireId;
  private String channel;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
}
