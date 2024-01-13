package com.xiaohudu.questionnaire.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysModule extends BaseTreeEntity {
  @NotBlank(message = "模块名称不能为空")
  private String name;
  private String path;
  @NotBlank(message = "模块类型不能为空")
  private String moduleType;
  private String permissionType;
  private Integer sortNo;
  private String icon;
  private String code;
}
