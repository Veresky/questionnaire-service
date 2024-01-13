package com.xiaohudu.questionnaire.vo.req.questionnaire;

import com.xiaohudu.questionnaire.vo.req.PageReqVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionnaireQuestionnairePageReqVO extends PageReqVO {
  private String title;
  private String state;
}
