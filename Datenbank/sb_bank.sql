SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `mydb` ;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`USER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`USER` ;

CREATE TABLE IF NOT EXISTS `mydb`.`USER` (
  `idUSER` INT NULL,
  `vorname` VARCHAR(45) NULL,
  `nachname` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `passwort` VARCHAR(45) NULL,
  `kontostand` VARCHAR(45) NULL,
  `isAdmin` TINYINT NULL,
  PRIMARY KEY (`idUSER`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
