package com.xiaohudu.questionnaire.vo.res.sys;

import com.xiaohudu.questionnaire.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserResVO extends BaseEntity {
  private String username;
  private String realname;
  private String state;
}
