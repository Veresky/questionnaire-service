package com.xiaohudu.questionnaire.controller.questionnaire;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohudu.questionnaire.entity.QuestionnaireQuestionnaire;
import com.xiaohudu.questionnaire.service.questionnaire.QuestionnaireQuestionnaireService;
import com.xiaohudu.questionnaire.utils.Result;
import com.xiaohudu.questionnaire.vo.req.IdReqVO;
import com.xiaohudu.questionnaire.vo.req.questionnaire.QuestionnaireQuestionnairePageReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("questionnaire/questionnaire")
public class QuestionnaireQuestionnaireController {
  @Autowired
  private QuestionnaireQuestionnaireService questionnaireQuestionnaireService;

  /**
   * 分页
   * @param questionnaireQuestionnairePageReqVO
   * @return Result
   */
  @PostMapping(path = "page")
  public Result page(@RequestBody QuestionnaireQuestionnairePageReqVO questionnaireQuestionnairePageReqVO) {
    IPage<QuestionnaireQuestionnaire> iPage = questionnaireQuestionnaireService.page(new Page<>(questionnaireQuestionnairePageReqVO.getCurrent(), questionnaireQuestionnairePageReqVO.getSize()), questionnaireQuestionnairePageReqVO);
    return Result.success(iPage);
  }

  /**
   * 详情
   * @param idReqVO
   * @return Result
   */
  @PostMapping(path = "detail")
  public Result detail(@Validated @RequestBody IdReqVO idReqVO) {
    QuestionnaireQuestionnaire questionnaireQuestionnaire = questionnaireQuestionnaireService.getById(idReqVO);
    return Result.success(questionnaireQuestionnaire);
  }

  /**
   * 编辑
   * @param questionnaireQuestionnaire
   * @return Result
   */
  @PostMapping(path = "edit")
  public Result edit(@Validated @RequestBody QuestionnaireQuestionnaire questionnaireQuestionnaire) {
    questionnaireQuestionnaireService.saveOrUpdate(questionnaireQuestionnaire);
    return Result.success();
  }

  /**
   * 删除
   * @param idReqVO
   * @return Result
   */
  @PostMapping(path = "delete")
  public Result delete(@Validated @RequestBody IdReqVO idReqVO) {
    questionnaireQuestionnaireService.removeWithRelationById(idReqVO.getId());
    return Result.success();
  }
}
