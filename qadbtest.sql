-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema qadb1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema qadb1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `qadb1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `qadb1` ;

-- -----------------------------------------------------
-- Table `qadb1`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qadb1`.`user`;
CREATE TABLE IF NOT EXISTS `qadb1`.`user` (
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

INSERT INTO `qadb1`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('admin', '12345', 'admin@123', '2138721381', 'admin');
INSERT INTO `qadb1`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('dungdo', '12345', 'dungdo@hcl.com', '0379242892', 'customer');
INSERT INTO `qadb1`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('ducdung', '12345', 'dungdo@hcl.com', '379242892', 'customer');
INSERT INTO `qadb1`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('dodung', '12345', 'dungdo@hcl.com', '379242892', 'customer');
INSERT INTO `qadb1`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('phamhieu', '12345', 'phamhieu@hcl.com', '379242892', 'customer');
INSERT INTO `qadb1`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('huedo', '12345', 'huedo@hcl.com', '379242892', 'customer');
INSERT INTO `qadb1`.`user` (`username`, `password`, `email`, `phone`, `role`) VALUES ('trinhvu', '12345', 'trinhvu@hcl.com', '379242892', 'customer');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '5');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '1');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '4');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '3');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '2');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '6');
UPDATE `authdb`.`user` SET `password` = '827CCB0EEA8A706C4C34A16891F84E7B' WHERE (`user_id` = '7');

