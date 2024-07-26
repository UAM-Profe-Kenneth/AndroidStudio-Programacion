# Android Studio App (Kotlin) + MySQL Acceso a MySql desde Kotlin haciendo uso del Connector/J

This is a template project to understand connections through Android Studio and MySQL

## Requirements

- Android Studio Jellyfish | 2023.3.1 o superior.
- Android Gradle Plugin Version 8.4.0
- Gradle Version 8.6
- Kotlin 1.9.22 o superior.
- Donwload Connector/J
- Virtualization mode turn on on the Computer

## MySql Database Create Script

```sql
CREATE DATABASE `testprogramacion` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE testprogramacion;

CREATE TABLE IF NOT EXISTS `testprogramacion`.`producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(200) NOT NULL,
  `codigobarra` VARCHAR(25) NOT NULL,
  `precio` DOUBLE(13,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `codigobarra` (`codigobarra` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
```