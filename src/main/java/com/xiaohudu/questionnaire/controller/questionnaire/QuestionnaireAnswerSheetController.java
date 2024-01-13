package com.xiaohudu.questionnaire.controller.questionnaire;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohudu.questionnaire.entity.QuestionnaireAnswer;
import com.xiaohudu.questionnaire.entity.QuestionnaireAnswerSheet;
import com.xiaohudu.questionnaire.service.questionnaire.QuestionnaireAnswerService;
import com.xiaohudu.questionnaire.service.questionnaire.QuestionnaireAnswerSheetService;
import com.xiaohudu.questionnaire.utils.Result;
import com.xiaohudu.questionnaire.vo.req.IdReqVO;
import com.xiaohudu.questionnaire.vo.req.questionnaire.QuestionnaireAnswerSheetCountsReqVO;
import com.xiaohudu.questionnaire.vo.req.questionnaire.QuestionnaireAnswerSheetPageReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("questionnaire/answerSheet")
public class QuestionnaireAnswerSheetController {
  @Autowired
  private QuestionnaireAnswerSheetService questionnaireAnswerSheetService;
  @Autowired
  private QuestionnaireAnswerService questionnaireAnswerService;

  /**
   * 分页
   * @param questionnaireAnswerSheetPageReqVO
   * @return Result
   */
  @PostMapping(path = "page")
  public Result page(@RequestBody QuestionnaireAnswerSheetPageReqVO questionnaireAnswerSheetPageReqVO) {
    IPage<QuestionnaireAnswerSheet> iPage = questionnaireAnswerSheetService.page(new Page<>(questionnaireAnswerSheetPageReqVO.getCurrent(), questionnaireAnswerSheetPageReqVO.getSize()), questionnaireAnswerSheetPageReqVO);
    return Result.success(iPage);
  }

  /**
   * 详情
   * @param idReqVO
   * @return Result
   */
  @PostMapping(path = "detail")
  public Result detail(@Validated @RequestBody IdReqVO idReqVO) {
    String id = idReqVO.getId();
    QuestionnaireAnswerSheet questionnaireAnswerSheet = questionnaireAnswerSheetService.getById(id);

    if (questionnaireAnswerSheet != null) {
      LambdaQueryWrapper<QuestionnaireAnswer> questionnaireAnswerLambdaQueryWrapper = new LambdaQueryWrapper<>();
      questionnaireAnswerLambdaQueryWrapper.eq(QuestionnaireAnswer::getAnswerSheetId, id);
      List<QuestionnaireAnswer> questionnaireQuestionList = questionnaireAnswerService.list(questionnaireAnswerLambdaQueryWrapper);

      questionnaireAnswerSheet.setAnswerList(questionnaireQuestionList);
    }

    return Result.success(questionnaireAnswerSheet);
  }

  /**
   * 删除
   * @param idReqVO
   * @return Result
   */
  @PostMapping(path = "delete")
  public Result delete(@Validated @RequestBody IdReqVO idReqVO) {
    questionnaireAnswerSheetService.removeWithRelationById(idReqVO.getId());
    return Result.success();
  }

  /**
   * 通过问卷ID查询答卷总数集合（问卷调查）
   * @param questionnaireAnswerSheetCountsReqVO
   * @return Result
   */
  @PostMapping(path = "countsByQuestionnaireId")
  public Result countsByQuestionnaireId(@RequestBody QuestionnaireAnswerSheetCountsReqVO questionnaireAnswerSheetCountsReqVO) {
    Map<String, Object> counts = questionnaireAnswerSheetService.countsByQuestionnaireId(questionnaireAnswerSheetCountsReqVO);
    return Result.success(counts);
  }
}
