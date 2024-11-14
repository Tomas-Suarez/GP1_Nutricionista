-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-11-2024 a las 03:12:10
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
(1, 'Leche', 'Lácteos', 42, 'Fuente de calcio y proteínas', 0),
(2, 'Yogur natural', 'Lácteos', 59, 'Fermentado con probióticos', 0),
(3, 'Queso cheddar', 'Lácteos', 402, 'Alto en grasas y calcio', 0),
(4, 'Pollo a la plancha', 'Carnes', 165, 'Proteína magra, sin piel', 0),
(5, 'Carne de res', 'Carnes', 250, 'Fuente de hierro y vitamina B12', 0),
(6, 'Cerdo asado', 'Carnes', 242, 'Carne rica en proteínas', 0),
(7, 'Lentejas', 'Legumbres', 116, 'Fuente de proteínas y fibra', 0),
(8, 'Garbanzos', 'Legumbres', 164, 'Fuente de hierro y fibra', 0),
(9, 'Frijoles negros', 'Legumbres', 132, 'Ricos en proteínas y fibra', 0),
(10, 'Espinaca', 'Verduras', 23, 'Baja en calorías y rica en hierro', 0),
(11, 'Zanahoria', 'Verduras', 41, 'Rica en betacaroteno y fibra', 0),
(12, 'Brócoli', 'Verduras', 34, 'Rico en vitamina C y fibra', 0),
(13, 'Manzana', 'Frutas', 52, 'Fruta rica en fibra y vitamina C', 0),
(14, 'Banana', 'Frutas', 89, 'Fuente de potasio y fibra', 0),
(15, 'Fresa', 'Frutas', 32, 'Alta en antioxidantes y vitamina C', 0),
(16, 'Arroz blanco', 'Cereales', 130, 'Fuente de carbohidratos', 0),
(17, 'Pasta', 'Cereales', 131, 'Carbohidratos complejos', 0),
(18, 'Avena', 'Cereales', 389, 'Rica en fibra soluble', 0),
(19, 'Aceite de oliva', 'Grasas, aceites y dulces', 884, 'Fuente de grasas saludables', 0),
(20, 'Mantequilla', 'Grasas, aceites y dulces', 717, 'Grasa de origen animal', 0),
(21, 'Azúcar', 'Grasas, aceites y dulces', 387, 'Alto en calorías, sin nutrientes esenciales', 0),
(22, 'Queso cottage', 'Lácteos', 98, 'Bajo en grasas y alto en proteínas', 0),
(23, 'Yogur griego', 'Lácteos', 59, 'Fermentado, rico en proteínas', 0),
(24, 'Helado', 'Lácteos', 207, 'Alto en grasas y azúcares', 0),
(25, 'Pavo al horno', 'Carnes', 135, 'Carne magra y baja en grasa', 0),
(26, 'Chuleta de cerdo', 'Carnes', 250, 'Fuente de proteínas y grasas', 0),
(27, 'Salmón', 'Carnes', 208, 'Alto en omega-3 y proteínas', 0),
(28, 'Tofu', 'Legumbres', 76, 'Fuente vegetal de proteínas', 0),
(29, 'Alubias blancas', 'Legumbres', 333, 'Ricas en fibra y proteínas', 0),
(30, 'Guisantes', 'Legumbres', 81, 'Fuente de proteínas y carbohidratos', 0),
(31, 'Pepino', 'Verduras', 15, 'Bajo en calorías y refrescante', 0),
(32, 'Calabacín', 'Verduras', 17, 'Bajo en carbohidratos y rico en agua', 0),
(33, 'Pimiento rojo', 'Verduras', 31, 'Rico en vitamina C y antioxidantes', 0),
(34, 'Naranja', 'Frutas', 47, 'Fuente de vitamina C y fibra', 0),
(35, 'Piña', 'Frutas', 50, 'Rica en bromelina y vitamina C', 0),
(36, 'Mango', 'Frutas', 60, 'Alto en vitamina A y antioxidantes', 0),
(37, 'Trigo', 'Cereales', 340, 'Alto en carbohidratos y proteínas', 0),
(38, 'Maíz', 'Cereales', 365, 'Fuente de energía y carbohidratos', 0),
(39, 'Quinua', 'Cereales', 120, 'Grano con alto contenido de proteínas', 0),
(40, 'Miel', 'Grasas, aceites y dulces', 304, 'Endulzante natural con antioxidantes', 0),
(41, 'Chocolate negro', 'Grasas, aceites y dulces', 546, 'Alto en antioxidantes y grasas', 0),
(42, 'Cacahuate', 'Grasas, aceites y dulces', 567, 'Alto en grasas y proteínas', 0),
(43, 'Leche de almendras', 'Lácteos', 17, 'Baja en calorías, sin lactosa', 0),
(44, 'Crema agria', 'Lácteos', 193, 'Alta en grasa, usada en salsas', 0),
(45, 'Queso ricotta', 'Lácteos', 174, 'Textura suave y alto en proteínas', 0),
(46, 'Bistec', 'Carnes', 271, 'Fuente de proteínas y hierro', 0),
(47, 'Cordero', 'Carnes', 294, 'Carne rica en sabor y proteínas', 0),
(48, 'Soja', 'Legumbres', 446, 'Alta en proteínas y grasas saludables', 0),
(49, 'Alcachofa', 'Verduras', 47, 'Baja en calorías y rica en fibra', 0),
(50, 'Pera', 'Frutas', 57, 'Fruta refrescante con fibra', 0),
(51, 'Requesón', 'Lácteos', 98, 'Bajo en grasa y rico en proteínas', 0),
(52, 'Leche de coco', 'Lácteos', 230, 'Alto en grasas y sabor tropical', 0),
(53, 'Chorizo', 'Carnes', 455, 'Alto en grasas y proteínas', 0),
(54, 'Atún en agua', 'Carnes', 116, 'Proteína baja en grasa', 0),
(55, 'Jamón', 'Carnes', 145, 'Carne procesada, alta en sodio', 0),
(56, 'Habas', 'Legumbres', 88, 'Alto contenido en proteínas y fibra', 0),
(57, 'Almendras', 'Legumbres', 576, 'Fuente de grasas saludables y proteínas', 0),
(58, 'Tofu firme', 'Legumbres', 76, 'Rico en proteínas, bajo en grasas', 0),
(59, 'Tomate', 'Verduras', 18, 'Alto contenido de licopeno y vitamina C', 0),
(60, 'Cebolla', 'Verduras', 40, 'Baja en calorías y rica en antioxidantes', 0),
(61, 'Acelga', 'Verduras', 19, 'Rica en hierro y vitaminas', 0),
(62, 'Uvas', 'Frutas', 69, 'Ricas en antioxidantes y vitamina C', 0),
(63, 'Sandía', 'Frutas', 30, 'Refrescante y alta en agua', 0),
(64, 'Cereza', 'Frutas', 50, 'Rica en antioxidantes y vitaminas', 0),
(65, 'Harina de trigo', 'Cereales', 364, 'Base para panes y pasteles', 0),
(66, 'Pan integral', 'Cereales', 265, 'Pan de trigo integral, alto en fibra', 0),
(67, 'Galletas de avena', 'Cereales', 450, 'Galletas caseras de avena, ideales para el desayuno', 0),
(68, 'Tostadas', 'Cereales', 313, 'Tostadas de pan blanco o integral, crujientes y ligeras', 0),
(69, 'Barra de granola', 'Cereales', 471, 'Barra de granola con frutos secos y miel', 0),
(70, 'Yogur con frutas', 'Lácteos', 95, 'Yogur natural con trozos de frutas frescas', 0),
(71, 'Batido de plátano', 'Frutas', 89, 'Batido de plátano con leche descremada', 0),
(72, 'Tostadas con aguacate', 'Grasas, aceites y dulces', 150, 'Tostadas de pan integral con aguacate', 0),
(73, 'Hummus con bastones de zanahoria', 'Legumbres', 166, 'Hummus de garbanzos con bastones de zanahoria', 0),
(74, 'Frutos secos mixtos', 'Grasas, aceites y dulces', 607, 'Mezcla de almendras, nueces y avellanas', 0),
(75, 'Smoothie de fresa y espinaca', 'Frutas', 50, 'Smoothie de fresa, espinaca y agua', 0),
(76, 'Galletas integrales', 'Cereales', 430, 'Galletas integrales bajas en azúcar', 0),
(77, 'Queso fresco con tomate', 'Lácteos', 75, 'Queso fresco con rodajas de tomate', 0),
(78, 'Manzana con mantequilla de maní', 'Frutas', 150, 'Rodajas de manzana untadas con mantequilla de maní', 0),
(79, 'Batido de proteína de chocolate', 'Lácteos', 120, 'Batido de proteína de chocolate con leche descremada', 0),
(80, 'Tostadas con mantequilla de almendras', 'Grasas, aceites y dulces', 200, 'Tostadas integrales con mantequilla de almendras', 0),
(81, 'Uvas congeladas', 'Frutas', 69, 'Uvas frescas congeladas para un snack refrescante', 0),
(82, 'Mix de frutas deshidratadas', 'Frutas', 325, 'Mezcla de mango, piña y arándanos deshidratados', 0),
(83, 'Cereal de avena con frutas', 'Cereales', 389, 'Mezcla de avena integral con frutas deshidratadas', 0),
(84, 'Cereal de maíz', 'Cereales', 360, 'Cereal de maíz sin azúcar añadido', 0),
(85, 'Granola con chocolate', 'Cereales', 480, 'Granola con trozos de chocolate amargo y frutos secos', 0),
(86, 'Galletas de avena y pasas', 'Cereales', 430, 'Galletas de avena con pasas y un toque de canela', 0),
(87, 'Galletas de coco', 'Grasas, aceites y dulces', 500, 'Galletas crujientes con sabor a coco', 0);

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
  `pesoInicial` float NOT NULL,
  `pesoObjetivo` float NOT NULL,
  `pesoFinal` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dieta`
--

INSERT INTO `dieta` (`idDieta`, `nombre`, `fechaInicio`, `fechaFin`, `idPaciente`, `totalCalorias`, `baja`, `pesoInicial`, `pesoObjetivo`, `pesoFinal`) VALUES
(1, 'Dieta 1', '2024-11-13', '2024-12-27', 1, 0, 1, 25, 30, 29.3),
(2, 'Dieta 2', '2024-11-13', '2025-01-10', 2, 0, 1, 55, 48, 48),
(3, 'Dieta 3', '2024-11-13', '2024-12-29', 3, 0, 1, 45, 52, 52.9),
(4, 'Dieta 4', '2024-02-13', '2024-04-30', 4, 0, 1, 20, 23, 23.4),
(5, 'Dieta 5', '2024-02-13', '2024-05-09', 5, 0, 1, 60, 56, 57.5),
(6, 'Dieta 6', '2024-02-13', '2024-03-31', 6, 0, 0, 30, 28.5, 0),
(7, 'Dieta 7', '2024-02-13', '2024-03-31', 7, 0, 1, 50, 53, 53.4),
(8, 'Dieta 8', '2024-02-13', '2024-04-13', 8, 0, 1, 15, 13.5, 13.5),
(9, 'Dieta 9', '2024-02-13', '2024-04-13', 9, 0, 1, 23, 26.3, 26.6),
(10, 'Dieta 10', '2024-02-13', '2024-05-13', 10, 0, 1, 58, 64, 62.5),
(11, 'Dieta 11', '2024-02-13', '2024-04-13', 11, 0, 1, 72, 70, 70),
(12, 'Dieta 12', '2024-02-13', '2024-05-13', 12, 0, 1, 85, 81, 80.7),
(13, 'Dieta 13', '2024-02-13', '2024-03-13', 13, 0, 1, 65, 61, 63.6),
(14, 'Dieta 14', '2024-02-13', '2024-05-13', 14, 0, 1, 78, 73, 74.1),
(15, 'Dieta 15', '2024-02-13', '2024-04-13', 15, 0, 0, 52, 55, 0),
(16, 'Dieta 16', '2024-02-13', '2024-05-13', 16, 0, 0, 88, 84, 0),
(17, 'Dieta 17', '2024-11-13', '2024-12-13', 17, 0, 1, 68, 70, 71),
(18, 'Dieta 18', '2024-11-13', '2025-01-14', 17, 0, 0, 71, 75, 0),
(19, 'Dieta 19', '2024-11-13', '2025-02-13', 18, 0, 0, 75, 71, 0),
(20, 'Dieta 20', '2024-11-13', '2025-01-13', 19, 0, 0, 55, 57, 0),
(21, 'Dieta 21', '2024-11-13', '2025-01-13', 20, 0, 0, 80, 76, 0),
(22, 'Dieta 22', '2024-11-13', '2025-01-13', 21, 0, 0, 62, 65, 0),
(23, 'Dieta 23', '2024-11-13', '2025-02-05', 22, 0, 0, 75, 70, 0),
(24, 'Dieta 24', '2024-11-13', '2024-12-25', 23, 0, 0, 64, 66, 0),
(25, 'Dieta 25', '2024-11-13', '2025-01-15', 24, 0, 0, 70, 72, 0),
(26, 'Dieta 26', '2024-11-13', '2025-02-26', 25, 0, 0, 77, 73, 0),
(27, 'Dieta N1', '2024-11-13', '2024-12-27', 1, 12130, 0, 29.3, 32, 0);

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
(1, 0, 0, 1, 0),
(2, 1, 0, 1, 0),
(3, 2, 0, 1, 0),
(4, 3, 0, 1, 0),
(5, 4, 0, 1, 0),
(6, 5, 0, 1, 0),
(7, 6, 0, 1, 0),
(8, 0, 0, 2, 0),
(9, 1, 0, 2, 0),
(10, 2, 0, 2, 0),
(11, 3, 0, 2, 0),
(12, 4, 0, 2, 0),
(13, 5, 0, 2, 0),
(14, 6, 0, 2, 0),
(15, 0, 0, 3, 0),
(16, 1, 0, 3, 0),
(17, 2, 0, 3, 0),
(18, 3, 0, 3, 0),
(19, 4, 0, 3, 0),
(20, 5, 0, 3, 0),
(21, 6, 0, 3, 0),
(22, 0, 0, 4, 0),
(23, 1, 0, 4, 0),
(24, 2, 0, 4, 0),
(25, 3, 0, 4, 0),
(26, 4, 0, 4, 0),
(27, 5, 0, 4, 0),
(28, 6, 0, 4, 0),
(29, 0, 0, 5, 0),
(30, 1, 0, 5, 0),
(31, 2, 0, 5, 0),
(32, 3, 0, 5, 0),
(33, 4, 0, 5, 0),
(34, 5, 0, 5, 0),
(35, 6, 0, 5, 0),
(36, 0, 0, 6, 0),
(37, 1, 0, 6, 0),
(38, 2, 0, 6, 0),
(39, 3, 0, 6, 0),
(40, 4, 0, 6, 0),
(41, 5, 0, 6, 0),
(42, 6, 0, 6, 0),
(43, 0, 0, 7, 0),
(44, 1, 0, 7, 0),
(45, 2, 0, 7, 0),
(46, 3, 0, 7, 0),
(47, 4, 0, 7, 0),
(48, 5, 0, 7, 0),
(49, 6, 0, 7, 0),
(50, 0, 0, 8, 0),
(51, 1, 0, 8, 0),
(52, 2, 0, 8, 0),
(53, 3, 0, 8, 0),
(54, 4, 0, 8, 0),
(55, 5, 0, 8, 0),
(56, 6, 0, 8, 0),
(57, 0, 0, 9, 0),
(58, 1, 0, 9, 0),
(59, 2, 0, 9, 0),
(60, 3, 0, 9, 0),
(61, 4, 0, 9, 0),
(62, 5, 0, 9, 0),
(63, 6, 0, 9, 0),
(64, 0, 0, 10, 0),
(65, 1, 0, 10, 0),
(66, 2, 0, 10, 0),
(67, 3, 0, 10, 0),
(68, 4, 0, 10, 0),
(69, 5, 0, 10, 0),
(70, 6, 0, 10, 0),
(71, 0, 0, 11, 0),
(72, 1, 0, 11, 0),
(73, 2, 0, 11, 0),
(74, 3, 0, 11, 0),
(75, 4, 0, 11, 0),
(76, 5, 0, 11, 0),
(77, 6, 0, 11, 0),
(78, 0, 0, 12, 0),
(79, 1, 0, 12, 0),
(80, 2, 0, 12, 0),
(81, 3, 0, 12, 0),
(82, 4, 0, 12, 0),
(83, 5, 0, 12, 0),
(84, 6, 0, 12, 0),
(85, 0, 0, 13, 0),
(86, 1, 0, 13, 0),
(87, 2, 0, 13, 0),
(88, 3, 0, 13, 0),
(89, 4, 0, 13, 0),
(90, 5, 0, 13, 0),
(91, 6, 0, 13, 0),
(92, 0, 0, 14, 0),
(93, 1, 0, 14, 0),
(94, 2, 0, 14, 0),
(95, 3, 0, 14, 0),
(96, 4, 0, 14, 0),
(97, 5, 0, 14, 0),
(98, 6, 0, 14, 0),
(99, 0, 0, 15, 0),
(100, 1, 0, 15, 0),
(101, 2, 0, 15, 0),
(102, 3, 0, 15, 0),
(103, 4, 0, 15, 0),
(104, 5, 0, 15, 0),
(105, 6, 0, 15, 0),
(106, 0, 0, 16, 0),
(107, 1, 0, 16, 0),
(108, 2, 0, 16, 0),
(109, 3, 0, 16, 0),
(110, 4, 0, 16, 0),
(111, 5, 0, 16, 0),
(112, 6, 0, 16, 0),
(113, 0, 0, 17, 0),
(114, 1, 0, 17, 0),
(115, 2, 0, 17, 0),
(116, 3, 0, 17, 0),
(117, 4, 0, 17, 0),
(118, 5, 0, 17, 0),
(119, 6, 0, 17, 0),
(120, 0, 0, 18, 0),
(121, 1, 0, 18, 0),
(122, 2, 0, 18, 0),
(123, 3, 0, 18, 0),
(124, 4, 0, 18, 0),
(125, 5, 0, 18, 0),
(126, 6, 0, 18, 0),
(127, 0, 0, 19, 0),
(128, 1, 0, 19, 0),
(129, 2, 0, 19, 0),
(130, 3, 0, 19, 0),
(131, 4, 0, 19, 0),
(132, 5, 0, 19, 0),
(133, 6, 0, 19, 0),
(134, 0, 0, 20, 0),
(135, 1, 0, 20, 0),
(136, 2, 0, 20, 0),
(137, 3, 0, 20, 0),
(138, 4, 0, 20, 0),
(139, 5, 0, 20, 0),
(140, 6, 0, 20, 0),
(141, 0, 0, 21, 0),
(142, 1, 0, 21, 0),
(143, 2, 0, 21, 0),
(144, 3, 0, 21, 0),
(145, 4, 0, 21, 0),
(146, 5, 0, 21, 0),
(147, 6, 0, 21, 0),
(148, 0, 0, 22, 0),
(149, 1, 0, 22, 0),
(150, 2, 0, 22, 0),
(151, 3, 0, 22, 0),
(152, 4, 0, 22, 0),
(153, 5, 0, 22, 0),
(154, 6, 0, 22, 0),
(155, 0, 0, 23, 0),
(156, 1, 0, 23, 0),
(157, 2, 0, 23, 0),
(158, 3, 0, 23, 0),
(159, 4, 0, 23, 0),
(160, 5, 0, 23, 0),
(161, 6, 0, 23, 0),
(162, 0, 0, 24, 0),
(163, 1, 0, 24, 0),
(164, 2, 0, 24, 0),
(165, 3, 0, 24, 0),
(166, 4, 0, 24, 0),
(167, 5, 0, 24, 0),
(168, 6, 0, 24, 0),
(169, 0, 0, 25, 0),
(170, 1, 0, 25, 0),
(171, 2, 0, 25, 0),
(172, 3, 0, 25, 0),
(173, 4, 0, 25, 0),
(174, 5, 0, 25, 0),
(175, 6, 0, 25, 0),
(176, 0, 0, 26, 0),
(177, 1, 0, 26, 0),
(178, 2, 0, 26, 0),
(179, 3, 0, 26, 0),
(180, 4, 0, 26, 0),
(181, 5, 0, 26, 0),
(182, 6, 0, 26, 0),
(183, 0, 1559, 27, 0),
(184, 1, 1885, 27, 0),
(185, 2, 1413, 27, 0),
(186, 3, 1624, 27, 0),
(187, 4, 1819, 27, 0),
(188, 5, 1802, 27, 0),
(189, 6, 2028, 27, 0);

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
(1, 'Ana López', 12345678, 8, 125, 0, 31.6),
(2, 'Miguel Torres', 23456789, 15, 165, 0, 48),
(3, 'Lucía Pérez', 34567890, 12, 150, 0, 52.9),
(4, 'Juan García', 45678901, 6, 110, 0, 23.4),
(5, 'Sofía Martínez', 56789012, 17, 170, 0, 57.5),
(6, 'Carlos Hernández', 67890123, 10, 135, 0, 30),
(7, 'Elena Sánchez', 78901234, 14, 160, 0, 53.4),
(8, 'Javier Romero', 89012345, 3, 95, 0, 13.5),
(9, 'Gabriela Castillo', 90123456, 7, 120, 0, 26.6),
(10, 'Andrés Núñez', 11223344, 16, 175, 0, 62.5),
(11, 'Patricia Fernández', 22334455, 32, 168, 0, 70),
(12, 'Roberto Rojas', 33445566, 45, 180, 0, 80.7),
(13, 'Laura Ruiz', 44556677, 28, 162, 0, 63.6),
(14, 'David Jiménez', 55667788, 50, 175, 0, 74.1),
(15, 'Sonia Medina', 66778899, 23, 155, 0, 52),
(16, 'Luis Vargas', 77889900, 40, 182, 0, 88),
(17, 'Adriana Salas', 88990011, 31, 170, 0, 71),
(18, 'Oscar López', 99001122, 19, 175, 0, 75),
(19, 'Valeria Gómez', 10111213, 20, 160, 0, 55),
(20, 'Pedro Torres', 11121314, 60, 173, 0, 80),
(21, 'Marta González', 12131415, 66, 158, 0, 62),
(22, 'Enrique Castro', 13141516, 72, 165, 0, 75),
(23, 'Juana Vázquez', 14151617, 55, 163, 0, 64),
(24, 'Isabel Delgado', 15161718, 59, 168, 0, 70),
(25, 'Rafael Pardo', 16171819, 65, 170, 0, 77);

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
(1, 17, 68, '2024-11-13', 'Peso inicial'),
(2, 17, 68.3, '2024-11-20', ''),
(3, 17, 69, '2024-11-27', ''),
(4, 17, 69.5, '2024-12-07', ''),
(5, 17, 71, '2024-12-13', ''),
(6, 1, 25, '2024-11-13', 'inicio'),
(7, 1, 26, '2024-11-20', ''),
(8, 1, 26.5, '2024-11-27', ''),
(9, 1, 26.9, '2024-12-01', ''),
(10, 1, 27.5, '2024-12-06', ''),
(11, 1, 28, '2024-12-13', ''),
(12, 1, 28.5, '2024-12-20', ''),
(13, 1, 29.3, '2024-12-27', ''),
(14, 2, 55, '2024-11-13', 'inicio'),
(15, 2, 53.3, '2024-11-27', ''),
(16, 2, 52, '2024-12-04', ''),
(17, 2, 51, '2024-12-11', ''),
(18, 2, 50.4, '2024-12-18', ''),
(19, 2, 49, '2024-12-25', ''),
(20, 2, 49.1, '2025-01-01', ''),
(21, 2, 48, '2025-01-10', ''),
(22, 3, 51, '2024-11-13', 'inicio'),
(23, 3, 52, '2024-11-20', ''),
(24, 3, 52.2, '2024-11-27', ''),
(25, 3, 52.5, '2024-12-04', ''),
(26, 3, 51.7, '2024-12-11', ''),
(27, 3, 52, '2024-12-18', ''),
(28, 3, 52.3, '2024-12-25', ''),
(29, 3, 52.9, '2024-12-29', ''),
(30, 4, 20, '2024-02-13', ''),
(31, 4, 20.5, '2024-02-20', ''),
(32, 4, 21, '2024-02-27', ''),
(33, 4, 21.1, '2024-03-06', ''),
(34, 4, 21.8, '2024-03-13', ''),
(35, 4, 22, '2024-03-20', ''),
(36, 4, 22.3, '2024-03-27', ''),
(37, 4, 22.1, '2024-03-06', ''),
(38, 4, 22.3, '2024-03-13', ''),
(39, 4, 22.9, '2024-03-20', ''),
(40, 4, 23.5, '2024-03-30', ''),
(41, 4, 23.1, '2024-04-02', ''),
(42, 4, 23.3, '2024-04-09', ''),
(43, 4, 23.6, '2024-04-09', ''),
(44, 4, 22.9, '2024-04-16', ''),
(45, 4, 23, '2024-04-23', ''),
(46, 4, 23.4, '2024-04-30', ''),
(47, 5, 60.2, '2024-02-27', ''),
(48, 5, 59.6, '2024-03-06', ''),
(49, 5, 59, '2024-03-13', ''),
(50, 5, 58.7, '2024-03-20', ''),
(51, 5, 58, '2024-03-27', ''),
(52, 5, 58.7, '2024-04-03', ''),
(53, 5, 58.4, '2024-04-10', ''),
(54, 5, 57.7, '2024-04-17', ''),
(55, 5, 57.3, '2024-04-24', ''),
(56, 5, 57, '2024-05-03', ''),
(57, 5, 57.5, '2024-05-09', ''),
(58, 7, 50, '2024-02-13', ''),
(59, 7, 51, '2024-02-27', ''),
(60, 7, 52, '2024-03-06', ''),
(61, 7, 52.3, '2024-03-13', ''),
(62, 7, 52.7, '2024-03-20', ''),
(63, 7, 53.4, '2024-03-31', ''),
(64, 8, 15, '2024-02-13', ''),
(65, 8, 14.6, '2024-02-27', ''),
(66, 8, 14.2, '2024-03-06', ''),
(67, 8, 14, '2024-03-13', ''),
(68, 8, 13.9, '2024-03-20', ''),
(69, 8, 13.4, '2024-03-27', ''),
(70, 8, 13.2, '2024-04-06', ''),
(71, 8, 13.5, '2024-04-13', ''),
(72, 9, 23, '2024-02-13', ''),
(73, 9, 23.8, '2024-02-20', ''),
(74, 9, 24, '2024-02-27', ''),
(75, 9, 24.6, '2024-03-06', ''),
(76, 9, 25, '2024-03-13', ''),
(77, 9, 25.6, '2024-03-20', ''),
(78, 9, 26, '2024-03-27', ''),
(79, 9, 26.1, '2024-04-06', ''),
(80, 9, 26.6, '2024-04-13', ''),
(81, 10, 58, '2024-02-13', ''),
(82, 10, 59, '2024-02-27', ''),
(83, 10, 58.5, '2024-03-06', ''),
(84, 10, 58.3, '2024-03-13', ''),
(85, 10, 59.4, '2024-03-20', ''),
(86, 10, 60, '2024-03-27', ''),
(87, 10, 60.4, '2024-04-06', ''),
(88, 10, 60.3, '2024-04-13', ''),
(89, 10, 61, '2024-04-20', ''),
(90, 10, 61.3, '2024-04-27', ''),
(91, 10, 62, '2024-05-06', ''),
(92, 10, 62.3, '2024-05-06', ''),
(93, 10, 62.5, '2024-05-13', ''),
(94, 11, 72, '2024-02-13', ''),
(95, 11, 71.6, '2024-02-27', ''),
(96, 11, 70.8, '2024-03-06', ''),
(97, 11, 70, '2024-03-13', ''),
(98, 11, 70.2, '2024-03-20', ''),
(99, 11, 70.1, '2024-03-27', ''),
(100, 11, 70.5, '2024-04-06', ''),
(101, 11, 70, '2024-04-13', ''),
(102, 12, 85, '2024-02-13', ''),
(103, 12, 84.5, '2024-02-27', ''),
(104, 12, 83.4, '2024-03-06', ''),
(105, 12, 82.5, '2024-03-13', ''),
(106, 12, 82, '2024-03-20', ''),
(107, 12, 81.6, '2024-03-27', ''),
(108, 12, 81.2, '2024-04-03', ''),
(109, 12, 81.1, '2024-04-10', ''),
(110, 12, 80.6, '2024-04-17', ''),
(111, 12, 80.3, '2024-04-24', ''),
(112, 12, 80.7, '2024-05-06', ''),
(113, 12, 80.7, '2024-05-13', ''),
(114, 13, 65, '2024-02-13', ''),
(115, 13, 64, '2024-02-27', ''),
(116, 13, 64.3, '2024-03-06', ''),
(117, 13, 63.6, '2024-03-13', ''),
(118, 14, 78, '2024-02-13', ''),
(119, 14, 77, '2024-02-27', ''),
(120, 14, 77.6, '2024-03-06', ''),
(121, 14, 76.2, '2024-03-13', ''),
(122, 14, 75.6, '2024-03-20', ''),
(123, 14, 75, '2024-03-27', ''),
(124, 14, 74.5, '2024-04-03', ''),
(125, 14, 73.5, '2024-04-10', ''),
(126, 14, 74, '2024-04-17', ''),
(127, 14, 74.5, '2024-04-24', ''),
(128, 14, 74.4, '2024-05-06', ''),
(129, 14, 74.1, '2024-05-13', ''),
(130, 27, 29.3, '2024-11-13', ''),
(131, 27, 30, '2024-11-20', ''),
(132, 27, 30.8, '2024-11-27', ''),
(133, 27, 31, '2024-12-06', ''),
(134, 27, 31.1, '2024-12-13', ''),
(135, 27, 31.6, '2024-12-20', '');

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
(1, 100, 59, 183, 2, 'Desayuno'),
(3, 150, 62, 183, 11, 'Almuerzo'),
(4, 100, 34, 183, 12, 'Almuerzo'),
(5, 100, 116, 183, 7, 'Almuerzo'),
(6, 100, 165, 183, 4, 'Almuerzo'),
(7, 120, 50, 183, 1, 'Merienda'),
(8, 100, 89, 183, 14, 'Merienda'),
(9, 100, 34, 183, 12, 'Cena'),
(10, 200, 260, 183, 16, 'Cena'),
(11, 170, 425, 183, 26, 'Cena'),
(14, 50, 225, 184, 67, 'Desayuno'),
(15, 200, 34, 184, 43, 'Desayuno'),
(16, 120, 156, 184, 16, 'Almuerzo'),
(17, 100, 41, 184, 11, 'Almuerzo'),
(18, 200, 152, 184, 28, 'Almuerzo'),
(19, 200, 196, 184, 22, 'Merienda'),
(20, 100, 304, 184, 40, 'Merienda'),
(21, 100, 265, 184, 66, 'Merienda'),
(22, 100, 250, 184, 5, 'Cena'),
(23, 200, 262, 184, 17, 'Cena'),
(24, 100, 59, 185, 2, 'Desayuno'),
(25, 100, 265, 185, 66, 'Desayuno'),
(26, 100, 41, 185, 11, 'Almuerzo'),
(27, 100, 165, 185, 4, 'Almuerzo'),
(28, 100, 59, 185, 23, 'Merienda'),
(29, 100, 450, 185, 67, 'Merienda'),
(30, 200, 328, 185, 8, 'Cena'),
(31, 200, 46, 185, 10, 'Cena'),
(32, 200, 94, 186, 34, 'Desayuno'),
(33, 100, 230, 186, 52, 'Desayuno'),
(34, 200, 500, 186, 5, 'Almuerzo'),
(35, 200, 82, 186, 11, 'Almuerzo'),
(36, 100, 174, 186, 45, 'Merienda'),
(37, 200, 84, 186, 1, 'Merienda'),
(38, 200, 330, 186, 4, 'Cena'),
(39, 100, 130, 186, 16, 'Cena'),
(40, 300, 51, 187, 43, 'Desayuno'),
(41, 100, 313, 187, 68, 'Desayuno'),
(42, 100, 98, 187, 22, 'Desayuno'),
(43, 200, 264, 187, 9, 'Almuerzo'),
(44, 200, 152, 187, 28, 'Almuerzo'),
(46, 300, 177, 187, 2, 'Merienda'),
(47, 100, 265, 187, 66, 'Merienda'),
(48, 100, 165, 187, 4, 'Cena'),
(49, 200, 36, 187, 59, 'Cena'),
(50, 100, 130, 187, 16, 'Cena'),
(51, 100, 41, 187, 11, 'Cena'),
(52, 200, 46, 187, 10, 'Cena'),
(53, 100, 81, 187, 30, 'Cena'),
(54, 200, 118, 188, 2, 'Desayuno'),
(55, 100, 450, 188, 67, 'Desayuno'),
(56, 300, 102, 188, 12, 'Almuerzo'),
(57, 300, 51, 188, 32, 'Almuerzo'),
(58, 100, 455, 188, 53, 'Almuerzo'),
(59, 100, 313, 188, 68, 'Merienda'),
(60, 100, 59, 188, 2, 'Merienda'),
(61, 200, 152, 188, 58, 'Cena'),
(62, 300, 57, 188, 61, 'Cena'),
(63, 300, 45, 188, 31, 'Cena'),
(64, 100, 265, 183, 66, 'Desayuno'),
(65, 100, 120, 189, 79, 'Merienda'),
(66, 100, 52, 189, 13, 'Merienda'),
(67, 100, 360, 189, 84, 'Desayuno'),
(68, 200, 118, 189, 2, 'Desayuno'),
(69, 100, 165, 189, 4, 'Almuerzo'),
(70, 100, 18, 189, 59, 'Almuerzo'),
(71, 100, 75, 189, 77, 'Almuerzo'),
(72, 100, 389, 189, 83, 'Merienda'),
(73, 200, 118, 189, 23, 'Merienda'),
(74, 200, 270, 189, 25, 'Cena'),
(75, 100, 208, 189, 27, 'Cena'),
(76, 200, 30, 189, 31, 'Cena'),
(77, 300, 51, 189, 32, 'Cena'),
(78, 300, 54, 189, 59, 'Cena');

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
  MODIFY `idAlimento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=88;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `idDieta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `menudiario`
--
ALTER TABLE `menudiario`
  MODIFY `idMenu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=190;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `idPaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `registro`
--
ALTER TABLE `registro`
  MODIFY `idRegistro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=136;

--
-- AUTO_INCREMENT de la tabla `renglondemenu`
--
ALTER TABLE `renglondemenu`
  MODIFY `idRenglon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

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
