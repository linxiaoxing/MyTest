	<?php
		  
		  $mycode = $_POST['mycode'];
		  $value = $_POST['value'];
		  if ($mycode == 1) {
			   $obj=json_decode($value);
			   $sid = $obj->sid;
			   $pid = $obj->pid;
			   $signcontent = $obj->signcontent;
			   $signlevel = $obj->signlevel;
			   $signimage = $obj->signimage;
			   $signtime = $obj->signtime;
               $link = mysql_connect('你自己数据库的IP地址','534429149','534429149');
               //查询的数据库
               mysql_select_db('534429149',$link);
               mysql_query('set names utf8');
			   $sql = "INSERT INTO sign(sid,pid,signcontent,signlevel,signimage,signtime) VALUES ('".$sid."','".$pid."','".$signcontent."','".$signlevel."','".$signimage."','".$signtime."')";
			   $res = mysql_query($sql);
               printf("ok");
		  }