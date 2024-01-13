package com.xiaohudu.questionnaire.service.questionnaire;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohudu.questionnaire.entity.QuestionnaireQuestion;
import com.xiaohudu.questionnaire.entity.QuestionnaireQuestionOption;
import com.xiaohudu.questionnaire.mapper.questionnaire.QuestionnaireQuestionMapper;
import com.xiaohudu.questionnaire.vo.req.questionnaire.QuestionnaireQuestionReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class QuestionnaireQuestionService extends ServiceImpl<QuestionnaireQuestionMapper, QuestionnaireQuestion> {
  @Autowired
  private QuestionnaireQuestionMapper questionnaireQuestionMapper;
  @Autowired
  private QuestionnaireQuestionOptionService questionnaireQuestionOptionService;

  public List<QuestionnaireQuestion> listWithQuestionOption(QuestionnaireQuestionReqVO questionnaireQuestionReqVO) {
    LambdaQueryWrapper<QuestionnaireQuestion> questionnaireQuestionLambdaQueryWrapper = new LambdaQueryWrapper<>();
    questionnaireQuestionLambdaQueryWrapper
            .eq(QuestionnaireQuestion::getQuestionnaireId, questionnaireQuestionReqVO.getQuestionnaireId())
            .orderByAsc(QuestionnaireQuestion::getSortNo);
    List<QuestionnaireQuestion> questionnaireQuestionList = this.list(questionnaireQuestionLambdaQueryWrapper);

    questionnaireQuestionList.forEach(v -> {
      LambdaQueryWrapper<QuestionnaireQuestionOption> questionnaireQuestionOptionLambdaQueryWrapper = new LambdaQueryWrapper<>();
      questionnaireQuestionOptionLambdaQueryWrapper
              .eq(QuestionnaireQuestionOption::getQuestionId, v.getId())
              .orderByAsc(QuestionnaireQuestionOption::getSortNo);
      v.setQuestionOptionList(questionnaireQuestionOptionService.list(questionnaireQuestionOptionLambdaQueryWrapper));
    });

    return questionnaireQuestionList;
  }

  @Transactional(rollbackFor = Exception.class)
  public void saveBatchWithQuestionOption(List<QuestionnaireQuestion> questionnaireQuestionList) {
    String questionnaireId = questionnaireQuestionList.get(0).getQuestionnaireId();
    // 先批量删
    LambdaQueryWrapper<QuestionnaireQuestion> questionnaireQuestionLambdaQueryWrapper = new LambdaQueryWrapper<>();
    questionnaireQuestionLambdaQueryWrapper.eq(QuestionnaireQuestion::getQuestionnaireId, questionnaireId);
    this.remove(questionnaireQuestionLambdaQueryWrapper);

    LambdaQueryWrapper<QuestionnaireQuestionOption> questionnaireQuestionOptionLambdaQueryWrapper = new LambdaQueryWrapper<>();
    questionnaireQuestionOptionLambdaQueryWrapper.eq(QuestionnaireQuestionOption::getQuestionnaireId, questionnaireId);
    questionnaireQuestionOptionService.remove(questionnaireQuestionOptionLambdaQueryWrapper);

    // 后批量插入
    questionnaireQuestionList.forEach(v -> {
      // java 题目设置主键，因为题目选项要用
      v.setId(UUID.randomUUID().toString().replace("-", ""));
    });
    questionnaireQuestionMapper.insertBatch(questionnaireQuestionList);

    List<QuestionnaireQuestionOption> questionnaireQuestionOptionList = new ArrayList<>();
    questionnaireQuestionList.forEach(v -> {
      v.getQuestionOptionList().forEach(vv -> {
        vv.setQuestionId(v.getId());
      });
      questionnaireQuestionOptionList.addAll(v.getQuestionOptionList());
    });

    if (questionnaireQuestionOptionList.size() != 0) {
      questionnaireQuestionOptionService.saveBatch(questionnaireQuestionOptionList);
    }
  }
}
