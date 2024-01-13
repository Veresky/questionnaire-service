package com.xiaohudu.questionnaire.service.questionnaire;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohudu.questionnaire.entity.QuestionnaireAnswer;
import com.xiaohudu.questionnaire.mapper.questionnaire.QuestionnaireAnswerMapper;
import com.xiaohudu.questionnaire.vo.req.questionnaire.QuestionnaireAnswerCountGroupByQuestionOptionReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuestionnaireAnswerService extends ServiceImpl<QuestionnaireAnswerMapper, QuestionnaireAnswer> {
  @Autowired
  private QuestionnaireAnswerMapper questionnaireAnswerMapper;

  public List<Map<String,Object>> countGroupByQuestionOption(QuestionnaireAnswerCountGroupByQuestionOptionReqVO questionnaireAnswerCountGroupByQuestionOptionReqVO) {
    return questionnaireAnswerMapper.selectCountGroupByQuestionOption(questionnaireAnswerCountGroupByQuestionOptionReqVO);
  }
}
