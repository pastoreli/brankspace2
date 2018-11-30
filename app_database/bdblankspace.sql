-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 19, 2018 at 01:18 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.0.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdblankspace`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbcolecao`
--

CREATE TABLE `tbcolecao` (
  `idColecao` int(11) NOT NULL,
  `tituloColecao` varchar(50) NOT NULL,
  `descricaoColecao` varchar(150) NOT NULL,
  `dataCriacao` date NOT NULL,
  `idPublicacao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbcolecao`
--

INSERT INTO `tbcolecao` (`idColecao`, `tituloColecao`, `descricaoColecao`, `dataCriacao`, `idPublicacao`) VALUES
(1, 'C Teste', 'Uma coleção show', '2018-11-18', 10),
(2, 'olha la', 'aqueles raios de luz', '2018-11-18', 11);

-- --------------------------------------------------------

--
-- Table structure for table `tbhistoria`
--

CREATE TABLE `tbhistoria` (
  `idHistoria` int(11) NOT NULL,
  `tituloHistoria` varchar(50) NOT NULL,
  `conteudoHistoria` varchar(5000) NOT NULL,
  `imagemHistoria` varchar(3000) DEFAULT NULL,
  `dataCriacao` date NOT NULL,
  `idColecao` int(11) DEFAULT NULL,
  `idPublicacao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbhistoria`
--

INSERT INTO `tbhistoria` (`idHistoria`, `tituloHistoria`, `conteudoHistoria`, `imagemHistoria`, `dataCriacao`, `idColecao`, `idPublicacao`) VALUES
(1, 'titulo', 'Conteudo', 'card_cover.jpg', '2018-11-18', NULL, 4),
(2, 'Vai', 'O se vai', 'card_cover.jpg', '2018-11-18', NULL, 5),
(3, 'Teste', '123456 testando', 'card_cover.jpg', '2018-11-18', NULL, 6),
(4, 'teste', '123445', 'card_cover.jpg', '2018-11-18', NULL, 7),
(5, 'teste', '123445', 'card_cover.jpg', '2018-11-18', NULL, 8),
(6, 'Teste 2', '123456 testando', 'card_cover.jpg', '2018-11-18', NULL, 9);

-- --------------------------------------------------------

--
-- Table structure for table `tbpublicacao`
--

CREATE TABLE `tbpublicacao` (
  `idPublicacao` int(11) NOT NULL,
  `dataModificacao` date NOT NULL,
  `statusPublicacao` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpublicacao`
--

INSERT INTO `tbpublicacao` (`idPublicacao`, `dataModificacao`, `statusPublicacao`) VALUES
(1, '2018-11-18', 1),
(2, '2018-11-18', 1),
(3, '2018-11-18', 1),
(4, '2018-11-18', 1),
(5, '2018-11-18', 1),
(6, '2018-11-18', 1),
(7, '2018-11-18', 1),
(8, '2018-11-18', 2),
(9, '2018-11-18', 3),
(10, '2018-11-18', 2),
(11, '2018-11-18', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbseguidor`
--

CREATE TABLE `tbseguidor` (
  `idSeguidor` int(11) NOT NULL,
  `idUsuarioSeguidor` int(11) NOT NULL,
  `idUsuarioSeguinte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbseguidor`
--

INSERT INTO `tbseguidor` (`idSeguidor`, `idUsuarioSeguidor`, `idUsuarioSeguinte`) VALUES
(1, 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbusuario`
--

CREATE TABLE `tbusuario` (
  `idUsuario` int(11) NOT NULL,
  `emailUsuario` varchar(100) NOT NULL,
  `nomeUsuario` varchar(20) NOT NULL,
  `sobrenomeUsuario` varchar(30) NOT NULL,
  `carreiraUsuario` varchar(30) NOT NULL,
  `nascimentoUsuario` date NOT NULL,
  `senhaUsuario` varchar(200) NOT NULL,
  `imagemUsuario` varchar(3000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbusuario`
--

INSERT INTO `tbusuario` (`idUsuario`, `emailUsuario`, `nomeUsuario`, `sobrenomeUsuario`, `carreiraUsuario`, `nascimentoUsuario`, `senhaUsuario`, `imagemUsuario`) VALUES
(2, 'sergio@sergio.com', 'Sergio', 'Pastoreli', 'Dono de casa', '1965-06-21', '123456', NULL),
(3, 'admin@admin.com', 'Admin', 'AdminLastName', 'Administrador', '2018-11-18', '8D969EEF6ECAD3C29A3A629280E686CF0C3F5D5A86AFF3CA12020C923ADC6C92', NULL),
(6, 'pastoreli.igor@gmail.com', 'Igor', 'Pastoreli', 'Fron End', '1999-08-08', 'BCD9E4FDB408A4D5D13DC938E374157C1034C70B6750D6B81833125B06B45CEC', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbusuariopublicacao`
--

CREATE TABLE `tbusuariopublicacao` (
  `idUsuario` int(11) NOT NULL,
  `idPublicacao` int(11) NOT NULL,
  `donoPublicacao` bit(2) DEFAULT NULL,
  `favoritoPublicacao` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbusuariopublicacao`
--

INSERT INTO `tbusuariopublicacao` (`idUsuario`, `idPublicacao`, `donoPublicacao`, `favoritoPublicacao`) VALUES
(3, 5, b'01', NULL),
(3, 8, b'01', NULL),
(3, 9, b'01', NULL),
(3, 10, b'01', NULL),
(3, 11, b'01', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbcolecao`
--
ALTER TABLE `tbcolecao`
  ADD PRIMARY KEY (`idColecao`),
  ADD KEY `idPublicacao` (`idPublicacao`);

--
-- Indexes for table `tbhistoria`
--
ALTER TABLE `tbhistoria`
  ADD PRIMARY KEY (`idHistoria`),
  ADD KEY `idPublicacao` (`idPublicacao`),
  ADD KEY `idPublicacao_2` (`idPublicacao`),
  ADD KEY `idColecao` (`idColecao`);

--
-- Indexes for table `tbpublicacao`
--
ALTER TABLE `tbpublicacao`
  ADD PRIMARY KEY (`idPublicacao`);

--
-- Indexes for table `tbseguidor`
--
ALTER TABLE `tbseguidor`
  ADD PRIMARY KEY (`idSeguidor`),
  ADD KEY `idUsuarioSeguidor` (`idUsuarioSeguidor`),
  ADD KEY `idUsuarioSeguinte` (`idUsuarioSeguinte`);

--
-- Indexes for table `tbusuario`
--
ALTER TABLE `tbusuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indexes for table `tbusuariopublicacao`
--
ALTER TABLE `tbusuariopublicacao`
  ADD KEY `idPublicacao` (`idPublicacao`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbcolecao`
--
ALTER TABLE `tbcolecao`
  MODIFY `idColecao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbhistoria`
--
ALTER TABLE `tbhistoria`
  MODIFY `idHistoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbpublicacao`
--
ALTER TABLE `tbpublicacao`
  MODIFY `idPublicacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `tbseguidor`
--
ALTER TABLE `tbseguidor`
  MODIFY `idSeguidor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbusuario`
--
ALTER TABLE `tbusuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
