package com.xiaohudu.questionnaire.mapper.questionnaire;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaohudu.questionnaire.entity.QuestionnaireAnswer;
import com.xiaohudu.questionnaire.vo.req.questionnaire.QuestionnaireAnswerCountGroupByQuestionOptionReqVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QuestionnaireAnswerMapper extends BaseMapper<QuestionnaireAnswer> {
  List<Map<String,Object>> selectCountGroupByQuestionOption(QuestionnaireAnswerCountGroupByQuestionOptionReqVO questionnaireAnswerCountGroupByQuestionOptionReqVO);
}










