package com.xiaohudu.questionnaire.mapper.questionnaire;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaohudu.questionnaire.entity.QuestionnaireQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionnaireQuestionMapper extends BaseMapper<QuestionnaireQuestion> {
  int insertBatch(List<QuestionnaireQuestion> questionnaireQuestionList);
}
