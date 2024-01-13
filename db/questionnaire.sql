/*
 Navicat Premium Data Transfer

 Source Server         : mysql_local
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : questionnaire

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 09/03/2023 09:24:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for monitor_log
-- ----------------------------
DROP TABLE IF EXISTS `monitor_log`;
CREATE TABLE `monitor_log`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求路径',
  `method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `code` int(6) NULL DEFAULT NULL COMMENT '响应码',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `duration` bigint(10) NULL DEFAULT NULL COMMENT '耗时',
  `ip` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_monitor_log_status`(`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of monitor_log
-- ----------------------------
INSERT INTO `monitor_log` VALUES ('06fcc5759717284e4868430c55d63864', '/sys/rolePermission/pageByRole', 'POST', 200, '2023-03-08 18:03:29', 11, '127.0.0.1', 'admin', '2023-03-08 18:03:29', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('09a9be508ae6048d1767873c77f821b1', '/sys/permission/page', 'POST', 200, '2023-03-08 17:51:07', 8, '127.0.0.1', 'admin', '2023-03-08 17:51:08', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('0f44ba8ee9ee4202a6a657e4ee887b5a', '/sys/dictItem/list', 'POST', 200, '2023-03-08 17:41:16', 7, '127.0.0.1', 'admin', '2023-03-08 17:41:16', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('179556e30cc04df68a1b0b7921049f5c', '/sys/permission/page', 'POST', 200, '2023-03-08 17:58:41', 8, '127.0.0.1', 'admin', '2023-03-08 17:58:41', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('243641c90ede736e6a3f4c5bc4c6abac', '/auth/login', 'POST', 200, '2023-03-08 17:39:33', 108, '127.0.0.1', NULL, '2023-03-08 17:39:33', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('252897687ea6ab51eae50e988f203ca8', '/sys/role/page', 'POST', 200, '2023-03-08 18:07:39', 11, '127.0.0.1', 'admin', '2023-03-08 18:07:39', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('2642b7ca8f409c1352308f9994d7f883', '/sys/dictItem/list', 'POST', 200, '2023-03-08 17:41:18', 8, '127.0.0.1', 'admin', '2023-03-08 17:41:18', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('26f37569f4b9042d43f771b474267125', '/sys/rolePermission/pageByRole', 'POST', 200, '2023-03-08 18:02:58', 8, '127.0.0.1', 'admin', '2023-03-08 18:02:58', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('283bae47072ef1dd326c8a030e8fae14', '/auth/currentUser', 'POST', 200, '2023-03-08 17:39:33', 59, '127.0.0.1', 'admin', '2023-03-08 17:39:34', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('2a1c6eff5a097bec1bf0df277656b902', '/sys/permission/page', 'POST', 200, '2023-03-08 17:59:45', 7, '127.0.0.1', 'admin', '2023-03-08 17:59:45', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('3b4ca54cb9e030b710d2273f8a51af72', '/sys/roleModule/moduleIdListByRole', 'POST', 200, '2023-03-08 18:00:10', 7, '127.0.0.1', 'admin', '2023-03-08 18:00:10', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('3ede9528bb2a784422caec8c39268f2c', '/sys/permission/page', 'POST', 200, '2023-03-08 17:57:05', 11, '127.0.0.1', 'admin', '2023-03-08 17:57:05', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('549518b5321ba51e33e5ea6a17b809da', '/sys/module/tree', 'POST', 200, '2023-03-08 18:00:08', 11, '127.0.0.1', 'admin', '2023-03-08 18:00:08', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('573f87c51952fa7cb0d9f0a5f3ed3018', '/sys/module/tree', 'POST', 200, '2023-03-08 18:00:10', 7, '127.0.0.1', 'admin', '2023-03-08 18:00:10', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('5b327df8f0f9739477c089d255ab544c', '/sys/role/page', 'POST', 200, '2023-03-08 17:41:49', 17, '127.0.0.1', 'admin', '2023-03-08 17:41:49', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('5d172142deb0b61de33bc8d6bc06ef9d', '/sys/roleModule/moduleIdListByRole', 'POST', 200, '2023-03-08 18:01:12', 7, '127.0.0.1', 'admin', '2023-03-08 18:01:12', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('63164e8d0d2d9ec30e8d18f5590b225b', '/sys/permission/page', 'POST', 200, '2023-03-08 17:42:01', 14, '127.0.0.1', 'admin', '2023-03-08 17:42:01', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('6549ecc61f738d16f866c7337bf4cc22', '/sys/user/page', 'POST', 200, '2023-03-08 17:39:40', 20, '127.0.0.1', 'admin', '2023-03-08 17:39:40', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('6ec4aac10efd5fdf69ecb018ce060e57', '/questionnaire/questionnaire/page', 'POST', 200, '2023-03-08 17:39:34', 59, '127.0.0.1', 'admin', '2023-03-08 17:39:34', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('712746fd4ee7b358bc24204e3ce33986', '/sys/dictItem/list', 'POST', 200, '2023-03-08 17:41:12', 7, '127.0.0.1', 'admin', '2023-03-08 17:41:12', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('753499fc7dd95d4fe2b56bbf59d68459', '/sys/dictItem/list', 'POST', 200, '2023-03-08 17:41:09', 8, '127.0.0.1', 'admin', '2023-03-08 17:41:09', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('76d88872d33d307c91ae21ad2bc8f4e0', '/sys/userRole/pageByUser', 'POST', 200, '2023-03-08 18:07:43', 9, '127.0.0.1', 'admin', '2023-03-08 18:07:43', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('7c2ff99d3fb473cd0980b77e22b3c878', '/sys/dict/page', 'POST', 200, '2023-03-08 17:40:16', 14, '127.0.0.1', 'admin', '2023-03-08 17:40:16', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('8033dd6368603b6c21a2fca24f530874', '/sys/rolePermission/pageByRole', 'POST', 200, '2023-03-08 18:02:42', 16, '127.0.0.1', 'admin', '2023-03-08 18:02:42', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('87277d03bbc12024c9efd806bf6d23cf', '/sys/module/tree', 'POST', 200, '2023-03-08 18:01:12', 7, '127.0.0.1', 'admin', '2023-03-08 18:01:12', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('9e002817d61aa3c0ed24ea45af5d1c4e', '/sys/permission/page', 'POST', 200, '2023-03-08 17:51:02', 11, '127.0.0.1', 'admin', '2023-03-08 17:51:02', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('affbeec57cae4465d0146db695ac8244', '/sys/module/tree', 'POST', 200, '2023-03-08 17:39:49', 10, '127.0.0.1', 'admin', '2023-03-08 17:39:49', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('c288ae22c30c197e0d0a2dacf2904cc2', '/sys/rolePermission/pageByRole', 'POST', 200, '2023-03-08 18:02:50', 14, '127.0.0.1', 'admin', '2023-03-08 18:02:50', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('c6b62511ac16b53ab79e772bae277203', '/sys/dictItem/list', 'POST', 200, '2023-03-08 17:41:10', 6, '127.0.0.1', 'admin', '2023-03-08 17:41:10', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('c809cc655e28fa397620cfc7dffc525b', '/sys/rolePermission/pageByRole', 'POST', 200, '2023-03-08 18:03:11', 6, '127.0.0.1', 'admin', '2023-03-08 18:03:11', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('c8a364a633aea19461d6aeb4d6eef685', '/sys/dict/all', 'POST', 200, '2023-03-08 17:39:32', 137, '127.0.0.1', NULL, '2023-03-08 17:39:32', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('da556e7d2d02f427bf1ca3ff84845b24', '/sys/permission/page', 'POST', 200, '2023-03-08 17:58:27', 8, '127.0.0.1', 'admin', '2023-03-08 17:58:27', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('dcb1b5e0581bb2fc8a0de7ace5489888', '/sys/roleModule/moduleIdListByRole', 'POST', 200, '2023-03-08 18:00:08', 11, '127.0.0.1', 'admin', '2023-03-08 18:00:08', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('e076c76cdc3508715efaed7b8cfde29d', '/sys/permission/page', 'POST', 200, '2023-03-08 17:51:11', 9, '127.0.0.1', 'admin', '2023-03-08 17:51:11', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('e58fc4e76bd21c05459f5751ebf26b09', '/sys/rolePermission/pageByRole', 'POST', 200, '2023-03-08 18:03:05', 7, '127.0.0.1', 'admin', '2023-03-08 18:03:05', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('e6364913c9e4b63a57df1ddadd942d03', '/sys/module/tree', 'POST', 200, '2023-03-08 18:07:35', 7, '127.0.0.1', 'admin', '2023-03-08 18:07:35', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('e69eb4538959312cf3350f323a40ab86', '/sys/permission/page', 'POST', 200, '2023-03-08 17:42:12', 9, '127.0.0.1', 'admin', '2023-03-08 17:42:12', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('e984df72c64d6626650215fe3d3d34a4', '/sys/user/page', 'POST', 200, '2023-03-08 18:07:40', 10, '127.0.0.1', 'admin', '2023-03-08 18:07:40', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('ec4713a74f2b2f4e26cb6fee463afc8c', '/sys/permission/page', 'POST', 200, '2023-03-08 17:58:11', 8, '127.0.0.1', 'admin', '2023-03-08 17:58:11', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('f182ed10b9e32e36b63445a70b39a25c', '/sys/permission/page', 'POST', 200, '2023-03-08 17:43:22', 15, '127.0.0.1', 'admin', '2023-03-08 17:43:22', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('f2ea7733d2f5b7c1e45a7f9325a07fdc', '/sys/dictItem/list', 'POST', 200, '2023-03-08 17:41:19', 5, '127.0.0.1', 'admin', '2023-03-08 17:41:19', NULL, NULL);
INSERT INTO `monitor_log` VALUES ('fca6bc3d7bc919523cb1b90389f1b76f', '/sys/dictItem/list', 'POST', 200, '2023-03-08 17:41:15', 6, '127.0.0.1', 'admin', '2023-03-08 17:41:15', NULL, NULL);

-- ----------------------------
-- Table structure for questionnaire_answer
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire_answer`;
CREATE TABLE `questionnaire_answer`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `answer_sheet_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '答卷id',
  `question_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '问题id',
  `option_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '选项id',
  `input` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '输入项',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '答题表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of questionnaire_answer
-- ----------------------------

-- ----------------------------
-- Table structure for questionnaire_answer_sheet
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire_answer_sheet`;
CREATE TABLE `questionnaire_answer_sheet`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `questionnaire_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '问卷id',
  `channel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '渠道(字典值)',
  `ip` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '答卷表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of questionnaire_answer_sheet
-- ----------------------------

-- ----------------------------
-- Table structure for questionnaire_question
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire_question`;
CREATE TABLE `questionnaire_question`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `questionnaire_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问卷id',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型(字典值)',
  `required` tinyint(1) NULL DEFAULT 0 COMMENT '是否必填(0-否,1-是)',
  `sort_no` int(10) NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '问题表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of questionnaire_question
-- ----------------------------

-- ----------------------------
-- Table structure for questionnaire_question_option
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire_question_option`;
CREATE TABLE `questionnaire_question_option`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `questionnaire_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问卷id',
  `question_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题id',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `inputable` tinyint(1) NULL DEFAULT NULL COMMENT '是否可输入(0-否,1-是)',
  `sort_no` int(10) NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '问题选项表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of questionnaire_question_option
-- ----------------------------

-- ----------------------------
-- Table structure for questionnaire_questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire_questionnaire`;
CREATE TABLE `questionnaire_questionnaire`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '描述',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `submit_tip` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '提交提示语',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态(字典值)',
  `collection_limit` int(10) NULL DEFAULT NULL COMMENT '回收限制',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_questionnaire_state`(`state`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '问卷表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of questionnaire_questionnaire
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `dict_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典名称',
  `dict_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典编码',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_sys_dict_dict_code`(`dict_code`) USING BTREE,
  INDEX `idx_sys_dict_dict_name`(`dict_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('139442989f232472c7ad8412944727d6', '答卷渠道', 'answer_channel', '', 'super_admin', '2023-03-01 15:08:56', 'super_admin', '2023-03-01 16:18:18');
INSERT INTO `sys_dict` VALUES ('1f38edb7074012bbed14ecaaadc5228b', '模块授权类型（按钮）', 'module_permission_type', '', 'super_admin', '2022-10-23 19:24:50', 'super_admin', '2023-02-16 15:26:30');
INSERT INTO `sys_dict` VALUES ('59794570556cdcb8e3e022fb46d4cbfc', '字典项状态', 'dict_item_state', '', 'super_admin', '2022-08-05 11:02:09', 'super_admin', '2022-08-15 11:22:45');
INSERT INTO `sys_dict` VALUES ('6b533dcccd6d8a01db49e30ffb95d019', '用户状态', 'user_state', '', 'super_admin', '2022-08-05 11:01:46', NULL, NULL);
INSERT INTO `sys_dict` VALUES ('785056bdc29c0e2ebfa1ff267a395ed1', '问卷状态', 'questionnaire_state', '', 'super_admin', '2023-02-20 19:57:17', NULL, NULL);
INSERT INTO `sys_dict` VALUES ('87695dcc5040bd22b9fff603e4211993', '题目类型', 'question_type', '', 'super_admin', '2023-02-21 10:04:40', NULL, NULL);
INSERT INTO `sys_dict` VALUES ('b3c7013b3f22bf478ad7987a95aacc6c', '模块类型', 'module_type', '', 'super_admin', '2022-05-27 14:47:19', NULL, NULL);

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `dict_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典id',
  `item_text` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典项文本',
  `item_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典项值',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `sort_no` int(10) NULL DEFAULT NULL COMMENT '排序',
  `state` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态(字典值)',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_sys_dict_item_dict_id`(`dict_id`) USING BTREE,
  INDEX `idx_sys_dict_item_dict_id_state`(`dict_id`, `state`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典项表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------
INSERT INTO `sys_dict_item` VALUES ('0216e04193479083b83f677dcfed8967', '87695dcc5040bd22b9fff603e4211993', '单选', 'radio', '', 1, 'enable', 'super_admin', '2023-02-21 10:05:10', 'super_admin', '2023-02-27 08:33:39');
INSERT INTO `sys_dict_item` VALUES ('1520e87d266b64fe4f0eaa79c3e1433b', '785056bdc29c0e2ebfa1ff267a395ed1', '已发布', 'published', '', 2, 'enable', 'super_admin', '2023-02-20 20:01:55', 'super_admin', '2023-02-20 20:36:17');
INSERT INTO `sys_dict_item` VALUES ('20f186c6f16489529509d5525d0e9e85', '87695dcc5040bd22b9fff603e4211993', '单行输入框', 'input', '', 3, 'enable', 'super_admin', '2023-02-21 10:05:40', 'super_admin', '2023-02-27 08:34:09');
INSERT INTO `sys_dict_item` VALUES ('28db28b247a57e6253924c66b5296cb4', '87695dcc5040bd22b9fff603e4211993', '多行输入框', 'textarea', '', 4, 'enable', 'super_admin', '2023-02-27 08:34:32', NULL, NULL);
INSERT INTO `sys_dict_item` VALUES ('35ac84c571e905775d9a3385a9c2edbc', '6b533dcccd6d8a01db49e30ffb95d019', '禁用', 'disable', '', 2, 'enable', 'super_admin', '2022-08-05 11:04:51', NULL, NULL);
INSERT INTO `sys_dict_item` VALUES ('3b380ad756aef2624fdc47b5970dec2f', '87695dcc5040bd22b9fff603e4211993', '多选', 'checkbox', '', 2, 'enable', 'super_admin', '2023-02-21 10:05:23', 'super_admin', '2023-02-27 08:33:42');
INSERT INTO `sys_dict_item` VALUES ('3e100096c1546a669c0db491ed357e92', '59794570556cdcb8e3e022fb46d4cbfc', '禁用', 'disable', '', 2, 'enable', 'super_admin', '2022-08-05 11:04:26', NULL, NULL);
INSERT INTO `sys_dict_item` VALUES ('4547e1997daf9344f7392199fb9bb693', '1f38edb7074012bbed14ecaaadc5228b', '可操作', 'operable', '', 1, 'enable', 'super_admin', '2022-10-23 19:34:15', NULL, NULL);
INSERT INTO `sys_dict_item` VALUES ('4bf58fd6ad0e69b63433184494c70d86', '6b533dcccd6d8a01db49e30ffb95d019', '启用', 'enable', '', 1, 'enable', 'super_admin', '2022-08-05 11:04:40', NULL, NULL);
INSERT INTO `sys_dict_item` VALUES ('7bc3f2cd768b8a85eeafa6cbef93c8f1', '785056bdc29c0e2ebfa1ff267a395ed1', '未发布', 'not_published', '', 1, 'enable', 'super_admin', '2023-02-20 20:01:32', 'super_admin', '2023-02-20 20:35:50');
INSERT INTO `sys_dict_item` VALUES ('7e88767bb29fb7b5307a355ff760c7a5', 'b3c7013b3f22bf478ad7987a95aacc6c', '菜单', 'menu', '', 1, 'enable', 'super_admin', '2022-05-27 14:47:39', NULL, NULL);
INSERT INTO `sys_dict_item` VALUES ('87a870567893446ea36894bc1a15350e', '1f38edb7074012bbed14ecaaadc5228b', '仅可见', 'viewable', '', 2, 'enable', 'super_admin', '2022-10-23 19:29:48', 'super_admin', '2022-10-23 19:34:43');
INSERT INTO `sys_dict_item` VALUES ('996c98fff4bd731f339d354723929e99', '139442989f232472c7ad8412944727d6', '电脑', 'pc', '', 1, 'enable', 'super_admin', '2023-03-01 16:14:31', 'super_admin', '2023-03-02 13:57:15');
INSERT INTO `sys_dict_item` VALUES ('a45e8e10b8b6d363be7a350500168be2', '139442989f232472c7ad8412944727d6', '手机', 'mobile', '', 2, 'enable', 'super_admin', '2023-03-01 16:14:46', 'super_admin', '2023-03-02 13:57:20');
INSERT INTO `sys_dict_item` VALUES ('a90c3d58ccd785f243c52da4fd413e25', '59794570556cdcb8e3e022fb46d4cbfc', '启用', 'enable', '', 1, 'enable', 'super_admin', '2022-08-05 11:03:43', NULL, NULL);
INSERT INTO `sys_dict_item` VALUES ('d8991ef0e5ccadcada7518d93f941418', 'b3c7013b3f22bf478ad7987a95aacc6c', '按钮', 'btn', '', 2, 'enable', 'super_admin', '2022-05-27 14:47:46', NULL, NULL);
INSERT INTO `sys_dict_item` VALUES ('f98df1f28d6a6f3a5a75b24ab965cd2f', '785056bdc29c0e2ebfa1ff267a395ed1', '已暂停', 'paused', '', 3, 'enable', 'super_admin', '2023-02-20 20:02:17', 'super_admin', '2023-02-20 20:36:55');

-- ----------------------------
-- Table structure for sys_module
-- ----------------------------
DROP TABLE IF EXISTS `sys_module`;
CREATE TABLE `sys_module`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父id',
  `id_path` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'id路径',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单路径',
  `module_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模块类型(字典值)',
  `sort_no` int(10) NULL DEFAULT NULL COMMENT '排序',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '按钮标识',
  `permission_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权类型',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_sys_module_sort_no`(`sort_no`) USING BTREE,
  INDEX `idx_sys_module_parent_id`(`parent_id`) USING BTREE,
  INDEX `idx_sys_module_module_type`(`module_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '模块表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_module
-- ----------------------------
INSERT INTO `sys_module` VALUES ('05ee43fbab8011edba567c8ae1bea1c4', 'f22d7bd9ab7f11edba567c8ae1bea1c4', 'f22d7bd9ab7f11edba567c8ae1bea1c4,05ee43fbab8011edba567c8ae1bea1c4', '在线用户', '/monitor/online-monitor', 'menu', 1, '', NULL, NULL, 'super_admin', '2023-02-13 17:22:56', NULL, NULL);
INSERT INTO `sys_module` VALUES ('1dbe8ffbab8011edba567c8ae1bea1c4', 'f22d7bd9ab7f11edba567c8ae1bea1c4', 'f22d7bd9ab7f11edba567c8ae1bea1c4,1dbe8ffbab8011edba567c8ae1bea1c4', '系统日志', '/monitor/log-monitor', 'menu', 2, '', NULL, NULL, 'super_admin', '2023-02-13 17:23:36', NULL, NULL);
INSERT INTO `sys_module` VALUES ('2aac736040c9f04c51092f4ac92d3813', '3efd2bda777a0b192fe258be873eaf9b', '3efd2bda777a0b192fe258be873eaf9b,2aac736040c9f04c51092f4ac92d3813', '模块管理', '/system/module-management', 'menu', 3, '', NULL, NULL, 'super_admin', '2022-06-08 10:21:37', NULL, NULL);
INSERT INTO `sys_module` VALUES ('39d3a5c3b10d11ed9aef7c8ae1bea1c4', NULL, '39d3a5c3b10d11ed9aef7c8ae1bea1c4', '问卷调查', '', 'menu', 1, 'icon-myapply', NULL, NULL, 'super_admin', '2023-02-20 18:56:29', 'super_admin', '2023-02-20 18:57:17');
INSERT INTO `sys_module` VALUES ('3efd2bda777a0b192fe258be873eaf9b', NULL, '3efd2bda777a0b192fe258be873eaf9b', '系统管理', '', 'menu', 2, 'icon-operate', NULL, NULL, 'super_admin', '2022-06-08 10:21:37', 'super_admin', '2023-02-20 18:56:33');
INSERT INTO `sys_module` VALUES ('631b6dc9b10d11ed9aef7c8ae1bea1c4', '39d3a5c3b10d11ed9aef7c8ae1bea1c4', '39d3a5c3b10d11ed9aef7c8ae1bea1c4,631b6dc9b10d11ed9aef7c8ae1bea1c4', '问卷管理', '/questionnaire/questionnaire-management', 'menu', 1, '', NULL, NULL, 'super_admin', '2023-02-20 18:57:38', NULL, NULL);
INSERT INTO `sys_module` VALUES ('793466a02c9dd11b534037adc7d5fcf0', '3efd2bda777a0b192fe258be873eaf9b', '3efd2bda777a0b192fe258be873eaf9b,793466a02c9dd11b534037adc7d5fcf0', '字典管理', '/system/dict-management', 'menu', 4, '', NULL, NULL, 'super_admin', '2022-06-08 10:21:37', 'super_admin', '2023-02-16 11:05:18');
INSERT INTO `sys_module` VALUES ('a09b26e0ee9994c8fa9246b185e400f4', '3efd2bda777a0b192fe258be873eaf9b', '3efd2bda777a0b192fe258be873eaf9b,a09b26e0ee9994c8fa9246b185e400f4', '用户管理', '/system/user-management', 'menu', 1, '', NULL, NULL, 'super_admin', '2022-06-08 10:21:37', NULL, NULL);
INSERT INTO `sys_module` VALUES ('ba3f3d7216935e3720286e7dac3939fa', '3efd2bda777a0b192fe258be873eaf9b', '3efd2bda777a0b192fe258be873eaf9b,ba3f3d7216935e3720286e7dac3939fa', '角色管理', '/system/role-management', 'menu', 2, '', NULL, NULL, 'super_admin', '2022-06-08 11:00:14', NULL, NULL);
INSERT INTO `sys_module` VALUES ('e6e9b76563f4de8af291922461998cf9', '3efd2bda777a0b192fe258be873eaf9b', '3efd2bda777a0b192fe258be873eaf9b,e6e9b76563f4de8af291922461998cf9', '接口管理', '/system/permission-management', 'menu', 5, '', NULL, NULL, 'super_admin', '2022-06-08 10:21:37', NULL, NULL);
INSERT INTO `sys_module` VALUES ('f22d7bd9ab7f11edba567c8ae1bea1c4', NULL, 'f22d7bd9ab7f11edba567c8ae1bea1c4', '系统监控', '', 'menu', 3, 'icon-channel', NULL, NULL, 'super_admin', '2023-02-13 17:22:23', 'super_admin', '2023-02-20 18:56:36');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口名称',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口地址',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_sys_permission_name`(`name`) USING BTREE,
  UNIQUE INDEX `uk_sys_permission_path`(`path`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('028943c000e62d121853e2d1113a87ea', '通过角色查询模块列表（系统管理）', '/sys/roleModule/moduleIdListByRole', '', 'super_admin', '2023-03-07 16:08:38', 'super_admin', '2023-03-07 16:40:32');
INSERT INTO `sys_permission` VALUES ('081208c4ef7520805421759f8ba26b08', '接口编辑（系统管理）', '/sys/permission/edit', '', 'super_admin', '2022-06-08 16:59:41', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('0f9d555c94a50cab6263e7d8fb006cc5', '接口详情（系统管理）', '/sys/permission/detail', '', 'super_admin', '2022-06-08 16:59:41', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('15e1cf1bab747f894579f81a9c8f4a1e', '用户编辑（系统管理）', '/sys/user/edit', '', 'super_admin', '2022-06-08 16:59:41', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('16777c8720e750f2a512852540da26b0', '通过用户查询角色分页（系统管理）', '/sys/userRole/pageByUser', '', 'super_admin', '2023-03-07 16:22:54', 'super_admin', '2023-03-07 16:40:53');
INSERT INTO `sys_permission` VALUES ('194a3df2577cea14189d7321fc243768', '字典详情（系统管理）', '/sys/dict/detail', '', 'super_admin', '2022-07-20 10:12:50', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('1a6de65a9423297cf233aedc7a889223', '用户详情（系统管理）', '/sys/user/detail', '', 'super_admin', '2022-06-08 16:59:26', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('1b60bbbe7f04da0dde779896a86ea3f8', '问卷编辑（问卷调查）', '/questionnaire/questionnaire/edit', '', 'super_admin', '2023-03-07 13:10:14', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('1dfbd04e3c5a15978544bda6557bf74b', '题目列表，带选项（问卷调查）', '/questionnaire/question/listWithQuestionOption', '', 'super_admin', '2023-03-07 13:12:00', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('1e01f4eff3ae1cdd7c3c93c0deafb520', '角色详情（系统管理）', '/sys/role/detail', '', 'super_admin', '2022-06-08 17:02:13', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('2079f214df2dd0fddc0e581c50f25e3a', '在线用户列表（系统监控）', '/monitor/online/list', '', 'super_admin', '2023-02-14 14:19:19', 'super_admin', '2023-03-07 11:42:09');
INSERT INTO `sys_permission` VALUES ('23e0447e60de7942b545ef75cddb2fb3', '答卷删除（问卷调查）', '/questionnaire/answerSheet/delete', '', 'super_admin', '2023-03-07 13:16:09', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('2780152d796ff7f8a2c2fbc18c0cb5b2', '角色删除（系统管理）', '/sys/role/delete', '', 'super_admin', '2022-06-08 17:04:04', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('3433f6390200828f8f6dfca504a3289f', '模块编辑（系统管理）', '/sys/module/edit', '', 'super_admin', '2022-06-08 17:08:56', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('3dd30a96721ffea63c348e4a9b537e13', '修改密码（系统管理）', '/sys/user/updatePassword', '', 'super_admin', '2023-02-17 09:12:21', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('406ad40a2fd7949e0192cddc2488b9b2', '问卷分页（问卷调查）', '/questionnaire/questionnaire/page', '', 'super_admin', '2023-03-07 13:08:36', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('4f4f147753c0565615413df5cc9020fd', '批量更新角色模块（系统管理）', '/sys/roleModule/updateBatch', '', 'super_admin', '2023-03-07 16:09:39', 'super_admin', '2023-03-07 16:40:37');
INSERT INTO `sys_permission` VALUES ('50dbd30c58ebf00129f66039ca799973', '字典删除（系统管理）', '/sys/dict/delete', '', 'super_admin', '2022-07-20 10:14:17', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('5a2ef2da221936eab7e8e4ad43b4de63', '用户删除（系统管理）', '/sys/user/delete', '', 'super_admin', '2022-06-08 17:01:05', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('5b16a460809759a42cb259dcc685c73a', '接口批量删除（系统管理）', '/sys/permission/removeByIds', '', 'super_admin', '2022-06-08 16:59:41', 'super_admin', '2023-03-07 14:23:53');
INSERT INTO `sys_permission` VALUES ('5f47c46894a00b350ecf045b3aac2063', '字典项编辑（系统管理）', '/sys/dictItem/edit', '', 'super_admin', '2022-07-20 10:16:47', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('6b6daeb0b6c39f7e8a94540cfee40e6e', '字典项分页（系统管理）', '/sys/dictItem/page', '', 'super_admin', '2022-07-20 10:16:19', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('7061e65d68ee3e5a792d3b7d32b3f62a', '用户角色批量删除（系统管理）', '/sys/userRole/removeByIds', '', 'super_admin', '2023-03-07 16:23:30', 'super_admin', '2023-03-07 16:41:00');
INSERT INTO `sys_permission` VALUES ('73e89bcd4cae26e84d97116c83e04415', '问卷详情（问卷调查）', 'questionnaire/questionnaire/detail', '', 'super_admin', '2023-03-07 13:09:06', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('791367ab287e9da3eec467ea8a74c84b', '答卷详情（问卷调查）', '/questionnaire/answerSheet/detail', '', 'super_admin', '2023-03-07 13:15:48', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('799954c090cd1781ebeb8cdfcd5251e4', '角色分页（系统管理）', '/sys/role/page', '', 'super_admin', '2022-06-08 17:01:40', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('8162920fde8c0d11a75cf5ba67b88e95', '通过角色查询接口分页（系统管理）', '/sys/rolePermission/pageByRole', '', 'super_admin', '2023-03-07 16:16:02', 'super_admin', '2023-03-07 16:40:41');
INSERT INTO `sys_permission` VALUES ('8183926ddcae81f17173a5456801d355', '题目选项分组下的总数（问卷调查）', '/questionnaire/answer/countGroupByQuestionOption', '', 'super_admin', '2023-03-07 13:05:54', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('897f2ba750d4cf85168d286dbed5ff24', '题目批量保存，带选项（问卷调查）', '/questionnaire/question/saveBatchWithQuestionOption', '', 'super_admin', '2023-03-07 13:12:45', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('8ea23830fb78b5d72ebf91cb26917ed5', '模块树（系统管理）', '/sys/module/tree', '', 'super_admin', '2022-06-08 17:08:19', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('93303940f71c535d519d42ea4ea5bfe6', '系统日志详情（系统监控）', '/monitor/log/detail', '', 'super_admin', '2023-02-14 14:18:35', 'super_admin', '2023-03-07 11:42:39');
INSERT INTO `sys_permission` VALUES ('958e27ac0f302b75e1e40dd2b0249957', '字典项删除（系统管理）', '/sys/dictItem/delete', '', 'super_admin', '2022-07-20 10:16:35', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('96fad4c450ba8d28e7184d272f9ed753', '字典分页（系统管理）', '/sys/dict/page', '', 'super_admin', '2022-07-20 10:12:25', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('9c6cf4a0cc30a710359ce13805fd2a93', '模块详情（系统管理）', '/sys/module/detail', '', 'super_admin', '2022-06-08 17:08:41', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('a0e06f9778c09fcce93e6ef3ba4a5405', '角色接口批量删除（系统管理）', '/sys/rolePermission/removeByIds', '', 'super_admin', '2023-03-07 16:20:13', 'super_admin', '2023-03-07 16:40:49');
INSERT INTO `sys_permission` VALUES ('ae998fe1fb2b7fa8d5bc5a2bdafaf4d3', '系统日志分页（系统监控）', '/monitor/log/page', '', 'super_admin', '2023-02-14 14:17:57', 'super_admin', '2023-03-07 11:42:43');
INSERT INTO `sys_permission` VALUES ('b26a52648440a9f3c19f34b0f3aa8bb7', '字典编辑（系统管理）', '/sys/dict/edit', '', 'super_admin', '2022-07-20 10:14:43', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('d53d8b7de696a938ffceb26c5911238a', '问卷删除（问卷调查）', '/questionnaire/questionnaire/delete', '', 'super_admin', '2023-03-07 13:09:52', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('d70fd36b1f3a9d2cab1c795b68b72041', '用户分页（系统管理）', '/sys/user/page', '', 'super_admin', '2022-06-08 16:59:41', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('daa8b07dd636a33adc3bd3e5c414a3a8', '模块删除（系统管理）', '/sys/module/delete', '', 'super_admin', '2022-06-08 17:09:05', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('dea4bcc2e368783a7c6da9fe3f13ecbf', '用户角色批量保存（系统管理）', '/sys/userRole/saveBatch', '', 'super_admin', '2023-03-07 16:23:14', 'super_admin', '2023-03-07 16:40:57');
INSERT INTO `sys_permission` VALUES ('ee32bf6f5c07649f01080967e4a631dc', '角色接口批量保存（系统管理）', '/sys/rolePermission/saveBatch', '', 'super_admin', '2023-03-07 16:19:39', 'super_admin', '2023-03-07 16:40:46');
INSERT INTO `sys_permission` VALUES ('f227450188adae3ee381aba58b7e6e50', '重置密码（系统管理）', '/sys/user/resetPassword', '', 'super_admin', '2023-02-17 14:59:53', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('f3bc594b66fe71a619d6a261e4411241', '接口分页（系统管理）', '/sys/permission/page', '', 'super_admin', '2022-06-08 16:59:41', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('f6ea76c76f363a81eaef8e11834b9ddd', '字典项详情（系统管理）', '/sys/dictItem/detail', '', 'super_admin', '2022-07-20 10:16:59', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('f700bc0958a61ddfc7d61ef9641c499f', '角色编辑（系统管理）', '/sys/role/edit', '', 'super_admin', '2022-06-08 17:02:49', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('f720bd3f6d0dc414aa6f5305a27615b3', '答卷分页（问卷调查）', '/questionnaire/answerSheet/page', '', 'super_admin', '2023-03-07 13:15:28', NULL, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编码',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_sys_role_role_code`(`role_code`) USING BTREE,
  UNIQUE INDEX `uk_sys_role_role_name`(`role_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('5d570915109483eabac03a428ad83e78', '管理员角色', 'admin_role', '', 'super_admin', '2022-07-20 09:48:06', 'super_admin', '2023-02-17 14:45:50');
INSERT INTO `sys_role` VALUES ('acccfc6e6584ef703427898dee2a9787', '超级管理员角色', 'super_admin_role', '', 'super_admin', '2022-07-20 09:46:18', 'super_admin', '2022-10-22 22:10:03');

-- ----------------------------
-- Table structure for sys_role_module
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_module`;
CREATE TABLE `sys_role_module`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `module_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模块id',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_sys_role_module_role_module_id`(`role_id`, `module_id`) USING BTREE,
  INDEX `idx_sys_role_module_role_id`(`role_id`) USING BTREE,
  INDEX `idx_sys_role_module_module_id`(`module_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色模块关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_module
-- ----------------------------
INSERT INTO `sys_role_module` VALUES ('00f69dca9a7f1e8065cb35dc6735c407', '5d570915109483eabac03a428ad83e78', 'ba3f3d7216935e3720286e7dac3939fa', 'super_admin', '2023-02-20 18:58:01', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('0863215fa2ace1593f50b532c5f642c4', 'acccfc6e6584ef703427898dee2a9787', '793466a02c9dd11b534037adc7d5fcf0', 'admin', '2023-03-03 17:34:16', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('13ba3bd2a56ea078faf3695c8406ee8e', 'acccfc6e6584ef703427898dee2a9787', 'e6e9b76563f4de8af291922461998cf9', 'admin', '2023-03-03 17:34:16', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('1461d291194ff19ce53d0ec3d181ba41', 'acccfc6e6584ef703427898dee2a9787', 'a09b26e0ee9994c8fa9246b185e400f4', 'admin', '2023-03-03 17:34:16', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('150c86f0f13799dee95cf56c3e4abb62', '5d570915109483eabac03a428ad83e78', 'e6e9b76563f4de8af291922461998cf9', 'super_admin', '2023-02-20 18:58:01', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('20b60c921c58e8386a7ec8188812983e', 'acccfc6e6584ef703427898dee2a9787', '631b6dc9b10d11ed9aef7c8ae1bea1c4', 'admin', '2023-03-03 17:34:16', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('29426ae351d4741859e31ace98eb2802', '5d570915109483eabac03a428ad83e78', 'a09b26e0ee9994c8fa9246b185e400f4', 'super_admin', '2023-02-20 18:58:01', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('31028d57945274333dceda76f1ab7ef0', 'acccfc6e6584ef703427898dee2a9787', '05ee43fbab8011edba567c8ae1bea1c4', 'admin', '2023-03-03 17:34:16', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('3b9aa2bd3838e641e86dc7726c201084', 'acccfc6e6584ef703427898dee2a9787', '1dbe8ffbab8011edba567c8ae1bea1c4', 'admin', '2023-03-03 17:34:16', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('4d09d10c1a122b791e4ba308d9d8975f', 'acccfc6e6584ef703427898dee2a9787', '3efd2bda777a0b192fe258be873eaf9b', 'admin', '2023-03-03 17:34:16', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('83cbdf134453f51fe48cf14ea57c8073', '5d570915109483eabac03a428ad83e78', '2aac736040c9f04c51092f4ac92d3813', 'super_admin', '2023-02-20 18:58:01', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('8865873dad4da40c9d8416d189535656', '5d570915109483eabac03a428ad83e78', '05ee43fbab8011edba567c8ae1bea1c4', 'super_admin', '2023-02-20 18:58:01', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('8ffe05baf9835567bcef8efef09aa708', 'acccfc6e6584ef703427898dee2a9787', '39d3a5c3b10d11ed9aef7c8ae1bea1c4', 'admin', '2023-03-03 17:34:16', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('93edf5fb526b212e272fc7e6b62588c9', '5d570915109483eabac03a428ad83e78', '631b6dc9b10d11ed9aef7c8ae1bea1c4', 'super_admin', '2023-02-20 18:58:01', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('9a3633b55809d08d8a0170543d710a70', '5d570915109483eabac03a428ad83e78', '3efd2bda777a0b192fe258be873eaf9b', 'super_admin', '2023-02-20 18:58:01', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('a1b9732a5c2538b19f49dcb1209e4843', '5d570915109483eabac03a428ad83e78', 'f22d7bd9ab7f11edba567c8ae1bea1c4', 'super_admin', '2023-02-20 18:58:01', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('a606e8b2ebba1d30a546c52f6891f662', 'acccfc6e6584ef703427898dee2a9787', '2aac736040c9f04c51092f4ac92d3813', 'admin', '2023-03-03 17:34:16', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('b405d706f0f58322542d8c4d27ebbe84', '5d570915109483eabac03a428ad83e78', '39d3a5c3b10d11ed9aef7c8ae1bea1c4', 'super_admin', '2023-02-20 18:58:01', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('b8be764b54f98902916ccc007878cc07', 'acccfc6e6584ef703427898dee2a9787', 'ba3f3d7216935e3720286e7dac3939fa', 'admin', '2023-03-03 17:34:16', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('c7fc20dbd36fca8cee09d862fe3983a4', '5d570915109483eabac03a428ad83e78', '1dbe8ffbab8011edba567c8ae1bea1c4', 'super_admin', '2023-02-20 18:58:01', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('e13c00ad061a896dcf21fc364beb6fc7', '5d570915109483eabac03a428ad83e78', '793466a02c9dd11b534037adc7d5fcf0', 'super_admin', '2023-02-20 18:58:01', NULL, NULL);
INSERT INTO `sys_role_module` VALUES ('efbd773a5079ade1fbdcd45aec2ec018', 'acccfc6e6584ef703427898dee2a9787', 'f22d7bd9ab7f11edba567c8ae1bea1c4', 'admin', '2023-03-03 17:34:16', NULL, NULL);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限id',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_sys_role_permission_role_permission_id`(`role_id`, `permission_id`) USING BTREE,
  INDEX `idx_sys_role_permission_role_id`(`role_id`) USING BTREE,
  INDEX `idx_sys_role_permission_permission_id`(`permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('0bdd79d9bcab11edbe6c7c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '1b60bbbe7f04da0dde779896a86ea3f8', 'super_admin', '2023-03-07 13:43:46', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('0bdd79e1bcab11edbe6c7c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '1dfbd04e3c5a15978544bda6557bf74b', 'super_admin', '2023-03-07 13:43:46', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('0bdd79e9bcab11edbe6c7c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '23e0447e60de7942b545ef75cddb2fb3', 'super_admin', '2023-03-07 13:43:46', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('0bdd79f1bcab11edbe6c7c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '406ad40a2fd7949e0192cddc2488b9b2', 'super_admin', '2023-03-07 13:43:46', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('0bdd7b4bbcab11edbe6c7c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '73e89bcd4cae26e84d97116c83e04415', 'super_admin', '2023-03-07 13:43:46', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('0bdd7b5abcab11edbe6c7c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '791367ab287e9da3eec467ea8a74c84b', 'super_admin', '2023-03-07 13:43:46', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('0bdd7b62bcab11edbe6c7c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '8183926ddcae81f17173a5456801d355', 'super_admin', '2023-03-07 13:43:46', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('0bdd7b68bcab11edbe6c7c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '897f2ba750d4cf85168d286dbed5ff24', 'super_admin', '2023-03-07 13:43:46', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('0bdd7c13bcab11edbe6c7c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', 'd53d8b7de696a938ffceb26c5911238a', 'super_admin', '2023-03-07 13:43:46', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('0bdd7c1abcab11edbe6c7c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', 'f720bd3f6d0dc414aa6f5305a27615b3', 'super_admin', '2023-03-07 13:43:46', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('224adfbebcc311edbe6c7c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '028943c000e62d121853e2d1113a87ea', 'super_admin', '2023-03-07 16:36:11', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f6fae07ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '081208c4ef7520805421759f8ba26b08', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f6ff807ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '0f9d555c94a50cab6263e7d8fb006cc5', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f700607ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '15e1cf1bab747f894579f81a9c8f4a1e', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f701007ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '194a3df2577cea14189d7321fc243768', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f701c07ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '1a6de65a9423297cf233aedc7a889223', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f702307ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '1e01f4eff3ae1cdd7c3c93c0deafb520', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f702a07ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '2780152d796ff7f8a2c2fbc18c0cb5b2', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f703007ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '3433f6390200828f8f6dfca504a3289f', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f703a07ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '50dbd30c58ebf00129f66039ca799973', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f703f07ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '5a2ef2da221936eab7e8e4ad43b4de63', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f704307ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '5b16a460809759a42cb259dcc685c73a', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f704907ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '5f47c46894a00b350ecf045b3aac2063', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f704e07ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '6b6daeb0b6c39f7e8a94540cfee40e6e', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f705307ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '799954c090cd1781ebeb8cdfcd5251e4', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f706207ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '8ea23830fb78b5d72ebf91cb26917ed5', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f709307ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '958e27ac0f302b75e1e40dd2b0249957', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f709e07ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '96fad4c450ba8d28e7184d272f9ed753', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f70a907ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '9c6cf4a0cc30a710359ce13805fd2a93', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f70b107ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', 'b26a52648440a9f3c19f34b0f3aa8bb7', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f70bb07ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', 'd70fd36b1f3a9d2cab1c795b68b72041', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f70c107ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', 'daa8b07dd636a33adc3bd3e5c414a3a8', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f70c607ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', 'f3bc594b66fe71a619d6a261e4411241', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f70cb07ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', 'f6ea76c76f363a81eaef8e11834b9ddd', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('2d5f70d007ed11ed96727c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', 'f700bc0958a61ddfc7d61ef9641c499f', NULL, '2022-07-20 13:31:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('3e4ca764ae6011ed91457c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '3dd30a96721ffea63c348e4a9b537e13', 'super_admin', '2023-02-17 09:13:08', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('3ef2be94ac3311ed91457c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '2079f214df2dd0fddc0e581c50f25e3a', 'super_admin', '2023-02-14 14:46:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('3ef2bf1bac3311ed91457c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '93303940f71c535d519d42ea4ea5bfe6', 'super_admin', '2023-02-14 14:46:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('3ef2bf2bac3311ed91457c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', 'ae998fe1fb2b7fa8d5bc5a2bdafaf4d3', 'super_admin', '2023-02-14 14:46:03', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('487682ddac3311ed91457c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '2079f214df2dd0fddc0e581c50f25e3a', 'super_admin', '2023-02-14 14:46:19', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('487682f1ac3311ed91457c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '93303940f71c535d519d42ea4ea5bfe6', 'super_admin', '2023-02-14 14:46:19', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('487682f8ac3311ed91457c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', 'ae998fe1fb2b7fa8d5bc5a2bdafaf4d3', 'super_admin', '2023-02-14 14:46:19', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('52fe8d7ebcc311edbe6c7c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '4f4f147753c0565615413df5cc9020fd', 'super_admin', '2023-03-07 16:37:33', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('5e22aa16bcc311edbe6c7c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '8162920fde8c0d11a75cf5ba67b88e95', 'super_admin', '2023-03-07 16:37:52', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('66954fdebcc311edbe6c7c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', 'a0e06f9778c09fcce93e6ef3ba4a5405', 'super_admin', '2023-03-07 16:38:06', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('66954ff8bcc311edbe6c7c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', 'ee32bf6f5c07649f01080967e4a631dc', 'super_admin', '2023-03-07 16:38:06', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('6d5c0b95bcc311edbe6c7c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '7061e65d68ee3e5a792d3b7d32b3f62a', 'super_admin', '2023-03-07 16:38:17', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('6d5c0ba9bcc311edbe6c7c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', 'dea4bcc2e368783a7c6da9fe3f13ecbf', 'super_admin', '2023-03-07 16:38:17', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('72ce09c0bcc311edbe6c7c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '16777c8720e750f2a512852540da26b0', 'super_admin', '2023-03-07 16:38:26', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('af7f10d6bcaa11edbe6c7c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '1b60bbbe7f04da0dde779896a86ea3f8', 'super_admin', '2023-03-07 13:41:11', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('af7f10ddbcaa11edbe6c7c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '1dfbd04e3c5a15978544bda6557bf74b', 'super_admin', '2023-03-07 13:41:11', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('af7f10e6bcaa11edbe6c7c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '23e0447e60de7942b545ef75cddb2fb3', 'super_admin', '2023-03-07 13:41:11', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('af7f10edbcaa11edbe6c7c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '406ad40a2fd7949e0192cddc2488b9b2', 'super_admin', '2023-03-07 13:41:11', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('af7f1106bcaa11edbe6c7c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '73e89bcd4cae26e84d97116c83e04415', 'super_admin', '2023-03-07 13:41:11', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('af7f110bbcaa11edbe6c7c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '791367ab287e9da3eec467ea8a74c84b', 'super_admin', '2023-03-07 13:41:11', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('af7f1111bcaa11edbe6c7c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '8183926ddcae81f17173a5456801d355', 'super_admin', '2023-03-07 13:41:11', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('af7f1116bcaa11edbe6c7c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', '897f2ba750d4cf85168d286dbed5ff24', 'super_admin', '2023-03-07 13:41:11', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('af7f111dbcaa11edbe6c7c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', 'd53d8b7de696a938ffceb26c5911238a', 'super_admin', '2023-03-07 13:41:11', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('af7f1124bcaa11edbe6c7c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', 'f720bd3f6d0dc414aa6f5305a27615b3', 'super_admin', '2023-03-07 13:41:11', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('c3cb4b24ae9011ed9fc17c8ae1bea1c4', 'acccfc6e6584ef703427898dee2a9787', 'f227450188adae3ee381aba58b7e6e50', 'super_admin', '2023-02-17 15:00:30', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('cf7373ccbcc411edbe6c7c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '028943c000e62d121853e2d1113a87ea', 'super_admin', '2023-03-07 16:48:11', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('e54f5b79bcc411edbe6c7c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '8162920fde8c0d11a75cf5ba67b88e95', 'super_admin', '2023-03-07 16:48:48', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('fc6d23e0bcc411edbe6c7c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '16777c8720e750f2a512852540da26b0', 'super_admin', '2023-03-07 16:49:27', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('fd10527b520d11ed84867c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '0f9d555c94a50cab6263e7d8fb006cc5', NULL, '2022-10-22 21:32:35', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('fd105f43520d11ed84867c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '194a3df2577cea14189d7321fc243768', NULL, '2022-10-22 21:32:35', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('fd105f5b520d11ed84867c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '1a6de65a9423297cf233aedc7a889223', NULL, '2022-10-22 21:32:35', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('fd105f65520d11ed84867c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '1e01f4eff3ae1cdd7c3c93c0deafb520', NULL, '2022-10-22 21:32:35', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('fd105f6a520d11ed84867c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '6b6daeb0b6c39f7e8a94540cfee40e6e', NULL, '2022-10-22 21:32:35', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('fd105f74520d11ed84867c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '799954c090cd1781ebeb8cdfcd5251e4', NULL, '2022-10-22 21:32:35', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('fd105f7a520d11ed84867c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '8ea23830fb78b5d72ebf91cb26917ed5', NULL, '2022-10-22 21:32:35', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('fd105f80520d11ed84867c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '96fad4c450ba8d28e7184d272f9ed753', NULL, '2022-10-22 21:32:35', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('fd105f86520d11ed84867c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', '9c6cf4a0cc30a710359ce13805fd2a93', NULL, '2022-10-22 21:32:35', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('fd105f8d520d11ed84867c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', 'd70fd36b1f3a9d2cab1c795b68b72041', NULL, '2022-10-22 21:32:35', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('fd105f92520d11ed84867c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', 'f3bc594b66fe71a619d6a261e4411241', NULL, '2022-10-22 21:32:35', NULL, NULL);
INSERT INTO `sys_role_permission` VALUES ('fd105f96520d11ed84867c8ae1bea1c4', '5d570915109483eabac03a428ad83e78', 'f6ea76c76f363a81eaef8e11834b9ddd', NULL, '2022-10-22 21:32:35', NULL, NULL);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `realname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐值',
  `state` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态(字典值)',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_sys_role_username`(`username`) USING BTREE,
  INDEX `idx_sys_role_state`(`state`) USING BTREE,
  INDEX `idx_sys_role_realname`(`realname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('3f1bffd8311cfd12b96498d26b6fa068', 'super_admin', '超级管理员', '85736412A19EC5409ADE0E014DD3C546', '9O892h', 'enable', 'super_admin', '2022-07-25 10:06:59', 'super_admin', '2023-03-08 14:57:32');
INSERT INTO `sys_user` VALUES ('66e8be7d33d07b862f63c623e841f21b', 'admin', '管理员', '11D48E9B230BAF6E02FAE3209A3EEE4E', 'CwJxvI', 'enable', 'super_admin', '2023-02-17 14:46:50', 'admin', '2023-03-08 15:02:45');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_sys_user_role_user_role_id`(`user_id`, `role_id`) USING BTREE,
  INDEX `idx_sys_user_role_user_id`(`user_id`) USING BTREE,
  INDEX `idx_sys_user_role_role_id`(`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('86bb9a960bbe11edb3b27c8ae1bea1c4', '3f1bffd8311cfd12b96498d26b6fa068', 'acccfc6e6584ef703427898dee2a9787', 'super_admin', '2022-07-25 10:07:24', NULL, NULL);
INSERT INTO `sys_user_role` VALUES ('e5f7ea16ae8e11ed9fc17c8ae1bea1c4', '66e8be7d33d07b862f63c623e841f21b', '5d570915109483eabac03a428ad83e78', 'super_admin', '2023-02-17 14:47:09', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
