CREATE TABLE `roles` (
    `id`   INT NOT NULL AUTO_INCREMENT  COMMENT '識別番号' ,
    `name` VARCHAR(255) NOT NULL       COMMENT 'ロール' ,
    PRIMARY KEY (`id`),
    UNIQUE `roles_name` (`name`)
);
