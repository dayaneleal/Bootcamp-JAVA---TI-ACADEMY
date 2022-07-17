-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Fornecedor` (
  `idFornecedor` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `inscricao_estadual` VARCHAR(45) NULL,
  PRIMARY KEY (`idFornecedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Ordem_compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Ordem_compra` (
  `id` INT NOT NULL,
  `data` VARCHAR(45) NULL,
  `fornecedor_idFornecedor` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_OrdemCompra_Fornecedor_idx` (`fornecedor_idFornecedor` ASC) VISIBLE,
  CONSTRAINT `fk_OrdemCompra_Fornecedor`
    FOREIGN KEY (`fornecedor_idFornecedor`)
    REFERENCES `mydb`.`Fornecedor` (`idFornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Material` (
  `idMaterial` INT NOT NULL,
  `nome_material` VARCHAR(45) NULL,
  `quantidade_material` INT NULL,
  `valor_material` VARCHAR(45) NULL,
  PRIMARY KEY (`idMaterial`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Item_ordem_compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Item_ordem_compra` (
  `ordem_compra_id` INT NOT NULL,
  `material_idMaterial` INT NOT NULL,
  `valor_material` DOUBLE NULL,
  `quantidade_material` INT NULL,
  PRIMARY KEY (`ordem_compra_id`, `material_idMaterial`),
  INDEX `fk_OrdemCompra_has_Material_Material1_idx` (`material_idMaterial` ASC) VISIBLE,
  INDEX `fk_OrdemCompra_has_Material_OrdemCompra1_idx` (`ordem_compra_id` ASC) VISIBLE,
  CONSTRAINT `fk_OrdemCompra_has_Material_OrdemCompra1`
    FOREIGN KEY (`ordem_compra_id`)
    REFERENCES `mydb`.`Ordem_compra` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrdemCompra_has_Material_Material1`
    FOREIGN KEY (`material_idMaterial`)
    REFERENCES `mydb`.`Material` (`idMaterial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
