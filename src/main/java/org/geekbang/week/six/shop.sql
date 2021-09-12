SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`
(
    `id`       bigint NOT NULL AUTO_INCREMENT COMMENT '订单表主键',
    `user_id`  bigint NULL DEFAULT NULL COMMENT '用户ID',
    `order_id` bigint NULL DEFAULT NULL COMMENT '订单ID',
    `goods_id` int    NULL DEFAULT NULL COMMENT '商品ID',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `u_uid_gid` (`user_id`, `goods_id`) USING BTREE COMMENT '用户ID和商品ID索引'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_order_info
-- ----------------------------
DROP TABLE IF EXISTS `t_order_info`;
CREATE TABLE `t_order_info`
(
    `id`               bigint                                                       NOT NULL AUTO_INCREMENT,
    `user_id`          bigint                                                       NULL DEFAULT NULL COMMENT '用户ID',
    `goods_id`         bigint                                                       NULL DEFAULT NULL COMMENT '商品ID',
    `delivery_addr_id` bigint                                                       NULL DEFAULT NULL COMMENT '收获地址ID',
    `goods_name`       varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '冗余过来的商品名称',
    `goods_count`      int                                                          NULL DEFAULT 0 COMMENT '商品数量',
    `goods_price`      decimal(10, 2)                                               NULL DEFAULT 0.00 COMMENT '商品单价',
    `order_channel`    tinyint                                                      NULL DEFAULT 0 COMMENT '1pc，2android，3ios',
    `status`           tinyint                                                      NULL DEFAULT 0 COMMENT '订单状态，0新建未支付，1已支付，2已发货，3已收货，4已退款，5已完成',
    `create_date`      datetime                                                     NULL DEFAULT NULL COMMENT '订单的创建时间',
    `pay_date`         datetime                                                     NULL DEFAULT NULL COMMENT '支付时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1565
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`
(
    `id`              bigint                                                        NOT NULL COMMENT '用户id',
    `nickname`        varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '昵称',
    `password`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL COMMENT '密码',
    `salt`            varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL COMMENT '加密盐',
    `head`            varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
    `register_date`   datetime                                                      NULL DEFAULT NULL COMMENT '注册时间',
    `last_login_date` datetime                                                      NULL DEFAULT NULL COMMENT '上次登陆时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;
