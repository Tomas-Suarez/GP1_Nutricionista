-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-10-2024 a las 07:13:30
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nutricionistagp1`
--
CREATE DATABASE IF NOT EXISTS `nutricionistagp1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `nutricionistagp1`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alimento`
--

CREATE TABLE `alimento` (
  `idAlimento` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `tipoComida` varchar(75) NOT NULL,
  `caloriasPor100g` int(11) NOT NULL,
  `detalle` varchar(300) NOT NULL,
  `baja` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alimento`
--

INSERT INTO `alimento` (`idAlimento`, `nombre`, `tipoComida`, `caloriasPor100g`, `detalle`, `baja`) VALUES
(1, 'Manzana', 'Fruta', 52, 'Fruta fresca rica en fibra y vitamina C', 0),
(2, 'Pollo', 'Carne', 165, 'Pechuga de pollo sin piel, fuente de proteínas', 0),
(3, 'Arroz', 'Cereal', 130, 'Arroz blanco cocido, carbohidrato', 0),
(4, 'Brócolii', 'cosa7', 34, 'Vegetal verde rico en vitaminas y fibra', 0),
(5, 'Salmón', 'Pescado', 208, 'Pescado rico en omega-3 y proteínas', 0),
(6, 'Huevo', 'leche y derivado', 155, 'Huevo de gallina, fuente de proteínas y grasas saludables', 1),
(7, 'Leche', 'Lácteo', 42, 'Leche entera de vaca, rica en calcio', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dieta`
--

CREATE TABLE `dieta` (
  `idDieta` int(11) NOT NULL,
  `nombre` varchar(75) NOT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  `idPaciente` int(11) NOT NULL,
  `totalCalorias` int(11) NOT NULL,
  `baja` tinyint(4) NOT NULL,
  `pesoInicial` int(11) NOT NULL,
  `pesoObjetivo` int(11) NOT NULL,
  `pesoFinal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dieta`
--

INSERT INTO `dieta` (`idDieta`, `nombre`, `fechaInicio`, `fechaFin`, `idPaciente`, `totalCalorias`, `baja`, `pesoInicial`, `pesoObjetivo`, `pesoFinal`) VALUES
(1, 'Dieta Balanceada', '2024-10-24', '2024-10-30', 1, 1500, 0, 80, 75, 60),
(2, 'probando', '2024-10-30', NULL, 28, 0, 0, 60, 120, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menudiario`
--

CREATE TABLE `menudiario` (
  `idMenu` int(11) NOT NULL,
  `dia` int(11) NOT NULL,
  `calorias` int(11) NOT NULL,
  `idDieta` int(11) NOT NULL,
  `baja` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `menudiario`
--

INSERT INTO `menudiario` (`idMenu`, `dia`, `calorias`, `idDieta`, `baja`) VALUES
(1, 1, 503, 1, 0),
(2, 2, 432, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `dni` int(11) NOT NULL,
  `edad` int(11) NOT NULL,
  `altura` float NOT NULL,
  `baja` int(11) NOT NULL,
  `pesoActual` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`idPaciente`, `nombre`, `dni`, `edad`, `altura`, `baja`, `pesoActual`) VALUES
(1, 'Juan Pérez', 12345678, 30, 175, 0, 80),
(5, 'asdasd', 222, 20, 1111, 1, 20),
(14, 'Jose Antonio', 44223312, 25, 170, 1, 90),
(15, 'ASDASDSA', 1212312, 20, 111, 1, 222),
(28, 'Ismael', 2223312, 19, 180, 0, 60);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro`
--

CREATE TABLE `registro` (
  `idRegistro` int(11) NOT NULL,
  `idDieta` int(11) NOT NULL,
  `peso` float NOT NULL,
  `FechaRegistro` date NOT NULL,
  `detalle` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `registro`
--

INSERT INTO `registro` (`idRegistro`, `idDieta`, `peso`, `FechaRegistro`, `detalle`) VALUES
(5, 1, 80, '2024-10-24', 'Inicio de la dieta'),
(6, 1, 79.3, '2024-10-25', 'DIA 2'),
(7, 1, 78.8, '2024-10-26', 'DIA 3'),
(8, 1, 78, '2024-10-27', 'DIA 4'),
(9, 1, 77.5, '2024-10-28', 'DIA 5'),
(10, 1, 76.5, '2024-10-29', 'DIA 6'),
(11, 1, 76, '2024-10-30', 'DIA 7'),
(12, 1, 75, '2024-10-31', 'DIA 8');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `renglondemenu`
--

CREATE TABLE `renglondemenu` (
  `idRenglon` int(11) NOT NULL,
  `cantidadGrs` float NOT NULL,
  `subtotalCalorias` int(11) NOT NULL,
  `idMenu` int(11) NOT NULL,
  `idAlimento` int(11) NOT NULL,
  `horario` varchar(75) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `renglondemenu`
--

INSERT INTO `renglondemenu` (`idRenglon`, `cantidadGrs`, `subtotalCalorias`, `idMenu`, `idAlimento`, `horario`) VALUES
(1, 150, 78, 1, 1, 'Desayuno'),
(2, 200, 260, 1, 3, 'Almuerzo'),
(3, 100, 165, 1, 2, 'Cena'),
(4, 100, 42, 2, 7, 'Desayuno'),
(5, 150, 312, 2, 5, 'Almuerzo'),
(6, 50, 78, 2, 4, 'Cena');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alimento`
--
ALTER TABLE `alimento`
  ADD PRIMARY KEY (`idAlimento`);

--
-- Indices de la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD PRIMARY KEY (`idDieta`),
  ADD KEY `idPaciente` (`idPaciente`);

--
-- Indices de la tabla `menudiario`
--
ALTER TABLE `menudiario`
  ADD PRIMARY KEY (`idMenu`),
  ADD KEY `idDieta` (`idDieta`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`idPaciente`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `registro`
--
ALTER TABLE `registro`
  ADD PRIMARY KEY (`idRegistro`),
  ADD KEY `idPaciente` (`idDieta`),
  ADD KEY `idDieta` (`idDieta`);

--
-- Indices de la tabla `renglondemenu`
--
ALTER TABLE `renglondemenu`
  ADD PRIMARY KEY (`idRenglon`),
  ADD KEY `idMenu` (`idMenu`),
  ADD KEY `idAlimento` (`idAlimento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alimento`
--
ALTER TABLE `alimento`
  MODIFY `idAlimento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `idDieta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `menudiario`
--
ALTER TABLE `menudiario`
  MODIFY `idMenu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `idPaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `registro`
--
ALTER TABLE `registro`
  MODIFY `idRegistro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `renglondemenu`
--
ALTER TABLE `renglondemenu`
  MODIFY `idRenglon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD CONSTRAINT `dieta_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE CASCADE;

--
-- Filtros para la tabla `menudiario`
--
ALTER TABLE `menudiario`
  ADD CONSTRAINT `menudiario_ibfk_1` FOREIGN KEY (`idDieta`) REFERENCES `dieta` (`idDieta`) ON DELETE CASCADE;

--
-- Filtros para la tabla `registro`
--
ALTER TABLE `registro`
  ADD CONSTRAINT `registro_ibfk_1` FOREIGN KEY (`idDieta`) REFERENCES `dieta` (`idDieta`) ON DELETE CASCADE;

--
-- Filtros para la tabla `renglondemenu`
--
ALTER TABLE `renglondemenu`
  ADD CONSTRAINT `renglondemenu_ibfk_1` FOREIGN KEY (`idMenu`) REFERENCES `menudiario` (`idMenu`) ON DELETE CASCADE,
  ADD CONSTRAINT `renglondemenu_ibfk_2` FOREIGN KEY (`idAlimento`) REFERENCES `alimento` (`idAlimento`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
