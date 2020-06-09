
CREATE TABLE `users` (
    `id`       INT NOT NULL AUTO_INCREMENT COMMENT '識別番号' ,
    `username` VARCHAR(255) NOT NULL      COMMENT 'アカウント' ,
    `email`    VARCHAR(255) NOT NULL      COMMENT 'メールアドレス' ,
    `password` VARCHAR(255) NOT NULL      COMMENT 'パスワード' ,
    `created`  DATETIME      NOT NULL      COMMENT '作成日時' ,
    `updated`  DATETIME      NOT NULL      COMMENT '更新日時' ,
    PRIMARY KEY (`id`),
    UNIQUE `users_username` (`username`),
    UNIQUE `users_email`    (`email`)
);

