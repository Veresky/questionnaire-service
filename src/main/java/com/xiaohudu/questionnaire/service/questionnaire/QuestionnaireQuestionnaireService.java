package com.xiaohudu.questionnaire.service.questionnaire;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohudu.questionnaire.entity.QuestionnaireAnswerSheet;
import com.xiaohudu.questionnaire.entity.QuestionnaireQuestion;
import com.xiaohudu.questionnaire.entity.QuestionnaireQuestionnaire;
import com.xiaohudu.questionnaire.mapper.questionnaire.QuestionnaireQuestionnaireMapper;
import com.xiaohudu.questionnaire.vo.req.IdReqVO;
import com.xiaohudu.questionnaire.vo.req.questionnaire.QuestionnaireQuestionReqVO;
import com.xiaohudu.questionnaire.vo.req.questionnaire.QuestionnaireQuestionnairePageReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestionnaireQuestionnaireService extends ServiceImpl<QuestionnaireQuestionnaireMapper, QuestionnaireQuestionnaire> {
  @Autowired
  private QuestionnaireQuestionnaireMapper questionnaireQuestionnaireMapper;
  @Autowired
  private QuestionnaireQuestionService questionnaireQuestionService;
  @Autowired
  private QuestionnaireAnswerSheetService questionnaireAnswerSheetService;

  public IPage<QuestionnaireQuestionnaire> page(Page<QuestionnaireQuestionnaire> page, QuestionnaireQuestionnairePageReqVO questionnaireQuestionnairePageReqVO) {
    LambdaQueryWrapper<QuestionnaireQuestionnaire> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    lambdaQueryWrapper
            .eq(questionnaireQuestionnairePageReqVO.getState() != null, QuestionnaireQuestionnaire::getState, questionnaireQuestionnairePageReqVO.getState())
            .like(questionnaireQuestionnairePageReqVO.getTitle() != null, QuestionnaireQuestionnaire::getTitle, questionnaireQuestionnairePageReqVO.getTitle())
            .orderByDesc(QuestionnaireQuestionnaire::getUpdateTime, QuestionnaireQuestionnaire::getCreateTime);

    return questionnaireQuestionnaireMapper.selectPage(page, lambdaQueryWrapper);
  }

  public QuestionnaireQuestionnaire getById(IdReqVO idReqVO) {
    String id = idReqVO.getId();
    QuestionnaireQuestionnaire questionnaireQuestionnaire = this.getById(id);

    if (questionnaireQuestionnaire != null) {
      QuestionnaireQuestionReqVO questionnaireQuestionReqVO = new QuestionnaireQuestionReqVO();
      questionnaireQuestionReqVO.setQuestionnaireId(id);

      List<QuestionnaireQuestion> questionnaireQuestionList = questionnaireQuestionService.listWithQuestionOption(questionnaireQuestionReqVO);
      questionnaireQuestionnaire.setQuestionList(questionnaireQuestionList);

      LambdaQueryWrapper<QuestionnaireAnswerSheet> questionnaireAnswerSheetLambdaQueryWrapper = new LambdaQueryWrapper<>();
      questionnaireAnswerSheetLambdaQueryWrapper.eq(QuestionnaireAnswerSheet::getQuestionnaireId, id);
      long count = questionnaireAnswerSheetService.count(questionnaireAnswerSheetLambdaQueryWrapper);
      questionnaireQuestionnaire.setAnswerSheetCount(count);

      questionnaireQuestionnaire.setNow(LocalDateTime.now());
    }

    return questionnaireQuestionnaire;
  }

  @Transactional(rollbackFor = Exception.class)
  public void removeWithRelationById(String id) {
    if (this.removeById(id)) {
      LambdaQueryWrapper<QuestionnaireQuestion> lambdaQueryWrapper = new LambdaQueryWrapper<>();
      lambdaQueryWrapper.eq(QuestionnaireQuestion::getQuestionnaireId, id);
      questionnaireQuestionService.remove(lambdaQueryWrapper);
    }
  }

}
