CREATE TABLE IF NOT EXISTS `user` (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT ,
    `username` VARCHAR(50) NULL ,
    `password` VARCHAR(50) NULL ,
    `email` VARCHAR(100) NULL,
    `phone` VARCHAR(50) NULL ,
    `role` VARCHAR(50) NULL
)