-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sistemaaeropuerto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sistemaaeropuerto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sistemaaeropuerto` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `sistemaaeropuerto` ;

-- -----------------------------------------------------
-- Table `sistemaaeropuerto`.`aeropuerto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaaeropuerto`.`aeropuerto` (
  `idAeropuerto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `pais` VARCHAR(45) NULL DEFAULT NULL,
  `ciudad` VARCHAR(45) NULL DEFAULT NULL,
  `estado` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idAeropuerto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sistemaaeropuerto`.`avion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaaeropuerto`.`avion` (
  `idAvion` INT NOT NULL AUTO_INCREMENT,
  `modelo` VARCHAR(45) NULL DEFAULT NULL,
  `capacidad` INT NULL DEFAULT NULL,
  `estado` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idAvion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sistemaaeropuerto`.`clases`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaaeropuerto`.`clases` (
  `idClases` INT NOT NULL AUTO_INCREMENT,
  `nombreClase` VARCHAR(45) NULL DEFAULT NULL,
  `nAsientos` INT NULL DEFAULT NULL,
  `nAsientosDisponibles` INT NULL DEFAULT NULL,
  `idAvion` INT NULL DEFAULT NULL,
  `porcentajeEPrecio` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idClases`),
  INDEX `FK_Clases_Vuelo_idx` (`idAvion` ASC) VISIBLE,
  CONSTRAINT `FK_Clases_Avion`
    FOREIGN KEY (`idAvion`)
    REFERENCES `sistemaaeropuerto`.`avion` (`idAvion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sistemaaeropuerto`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaaeropuerto`.`company` (
  `idCompany` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `estado` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idCompany`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sistemaaeropuerto`.`itinerario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaaeropuerto`.`itinerario` (
  `idItinerario` INT NOT NULL AUTO_INCREMENT,
  `idAeropuertoDestino` INT NULL DEFAULT NULL,
  `idAeropuertoOrigen` INT NULL DEFAULT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  `hora` TIME NULL DEFAULT NULL,
  PRIMARY KEY (`idItinerario`),
  INDEX `FK_Iterinario_Aeropuerto_O_idx` (`idAeropuertoOrigen` ASC) VISIBLE,
  INDEX `FK_Iterinario_Aeropuerto_D_idx` (`idAeropuertoDestino` ASC) VISIBLE,
  CONSTRAINT `FK_Iterinario_Aeropuerto_D`
    FOREIGN KEY (`idAeropuertoDestino`)
    REFERENCES `sistemaaeropuerto`.`aeropuerto` (`idAeropuerto`),
  CONSTRAINT `FK_Iterinario_Aeropuerto_O`
    FOREIGN KEY (`idAeropuertoOrigen`)
    REFERENCES `sistemaaeropuerto`.`aeropuerto` (`idAeropuerto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sistemaaeropuerto`.`escala`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaaeropuerto`.`escala` (
  `idEscala` INT NOT NULL AUTO_INCREMENT,
  `numeroEscala` INT NULL DEFAULT NULL,
  `idAeropuerto` INT NULL DEFAULT NULL,
  `nPasajerosSuben` INT NULL DEFAULT NULL,
  `nPasajerosBajan` INT NULL DEFAULT NULL,
  `idIterinario` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idEscala`),
  INDEX `FK_Escala_Aeropuerto_idx` (`idAeropuerto` ASC) VISIBLE,
  INDEX `FK_Escala_Iterinario_idx` (`idIterinario` ASC) VISIBLE,
  CONSTRAINT `FK_Escala_Aeropuerto`
    FOREIGN KEY (`idAeropuerto`)
    REFERENCES `sistemaaeropuerto`.`aeropuerto` (`idAeropuerto`),
  CONSTRAINT `FK_Escala_Iterinario`
    FOREIGN KEY (`idIterinario`)
    REFERENCES `sistemaaeropuerto`.`itinerario` (`idItinerario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sistemaaeropuerto`.`pasajero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaaeropuerto`.`pasajero` (
  `idPasajero` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NULL DEFAULT NULL,
  `apellidos` VARCHAR(45) NULL DEFAULT NULL,
  `edad` INT NULL DEFAULT NULL,
  `sexo` VARCHAR(45) NULL DEFAULT NULL,
  `documentoIdentidad` VARCHAR(45) NULL DEFAULT NULL,
  `pasaporte` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idPasajero`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sistemaaeropuerto`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaaeropuerto`.`usuarios` (
  `nombreUsuario` VARCHAR(45) NOT NULL,
  `nombres` VARCHAR(45) NULL DEFAULT NULL,
  `apellidos` VARCHAR(45) NULL DEFAULT NULL,
  `edad` INT NULL DEFAULT NULL,
  `telefono` VARCHAR(45) NULL DEFAULT NULL,
  `Password` VARCHAR(500) NULL DEFAULT NULL,
  `TipoUsuario` INT NULL DEFAULT NULL,
  PRIMARY KEY (`nombreUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sistemaaeropuerto`.`tipos_vuelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaaeropuerto`.`tipos_vuelo` (
  `idTipos_vuelo` INT NOT NULL AUTO_INCREMENT,
  `Tiposdevuelo` VARCHAR(45) NULL DEFAULT NULL,
  `PorcentajeDesc` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`idTipos_vuelo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sistemaaeropuerto`.`vuelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaaeropuerto`.`vuelo` (
  `idVuelo` INT NOT NULL AUTO_INCREMENT,
  `idCompany` INT NULL DEFAULT NULL,
  `idItinerario` INT NULL DEFAULT NULL,
  `idAvion` INT NULL DEFAULT NULL,
  `idTiposvuelo` INT NULL DEFAULT NULL,
  `Capacidad` INT NULL DEFAULT NULL,
  `Costos Extras` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`idVuelo`),
  INDEX `FK_Vuelo_Avion_idx` (`idAvion` ASC) VISIBLE,
  INDEX `FK_Vuelo_Iterinario_idx` (`idItinerario` ASC) VISIBLE,
  INDEX `FK_Vuelo_Company_idx` (`idCompany` ASC) VISIBLE,
  INDEX `FK_Vuelo_Tipos_Vuelo_idx` (`idTiposvuelo` ASC) VISIBLE,
  CONSTRAINT `FK_Vuelo_Avion`
    FOREIGN KEY (`idAvion`)
    REFERENCES `sistemaaeropuerto`.`avion` (`idAvion`),
  CONSTRAINT `FK_Vuelo_Company`
    FOREIGN KEY (`idCompany`)
    REFERENCES `sistemaaeropuerto`.`company` (`idCompany`),
  CONSTRAINT `FK_Vuelo_Iterinario`
    FOREIGN KEY (`idItinerario`)
    REFERENCES `sistemaaeropuerto`.`itinerario` (`idItinerario`),
  CONSTRAINT `FK_Vuelo_Tipos_Vuelo`
    FOREIGN KEY (`idTiposvuelo`)
    REFERENCES `sistemaaeropuerto`.`tipos_vuelo` (`idTipos_vuelo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sistemaaeropuerto`.`pasaje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaaeropuerto`.`pasaje` (
  `idPasaje` INT NOT NULL AUTO_INCREMENT,
  `idPasajero` INT NULL DEFAULT NULL,
  `idVuelo` INT NULL DEFAULT NULL,
  `idClase` INT NULL DEFAULT NULL,
  `NAsiento` INT NULL DEFAULT NULL,
  `nombreUsuario` VARCHAR(45) NULL DEFAULT NULL,
  `precioTotal` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`idPasaje`),
  INDEX `FK_Pasaje_Vuelo_idx` (`idVuelo` ASC) VISIBLE,
  INDEX `FK_Pasaje_Pasajero_idx` (`idPasajero` ASC) VISIBLE,
  INDEX `FK_Pasaje_Usuario_idx` (`nombreUsuario` ASC) VISIBLE,
  INDEX `FK_Pasaje_Clase_idx` (`idClase` ASC) VISIBLE,
  CONSTRAINT `FK_Pasaje_Clase`
    FOREIGN KEY (`idClase`)
    REFERENCES `sistemaaeropuerto`.`clases` (`idClases`),
  CONSTRAINT `FK_Pasaje_Pasajero`
    FOREIGN KEY (`idPasajero`)
    REFERENCES `sistemaaeropuerto`.`pasajero` (`idPasajero`),
  CONSTRAINT `FK_Pasaje_Usuario`
    FOREIGN KEY (`nombreUsuario`)
    REFERENCES `sistemaaeropuerto`.`usuarios` (`nombreUsuario`),
  CONSTRAINT `FK_Pasaje_Vuelo`
    FOREIGN KEY (`idVuelo`)
    REFERENCES `sistemaaeropuerto`.`vuelo` (`idVuelo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sistemaaeropuerto`.`promocionesvuelos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaaeropuerto`.`promocionesvuelos` (
  `idPromocionesvuelos` INT NOT NULL AUTO_INCREMENT,
  `FechaInicioPromo` DATE NULL DEFAULT NULL,
  `FechaFinalPromo` DATE NULL DEFAULT NULL,
  `Descuento` FLOAT NULL DEFAULT NULL,
  `idVuelo` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idPromocionesvuelos`),
  INDEX `FK_Promocionesvuelos_Vuelos_idx` (`idVuelo` ASC) VISIBLE,
  CONSTRAINT `FK_Promocionesvuelos_Vuelos`
    FOREIGN KEY (`idVuelo`)
    REFERENCES `sistemaaeropuerto`.`vuelo` (`idVuelo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `sistemaaeropuerto` ;

-- -----------------------------------------------------
-- procedure SP_A_Aeropuerto
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_A_Aeropuerto`(PNombre varchar(45))
BEGIN
	Update aeropuerto set estado = 'Activo' where nombre = PNombre;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_A_Company
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_A_Company`(PNombre varchar(45))
BEGIN
	Update company set estado = 'Activo' where nombre = PNombre;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_D_Aeropuerto
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_D_Aeropuerto`(
PidAeropuerto int(11)
)
BEGIN
update aeropuerto set Estado = 'Inactivo' where idAeropuerto = PidAeropuerto;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_D_Avion
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_D_Avion`(PidAvion int(11))
BEGIN
	Update avion set estado = 'Inactivo' where idAvion = PidAvion;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_D_Company
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_D_Company`(PidCompany int(11))
BEGIN
	Update company set estado = 'Inactivo' where idCompany = PidCompany;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_D_Itinerario
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_D_Itinerario`(
PidItinerario int(11)
)
BEGIN
delete from iterinario where idIterinario = PidItinerario;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_I_Aeropuerto
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_I_Aeropuerto`(
Pnombre varchar(45),
Ppais varchar(45),
Pciudad varchar(45)
)
BEGIN
INSERT INTO aeropuerto(nombre,pais,ciudad,Estado) value(Anombre,Apais,Aciudad,'Activo');
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_I_Avion
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_I_Avion`(PModelo varchar(50), PCapacidad int)
BEGIN
	INSERT INTO avion(modelo,capacidad) values (Pmodelo,Pcapacidad);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_I_Company
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_I_Company`(PNombre varchar(45))
BEGIN
	INSERT INTO company(nombre,estado) values (PNombre,'Activo');
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_I_Itinerario
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_I_Itinerario`(
PidAeropuertoDestino int(11),
PidAeropuertoOrigen int(11),
Pfecha date,
PHora time
)
BEGIN
INSERT INTO iterinario(idAeropuertoDestino,idAeropuertoOrigen,fecha,hora) value(PidAeropuertoDestino,PidAeropuertoOrigen,Pfecha,PHora);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_I_Usuario
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_I_Usuario`(
pNombreUsuario varchar(45),
pNombres varchar(45),
pApellidos varchar(45),
pEdad int(11),
pTelefono varchar(45),
pPassword varchar(45)
)
BEGIN
INSERT INTO usuarios(nombreUsuario,nombres,apellidos,edad,telefono,Password) values (pNombreUsuario,pNombres,pApellidos,pEdad,pTelefono,sha2(pPassword,512));
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_S_Aeropuerto
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_S_Aeropuerto`(
)
BEGIN
SELECT * FROM sistemaaeropuerto.aeropuerto where Estado = "Activo";
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_S_CRIPSHA2
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_S_CRIPSHA2`(PcripPass varchar(500))
BEGIN
	Select sha2(PcripPass,512) as crip;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_S_Company
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_S_Company`(
)
BEGIN
SELECT * FROM sistemaaeropuerto.company where estado = "Activo";
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_S_Itinerario
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_S_Itinerario`(
)
BEGIN
SELECT * FROM sistemaaeropuerto.iterinario;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_S_LOGUINUSUARIO
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_S_LOGUINUSUARIO`(pUsuario varchar(50), pPass varchar(50))
BEGIN
select * from usuarios where nombreUsuario = pUsuario and password = sha2(pPass,512);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_U_Aeropuerto
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_U_Aeropuerto`(
PidAeropuerto int(11),
Pnombre varchar(45),
Ppais varchar(45),
Pciudad varchar(45)
)
BEGIN
update aeropuerto set nombre = Pnombre, pais = Ppais, ciudad = Pciudad where idAeropuerto = PidAeropuerto;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_U_Avion
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_U_Avion`(PModelo varchar(50), PCapacidad int, PidAvion int(11))
BEGIN
	Update avion set modelo = Pmodelo , capacidad = Pcapacidad where idAvion = PidAvion;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_U_Company
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_U_Company`(PNombre varchar(45), PidCompany int(11))
BEGIN
	Update company set nombre = PNombre where idCompany = PidCompany;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure SP_U_Itinerario
-- -----------------------------------------------------

DELIMITER $$
USE `sistemaaeropuerto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_U_Itinerario`(
PidItinerario int(11),
PidAeropuertoDestino int(11),
PidAeropuertoOrigen int(11),
Pfecha date,
PHora time
)
BEGIN
	Update iterinario set idAeropuertoDestino = PidAeropuertoDestino, idAeropuertoOrigen = PidAeropuertoOrigen, fecha = Pfecha, hora = PHora where idIterinario = PidItinerario;
END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
