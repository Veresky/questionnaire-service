package com.xiaohudu.questionnaire.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

@Data
public abstract class BaseTreeEntity extends BaseEntity {
  private String parentId;
  private String idPath;
  @TableField(exist = false)
  private String parentIdPath;
  @TableField(exist = false)
  private List<BaseTreeEntity> children;
}
