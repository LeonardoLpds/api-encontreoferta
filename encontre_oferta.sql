-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 09-Jun-2015 às 17:37
-- Versão do servidor: 5.7.4-m14
-- PHP Version: 5.4.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `encontre_oferta`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `admin`
--

INSERT INTO `admin` (`id`, `nome`, `email`, `senha`) VALUES
(1, 'Leonardo de Souza', 'leonardo.lpds@gmail.com', '123456');

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`id`, `nome`, `descricao`) VALUES
(1, 'Informática', 'Computadores, tablets, impressoras, etc.'),
(2, 'Eletrodomésticos', 'Geladeiras, fogões, etc.'),
(3, 'Telefonia', 'Smartphones, celulares e telefones.'),
(4, 'Eletrônicos', 'TVs, Blu-Ray, Players e Home Theater');

-- --------------------------------------------------------

--
-- Estrutura da tabela `nivel`
--

CREATE TABLE IF NOT EXISTS `nivel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `nivel`
--

INSERT INTO `nivel` (`id`, `nome`, `descricao`) VALUES
(1, 'Gold', 'Melhores promoções'),
(2, 'Silver', 'Promoções comuns.');

-- --------------------------------------------------------

--
-- Estrutura da tabela `promocao`
--

CREATE TABLE IF NOT EXISTS `promocao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `data_final` date NOT NULL,
  `imagem` varchar(50) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `oferta` varchar(50) NOT NULL,
  `id_vendedor` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `id_nivel` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_vendedor` (`id_vendedor`),
  KEY `id_categoria` (`id_categoria`),
  KEY `id_nivel` (`id_nivel`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `promocao`
--

INSERT INTO `promocao` (`id`, `nome`, `descricao`, `data_final`, `imagem`, `quantidade`, `oferta`, `id_vendedor`, `id_categoria`, `id_nivel`) VALUES
(1, 'Notebook ASUS Intel Core i5 HD 8GB 1TB Ultrafino', 'Notebook Asus X450LD-BRA-WX112H Possui design ultrafino e hardware altamente eficiente para o usuário.', '2015-06-23', 'http://migre.me/q9i4j', 10, 'de R$ 2.099,00 por R$ 1.999,00', 1, 1, 1),
(2, 'Motorola Moto G (2ª Geração) TV Digital, Dual Chip', 'A Motorola inova mais uma vez trazendo a evolução do incrível Moto G em um aparelho com tecnologia inteligente que confirma seu sucesso no mercado. Com a nova Tela HD Brilhante de 5 polegadas.', '2015-06-29', 'http://migre.me/q9ibx', 10, 'de R$ 879,00 po R$ por 749,00', 1, 3, 1),
(3, 'Smart TV 3D LED 40" Full HD Philips com Ambilight', 'A tecnologia exclusiva Ambilight dá a esse televisor LED de 40 polegadas a sensação de uma tela ainda maior. Ela ilumina as laterais seguindo as cores da programação! ', '2015-06-29', 'http://migre.me/q9iZS', 10, 'de: R$ 1.999,00 por: R$ 1.657,90', 1, 4, 2),
(4, 'Tablet Infantil TecToy Galinha Pintadinha Tela 7"', 'A criançada vai ser divertir muito com este Tablet Galinha Pintadinha 2 da Tectoy. Com uma linda capa que mantém a segurança do aparelho.', '2015-06-29', 'http://migre.me/q9jpQ', 10, 'de R$ 399,00 po R$ 348,00', 1, 1, 2),
(5, 'Lavadora/Secadora de Roupas Samsung - 8,5Kg', 'Com a Samsung WD856UHSA, a lavagem das roupas fica muito mais econômica e prática. A começar pela configuração 2 em 1 do produto.', '2015-06-29', 'http://migre.me/qc6VM', 10, 'A partir de R$ 2.158,20', 1, 2, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `senha` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `email_2` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=29 ;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `endereco`, `telefone`, `email`, `senha`) VALUES
(1, 'Leonardo', 'Rua b', '2147483647', 'leonardo_lpds@hotmail.com', '123456'),
(2, 'Exemplo', 'Rua b', '34411321', 'test@test.com', '123456'),
(3, NULL, NULL, NULL, 'leonardo.lpds@gmail.com', NULL),
(4, NULL, NULL, NULL, 'leonardo@gmail.com', NULL),
(27, NULL, NULL, NULL, 'r1@ig.com.br', NULL),
(28, NULL, NULL, NULL, 'r2@ig.com.br', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendedor`
--

CREATE TABLE IF NOT EXISTS `vendedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cnpj` int(18) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cnpj` (`cnpj`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `vendedor`
--

INSERT INTO `vendedor` (`id`, `cnpj`, `nome`, `descricao`, `telefone`, `endereco`, `email`) VALUES
(1, 0, 'Aquela Loja', 'Loja de departamentos', '11-22223333', 'Rua Francis n 71', 'aquela@loja.com.br');

-- --------------------------------------------------------

--
-- Estrutura da tabela `voucher`
--

CREATE TABLE IF NOT EXISTS `voucher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) NOT NULL,
  `id_promocao` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo` (`codigo`),
  KEY `id_promocao` (`id_promocao`),
  KEY `id_usuario` (`id_usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=23 ;

--
-- Extraindo dados da tabela `voucher`
--

INSERT INTO `voucher` (`id`, `codigo`, `id_promocao`, `id_usuario`) VALUES
(1, '1433705639142', 1, 4),
(2, '1433705673663', 1, 4),
(3, '1433705889172', 1, 4),
(4, '1433705967598', 1, 2),
(5, '1433705999023', 2, 2),
(6, '1433706031194', 2, 1),
(7, '1433706092700', 2, 2),
(8, '1433706110102', 2, 1),
(9, '1433720247133', 2, 1),
(10, '1433720607117', 1, 2),
(11, '1433720613295', 1, 2),
(12, '1433787965542', 4, 2),
(13, '1433789692460', 2, 2),
(14, '1433792354933', 3, 2),
(15, '1433792570053', 3, 27),
(16, '1433792842695', 3, 1),
(17, '1433807554221', 1, 27),
(18, '1433807644312', 1, 27),
(19, '1433810137757', 1, 2),
(20, '1433812786507', 1, 27),
(21, '1433822936156', 1, 27),
(22, '1433823676118', 1, 28);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `promocao`
--
ALTER TABLE `promocao`
  ADD CONSTRAINT `fk_promo_cat` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`),
  ADD CONSTRAINT `fk_promo_niv` FOREIGN KEY (`id_nivel`) REFERENCES `nivel` (`id`),
  ADD CONSTRAINT `fk_promo_vend` FOREIGN KEY (`id_vendedor`) REFERENCES `vendedor` (`id`);

--
-- Limitadores para a tabela `voucher`
--
ALTER TABLE `voucher`
  ADD CONSTRAINT `fk_voucher_promo` FOREIGN KEY (`id_promocao`) REFERENCES `promocao` (`id`),
  ADD CONSTRAINT `fk_voucher_usu` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
