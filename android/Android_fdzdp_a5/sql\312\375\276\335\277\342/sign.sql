-- phpMyAdmin SQL Dump
-- version 4.0.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2014 年 04 月 29 日 23:59
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
-- 表的结构 `sign`
--

DROP TABLE IF EXISTS `sign`;
CREATE TABLE IF NOT EXISTS `sign` (
  `signid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `signcontent` varchar(50) DEFAULT NULL,
  `signlevel` varchar(50) DEFAULT NULL,
  `signimage` varchar(50) DEFAULT NULL,
  `signtime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`signid`,`sid`,`pid`)
) ENGINE=MyISAM  DEFAULT CHARSET=gbk AUTO_INCREMENT=10 ;

--
-- 转存表中的数据 `sign`
--

INSERT INTO `sign` (`signid`, `sid`, `pid`, `name`, `signcontent`, `signlevel`, `signimage`, `signtime`) VALUES
(1, 1, 1, '张坤', '安然嘎嘎撒旦法gas公司而言格萨尔噶人格', '4', 'sign0.jpg', '2014/04/25 08:55'),
(2, 2, 2, '葛晨', '和金融大街附近的感觉到他家的', '3', '', '2014/04/25 10:20'),
(4, 1, 1, '刘晓伟', '[大笑][高兴][抓狂]噶饿嘎嘎', '4', '', '2014/04/25 15:52'),
(3, 3, 3, '孙占军', '刷说说都凤凰山同时发生', '5', 'sign2.jpg', '2014/04/25 10:30'),
(5, 1, 1, '孙佳鑫', '[唇印][唇印][汉堡]加拿大皇家想到他会说', '5', 'sign1.jpg', '2014/04/25 16:57'),
(6, 1, 1, '王耀庆', '[唇印][唇印]啊各位如果在德国', '4', '', '2014/04/25 16:57'),
(7, 1, 1, '赵浩天', '[唇印][唇印][汉堡]啊图为噶工作', '5', 'sign1.jpg', '2014/04/25 16:57'),
(8, 3, 1, '杨威', '[调皮][大笑][可爱]你好 [害羞]', '2', '', '2014/04/25 05:02'),
(9, 1, 1, '孙浩楠', '别破泼妇而你你虐而你', '5', 'sign3.jpg', '2014/04/28 10:53');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