-- -----------------------------------------------------
-- Table `qadb1`.`question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qadb1`.`question`;
CREATE TABLE IF NOT EXISTS `qadb1`.`question` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` text NULL,
  `created_date` VARCHAR(255) NULL,
  `img` VARCHAR(255) NULL,
  `status` INT NULL,
  `title` VARCHAR(255) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK4ekrlbqiybwk8abhgclfjwnmc` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK4ekrlbqiybwk8abhgclfjwnmc`
    FOREIGN KEY (`user_id`)
    REFERENCES `qadb1`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `qadb1`.`question` (`content`, `created_date`, `img`, `status`, `title`, `user_id`) VALUES ('Why is the TV station logo so deep inside?', '2141313131313', 'question1.png', '0', 'Why is the TV station logo so deep inside?', '2');
INSERT INTO `qadb1`.`question` (`content`, `created_date`, `img`, `status`, `title`, `user_id`) VALUES ('Blockchain (part 1)', '5214587313', 'question2.png', '0', 'Blockchain (part 1)', '2');
INSERT INTO `qadb1`.`question` (`content`, `created_date`, `img`, `status`, `title`, `user_id`) VALUES ('Historical basis of Vietnam\'s sovereignty over Hoang Sa and Truong Sa', '8213821362193', 'question3.png', '0', 'Historical basis of Vietnam\'s sovereignty over Hoang Sa and Truong Sa', '2');
INSERT INTO `qadb1`.`question` (`content`, `created_date`, `img`, `status`, `title`, `user_id`) VALUES ('Historical basis of Vietnam\'s sovereignty over Hoang Sa and Truong Sa', '8213821362193', 'question3.png', '0', 'Historical basis of Vietnam\'s sovereignty over Hoang Sa and Truong Sa', '3');
INSERT INTO `qadb1`.`question` (`content`, `created_date`, `img`, `status`, `title`, `user_id`) VALUES ('Blockchain (part 1)', '8213821362193', 'question3.png', '0', 'Blockchain (part 1)', '3');
INSERT INTO `qadb1`.`question` (`content`, `created_date`, `img`, `status`, `title`, `user_id`) VALUES ('Why is the TV station logo so deep inside?', '8213821362193', 'question1.png', '0', 'Why is the TV station logo so deep inside?', '4');
INSERT INTO `qadb1`.`question` (`content`, `created_date`, `img`, `status`, `title`, `user_id`) VALUES ('Why is the TV station logo so deep inside?', '8213821362193', 'question1.png', '0', 'Why is the TV station logo so deep inside?', '4');
INSERT INTO `qadb1`.`question` (`content`, `created_date`, `img`, `status`, `title`, `user_id`) VALUES ('Why do I believe in Blockchain?', '8213821362193', 'question3.png', '1', 'If I do good, right things, I will surely get better things in the future.If I make a mistake, then I will be punished. And you too.', '3');
INSERT INTO `qadb1`.`question` (`content`, `created_date`, `img`, `status`, `title`, `user_id`) VALUES ('Why is the human race superior to other animals?', '5214587313', 'question3.png', '1', 'If I do good, right things, I will surely get better things in the future.If I make a mistake, then I will be punished. And you too.', '4');
INSERT INTO `qadb1`.`question` (`content`, `created_date`, `img`, `status`, `title`, `user_id`) VALUES ('History of the Megaman/Rockman series', '5214587313', 'question3.png', '1', 'When it comes to a series of games associated with childhood, surely many people will immediately think of Megaman, also known for the...', '4');
INSERT INTO `qadb1`.`question` (`content`, `created_date`, `img`, `status`, `title`, `user_id`) VALUES ('HOW DOES MUSIC AFFECT WORK PERFORMANCE?', '5214587313', 'question3.png', '1', 'When listening to music that suits you, your work efficiency can increase 3 times!', '3');
INSERT INTO `qadb1`.`question` (`content`, `created_date`, `img`, `status`, `title`, `user_id`) VALUES ('4 HIGHLIGHTS OF VIETNAM MUSIC PROJECTS IN FEBRUARY', '5214587313', 'question3.png', '1', 'After the explosion of albums in the first month of the year, February had a slowdown when only one album was released, but marked with impressive opening singles.', '2');
UPDATE `qadb1`.`question` SET `content` = 'Blockchain application in agriculture (Part 1)', `title` = 'Blockchain application in agriculture (Part 1)' WHERE (`id` = '3');
UPDATE `qadb1`.`question` SET `img` = 'question4.png' WHERE (`id` = '4');
UPDATE `qadb1`.`question` SET `img` = 'question5.png' WHERE (`id` = '5');
UPDATE `qadb1`.`question` SET `img` = 'question6.png' WHERE (`id` = '6');
UPDATE `qadb1`.`question` SET `img` = 'question7.png' WHERE (`id` = '7');
UPDATE `qadb1`.`question` SET `img` = 'question8.png' WHERE (`id` = '8');
UPDATE `qadb1`.`question` SET `img` = 'question9.png' WHERE (`id` = '9');
UPDATE `qadb1`.`question` SET `img` = 'question10.png' WHERE (`id` = '10');
UPDATE `qadb1`.`question` SET `img` = 'question11.png' WHERE (`id` = '11');
UPDATE `qadb1`.`question` SET `img` = 'question12.png' WHERE (`id` = '12');
INSERT INTO `qadb1`.`question` (`content`, `created_date`, `img`, `status`, `title`, `user_id`) VALUES ('“HAPPINESS IS THE WAY”', '5214587313', 'question14.png', '1', 'Happiness is like a long road. What must the road go through, how must we go? No one told us.', '3');
UPDATE `qadb1`.`question` SET `created_date` = '1650937797' WHERE (`id` = '7');
UPDATE `qadb1`.`question` SET `created_date` = '1650764997' WHERE (`id` = '8');
UPDATE `qadb1`.`question` SET `created_date` = '1648086597' WHERE (`id` = '9');
UPDATE `qadb1`.`question` SET `created_date` = '1648345797' WHERE (`id` = '10');
UPDATE `qadb1`.`question` SET `created_date` = '1648518597' WHERE (`id` = '11');
UPDATE `qadb1`.`question` SET `created_date` = '1648511397' WHERE (`id` = '12');
UPDATE `qadb1`.`question` SET `created_date` = '1648511637' WHERE (`id` = '13');
UPDATE `qadb1`.`question` SET `created_date` = '1650848037' WHERE (`id` = '14');
UPDATE `qadb1`.`question` SET `status` = '1' WHERE (`id` = '2');
UPDATE `qadb1`.`question` SET `status` = '1' WHERE (`id` = '3');
UPDATE `qadb1`.`question` SET `status` = '1' WHERE (`id` = '4');
UPDATE `qadb1`.`question` SET `created_date` = '1650937797' WHERE (`id` = '6');
UPDATE `qadb1`.`question` SET `created_date` = '1650937797' WHERE (`id` = '5');
UPDATE `qadb1`.`question` SET `created_date` = '1650937797' WHERE (`id` = '4');
UPDATE `qadb1`.`question` SET `created_date` = '1650937797' WHERE (`id` = '3');
UPDATE `qadb1`.`question` SET `created_date` = '1650937797' WHERE (`id` = '2');
UPDATE `qadb1`.`question` SET `created_date` = '1650937797' WHERE (`id` = '1');

-- -----------------------------------------------------
-- Table `qadb1`.`answers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qadb1`.`answers`;
CREATE TABLE IF NOT EXISTS `qadb1`.`answers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` text NULL,
  `created_date` VARCHAR(255) NULL,
  `status` INT NULL,
  `question_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKs4j12sfj254yawphx0k1xrl3f` (`question_id` ASC) VISIBLE,
  INDEX `FK4l9tdx1qt5esehos4ygj0sa81` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK4l9tdx1qt5esehos4ygj0sa81`
    FOREIGN KEY (`user_id`)
    REFERENCES `qadb1`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FKs4j12sfj254yawphx0k1xrl3f`
    FOREIGN KEY (`question_id`)
    REFERENCES `qadb1`.`question` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet', '8213821362193', '0', '1', '2');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet', '8213821362193', '0', '2', '2');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet', '8213821362193', '0', '3', '2');
UPDATE `qadb1`.`answers` SET `content` = 'The logo is displayed so that you can identify which channel it is. With multiple channels an onscreen logo is the easiest way a channel can be identified. The top left or right hand corner is the position where the logo is least likely to clash with the video content being shown. While there is no rule, most channels place the logo in the top right corner. Some place the logo on the top left and some even on the bottom left corner.', `created_date` = '1646032326' WHERE (`id` = '1');
UPDATE `qadb1`.`answers` SET `content` = 'The provider has placed what the TV industry calls a ‘slate’ up on their programming. Your cable provider has a contract with the provider to show the service until a specific date When that contract ends, your cable provider will most likely drop the service. If the provider renews the contract then your cable provider will continue to provide the service. Your cable provider doesn\'t choose what the provider sends out for their service, the cable provider just provides the path from the provider to your TV.', `created_date` = '1645859526', `status` = '1', `question_id` = '1', `user_id` = '3' WHERE (`id` = '2');
UPDATE `qadb1`.`answers` SET `content` = 'The standard aspect ratio for televisions today is 16:9. Some content, such as cinematic productions, use a wider aspect ratio. The station may be choosing to use the black bars (“letterboxing”) to avoid having to crop the edges of the picture. The streaming player on their Website might be able to display wider aspect ratios (thus avoiding the need for letterboxing) or they might just be cropping the image to fit what the player displays.', `created_date` = '1645866726', `status` = '1', `question_id` = '1', `user_id` = '4' WHERE (`id` = '3');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('The LCD panel has been damaged, and the liquid (LCD stands for Liquid Crystal Display) is leaking out, and that spot will slowly grow larger. This kind of damage is most commonly from an impact, which is why they most commonly appear in corners. An impact directly to the screen glass usually breaks the glass, but if your TV takes an impact to the corner, it can cause the screen inside the frame to buckle a bit and crack.', '1645848726', '1', '1', '5');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Anyway, there’s no “fix” - the screen is damaged and can’t be repaired, and no one sells replacement screens because it would cost more to replace screens on old TVs than it would to buy a new TV. The screen is roughly 80% of the parts cost of a TV set, and the entire rest of the TV is built around it, so even if it was possible to buy a screen (it isn’t), and even if it could be transported to you without breaking it (unlikely), you’d need a technician to spend a couple of hours completely disassembling the TV down to the last screw, and rebuilding it again on the new screen. That would make the cost of the part and the labor higher than the cost of a replacement TV - which is why this kind of repair doesn’t exist.', '1648267926', '1', '1', '6');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('The VeChainThor blockchain uses a proof-of-authority (PoA) consensus algorithm, which ensures high throughput by allowing nodes to make the best use of network bandwidth for transmitting transactions. There needs to be qualified nodes participating directly in the consensus process to guarantee sufficient decentralisation.', '1646032326', '1', '2', '2');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Enterprises are more likely to attract quality NFTs to the ecosystem, which is important for its sustainability. To get the most benefits from NFTs, enterprises can develop elements of the ecosystem such as NFT wallets, websites and apps. Enterprises also have reason to ensure that the legitimate ownership of NFTs is enforced, to avoid damaging their reputation.', '1645859526', '1', '2', '3');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES (' I’m not a Financial Advisor. I am not responsible for your investment behavior and cannot be held responsible for your decisions. I am not responsible for your profits and neither for your losses. This is not financial advice.', '1645866726', '1', '2', '4');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Once you STAKE your CAKE to get SYRUP, then you are earning a portion of 25% of each block reward. ANd once you get SYRUP, you can stake that SYRUP and start earning tokens from brand new BSC projects. This is just like CAKE compounding. by doing this way you are actually pulling multiple income stream from CAKE', '1648267926', '1', '2', '5');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES (' I’m not a Financial Advisor. I am not responsible for your investment behavior and cannot be held responsible for your decisions. I am not responsible for your profits and neither for your losses. This is not financial advice.', '1646032326', '1', '2', '6');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('The VeChainThor blockchain uses a proof-of-authority (PoA) consensus algorithm, which ensures high throughput by allowing nodes to make the best use of network bandwidth for transmitting transactions. There needs to be qualified nodes participating directly in the consensus process to guarantee sufficient decentralisation.', '1646032326', '1', '3', '2');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Enterprises are more likely to attract quality NFTs to the ecosystem, which is important for its sustainability. To get the most benefits from NFTs, enterprises can develop elements of the ecosystem such as NFT wallets, websites and apps. Enterprises also have reason to ensure that the legitimate ownership of NFTs is enforced, to avoid damaging their reputation.', '1645859526', '1', '3', '3');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES (' I’m not a Financial Advisor. I am not responsible for your investment behavior and cannot be held responsible for your decisions. I am not responsible for your profits and neither for your losses. This is not financial advice.', '1645866726', '1', '3', '4');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Once you STAKE your CAKE to get SYRUP, then you are earning a portion of 25% of each block reward. ANd once you get SYRUP, you can stake that SYRUP and start earning tokens from brand new BSC projects. This is just like CAKE compounding. by doing this way you are actually pulling multiple income stream from CAKE', '1648267926', '1', '3', '5');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES (' I’m not a Financial Advisor. I am not responsible for your investment behavior and cannot be held responsible for your decisions. I am not responsible for your profits and neither for your losses. This is not financial advice.', '1646032326', '1', '3', '6');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('The history of Vietnam can be traced back to around 20,000 years ago, as the first modern humans arrived and settled on this land, known as the Hoabinhians, which can be traced back to the modern-day Negritos. Archaeological findings from 1965, which are still under research, show the remains of two hominins closely related to the Sinanthropus, dating as far back as the Middle Pleistocene era, roughly half a million years ago', '1646032326', '1', '4', '3');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Pre-historic Vietnam was home to some of the world\'s earliest civilizations and societies—making them one of the world\'s first people who had practiced agriculture.[2][3] The Red River valley formed a natural geographic and economic unit, bounded to the north and west by mountains and jungles, to the east by the sea and to the south by the Red River Delta.', '1646032326', '1', '4', '4');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('The need to have a single authority to prevent floods of the Red River, to cooperate in constructing hydraulic systems, trade exchange, and to repel invaders, led to the creation of the first legendary Vietnamese states approximately 2879 BC. While in the later times, ongoing research from archaeologists have suggested that the Vietnamese Đông Sơn culture were traceable back to Northern Vietnam, Guangxi and Laos around 700 BC.[5][6][7] Sơn Vi culture was so far discovered to be the oldest, stretching back to 20,000 BC during the paleolithic stages.', '1645866726', '1', '4', '5');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('The VeChainThor blockchain uses a proof-of-authority (PoA) consensus algorithm, which ensures high throughput by allowing nodes to make the best use of network bandwidth for transmitting transactions. There needs to be qualified nodes participating directly in the consensus process to guarantee sufficient decentralisation.', '1646032326', '1', '5', '2');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Enterprises are more likely to attract quality NFTs to the ecosystem, which is important for its sustainability. To get the most benefits from NFTs, enterprises can develop elements of the ecosystem such as NFT wallets, websites and apps. Enterprises also have reason to ensure that the legitimate ownership of NFTs is enforced, to avoid damaging their reputation.', '1645859526', '1', '5', '3');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES (' I’m not a Financial Advisor. I am not responsible for your investment behavior and cannot be held responsible for your decisions. I am not responsible for your profits and neither for your losses. This is not financial advice.', '1645866726', '1', '5', '4');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Once you STAKE your CAKE to get SYRUP, then you are earning a portion of 25% of each block reward. ANd once you get SYRUP, you can stake that SYRUP and start earning tokens from brand new BSC projects. This is just like CAKE compounding. by doing this way you are actually pulling multiple income stream from CAKE', '1648267926', '1', '5', '5');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES (' I’m not a Financial Advisor. I am not responsible for your investment behavior and cannot be held responsible for your decisions. I am not responsible for your profits and neither for your losses. This is not financial advice.', '1646032326', '1', '5', '6');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('The LCD panel has been damaged, and the liquid (LCD stands for Liquid Crystal Display) is leaking out, and that spot will slowly grow larger. This kind of damage is most commonly from an impact, which is why they most commonly appear in corners. An impact directly to the screen glass usually breaks the glass, but if your TV takes an impact to the corner, it can cause the screen inside the frame to buckle a bit and crack.', '1645848726', '1', '6', '5');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Anyway, there’s no “fix” - the screen is damaged and can’t be repaired, and no one sells replacement screens because it would cost more to replace screens on old TVs than it would to buy a new TV. The screen is roughly 80% of the parts cost of a TV set, and the entire rest of the TV is built around it, so even if it was possible to buy a screen (it isn’t), and even if it could be transported to you without breaking it (unlikely), you’d need a technician to spend a couple of hours completely disassembling the TV down to the last screw, and rebuilding it again on the new screen. That would make the cost of the part and the labor higher than the cost of a replacement TV - which is why this kind of repair doesn’t exist.', '1648267926', '1', '6', '6');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('The LCD panel has been damaged, and the liquid (LCD stands for Liquid Crystal Display) is leaking out, and that spot will slowly grow larger. This kind of damage is most commonly from an impact, which is why they most commonly appear in corners. An impact directly to the screen glass usually breaks the glass, but if your TV takes an impact to the corner, it can cause the screen inside the frame to buckle a bit and crack.', '1645848726', '1', '6', '3');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Anyway, there’s no “fix” - the screen is damaged and can’t be repaired, and no one sells replacement screens because it would cost more to replace screens on old TVs than it would to buy a new TV. The screen is roughly 80% of the parts cost of a TV set, and the entire rest of the TV is built around it, so even if it was possible to buy a screen (it isn’t), and even if it could be transported to you without breaking it (unlikely), you’d need a technician to spend a couple of hours completely disassembling the TV down to the last screw, and rebuilding it again on the new screen. That would make the cost of the part and the labor higher than the cost of a replacement TV - which is why this kind of repair doesn’t exist.', '1648267926', '1', '6', '2');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('The LCD panel has been damaged, and the liquid (LCD stands for Liquid Crystal Display) is leaking out, and that spot will slowly grow larger. This kind of damage is most commonly from an impact, which is why they most commonly appear in corners. An impact directly to the screen glass usually breaks the glass, but if your TV takes an impact to the corner, it can cause the screen inside the frame to buckle a bit and crack.', '1645848726', '1', '7', '5');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Anyway, there’s no “fix” - the screen is damaged and can’t be repaired, and no one sells replacement screens because it would cost more to replace screens on old TVs than it would to buy a new TV. The screen is roughly 80% of the parts cost of a TV set, and the entire rest of the TV is built around it, so even if it was possible to buy a screen (it isn’t), and even if it could be transported to you without breaking it (unlikely), you’d need a technician to spend a couple of hours completely disassembling the TV down to the last screw, and rebuilding it again on the new screen. That would make the cost of the part and the labor higher than the cost of a replacement TV - which is why this kind of repair doesn’t exist.', '1648267926', '1', '7', '6');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('The LCD panel has been damaged, and the liquid (LCD stands for Liquid Crystal Display) is leaking out, and that spot will slowly grow larger. This kind of damage is most commonly from an impact, which is why they most commonly appear in corners. An impact directly to the screen glass usually breaks the glass, but if your TV takes an impact to the corner, it can cause the screen inside the frame to buckle a bit and crack.', '1645848726', '1', '7', '3');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Anyway, there’s no “fix” - the screen is damaged and can’t be repaired, and no one sells replacement screens because it would cost more to replace screens on old TVs than it would to buy a new TV. The screen is roughly 80% of the parts cost of a TV set, and the entire rest of the TV is built around it, so even if it was possible to buy a screen (it isn’t), and even if it could be transported to you without breaking it (unlikely), you’d need a technician to spend a couple of hours completely disassembling the TV down to the last screw, and rebuilding it again on the new screen. That would make the cost of the part and the labor higher than the cost of a replacement TV - which is why this kind of repair doesn’t exist.', '1648267926', '1', '7', '2');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Can the tech be used for evil? Certainly. But if we all keep a close eye on it as its rolling out, we will be in a position to choose the systems we participate in. It seems likely that looking back from the future, the idea that you are born into an ideology and you stay there for your whole life (read Nations), will look like the dark ages of choice.', '1645848726', '1', '8', '3');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('But it’s not magic. Nothing is going to fix our situation without fixing us. Globally, there are some very vexing issues with respect to ideology. Earthlings, as a people, are still not in the habit of classifying the practical outcomes of belief. For instance, any ideology that creates an ‘us / them’ delusion will increase suffering on both sides of that fence. Can I prove that? Not yet, but someone out there is going to.', '1645848726', '1', '8', '4');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Can block chain be used to create insurance without middle men? Possibly. Can it be used to fund a global basic income? I hope so. Can it be used to create systems of exchange based on something besides blood and oil? Yep.', '1645848726', '1', '8', '5');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('The two primary factors were probably large brain size and modified \"hands,\" including opposable thumbs and sensitive pads on the hands. These two attributes allowed humans to create and use tools to an extent other animals could not. You don\'t need to be the strongest or fastest when you can grow food.', '1648267926', '1', '9', '2');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Humans had , or created , superior social skills which added to a basic more inventive ability ( like creating makeshift weapons ) gave us enough of an advantage to band together and be more powerful . We could step outside the box of relying solely on animal instinct , whereas most other animals likely unable to do so . We were also able to eat more variety of foods , whereas most animals could not … so we could survive on plant or animal ', '1648267926', '1', '9', '3');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('As you know, humans are gifted with minds and thoughts. Great power does not always mean great outcome. Humans win over those physically stronger animals because humans are more clever, we have minds and thoughts that will give us so many ways and solutions to any kind of problems.', '1645848726', '1', '9', '5');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('The need to have a single authority to prevent floods of the Red River, to cooperate in constructing hydraulic systems, trade exchange, and to repel invaders, led to the creation of the first legendary Vietnamese states approximately 2879 BC. While in the later times, ongoing research from archaeologists have suggested that the Vietnamese Đông Sơn culture were traceable back to Northern Vietnam, Guangxi and Laos around 700 BC.[5][6][7] Sơn Vi culture was so far discovered to be the oldest, stretching back to 20,000 BC during the paleolithic stages.', '1645848726', '1', '10', '4');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Vietnam\'s long coastal and narrowed lands, rugged mountainous terrains, with two major deltas, were soon home to several different ancient cultures and civilizations. In the north, the Dongsonian culture and its indigenous chiefdoms of Van Lang and Au Lac started to flourish by 500 BC. ', '1645848726', '1', '10', '2');
UPDATE `qadb1`.`answers` SET `created_date` = '1645848726' WHERE (`id` = '35');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Music has officially entered the workforce. With the advent of open working environments and the rise of computer desk jockeys, it’s rare to find someone who doesn’t have a pair of headphones or earbuds at their desk.', '1645848726', '1', '11', '3');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('At some offices, seeing co-workers pounding their keyboards with headphones on is status quo. At other companies, this might be considered suspect, as in: Are they really working?', '1645848726', '1', '11', '4');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('According to this New York Times article, music can release dopamine in the same way that eating something delicious or looking at a beautiful view does.', '1645848726', '1', '11', '6');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('The show highlights the lives of tribal families from the southwest highlands of Vietnam, using UNESCO-listed percussion instruments, such as Vietnamese gongs and buffalo horns, as well as vibrant costumes, and a stunning bamboo cirque depicting various landscapes and creatures from tribal folklores.', '1645848726', '1', '12', '2');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('On 20 Dec 2019, “The Foliage 3” will return to the audience with a brand new look at Vincom Center for Contemporary Art (VCCA). The exhibition follows the original idea of “Foliage” – a gathering of large-scale quality contemporary works held annually by VCCA with the mission of supporting, connecting and spreading art to the grand public.', '1645848726', '1', '12', '3');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('2020 is approaching fast and to celebrate the new year, we are pleased to bring you a special display ‘Untitled Fictions in the Age After Divinity’ featuring works by Bàng Nhất Linh, Lê Quý Tông, Nguyễn Mạnh Hùng, Nguyễn Trần Nam –the four important contemporary artists of Vietnam today.', '1645848726', '1', '12', '5');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('The first book of spiritual teachings in several years from international best-selling author and beloved spiritual teacher Dr. Wayne W. Dyer. This book pulls from audio lectures of Wayne\'s from the 1990s and 2000s, restructuring them in a cohesive way to offer a fresh take on his teachings.', '1645848726', '1', '13', '4');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('One of Dr. Wayne Dyer\'s favorite quotes was \"When you change the way you look at things, the things you look at change.\" So in this book, which collects some of Wayne\'s most classic teachings in a new format, you will find a novel solution for most any problem you may be encountering. ', '1645848726', '1', '13', '2');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Happiness Is the Way · How to Reframe Your Thinking and Work with What You Already Have to Live the Life of Your Dreams · More in Philosophy · More in Personal .', '1645848726', '1', '13', '6');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('It is a long review. I played the original RE2 back in 2000, (yes I am old, born in 89), I bought this game without hesitation. I would think re2 remake is a masterpiece with plot holes. Because of the plot holes, this game is great but not top notch.', '1645848727', '1', '14', '4');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('I guess it is not that Capcom did not want to make a more different 1st run and 2nd run, they did it 21 years ago and can do the same now. It would take more time and money to do so, and they were sure the current game was good enough to make profits, a better plot will marginally increase it.', '1645858726', '1', '14', '2');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('Besides subway, I also saw a cable car in the concept art but it is labelled “unused”. They should have used it! The cable car can reach the mountain top, and Umbrella research facility is in the hollow mountain!', '1645844726', '1', '14', '7');
INSERT INTO `qadb1`.`answers` (`content`, `created_date`, `status`, `question_id`, `user_id`) VALUES ('I thumb up to the orphanage, the original doesn’t have it. Now we know Umbrella is using orphans on experiments. Originally Chief Irons never meets Sherry, and Katherine Warren’s corpse is bleeding badly. I don’t understand why Capcom created such a sick character.', '1645849726', '1', '14', '5');
UPDATE `qadb1`.`answers` SET `status` = '0' WHERE (`id` = '51');
UPDATE `qadb1`.`answers` SET `status` = '0' WHERE (`id` = '41');
UPDATE `qadb1`.`answers` SET `status` = '0' WHERE (`id` = '43');
UPDATE `qadb1`.`answers` SET `status` = '0' WHERE (`id` = '32');
UPDATE `qadb1`.`answers` SET `status` = '0' WHERE (`id` = '21');
UPDATE `qadb1`.`answers` SET `status` = '0' WHERE (`id` = '7');
UPDATE `qadb1`.`answers` SET `status` = '0' WHERE (`id` = '3');



-- -----------------------------------------------------
-- Table `qadb1`.`topic`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qadb1`.`topic`;
CREATE TABLE IF NOT EXISTS `qadb1`.`topic` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` TEXT NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `qadb1`.`topic` (`id`, `description`, `name`) VALUES ('1', 'Science', 'Science');
INSERT INTO `qadb1`.`topic` (`id`, `description`, `name`) VALUES ('2', 'Technology', 'Technology');
INSERT INTO `qadb1`.`topic` (`id`, `description`, `name`) VALUES ('3', 'Inspire', 'Inspire');
INSERT INTO `qadb1`.`topic` (`id`, `description`, `name`) VALUES ('4', 'Game', 'Game');
INSERT INTO `qadb1`.`topic` (`id`, `description`, `name`) VALUES ('5', 'Music', 'Music');
INSERT INTO `qadb1`.`question` (`content`, `created_date`, `img`, `status`, `title`, `user_id`) VALUES ('Resident Evil 2 Remake from the perspective of not being a horror fan.', '5214587313', 'question13.png', '1', 'Horror games have never been my first choice when I go to steam to buy games. Because for me, the game is for entertainment, for fun, to relieve stress after a day of school or work.', '4');

-- -----------------------------------------------------
-- Table `qadb1`.`topic_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qadb1`.`topic_details`;
CREATE TABLE IF NOT EXISTS `qadb1`.`topic_details` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `question_id` INT NULL,
  `topic_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKc970ay8pdqq5e8wyuhtom3i59` (`question_id` ASC) VISIBLE,
  INDEX `FKb3fr1p7hi9uoudr6e75jtk963` (`topic_id` ASC) VISIBLE,
  CONSTRAINT `FKb3fr1p7hi9uoudr6e75jtk963`
    FOREIGN KEY (`topic_id`)
    REFERENCES `qadb1`.`topic` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FKc970ay8pdqq5e8wyuhtom3i59`
    FOREIGN KEY (`question_id`)
    REFERENCES `qadb1`.`question` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `qadb1`.`topic_details` (`question_id`, `topic_id`) VALUES ('1', '1');
