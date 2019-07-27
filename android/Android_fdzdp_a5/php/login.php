<?php
   $pname = $_POST['pname'];
   $ppassword = $_POST['ppassword'];
                  $link = mysql_connect('你自己数据库的IP地址','534429149','534429149');
               //查询的数据库
               mysql_select_db('534429149',$link);
   mysql_query('set names utf8');
   //从数据库中查询。如果不为空，说明有这个用户，可以登录。若为空，则不可以登录
   $sql = "select * from users where pname = '".$pname."' and ppassword = '".$ppassword."'";
   $res = mysql_query($sql);
   $arrayName = array();
   $arrayName = mysql_fetch_array($res);
   if(empty($arrayName)){
      printf("no");
   }else{
      printf("yes");
        }  