package com.xiaohudu.questionnaire.service.questionnaire;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohudu.questionnaire.entity.QuestionnaireQuestionOption;
import com.xiaohudu.questionnaire.mapper.questionnaire.QuestionnaireQuestionOptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireQuestionOptionService extends ServiceImpl<QuestionnaireQuestionOptionMapper, QuestionnaireQuestionOption> {
  @Autowired
  private QuestionnaireQuestionOptionMapper questionnaireQuestionOptionMapper;

  public void saveBatch(List<QuestionnaireQuestionOption> questionnaireQuestionOptionList) {
    questionnaireQuestionOptionMapper.insertBatch(questionnaireQuestionOptionList);
  }
}
