-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 18, 2019 at 03:47 AM
-- Server version: 5.7.14-log
-- PHP Version: 7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `bairro`
--

CREATE TABLE `bairro` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cidade_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `bairro`
--

INSERT INTO `bairro` (`id`, `nome`, `cidade_id`) VALUES
(1, 'Marbrasa', 1),
(2, 'BNH', 1),
(3, 'Centro Alegre', 2),
(4, 'Roça Alegre', 2),
(5, 'Pampulha', 3),
(6, 'Dona Clara', 3),
(7, 'Centro Carat', 4),
(8, 'Roça Carat', 4);

-- --------------------------------------------------------

--
-- Table structure for table `cidade`
--

CREATE TABLE `cidade` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `uf_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `cidade`
--

INSERT INTO `cidade` (`id`, `nome`, `uf_id`) VALUES
(1, 'Cachoeiro', 1),
(2, 'Alegre', 1),
(3, 'Belo Horizonte', 2),
(4, 'Caratinga', 2);

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `funcionario_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`id`, `funcionario_id`) VALUES
(4, 1),
(5, 2),
(6, 3),
(7, 1);

-- --------------------------------------------------------

--
-- Table structure for table `compra`
--

CREATE TABLE `compra` (
  `id` int(11) NOT NULL,
  `data` datetime DEFAULT NULL,
  `data_vencimento` datetime DEFAULT NULL,
  `forma_pagamento` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `fornecedor_id` int(11) DEFAULT NULL,
  `funcionario_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `compra`
--

INSERT INTO `compra` (`id`, `data`, `data_vencimento`, `forma_pagamento`, `status`, `total`, `fornecedor_id`, `funcionario_id`) VALUES
(1, '2019-04-01 08:45:00', '2019-04-01 08:45:00', 1, 1, 102.2, 8, 1),
(2, '2019-04-10 08:45:00', '2019-04-25 08:45:00', 2, 1, 204.4, 9, 2);

-- --------------------------------------------------------

--
-- Table structure for table `fornecedor`
--

CREATE TABLE `fornecedor` (
  `id` int(11) NOT NULL,
  `funcionario_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `fornecedor`
--

INSERT INTO `fornecedor` (`id`, `funcionario_id`) VALUES
(8, 1),
(9, 2);

-- --------------------------------------------------------

--
-- Table structure for table `funcionario`
--

CREATE TABLE `funcionario` (
  `login` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `senha` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `funcionario`
--

INSERT INTO `funcionario` (`login`, `senha`, `id`) VALUES
('root', '1234', 1),
('root', '1234', 2),
('root', '1234', 3);

-- --------------------------------------------------------

--
-- Table structure for table `item_compra`
--

CREATE TABLE `item_compra` (
  `quantidade_compra` int(11) DEFAULT NULL,
  `produto_id` int(11) NOT NULL,
  `compra_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `item_compra`
--

INSERT INTO `item_compra` (`quantidade_compra`, `produto_id`, `compra_id`) VALUES
(1, 1, 1),
(1, 2, 1),
(1, 3, 1),
(1, 4, 1),
(2, 1, 2),
(2, 2, 2),
(2, 3, 2),
(2, 4, 2);

-- --------------------------------------------------------

--
-- Table structure for table `item_venda`
--

CREATE TABLE `item_venda` (
  `quantidade_venda` int(11) DEFAULT NULL,
  `produto_id` int(11) NOT NULL,
  `venda_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `item_venda`
--

INSERT INTO `item_venda` (`quantidade_venda`, `produto_id`, `venda_id`) VALUES
(3, 1, 1),
(3, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `pessoa`
--

CREATE TABLE `pessoa` (
  `id` int(11) NOT NULL,
  `cpf_cnpj` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nome` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `numero` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rua` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  `bairro_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `pessoa`
--

INSERT INTO `pessoa` (`id`, `cpf_cnpj`, `email`, `nome`, `numero`, `rua`, `status`, `tipo`, `bairro_id`) VALUES
(1, '111111111-11', 'abc@sdb.com.br', 'Alexandre', '1001', 'Rua 45', 1, 1, 1),
(2, '222222222-22', 'mgn@sdb.com.br', 'Magneto', '2002', 'Rua A', 1, 1, 2),
(3, '333333333-33', 'jhn@sdb.com.br', 'Jonh', '3003', 'Rua Leste', 1, 1, 3),
(4, '444444444-44', 'alx@cliente.com.br', 'Alex', '101', 'Rua B', 1, 1, 4),
(5, '555.555.555-55', 'thg@cliente.com.br', 'Thiago', '202', 'Rua C', 2, 1, 5),
(6, '666.666.666-66', 'mrl@cliente.com.br', 'Marlon', '303', 'Rua D', 2, 1, 6),
(7, '777.777.777-77', 'lsa@cliente.com.br', 'Luisa', '404', 'Rua E', 1, 1, 7),
(8, '888.888.888-88', 'rnn@fornecedor.com.br', 'Renan', '505', 'Rua F', 1, 1, 2),
(9, '999.999.999-99-88', 'lui@fornecedor.com.br', 'Luis', '606', 'Rua G', 1, 1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `curvaabc` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `curvaxyz` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `estoque` int(11) DEFAULT NULL,
  `estoque_minimo` int(11) DEFAULT NULL,
  `nome` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `preco_compra` double DEFAULT NULL,
  `preco_promocao` double DEFAULT NULL,
  `preco_venda` double DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  `funcionario_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `produto`
--

INSERT INTO `produto` (`id`, `curvaabc`, `curvaxyz`, `estoque`, `estoque_minimo`, `nome`, `preco_compra`, `preco_promocao`, `preco_venda`, `status`, `tipo`, `funcionario_id`) VALUES
(1, 'A', 'Z', 20, 10, 'Cerveja A', 10.55, 15.66, 18.22, 1, 1, 1),
(2, 'B', 'Y', 30, 10, 'Cerveja B', 20.55, 25.66, 28.22, 1, 1, 2),
(3, 'C', 'X', 40, 10, 'Cerveja C', 30.55, 35.66, 38.22, 1, 1, 1),
(4, 'A', 'Z', 50, 10, 'Cerveja D', 40.55, 45.66, 48.22, 1, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `produto_fornecedor`
--

CREATE TABLE `produto_fornecedor` (
  `produto_id` int(11) NOT NULL,
  `fornecedor_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `telefone`
--

CREATE TABLE `telefone` (
  `id` int(11) NOT NULL,
  `numero` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  `pessoa_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `telefone`
--

INSERT INTO `telefone` (`id`, `numero`, `tipo`, `pessoa_id`) VALUES
(1, '31987455550', 1, 4),
(2, '31985632551', 1, 5),
(3, '31987455552', 1, 6),
(4, '31985632553', 1, 7),
(5, '31987455554', 1, 1),
(6, '31985632555', 1, 2),
(7, '31987455556', 1, 3),
(8, '31985632557', 1, 8),
(9, '31987455558', 1, 8),
(10, '31985632559', 1, 9),
(11, '31987455510', 1, 3),
(12, '31985632511', 1, 7);

-- --------------------------------------------------------

--
-- Table structure for table `uf`
--

CREATE TABLE `uf` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sigla` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `uf`
--

INSERT INTO `uf` (`id`, `nome`, `sigla`) VALUES
(1, 'Espírito Santo', 'ES'),
(2, 'Minas Gerais', 'MG');

-- --------------------------------------------------------

--
-- Table structure for table `venda`
--

CREATE TABLE `venda` (
  `id` int(11) NOT NULL,
  `data` datetime DEFAULT NULL,
  `numero` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rua` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `bairro_id` int(11) DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `funcionario_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `venda`
--

INSERT INTO `venda` (`id`, `data`, `numero`, `rua`, `status`, `total`, `bairro_id`, `cliente_id`, `funcionario_id`) VALUES
(1, '2019-04-12 15:00:00', '111', 'Rua J', 1, 54.66, 1, 4, 1),
(2, '2019-04-15 15:00:00', '222', 'Rua K', 1, 84.66, 3, 5, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bairro`
--
ALTER TABLE `bairro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgmx8his7a51210gcsaunulx8b` (`cidade_id`);

--
-- Indexes for table `cidade`
--
ALTER TABLE `cidade`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmmhbkvcabtujkj1t29lq47oq0` (`uf_id`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKejevt2s2vvl3q3u8dfksw1aiq` (`funcionario_id`);

--
-- Indexes for table `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4go8vtn4msugmpbf6wwkpumkb` (`fornecedor_id`),
  ADD KEY `FKllc2wkpam82iqqxr3cwim0soc` (`funcionario_id`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpihlc0pl0oshhb6i24ubs9l54` (`funcionario_id`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item_compra`
--
ALTER TABLE `item_compra`
  ADD PRIMARY KEY (`compra_id`,`produto_id`),
  ADD KEY `FKhi8mnlw3bmx5g5rs232xx4i3g` (`produto_id`);

--
-- Indexes for table `item_venda`
--
ALTER TABLE `item_venda`
  ADD PRIMARY KEY (`produto_id`,`venda_id`),
  ADD KEY `FKkiky88fkai72328rhw3r3yebx` (`venda_id`);

--
-- Indexes for table `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1le6odj68ymx3tqqs9217vrk4` (`bairro_id`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8tv9rjd56w1ft2wt8f63h0s5n` (`funcionario_id`);

--
-- Indexes for table `produto_fornecedor`
--
ALTER TABLE `produto_fornecedor`
  ADD KEY `FKn1k3cs5wvvvwbg2xkpbwrqhnn` (`fornecedor_id`),
  ADD KEY `FKjndqo3rv2gc9bsttkvcet0y98` (`produto_id`);

--
-- Indexes for table `telefone`
--
ALTER TABLE `telefone`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdfopyen4k14hhqgi17u5ct0h3` (`pessoa_id`);

--
-- Indexes for table `uf`
--
ALTER TABLE `uf`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6h15kty35s8esnfdp5tiivdfa` (`bairro_id`),
  ADD KEY `FK50murhuotq9h2dnxej317jjiy` (`cliente_id`),
  ADD KEY `FKon6h4s8x1kdjwkcipq65i5my7` (`funcionario_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bairro`
--
ALTER TABLE `bairro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `cidade`
--
ALTER TABLE `cidade`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `compra`
--
ALTER TABLE `compra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `telefone`
--
ALTER TABLE `telefone`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `venda`
--
ALTER TABLE `venda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
