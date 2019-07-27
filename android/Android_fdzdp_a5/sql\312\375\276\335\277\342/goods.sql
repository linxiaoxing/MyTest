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
-- 表的结构 `goods`
--

CREATE TABLE IF NOT EXISTS `goods` (
  `sid` int(11) NOT NULL,
  `iid` int(11) NOT NULL,
  `gname` varchar(50) CHARACTER SET utf8 NOT NULL,
  `gprice` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`iid`,`sid`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

--
-- 转存表中的数据 `goods`
--

INSERT INTO `goods` (`sid`, `iid`, `gname`, `gprice`) VALUES
(1, 1, '可乐鸡翅', '25'),
(2, 2, '大排骨', '35'),
(3, 3, '咪咕披萨', '37'),
(4, 4, '蛋挞', '5'),
(4, 5, '酸辣粉', '6'),
(17, 6, '麻辣烫', '7'),
(17, 7, '火爆大头菜', '8'),
(8, 8, '香菇肉片', '20'),
(8, 9, '一汽大众', '20000'),
(10, 10, '比亚迪', '100000'),
(4, 11, '奥迪', '550000'),
(17, 12, '宝马', '110000'),
(13, 13, '奥拓', '455555'),
(8, 14, '本田', '48552'),
(15, 15, '丰田', '255555'),
(8, 16, '波西米亚', '320'),
(17, 17, '复古', '250'),
(9, 18, '清新', '145'),
(19, 19, '典雅', '458'),
(20, 20, '卡法小镇', '5');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
