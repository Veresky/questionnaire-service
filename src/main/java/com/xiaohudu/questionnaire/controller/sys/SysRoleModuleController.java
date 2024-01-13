package com.xiaohudu.questionnaire.controller.sys;

import com.xiaohudu.questionnaire.service.sys.SysRoleModuleService;
import com.xiaohudu.questionnaire.utils.Result;
import com.xiaohudu.questionnaire.vo.req.sys.SysRoleModuleModuleIdListByRoleReqVO;
import com.xiaohudu.questionnaire.vo.req.sys.SysRoleModuleSaveBatchReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sys/roleModule")
public class SysRoleModuleController {
  @Autowired
  private SysRoleModuleService sysRoleModuleService;

  /**
   * moduleIdList - byRole
   * @param sysRoleModuleModuleIdListByRoleReqVO
   * @return Result
   */
  @PostMapping(path = "moduleIdListByRole")
  public Result moduleIdListByRole(@RequestBody SysRoleModuleModuleIdListByRoleReqVO sysRoleModuleModuleIdListByRoleReqVO) {
    List<String> moduleIdList = sysRoleModuleService.moduleIdListByRoleId(sysRoleModuleModuleIdListByRoleReqVO.getRoleId());
    return Result.success(moduleIdList);
  }

  /**
   * 批量更新
   * @param sysRoleModuleSaveBatchReqVO
   * @return Result
   */
  @PostMapping(path = "updateBatch")
  public Result updateBatch(@RequestBody SysRoleModuleSaveBatchReqVO sysRoleModuleSaveBatchReqVO) {
    sysRoleModuleService.updateBatch(sysRoleModuleSaveBatchReqVO);
    return Result.success();
  }
}
