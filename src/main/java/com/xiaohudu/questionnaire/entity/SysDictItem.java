package com.xiaohudu.questionnaire.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysDictItem extends BaseEntity {
  @NotBlank(message = "字典ID不能为空")
  private String dictId;
  @NotBlank(message = "字典项名称不能为空")
  private String itemText;
  @NotBlank(message = "字典项值不能为空")
  private String itemValue;
  private String description;
  private Integer sortNo;
  private String state;
}
