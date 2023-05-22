-- 用户表
DROP TABLE IF EXISTS `lib_user`;
CREATE TABLE `lib_user`
(
    `user_id`       int(11) NOT NULL AUTO_INCREMENT,
    `user_name`     varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `user_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `user_realname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `user_address`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `user_type`     varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `create_time`   datetime(0) NULL DEFAULT NULL,
    `create_opr`    int(11) NULL DEFAULT NULL,
    `update_time`   datetime(0) NULL DEFAULT NULL,
    `update_opr`    int(11) NULL DEFAULT NULL,
    `enable_flag`   int(11) NULL DEFAULT NULL,
    `delete_flag`   int(11) NULL DEFAULT NULL,
    PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
alter table `lib_user` add unique (`user_name`);
alter table `lib_user` add unique (`user_realname`);