-- phpMyAdmin SQL Dump
-- version 4.0.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2014 年 04 月 01 日 01:11
-- 服务器版本: 5.5.32
-- PHP 版本: 5.3.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `mysql`
--

-- --------------------------------------------------------

--
-- 表的结构 `photo`
--

CREATE TABLE IF NOT EXISTS `photo` (
  `iid` int(11) NOT NULL AUTO_INCREMENT,
  `iname` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`iid`)
) ENGINE=MyISAM  DEFAULT CHARSET=gbk AUTO_INCREMENT=31 ;

--
-- 转存表中的数据 `photo`
--

INSERT INTO `photo` (`iid`, `iname`) VALUES
(1, 'f1.jpg'),
(2, 'f2.jpg'),
(3, 'f3.jpg'),
(4, 'f4.jpg'),
(5, 'f5.jpg'),
(6, 'f6.jpg'),
(7, 'f7.jpg'),
(8, 'f8.jpg'),
(9, 'f9.jpg'),
(10, 'f10.jpg'),
(11, 'f11.jpg'),
(12, 'f12.jpg'),
(13, 'f13.jpg'),
(14, 'f14.jpg'),
(15, 'f15.jpg'),
(16, 'f16.jpg'),
(17, 'f17.jpg'),
(18, 'f18.jpg'),
(19, 'f19.jpg'),
(20, 'f20.jpg'),
(21, 'f21.jpg'),
(22, 'f22.jpg'),
(23, 'f23.jpg'),
(24, 'f24.jpg'),
(25, 'f25.jpg'),
(26, 'f26.jpg'),
(27, 'f27.jpg'),
(28, 'f28.jpg'),
(29, 'f29.jpg'),
(30, 'f30.jpg');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
