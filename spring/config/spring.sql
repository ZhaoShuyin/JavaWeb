/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : spring

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 03/02/2021 17:43:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `amount` float(255, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of accounts
-- ----------------------------
INSERT INTO `accounts` VALUES (1, 'aaa', 499992);
INSERT INTO `accounts` VALUES (2, 'bbb', 120);
INSERT INTO `accounts` VALUES (3, 'ccc', 1000);
INSERT INTO `accounts` VALUES (5, 'ggg', 1000);
INSERT INTO `accounts` VALUES (6, 'jjj', 1000);
INSERT INTO `accounts` VALUES (7, 'hhh', 1000);
INSERT INTO `accounts` VALUES (8, 'hhh', 1000);
INSERT INTO `accounts` VALUES (9, 'hhh', 1000);

SET FOREIGN_KEY_CHECKS = 1;
