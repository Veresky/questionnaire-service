package com.xiaohudu.questionnaire.controller.questionnaire;

import com.xiaohudu.questionnaire.service.questionnaire.QuestionnaireAnswerService;
import com.xiaohudu.questionnaire.utils.Result;
import com.xiaohudu.questionnaire.vo.req.questionnaire.QuestionnaireAnswerCountGroupByQuestionOptionReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("questionnaire/answer")
public class QuestionnaireAnswerController {
  @Autowired
  private QuestionnaireAnswerService questionnaireAnswerService;

  /**
   * 题目选项分组下的总数
   * @param questionnaireAnswerCountGroupByQuestionOptionReqVO
   * @return Result
   */
  @PostMapping(path = "countGroupByQuestionOption")
  public Result countGroupByQuestionOption(@RequestBody QuestionnaireAnswerCountGroupByQuestionOptionReqVO questionnaireAnswerCountGroupByQuestionOptionReqVO) {
    List<Map<String,Object>> list = questionnaireAnswerService.countGroupByQuestionOption(questionnaireAnswerCountGroupByQuestionOptionReqVO);

    return Result.success(list);
  }
}
