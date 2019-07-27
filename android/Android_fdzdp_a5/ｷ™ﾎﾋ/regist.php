<?php 
     $value1 = $_POST['value1'];
     $value = $_POST['value'];
     $obj=json_decode($value);
	 $pname = $obj->pname;
	 $ppassword = $obj->ppassword;
	 $nickname = $obj->nickname;
                    $link = mysql_connect('你自己数据库的IP地址','534429149','534429149');
               //查询的数据库
               mysql_select_db('534429149',$link);
     mysql_query('set names utf8');
	 $sql="INSERT INTO `users`( `pname`, `ppassword`, `nickname`, `sex`, `domicile`, `account_balance`) VALUES ('".$pname."','".$ppassword."','".$nickname."','1','哈尔滨','100');";
     $res = mysql_query($sql);
     printf("ok");
