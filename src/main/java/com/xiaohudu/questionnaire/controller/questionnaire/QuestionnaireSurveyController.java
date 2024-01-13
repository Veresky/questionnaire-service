package com.xiaohudu.questionnaire.controller.questionnaire;

import com.xiaohudu.questionnaire.entity.QuestionnaireAnswerSheet;
import com.xiaohudu.questionnaire.service.questionnaire.QuestionnaireAnswerSheetService;
import com.xiaohudu.questionnaire.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("questionnaire/survey")
public class QuestionnaireSurveyController {
  @Autowired
  private QuestionnaireAnswerSheetService questionnaireAnswerSheetService;


  /**
   * 创建答卷
   * @param questionnaireAnswerSheet
   * @return Result
   */
  @PostMapping(path = "save")
  public Result save(HttpServletRequest request, @RequestBody QuestionnaireAnswerSheet questionnaireAnswerSheet) {
    questionnaireAnswerSheet.setIp(request.getRemoteHost());
    questionnaireAnswerSheetService.saveWithAnswer(questionnaireAnswerSheet);
    return Result.success();
  }
}
