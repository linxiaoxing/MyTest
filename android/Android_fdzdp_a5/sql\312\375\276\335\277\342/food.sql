-- phpMyAdmin SQL Dump
-- version 4.0.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2014 年 04 月 29 日 23:55
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
-- 表的结构 `food`
--

DROP TABLE IF EXISTS `food`;
CREATE TABLE IF NOT EXISTS `food` (
  `foodid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NOT NULL,
  `foodname` varchar(50) CHARACTER SET utf8 NOT NULL,
  `foodphotoid` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`foodid`)
) ENGINE=MyISAM  DEFAULT CHARSET=gbk AUTO_INCREMENT=9 ;

--
-- 转存表中的数据 `food`
--

INSERT INTO `food` (`foodid`, `sid`, `foodname`, `foodphotoid`) VALUES
(1, 1, '素拍黄瓜', '1'),
(2, 1, '酱炒蛋', '2'),
(3, 2, '肉末茄子', '3'),
(4, 2, '锅包肉', '4'),
(5, 3, '鱼香肉丝', '5'),
(6, 3, '尖椒干豆腐', '6'),
(7, 4, '紫菜蛋花汤', '7'),
(8, 4, '红烧肉', '8');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
