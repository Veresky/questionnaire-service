package com.xiaohudu.questionnaire.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysDict extends BaseEntity {
  @NotBlank(message = "字典名称不能为空")
  private String dictName;
  @NotBlank(message = "字典编码不能为空")
  private String dictCode;
  private String description;
}
