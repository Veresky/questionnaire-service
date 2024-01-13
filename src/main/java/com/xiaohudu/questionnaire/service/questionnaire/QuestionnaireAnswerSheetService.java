package com.xiaohudu.questionnaire.service.questionnaire;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohudu.questionnaire.entity.QuestionnaireAnswer;
import com.xiaohudu.questionnaire.entity.QuestionnaireAnswerSheet;
import com.xiaohudu.questionnaire.mapper.questionnaire.QuestionnaireAnswerSheetMapper;
import com.xiaohudu.questionnaire.vo.req.questionnaire.QuestionnaireAnswerSheetCountsReqVO;
import com.xiaohudu.questionnaire.vo.req.questionnaire.QuestionnaireAnswerSheetPageReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionnaireAnswerSheetService extends ServiceImpl<QuestionnaireAnswerSheetMapper, QuestionnaireAnswerSheet> {
  @Autowired
  private QuestionnaireAnswerSheetMapper questionnaireAnswerSheetMapper;
  @Autowired
  private QuestionnaireAnswerService questionnaireAnswerService;

  public IPage<QuestionnaireAnswerSheet> page(Page<QuestionnaireAnswerSheet> page, QuestionnaireAnswerSheetPageReqVO questionnaireAnswerSheetPageReqVO) {
    LambdaQueryWrapper<QuestionnaireAnswerSheet> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    lambdaQueryWrapper
            .eq(QuestionnaireAnswerSheet::getQuestionnaireId, questionnaireAnswerSheetPageReqVO.getQuestionnaireId())
            .eq(questionnaireAnswerSheetPageReqVO.getChannel() != null, QuestionnaireAnswerSheet::getChannel, questionnaireAnswerSheetPageReqVO.getChannel())
            .gt(questionnaireAnswerSheetPageReqVO.getStartTime() != null, QuestionnaireAnswerSheet::getCreateTime, questionnaireAnswerSheetPageReqVO.getStartTime())
            .lt(questionnaireAnswerSheetPageReqVO.getEndTime() != null, QuestionnaireAnswerSheet::getCreateTime, questionnaireAnswerSheetPageReqVO.getEndTime())
            .orderByDesc(QuestionnaireAnswerSheet::getUpdateTime, QuestionnaireAnswerSheet::getCreateTime);

    return questionnaireAnswerSheetMapper.selectPage(page, lambdaQueryWrapper);
  }

  @Transactional(rollbackFor = Exception.class)
  public void removeWithRelationById(String id) {
    if (this.removeById(id)) {
      LambdaQueryWrapper<QuestionnaireAnswer> lambdaQueryWrapper = new LambdaQueryWrapper<>();
      lambdaQueryWrapper.eq(QuestionnaireAnswer::getAnswerSheetId, id);
      questionnaireAnswerService.remove(lambdaQueryWrapper);
    }
  }

  @Transactional(rollbackFor = Exception.class)
  public void saveWithAnswer(QuestionnaireAnswerSheet questionnaireAnswerSheet) {
    questionnaireAnswerSheetMapper.insert(questionnaireAnswerSheet);
    String answerSheetId = questionnaireAnswerSheet.getId();
    questionnaireAnswerSheet.getAnswerList().forEach(v -> {
      v.setAnswerSheetId(answerSheetId);
    });

    questionnaireAnswerService.saveBatch(questionnaireAnswerSheet.getAnswerList());
  }

  public Map<String, Object> countsByQuestionnaireId(QuestionnaireAnswerSheetCountsReqVO questionnaireAnswerSheetCountsReqVO) {
    QueryWrapper<QuestionnaireAnswerSheet> questionnaireAnswerSheetQueryWrapper = new QueryWrapper<>();
    questionnaireAnswerSheetQueryWrapper
            .select("COUNT(*) AS count, channel")
            .lambda()
            .eq(QuestionnaireAnswerSheet::getQuestionnaireId, questionnaireAnswerSheetCountsReqVO.getQuestionnaireId())
            .groupBy(QuestionnaireAnswerSheet::getChannel);
    List<Map<String,Object>> channelCountList = this.listMaps(questionnaireAnswerSheetQueryWrapper);

    LambdaQueryWrapper<QuestionnaireAnswerSheet> questionnaireAnswerSheetLambdaQueryWrapper = new LambdaQueryWrapper<>();
    questionnaireAnswerSheetLambdaQueryWrapper.eq(QuestionnaireAnswerSheet::getQuestionnaireId, questionnaireAnswerSheetCountsReqVO.getQuestionnaireId());
    long count = this.count(questionnaireAnswerSheetLambdaQueryWrapper);

    Map<String, Object> map = new HashMap<>();
    map.put("count", count);
    map.put("channelCountList", channelCountList);

    return map;
  }

}
