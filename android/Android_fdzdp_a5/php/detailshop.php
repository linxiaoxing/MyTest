				<?php 
					  $mstart = $_GET['shopid'];
					                 $link = mysql_connect('你自己数据库的IP地址','534429149','534429149');
               //查询的数据库
               mysql_select_db('534429149',$link);
					  mysql_query('set names utf8');
					  $sql = "SELECT `sign`.* FROM `shop`,`sign` where `shop`.`sid` = `sign`.`sid` and `shop`.`sid` = ".$mstart;
					  $sql1 = "SELECT `comments`.* FROM `shop`,`comments` where `shop`.`sid` = `comments`.`sid` and `shop`.`sid` = ".$mstart;
                     			  $sql2 = "SELECT `food`.* FROM `shop`,`food` where `shop`.`sid` = `food`.`sid` and `shop`.`sid` = ".$mstart;
				$res = mysql_query($sql);
				$res1 = mysql_query($sql1);
				$res2 = mysql_query($sql2);
				$arr = array();
				$arr1 = array();
				$arr2 = array();
				while($row = mysql_fetch_assoc($res)){
	               $arr[] = $row;
		           }
				while($row = mysql_fetch_assoc($res1)){
	               $arr1[] = $row;
		          }
				  while($row = mysql_fetch_assoc($res2)){
	               $arr2[] = $row;
		          }
				$out ="{\"result\":\"ok\",\"sign\":".json_encode($arr).",\"comments\":".json_encode($arr1).",\"food\":".json_encode($arr2)."}";
				print($out);