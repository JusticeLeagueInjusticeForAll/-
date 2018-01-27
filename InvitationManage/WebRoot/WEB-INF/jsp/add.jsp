<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加回复</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<script type="text/javascript" src="/statics/jquery-1.8.3.js"></script>
  <script type="text/javascript">
 function add() {    
 		alert(1);   
        $.ajax({
                url: 'add',
                type: 'POST',
                datatype: 'JSON',               
                data: $('#add').serialize(),
            	success: function(data) {
            	if(data>0){
            	alert('添加成功！');
            	}else{
            	alert('添加失败！');
            	}
            	}
            });
    };
   </script>
  <body>
  	<div align="center">
    <form id="add" action="" method="post" >
    
    	<h1>添加回复</h1>
    	回复内容:<input type="text" name="content"><br/><br/>
    	回复昵称:<input type="text" name="author"><br/>
    	<input onclick="add()" type="button" value="提交"><input type="button" value="返回" onclick="javascript:window.history.back(-1);" >
    </form>
    </div>
  </body>
</html>