INSERT INTO `qadb1`.`topic_details` (`question_id`, `topic_id`) VALUES ('2', '1');
INSERT INTO `qadb1`.`topic_details` (`question_id`, `topic_id`) VALUES ('3', '1');
INSERT INTO `qadb1`.`topic_details` (`question_id`, `topic_id`) VALUES ('4', '2');
INSERT INTO `qadb1`.`topic_details` (`question_id`, `topic_id`) VALUES ('5', '2');
INSERT INTO `qadb1`.`topic_details` (`question_id`, `topic_id`) VALUES ('12', '5');
INSERT INTO `qadb1`.`topic_details` (`question_id`, `topic_id`) VALUES ('11', '5');
INSERT INTO `qadb1`.`topic_details` (`question_id`, `topic_id`) VALUES ('10', '4');
INSERT INTO `qadb1`.`topic_details` (`question_id`, `topic_id`) VALUES ('9', '3');
INSERT INTO `qadb1`.`topic_details` (`question_id`, `topic_id`) VALUES ('8', '4');
INSERT INTO `qadb1`.`topic_details` (`question_id`, `topic_id`) VALUES ('7', '3');
INSERT INTO `qadb1`.`topic_details` (`question_id`, `topic_id`) VALUES ('6', '1');
INSERT INTO `qadb1`.`topic_details` (`question_id`, `topic_id`) VALUES ('13', '4');


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
