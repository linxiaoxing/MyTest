-- phpMyAdmin SQL Dump
-- version 4.0.3
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2014 年 04 月 01 日 01:12
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
-- 表的结构 `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) CHARACTER SET utf8 NOT NULL,
  `ppassword` varchar(50) CHARACTER SET utf8 NOT NULL,
  `nickname` varchar(50) CHARACTER SET utf8 NOT NULL,
  `sex` varchar(50) CHARACTER SET utf8 NOT NULL,
  `domicile` varchar(50) CHARACTER SET utf8 NOT NULL,
  `account_balance` int(11) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=MyISAM  DEFAULT CHARSET=gbk AUTO_INCREMENT=23 ;

--
-- 转存表中的数据 `users`
--

INSERT INTO `users` (`pid`, `pname`, `ppassword`, `nickname`, `sex`, `domicile`, `account_balance`) VALUES
(1, '123', '123', '叫我123', '1', '哈尔滨', 100),
(2, 'zhangsan', 'zhangsan', '叫我张三', '1', '北京', 200),
(3, 'lisi', 'lisi', '叫我李四', '0', '河北', 200),
(4, 'wangwu', 'wangwu', '叫我王五', '1', '双鸭山', 100),
(5, 'zhaoliu', 'zhaoliu', '叫我赵六', '0', '北京', 200),
(6, 'qqq', 'qqq', '叫我qqq', '0', '河北', 200),
(7, 'www', 'www', '叫我www', '1', '哈尔滨', 100),
(8, 'eee', 'eee', '叫我eee', '1', '北京', 200),
(9, 'rrr', 'rrr', '叫我rrr', '0', '河北', 200),
(10, 'ttt', 'ttt', '叫我ttt', '1', '哈尔滨', 100),
(11, 'yyy', 'yyy', '叫我yyy', '1', '北京', 200),
(12, '123', '123', '叫我123', '1', '哈尔滨', 100),
(13, 'zhangsan', 'zhangsan', '叫我张三', '1', '北京', 200),
(14, 'lisi', 'lisi', '叫我李四', '0', '河北', 200),
(15, 'wangwu', 'wangwu', '叫我王五', '1', '双鸭山', 100),
(16, 'zhaoliu', 'zhaoliu', '叫我赵六', '0', '北京', 200),
(17, 'qqq', 'qqq', '叫我qqq', '0', '河北', 200),
(18, 'www', 'www', '叫我www', '1', '哈尔滨', 100),
(19, 'eee', 'eee', '叫我eee', '1', '北京', 200),
(20, 'rrr', 'rrr', '叫我rrr', '0', '河北', 200),
(21, 'ttt', 'ttt', '叫我ttt', '1', '哈尔滨', 100),
(22, 'yyy', 'yyy', '叫我yyy', '1', '北京', 200);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
