<?php
     //$_GET请求方式，code请求参数
     $mycode = $_GET['code'];
	 //建立数据库连接
	 //localhost请求ip
	 //root数据库用户名
	 //root数据库用户密码
                    $link = mysql_connect('你自己数据库的IP地址','534429149','534429149');
               //查询的数据库
               mysql_select_db('534429149',$link);
	 //设置编码格式utf8
     mysql_query('set names utf8');
	 //查询语句
     $sql = "SELECT * FROM  `app` ";
	 //查询数据库，返回游标
     $res = mysql_query($sql);
	 //定义数组
     $arr = array();
	 //循环从游标当中获取数据，添加到数组
     while($row = mysql_fetch_assoc($res)){
           $arr[] = $row;
     }
	 //结束程序，并打印
	 //json_encode($arr) 把数组转化成json数组
     die(json_encode($arr));