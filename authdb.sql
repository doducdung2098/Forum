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
Drop schema if exists `authdb`;
CREATE SCHEMA IF NOT EXISTS `authdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `authdb` ;

-- -----------------------------------------------------
-- Table `chatboxdb1`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `authdb`.`user`;
CREATE TABLE IF NOT EXISTS `authdb`.`user` (
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

INSERT INTO `authdb`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('admin', '12345', 'admin@123', '2138721381', 'admin');
INSERT INTO `authdb`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('dungdo', '12345', 'dungdo@hcl.com', '0379242892', 'customer');
INSERT INTO `authdb`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('ducdung', '12345', 'dungdo@hcl.com', '379242892', 'customer');
INSERT INTO `authdb`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('dodung', '12345', 'dungdo@hcl.com', '379242892', 'customer');
INSERT INTO `authdb`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('phamhieu', '12345', 'phamhieu@hcl.com', '379242892', 'customer');
INSERT INTO `authdb`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('huedo', '12345', 'huedo@hcl.com', '379242892', 'customer');
INSERT INTO `authdb`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('trinhvu', '12345', 'trinhvu@hcl.com', '379242892', 'customer');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '5');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '1');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '4');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '3');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '2');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '6');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '7');
