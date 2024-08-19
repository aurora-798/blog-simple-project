/*
 Navicat Premium Data Transfer

 Source Server         : mysql 5.7
 Source Server Type    : MySQL
 Source Server Version : 50738
 Source Host           : localhost:3306
 Source Schema         : blogs

 Target Server Type    : MySQL
 Target Server Version : 50738
 File Encoding         : 65001

 Date: 22/12/2023 20:47:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blogs
-- ----------------------------
DROP TABLE IF EXISTS `blogs`;
CREATE TABLE `blogs`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `likes` int(11) NULL DEFAULT NULL,
  `favours` int(11) NULL DEFAULT NULL,
  `createTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `updateTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blogs
-- ----------------------------
INSERT INTO `blogs` VALUES (3, '悲风白杨', 360, 360, '2022-01-01 19:10:59', '2023-12-22 20:36:32');
INSERT INTO `blogs` VALUES (4, '九阴白骨爪', 400, 400, '2022-01-01 19:10:59', '2023-12-16 22:35:50');
INSERT INTO `blogs` VALUES (5, '九阴真经', 1000, 100, '2022-01-01 19:10:59', '2022-01-01 19:10:59');
INSERT INTO `blogs` VALUES (6, '明月沉南海', 77, 200, '2022-01-01 19:10:59', '2023-12-17 19:10:2');
INSERT INTO `blogs` VALUES (7, '明月沉东海', 789, 200, '2022-01-01 19:10:59', '2023-12-17 16:33:42');
INSERT INTO `blogs` VALUES (12, '冬至到,吃饺子', 360, 360, '2023-12-22 20:36:32', '2023-12-22 20:36:32');

SET FOREIGN_KEY_CHECKS = 1;
