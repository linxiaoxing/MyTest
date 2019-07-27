-- phpMyAdmin SQL Dump
-- version 4.0.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2014 年 04 月 01 日 01:10
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
-- 表的结构 `foodimg`
--

CREATE TABLE IF NOT EXISTS `foodimg` (
  `foodimgid` int(11) NOT NULL AUTO_INCREMENT,
  `foodphotoid` int(11) NOT NULL,
  `foodimgname` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`foodimgid`)
) ENGINE=MyISAM  DEFAULT CHARSET=gbk AUTO_INCREMENT=9 ;

--
-- 转存表中的数据 `foodimg`
--

INSERT INTO `foodimg` (`foodimgid`, `foodphotoid`, `foodimgname`) VALUES
(1, 1, 'food_1_1.png'),
(2, 1, 'food_1_2.png'),
(3, 2, 'food_2_1.png'),
(4, 2, 'food_2_2.png'),
(5, 3, 'food_3_1.png'),
(6, 3, 'food_3_2.png'),
(7, 4, 'food_4_1.png'),
(8, 4, 'food_4_2.png');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
