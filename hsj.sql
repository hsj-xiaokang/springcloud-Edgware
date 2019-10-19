/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : hsj

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 18/10/2019 21:37:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ats_test
-- ----------------------------
DROP TABLE IF EXISTS `ats_test`;
CREATE TABLE `ats_test`  (
  `id` int(11) NOT NULL COMMENT 'id',
  `delete_status` int(11) NOT NULL DEFAULT 0 COMMENT '0未删除，1已删除',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'name',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ats_test
-- ----------------------------
INSERT INTO `ats_test` VALUES (1, 0, 'hsj-何胜金');

SET FOREIGN_KEY_CHECKS = 1;
