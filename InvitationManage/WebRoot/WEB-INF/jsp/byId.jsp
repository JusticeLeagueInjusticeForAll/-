<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>回复信息列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div align="center">
  <h1>回复信息列表</h1>
  	<form action="byId" method="post">
  	<a href="getAdd" style="color: red;">添加回复</a>  <a href="list">返回列表帖子</a>
  	<table width="456" height="100" border="1">
  		<tr>
  			<th width="77" align="center">回复内容</th>
  			<th width="77" align="center">回复昵称</th>
  			<th width="77" align="center">发布时间</th>
  		</tr>
  		<c:forEach items="${reply}" var="reply" varStatus="statu">
  			<tr <c:if test="${statu.index%2==0}">bgcolor=#00FFFF;"</c:if>>
		     		  	<td align="center">${reply.content}</td> 	
		     		  	<td align="center">${reply.author }</td> 
		     		  	<td align="center">${reply.createdate}</td> 	     		  	
		     	</tr>
  		</c:forEach>
  	</table>
    </form>
    </div>
  </body>
</html>
