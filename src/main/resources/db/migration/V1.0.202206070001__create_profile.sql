DROP TABLE IF EXISTS `profile`;
CREATE TABLE `profile`
(
    id         INT(6)                                                 NOT NULL AUTO_INCREMENT,
    age        INT(4)                                                 NULL     DEFAULT NULL,
    nick_name  VARCHAR(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL,
    birth_date DATE                                                   NULL     DEFAULT NULL,
    user_id    INT(6)                                                 NOT NULL UNIQUE,
    created_at TIMESTAMP                                              NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP                                              NOT NUll DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT fk_user_id_id FOREIGN KEY (user_id) REFERENCES user (id) ON UPDATE CASCADE ON DELETE CASCADE
);