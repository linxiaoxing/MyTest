<?php
     //$_GET����ʽ��code�������
     $mycode = $_GET['code'];
	 //�������ݿ�����
	 //localhost����ip
	 //root���ݿ��û���
	 //root���ݿ��û�����
                    $link = mysql_connect('���Լ����ݿ��IP��ַ','534429149','534429149');
               //��ѯ�����ݿ�
               mysql_select_db('534429149',$link);
	 //���ñ����ʽutf8
     mysql_query('set names utf8');
	 //��ѯ���
     $sql = "SELECT * FROM  `app` ";
	 //��ѯ���ݿ⣬�����α�
     $res = mysql_query($sql);
	 //��������
     $arr = array();
	 //ѭ�����α굱�л�ȡ���ݣ���ӵ�����
     while($row = mysql_fetch_assoc($res)){
           $arr[] = $row;
     }
	 //�������򣬲���ӡ
	 //json_encode($arr) ������ת����json����
     die(json_encode($arr));