-- phpMyAdmin SQL Dump
-- version 4.0.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2014 年 04 月 29 日 23:53
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
-- 表的结构 `comments`
--

DROP TABLE IF EXISTS `comments`;
CREATE TABLE IF NOT EXISTS `comments` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `comments` varchar(50) NOT NULL,
  `clevel` varchar(50) NOT NULL,
  `kouweilevel` varchar(50) NOT NULL,
  `huanjinglevel` varchar(50) NOT NULL,
  `fuwulevel` varchar(50) NOT NULL,
  `cpermoney` varchar(50) NOT NULL,
  `time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`,`pid`,`sid`)
) ENGINE=MyISAM  DEFAULT CHARSET=gbk AUTO_INCREMENT=5 ;

--
-- 转存表中的数据 `comments`
--

INSERT INTO `comments` (`cid`, `sid`, `pid`, `name`, `comments`, `clevel`, `kouweilevel`, `huanjinglevel`, `fuwulevel`, `cpermoney`, `time`) VALUES
(1, 1, 1, '绿_cat', '酒店不错.房间设施都蛮新.只是早餐的话,可以多一些品种,要适应更多人. 4.位置不错，离万达广场很近', '4', '1', '2', '1', '25', '2013/11/11 08:55:43'),
(2, 2, 2, '胡闹是种依赖', '酒店环境和早餐都很不错，就是打车很难，不过宁波哪个地方打车都不容易。另外，服务员的效率稍微有点低，其', '3', '4', '2', '3', '32', '2013/11/11 08:55:43'),
(3, 3, 1, '张坤', '软硬件都达不到五星水平！北楼19楼没有直达电梯，入住之前根本就没介绍清楚;服务员态度不好，根本不给叫', '5', '2', '3', '3', '25', '2013/11/11 08:55:43'),
(4, 4, 2, '葛晨', '酒店位置不错，就在天一广场边上！服务根本达不到五星标准，北楼19楼没有直达电梯，因为行李多，本来不想', '4', '4', '4', '2', '56', '2013/11/11 08:55:43');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
