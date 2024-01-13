package com.xiaohudu.questionnaire.service.sys;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohudu.questionnaire.entity.MonitorLog;
import com.xiaohudu.questionnaire.entity.SysDict;
import com.xiaohudu.questionnaire.entity.SysDictItem;
import com.xiaohudu.questionnaire.mapper.sys.SysDictMapper;
import com.xiaohudu.questionnaire.vo.req.sys.SysDictPageReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysDictService extends ServiceImpl<SysDictMapper, SysDict> {
  @Autowired
  private SysDictMapper sysDictMapper;
  @Autowired
  private SysDictItemService sysDictItemService;

  public IPage<SysDict> page(Page<SysDict> page, SysDictPageReqVO sysDictPageReqVO) {
    LambdaQueryWrapper<SysDict> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    lambdaQueryWrapper
            .eq(sysDictPageReqVO.getDictCode() != null, SysDict::getDictCode, sysDictPageReqVO.getDictCode())
            .like(sysDictPageReqVO.getDictName() != null, SysDict::getDictName, sysDictPageReqVO.getDictName())
            .orderByDesc(SysDict::getUpdateTime, SysDict::getCreateTime);

    return sysDictMapper.selectPage(page, lambdaQueryWrapper);
  }

  @Transactional(rollbackFor = Exception.class)
  public void removeWithSysDictItemById(String id) {
    if (this.removeById(id)) {
      LambdaQueryWrapper<SysDictItem> lambdaQueryWrapper = new LambdaQueryWrapper<>();
      lambdaQueryWrapper.eq(SysDictItem::getDictId, id);
      sysDictItemService.remove(lambdaQueryWrapper);
    }
  }

  public Map<String, List<SysDictItem>> all() {
    List<SysDict> sysDictList = sysDictMapper.selectList(null);
    LambdaQueryWrapper<SysDictItem> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    lambdaQueryWrapper.orderByAsc(SysDictItem::getSortNo);
    List<SysDictItem> sysDictItemList = sysDictItemService.list(lambdaQueryWrapper);

    Map<String, List<SysDictItem>> map = new HashMap<>();

    for (SysDict sysDict : sysDictList) {
      String dictCode = sysDict.getDictCode();
      List<SysDictItem> value = map.get(dictCode);

      if (value == null) {
        value = new ArrayList<>();
        map.put(dictCode, value);
      }

      String dictId = sysDict.getId();
      for (SysDictItem sysDictItem : sysDictItemList) {
        if (sysDictItem.getDictId().equals(dictId)) {
          value.add(sysDictItem);
        }
      }
    }

    return map;
  }

}
