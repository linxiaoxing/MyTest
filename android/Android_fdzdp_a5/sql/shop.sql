-- phpMyAdmin SQL Dump
-- version 4.0.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2014 年 04 月 29 日 23:58
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
-- 表的结构 `shop`
--

DROP TABLE IF EXISTS `shop`;
CREATE TABLE IF NOT EXISTS `shop` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `iid` int(11) DEFAULT NULL,
  `sname` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `stype` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `saddress` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `snear` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `stel` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `stime` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `szhekou` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `smembercard` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `sper` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `smoney` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `snum` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `slevel` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `sflag_tuan` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `sflag_quan` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `sflag_ding` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `sflag_ka` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `longitude` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `latitude` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `sintroduction` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `sdetails` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `stips` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `sflag_promise` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=MyISAM  DEFAULT CHARSET=gbk AUTO_INCREMENT=12 ;

--
-- 转存表中的数据 `shop`
--

INSERT INTO `shop` (`sid`, `iid`, `sname`, `stype`, `saddress`, `snear`, `stel`, `stime`, `szhekou`, `smembercard`, `sper`, `smoney`, `snum`, `slevel`, `sflag_tuan`, `sflag_quan`, `sflag_ding`, `sflag_ka`, `longitude`, `latitude`, `sintroduction`, `sdetails`, `stips`, `sflag_promise`) VALUES
(1, 20, '兴农食府', '团购', '南兴街', '工业大学', '1337289294', '每日/8:00-23:00', '会员专享5折优惠', '0', '25', '12', '200', '2', '1', '0', '0', '0', '45.7222', '126.6666', '热爱烘焙的人都有一个快乐的梦想——让更多人尝到自己做的美味，让更多人幸福和感动。巴黎贝甜就一直走在这', '适用范围：店内产品，除月饼、圣诞节蛋糕、粽子、储值卡外通用店内人均消费：20元/人', '购买须知有效期：2013.8.4 至 2014.2.4（周末、法定节假日通用使用时间：09:00-2', '0'),
(2, 21, '如家饭庄', '生活服务', '学府头道街', '工业大学', '1381894841', '每日/9:00-20:00', '会员专享6折优惠', '0', '25', '66', '200', '5', '0', '1', '0', '1', '45.7202', '126.6070', '热爱烘焙的人都有一个快乐的梦想——让更多人尝到自己做的美味，让更多人幸福和感动。巴黎贝甜就一直走在这', '适用范围：店内产品，除月饼、圣诞节蛋糕、粽子、储值卡外通用店内人均消费：20元/人', '购买须知有效期：2013.8.4 至 2014.2.4（周末、法定节假日通用使用时间：09:00-2', '1'),
(3, 22, '天津万源龙顺度假庄园', '团购', '测绘路', '工业大学', '1357901931', '每日/7:00-23:00', '会员专享5折优惠', '0', '25', '55', '200', '5', '1', '0', '0', '0', '45.7119', '126.6622', '热爱烘焙的人都有一个快乐的梦想——让更多人尝到自己做的美味，让更多人幸福和感动。巴黎贝甜就一直走在这', '适用范围：店内产品，除月饼、圣诞节蛋糕、粽子、储值卡外通用店内人均消费：20元/人', '购买须知有效期：2013.8.4 至 2014.2.4（周末、法定节假日通用使用时间：09:00-2', '1'),
(4, 23, '集贤大酒家', '生活服务', '正义路', '爱建路', '1361904732', '每日/7:00-22:00', '会员专享5折优惠', '0', '25', '44', '200', '5', '1', '0', '1', '0', '45.7888', '126.1025', '热爱烘焙的人都有一个快乐的梦想——让更多人尝到自己做的美味，让更多人幸福和感动。巴黎贝甜就一直走在这', '适用范围：店内产品，除月饼、圣诞节蛋糕、粽子、储值卡外通用店内人均消费：20元/人', '购买须知有效期：2013.8.4 至 2014.2.4（周末、法定节假日通用使用时间：09:00-2', '1'),
(5, 24, '苏浙酒楼', '休闲娱乐', '保健路', '爱建路', '1358183413', '每日/8:00-22:00', '会员专享8折优惠', '0', '25', '89', '200', '5', '1', '0', '0', '0', '45.6993', '126.5993', '热爱烘焙的人都有一个快乐的梦想——让更多人尝到自己做的美味，让更多人幸福和感动。巴黎贝甜就一直走在这', '适用范围：店内产品，除月饼、圣诞节蛋糕、粽子、储值卡外通用店内人均消费：20元/人', '购买须知有效期：2013.8.4 至 2014.2.4（周末、法定节假日通用使用时间：09:00-2', '1'),
(6, 25, '马记烧卖海鲜城', '生活服务', '宁安路', '爱建路', '1581289347', '每日/9:00-23:00', '会员专享5折优惠', '0', '25', '23', '200', '4', '1', '0', '0', '0', '45.6921', '126.6126', '热爱烘焙的人都有一个快乐的梦想——让更多人尝到自己做的美味，让更多人幸福和感动。巴黎贝甜就一直走在这', '适用范围：店内产品，除月饼、圣诞节蛋糕、粽子、储值卡外通用店内人均消费：20元/人', '购买须知有效期：2013.8.4 至 2014.2.4（周末、法定节假日通用使用时间：09:00-2', '0'),
(7, 26, '原野人家', '团购', '科研街', '爱建路', '1563412344', '每日/8:00-21:00', '会员专享9折优惠', '0', '25', '56', '200', '5', '1', '0', '0', '0', '45.6987', '126.6256', '热爱烘焙的人都有一个快乐的梦想——让更多人尝到自己做的美味，让更多人幸福和感动。巴黎贝甜就一直走在这', '适用范围：店内产品，除月饼、圣诞节蛋糕、粽子、储值卡外通用店内人均消费：20元/人', '购买须知有效期：2013.8.4 至 2014.2.4（周末、法定节假日通用使用时间：09:00-2', '1'),
(8, 27, '华特美酒楼', '酒店', '哈机街', '爱建路', '1396723842', '每日/7:00-22:00', '会员专享6折优惠', '1', '25', '89', '200', '5', '1', '0', '0', '1', '45.6870', '126.6659', '热爱烘焙的人都有一个快乐的梦想——让更多人尝到自己做的美味，让更多人幸福和感动。巴黎贝甜就一直走在这', '适用范围：店内产品，除月饼、圣诞节蛋糕、粽子、储值卡外通用\r\n店内人均消费：20元/人', '购买须知有效期：2013.8.4 至 2014.2.4（周末、法定节假日通用使用时间：09:00-2', '0'),
(9, 28, '七天', '酒店', '绥化街', '爱建路', '1324324662', '每日/8:00-22:00', '会员专享8折优惠', '1', '25', '78', '200', '2', '1', '0', '0', '0', '45.6849', '126.6250', '热爱烘焙的人都有一个快乐的梦想——让更多人尝到自己做的美味，让更多人幸福和感动。巴黎贝甜就一直走在这', '适用范围：店内产品，除月饼、圣诞节蛋糕、粽子、储值卡外通用\r\n店内人均消费：20元/人', '购买须知有效期：2013.8.4 至 2014.2.4（周末、法定节假日通用使用时间：09:00-2', '0'),
(10, 29, '天域酒家', '酒店', '绿荣街', '林兴路', '1332362456', '每日/7:00-23:00', '会员专享9折优惠', '1', '25', '172', '200', '5', '1', '0', '0', '0', '45.7183', '126.5979', '热爱烘焙的人都有一个快乐的梦想——让更多人尝到自己做的美味，让更多人幸福和感动。巴黎贝甜就一直走在这', '适用范围：店内产品，除月饼、圣诞节蛋糕、粽子、储值卡外通用店内人均消费：20元/人', '购买须知有效期：2013.8.4 至 2014.2.4（周末、法定节假日通用使用时间：09:00-2', '1'),
(11, 30, '新干线海鲜城', '酒店', '清华大街', '林兴路', '1375430523', '每日/9:00-21:00', '会员专享6折优惠', '1', '25', '102', '200', '5', '1', '0', '0', '0', '45.7163', '126.6001', '热爱烘焙的人都有一个快乐的梦想——让更多人尝到自己做的美味，让更多人幸福和感动。巴黎贝甜就一直走在这', '适用范围：店内产品，除月饼、圣诞节蛋糕、粽子、储值卡外通用店内人均消费：20元/人', '购买须知有效期：2013.8.4 至 2014.2.4（周末、法定节假日通用使用时间：09:00-2', '0');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
