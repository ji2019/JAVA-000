/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 24/11/2020 08:41:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for member_inf
-- ----------------------------
DROP TABLE IF EXISTS `member_inf`;
CREATE TABLE `member_inf`  (
  `member_inf_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `member_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户真实姓名',
  `identity_card_type` tinyint(0) NOT NULL DEFAULT 1 COMMENT '证件类型：1 身份证，2 军官证，3 护照',
  `identity_card_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '证件号码',
  `mobile_phone` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '手机号',
  `member_email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `user_point` int(0) NOT NULL DEFAULT 0 COMMENT '用户积分',
  `register_time` timestamp(0) NOT NULL COMMENT '注册时间',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '会员生日',
  `member_level` tinyint(0) NOT NULL DEFAULT 1 COMMENT '会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石',
  `user_money` decimal(8, 2) NOT NULL COMMENT '用户余额',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` bigint(0) NULL DEFAULT NULL,
  `deleted` int(0) NULL DEFAULT NULL,
  `version` bigint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`member_inf_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_inf
-- ----------------------------

-- ----------------------------
-- Table structure for order_inf
-- ----------------------------
DROP TABLE IF EXISTS `order_inf`;
CREATE TABLE `order_inf`  (
  `order_id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `member_id` int(0) NULL DEFAULT NULL COMMENT '会员ID',
  `order_no` int(0) NULL DEFAULT NULL COMMENT '订单编号',
  `total_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '应付金额',
  `pay_total_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '实付金额',
  `discount_amount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '优惠金额',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `order_status` int(0) NULL DEFAULT NULL COMMENT '状态 0已退款 1正常  2退款中',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` bigint(0) NULL DEFAULT NULL,
  `deleted` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `version` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_inf
-- ----------------------------

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `order_item_id` int(0) NOT NULL COMMENT 'PKID',
  `order_id` int(0) NULL DEFAULT NULL COMMENT '订单ID',
  `order_no` int(0) NULL DEFAULT NULL COMMENT '订单编号',
  `order_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单状态',
  `member_id` int(0) NULL DEFAULT NULL COMMENT '会员ID',
  `product_id` int(0) NULL DEFAULT NULL COMMENT '商品ID',
  `product_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名称',
  `quantity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '购买数量 QTY ',
  `unit_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '应付单价',
  `pay_unit_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '实付单价',
  `total_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '应付价格',
  `pay_total_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '实付价格',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `product_snapshot` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品快照。json 格式存储，图片信息',
  `coupon_id` int(0) NULL DEFAULT NULL COMMENT '优惠券ID',
  `coupon_no` int(0) NULL DEFAULT NULL COMMENT '优惠券编号',
  `coupon_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '优惠券名称',
  `activity_coupon_id` int(0) NULL DEFAULT NULL COMMENT '活动券ID',
  `activity_coupon_no` int(0) NULL DEFAULT NULL COMMENT '活动券编号',
  `activity_coupon_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '活动券编号',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_by` datetime(0) NULL DEFAULT NULL,
  `update_time` bigint(0) NULL DEFAULT NULL,
  `version` bigint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`order_item_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单详情' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_item
-- ----------------------------

-- ----------------------------
-- Table structure for product_inf
-- ----------------------------
DROP TABLE IF EXISTS `product_inf`;
CREATE TABLE `product_inf`  (
  `product_id` int(0) NOT NULL,
  `product_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名称',
  `unit_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `selling_unit_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '销售价格',
  `quantity` int(0) NULL DEFAULT NULL COMMENT '库存数量  应该放到另外一张表里的',
  `cover` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品封面图 url',
  `photos` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品图片',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品描述',
  `display` int(0) NULL DEFAULT NULL COMMENT '会员端是否显示 1 显示  0 不显示',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` bigint(0) NULL DEFAULT NULL,
  `deleted` int(0) NULL DEFAULT NULL,
  `version` bigint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_inf
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
