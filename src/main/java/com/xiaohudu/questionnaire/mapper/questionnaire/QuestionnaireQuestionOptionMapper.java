package com.xiaohudu.questionnaire.mapper.questionnaire;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaohudu.questionnaire.entity.QuestionnaireQuestionOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionnaireQuestionOptionMapper extends BaseMapper<QuestionnaireQuestionOption> {
  int insertBatch(List<QuestionnaireQuestionOption> questionnaireQuestionOptionList);
}
