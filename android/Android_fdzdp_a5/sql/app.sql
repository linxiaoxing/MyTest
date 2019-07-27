-- phpMyAdmin SQL Dump
-- version 4.0.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2014 年 04 月 01 日 01:08
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
-- 表的结构 `app`
--

CREATE TABLE IF NOT EXISTS `app` (
  `appid` int(11) NOT NULL AUTO_INCREMENT,
  `appname` varchar(50) CHARACTER SET utf8 NOT NULL,
  `appimg` varchar(50) CHARACTER SET utf8 NOT NULL,
  `appinfo` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`appid`)
) ENGINE=MyISAM  DEFAULT CHARSET=gbk AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `app`
--

INSERT INTO `app` (`appid`, `appname`, `appimg`, `appinfo`) VALUES
(1, '360手机助手', '360手机助手.jpg', '360手机手—是android智能手机的资源获取平台。360手机助手帮助你用更省流量、更快捷、更方便、更安全的方式获取网络源，为您的android手机注入鲜活色彩！'),
(2, '91桌面', '91桌面.jpg', '海量主题壁纸铃声，任您选择，更有动态多屏壁纸等丰富DIY功能，全面打造您的个性化桌面。'),
(3, '携程旅行', '携程旅行.jpg', '提供集酒店预订、机票预订、度假预订、商旅管理、特惠商户及旅游资讯在内的全方位旅行服务，被誉为互联网和传统旅游无缝结合的典范。'),
(4, '唯品会', '唯品会.jpg', '唯品会坚持以安全诚信的交易环境和服务平台、可对比的低价位、高品质的商品、专业的唯美设计、完善的售后服务，全方位地服务于每一位会员。'),
(5, 'PPS影音', 'PPS影音.jpg', 'PPS一直致力于倾听、挖掘与满足中国网民的需求，秉承“用户体验至上”的理念，除播放器外，还提供影视百科、PPS看看、影视搜索等多样化的产品及服务。');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
