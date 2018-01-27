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
    
    <title>帖子列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script> 
function del(){ 
if(confirm("确认要删除该内容吗?")){ 
alert("删除成功！"); 
} 
else{ 
alert("删除失败！");
return; 
} 
} 
</script> 
  <body>
  <div align="center">
  <h1>帖子列表</h1>
  	<form action="list" method="post">
  		帖子标题:<input type="text" value="${title }" name="title"><input type="submit" value="搜索">
  		<table border="1px;"></table>
	   <table width="568" height="100" border="1">
	   <tr style="background-color:#E93EFF;">
	    <th width="120" align="center">标题</th>
	    <th width="120" align="center">内容摘要</th>
	    <th width="77" align="center">作者</th>
	    <th width="120" align="center">发布时间</th>
	    <th width="120" align="center">操作</th>
	  </tr>
	  <c:forEach items="${list}" var="list" varStatus="statu" >	      	
	      		<tr <c:if test="${statu.index%2==0}">bgcolor=#00FFFF;"</c:if>>
		     		  	<td align="center">${list.title}</td> 	
		     		  	<td align="center">${list.summary }</td> 
		     		  	<td align="center">${list.author}</td> 
		     		  	<td align="center">${list.createdate}</td>
		     		  	<td align="center"><a href="byId?id=${list.id }">查看回复</a>||<a href="del?id=${list.id }" onclick="return del();">删除</a></td>	     		  	
		     	</tr>
      	</c:forEach>
      	<tr>
      		<td colspan="5">
      		
	  	<a href="list?pageIndex=${1 }&title=${title}">首页</a>  
      	<a href="list?pageIndex=${page.currentPageNo -1 }&title=${title}">上一页</a>  
      	当前第${page.currentPageNo}页
      	总共${page.totalPageCount }页
      	<a href="list?pageIndex=${page.currentPageNo +1 }&title=${title}">下一页</a>
      	<a href="list?pageIndex=${totalPageCount }&title=${title}">尾页</a>
      	 <br>
      	 <form action="list?title=${title}">
      	 <input type="text" name="pageIndex"/>
      	 <input type="submit" value="跳转到"/>
      	 </form>
      		</td>
      	</tr>
      	<tr>
      		<td colspan="5">
      		<c:if test="${msg == 'true' }"><span style="color: red">删除成功！</span></c:if>
      		</td>
      	</tr>
	  </table>
  	</form>
  </div>  
  </body>
</html>
