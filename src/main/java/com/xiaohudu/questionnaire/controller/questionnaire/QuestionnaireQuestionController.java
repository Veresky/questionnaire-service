package com.xiaohudu.questionnaire.controller.questionnaire;

import com.xiaohudu.questionnaire.entity.QuestionnaireQuestion;
import com.xiaohudu.questionnaire.service.questionnaire.QuestionnaireQuestionService;
import com.xiaohudu.questionnaire.utils.Result;
import com.xiaohudu.questionnaire.vo.req.questionnaire.QuestionnaireQuestionReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("questionnaire/question")
public class QuestionnaireQuestionController {
  @Autowired
  private QuestionnaireQuestionService questionnaireQuestionService;

  /**
   * 列表，带选项
   * @param questionnaireQuestionReqVO
   * @return Result
   */
  @PostMapping(path = "listWithQuestionOption")
  public Result listWithQuestionOption(@RequestBody QuestionnaireQuestionReqVO questionnaireQuestionReqVO) {
    List<QuestionnaireQuestion> questionnaireQuestionList = questionnaireQuestionService.listWithQuestionOption(questionnaireQuestionReqVO);
    return Result.success(questionnaireQuestionList);
  }

  /**
   * 批量保存
   * @param questionnaireQuestionList
   * @return Result
   */
  @PostMapping(path = "saveBatchWithQuestionOption")
  public Result saveBatchWithQuestionOption(@RequestBody List<QuestionnaireQuestion> questionnaireQuestionList) {
    questionnaireQuestionService.saveBatchWithQuestionOption(questionnaireQuestionList);
    return Result.success();
  }
}
