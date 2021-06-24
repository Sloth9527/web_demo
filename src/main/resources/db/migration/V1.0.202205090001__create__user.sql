DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       int(6)                                                 NOT NULL AUTO_INCREMENT,
    `username` varchar(25) CHARACTER SET utf8                         NOT NULL,
    `nickname` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `password` char(16) CHARACTER SET utf8                            NOT NULL,
    PRIMARY KEY (id)
);


