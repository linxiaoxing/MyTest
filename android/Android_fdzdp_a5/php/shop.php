		<?php 
			  $mstart = $_GET['start'];
			  $mend = $_GET['end'];
			                $link = mysql_connect('你自己数据库的IP地址','534429149','534429149');
               //查询的数据库
               mysql_select_db('534429149',$link);
			  mysql_query('set names utf8');
			  $sql = "SELECT `shop`.`sid`,
		`shop`.`iid`,
		`shop`.`sname`,
		`shop`.`stype`,
		`shop`.`saddress`,
		`shop`.`snear`,
		`shop`.`stel`,
		`shop`.`stime`,
		`shop`.`szhekou`,
		`shop`.`smembercard`,
		`shop`.`sper`,
		`shop`.`smoney`,
		`shop`.`snum`,
		`shop`.`slevel`,
		`shop`.`sflag_tuan`,
		`shop`.`sflag_quan`,
		`shop`.`sflag_ding`,
		`shop`.`sflag_ka`,
		`shop`.`longitude`,
		`shop`.`latitude`,
		`shop`.`sintroduction`,
		`shop`.`sdetails`,
		`shop`.`stips`,
		`shop`.`sflag_promise`,
		`photo`.`iname` 
		FROM `shop`,`photo` where 
		`shop`.`iid` = `photo`.`iid` and 
		`shop`.`sid` >= ".$mstart." and `shop`.`sid` <= ".$mend;
		$res = mysql_query($sql);
		$arr = array();
		while($row = mysql_fetch_assoc($res)){
	           $arr[] = $row;
		}
		die(json_encode($arr));