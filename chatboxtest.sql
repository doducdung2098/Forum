-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema chatboxdb1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema chatboxdb1
-- -----------------------------------------------------
Drop schema if exists `chatboxdb1`;
CREATE SCHEMA IF NOT EXISTS `chatboxdb1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `chatboxdb1` ;

-- -----------------------------------------------------
-- Table `chatboxdb1`.`chatbox`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chatboxdb1`.`chatbox`;
CREATE TABLE IF NOT EXISTS `chatboxdb1`.`chatbox` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created_date` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `chatboxdb1`.`chatbox` (`created_date`) VALUES ('1643082084');
INSERT INTO `chatboxdb1`.`chatbox` (`created_date`) VALUES ('1643168484');
INSERT INTO `chatboxdb1`.`chatbox` (`created_date`) VALUES ('1643182884');
INSERT INTO `chatboxdb1`.`chatbox` (`created_date`) VALUES ('1643355684');


-- -----------------------------------------------------
-- Table `chatboxdb1`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chatboxdb1`.`user`;
CREATE TABLE IF NOT EXISTS `chatboxdb1`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` TEXT NULL,
  `password` TEXT NULL,
  `email` TEXT NULL,
  `phone` TEXT NULL,
  `role` TEXT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `chatboxdb1`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('admin', '12345', 'admin@123', '2138721381', 'admin');
INSERT INTO `chatboxdb1`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('dungdo', '12345', 'dungdo@hcl.com', '0379242892', 'customer');
INSERT INTO `chatboxdb1`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('ducdung', '12345', 'dungdo@hcl.com', '379242892', 'customer');
INSERT INTO `chatboxdb1`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('dodung', '12345', 'dungdo@hcl.com', '379242892', 'customer');
INSERT INTO `chatboxdb1`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('phamhieu', '12345', 'phamhieu@hcl.com', '379242892', 'customer');
INSERT INTO `chatboxdb1`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('huedo', '12345', 'huedo@hcl.com', '379242892', 'customer');
INSERT INTO `chatboxdb1`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('trinhvu', '12345', 'trinhvu@hcl.com', '379242892', 'customer');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '5');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '1');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '4');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '3');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '2');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '6');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '7');



-- -----------------------------------------------------
-- Table `chatboxdb1`.`message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chatboxdb1`.`message`;
CREATE TABLE IF NOT EXISTS `chatboxdb1`.`message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` text NULL,
  `created_date` VARCHAR(255) NULL,
  `chatbox_id` INT NULL,
  `user_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK71a7qfa9wmp3losvepdiwf68m` (`chatbox_id` ASC) VISIBLE,
  INDEX `FKb3y6etti1cfougkdr0qiiemgv` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK71a7qfa9wmp3losvepdiwf68m`
    FOREIGN KEY (`chatbox_id`)
    REFERENCES `chatboxdb1`.`chatbox` (`id`),
  CONSTRAINT `FKb3y6etti1cfougkdr0qiiemgv`
    FOREIGN KEY (`user_id`)
    REFERENCES `chatboxdb1`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `chatboxdb1`.`message` (`content`, `created_date`, `chatbox_id`, `user_id`) VALUES ('hi', '1648212087', '1', '2');
INSERT INTO `chatboxdb1`.`message` (`content`, `created_date`, `chatbox_id`, `user_id`) VALUES ('hi', '1648212147', '1', '3');
INSERT INTO `chatboxdb1`.`message` (`content`, `created_date`, `chatbox_id`, `user_id`) VALUES ('who are you?', '1648212207', '1', '3');
INSERT INTO `chatboxdb1`.`message` (`content`, `created_date`, `chatbox_id`, `user_id`) VALUES ('I am Dung', '1648212210', '1', '2');
INSERT INTO `chatboxdb1`.`message` (`content`, `created_date`, `chatbox_id`, `user_id`) VALUES ('can i help you?', '1648212214', '1', '3');
INSERT INTO `chatboxdb1`.`message` (`content`, `created_date`, `chatbox_id`, `user_id`) VALUES ('hey', '1648212087', '2', '2');
INSERT INTO `chatboxdb1`.`message` (`content`, `created_date`, `chatbox_id`, `user_id`) VALUES ('whats up?', '1648212147', '2', '4');
INSERT INTO `chatboxdb1`.`message` (`content`, `created_date`, `chatbox_id`, `user_id`) VALUES ('when do you return home?', '1648212210', '2', '2');
INSERT INTO `chatboxdb1`.`message` (`content`, `created_date`, `chatbox_id`, `user_id`) VALUES ('i dont know', '1648212214', '2', '4');
INSERT INTO `chatboxdb1`.`message` (`content`, `created_date`, `chatbox_id`, `user_id`) VALUES ('hi', '1651728434122', '3', '3');
INSERT INTO `chatboxdb1`.`message` (`content`, `created_date`, `chatbox_id`, `user_id`) VALUES ('hi', '1651733675373', '3', '5');


-- -----------------------------------------------------
-- Table `chatboxdb1`.`user_chatbox`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chatboxdb1`.`user_chatbox`;
CREATE TABLE IF NOT EXISTS `chatboxdb1`.`user_chatbox` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `last_update` VARCHAR(255) NULL,
  `chatbox_id` INT NULL,
  `user_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKk61pogvtvym4s3uryx4bqn022` (`chatbox_id` ASC) VISIBLE,
  INDEX `FK689jwhfm4egygu9j3ymkwem1j` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK689jwhfm4egygu9j3ymkwem1j`
    FOREIGN KEY (`user_id`)
    REFERENCES `chatboxdb1`.`user` (`user_id`),
  CONSTRAINT `FKk61pogvtvym4s3uryx4bqn022`
    FOREIGN KEY (`chatbox_id`)
    REFERENCES `chatboxdb1`.`chatbox` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `chatboxdb1`.`user_chatbox` (`last_update`, `chatbox_id`, `user_id`) VALUES ('1650699687', '1', '2');
INSERT INTO `chatboxdb1`.`user_chatbox` (`last_update`, `chatbox_id`, `user_id`) VALUES ('1650703287', '1', '3');
INSERT INTO `chatboxdb1`.`user_chatbox` (`last_update`, `chatbox_id`, `user_id`) VALUES ('1650530487', '2', '2');
INSERT INTO `chatboxdb1`.`user_chatbox` (`last_update`, `chatbox_id`, `user_id`) VALUES ('1650541287', '2', '4');
INSERT INTO `chatboxdb1`.`user_chatbox` (`last_update`, `chatbox_id`, `user_id`) VALUES ('1647862887', '3', '3');
INSERT INTO `chatboxdb1`.`user_chatbox` (`last_update`, `chatbox_id`, `user_id`) VALUES ('1648122087', '3', '5');


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
