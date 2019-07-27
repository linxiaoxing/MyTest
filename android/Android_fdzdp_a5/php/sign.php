<?php 
	
	                $link = mysql_connect('你自己数据库的IP地址','534429149','534429149');
               //查询的数据库
               mysql_select_db('534429149',$link);
	mysql_query('set names utf8');
    $sql = "SELECT `sign`.* , `users`.`nickname` FROM `sign` ,  `users` where `users`.`pid` = `sign`.`pid`";
	$res = mysql_query($sql);
	$arr = array();
	while($row = mysql_fetch_assoc($res)){
	    $arr[] = $row;
	}
	die(json_encode($arr));