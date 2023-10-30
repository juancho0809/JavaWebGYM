-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 23, 2023 at 03:52 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dgym`
--

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `correo` varchar(30) DEFAULT NULL,
  `telefono` varchar(12) DEFAULT NULL,
  `alturacm` varchar(5) DEFAULT NULL,
  `pesokg` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellido`, `correo`, `telefono`, `alturacm`, `pesokg`) VALUES
(6, 'Santiago', 'Lozada', 'juandiegolozada123@gmail.com', '3104618389', '170', '63'),
(7, 'Jorge', 'Perez', 'perez@gmail.com', '3215678790', '170', '73'),
(10, 'Mateito', 'Pepito', 'pere3333z@gmail.com', '3108691311', '170', '63'),
(11, 'Mateito', 'Pepito', 'pere3333z@gmail.com', '3108691311', '170', '63'),
(13, 'jklkkj', 'Perez', 'pere3333z@gmail.com', '3104618389', '180', '75'),
(16, 'holaaaaa', 'fsd', 'juandiegolozada123@gmail.com', '3124567678', '186', '73'),
(19, 'Johan', 'AlimaÃ±a', 'juama@hotmail.com', '231', '160', '56'),
(21, 'Nicolas', 'aaaa', 'juandiegolozada123@gmail.com', '3124523454', '190', '55'),
(24, 'Juan Diego', 'Lozada Gonzalez', 'juan123@mail.com', '3104618389', '180', '78'),
(32, 'Nicolas ', 'Romero', 'nico@gmail.com', '3213123', '160', '65'),
(33, 'Nicolas ', 'Romero', 'nico@gmail.com', '3213123', '160', '65'),
(34, 'Nicolas ', 'Romero', 'nico@gmail.com', '3213123', '160', '65'),
(36, 'Juan', 'Celis Lozada', 'juan@gmai.com', '3123123', '170', '68');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
