CREATE TABLE `project_comment`.`member` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `mail` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `project_comment`.`comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account` VARCHAR(45) NOT NULL,
  `url` VARCHAR(300) NOT NULL,
  `comment` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`id`));
