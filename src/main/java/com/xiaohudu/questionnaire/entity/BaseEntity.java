package com.xiaohudu.questionnaire.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class BaseEntity {
  @TableId
  private String id;
  @TableField(fill = FieldFill.INSERT)
  private String createBy;
  @TableField(fill = FieldFill.INSERT)
  private LocalDateTime createTime;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateBy;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime updateTime;
}
