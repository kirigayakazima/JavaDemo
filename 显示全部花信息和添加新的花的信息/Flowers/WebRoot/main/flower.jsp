<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'flower.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		a{
			color:black;
			text-decoration:none;
		}
		a:hover{
			color:red;
		}
	</style>
  </head>

  <body>
    <table border="1px">
    	<tr>
    		<td>编号</td>
    		<td>名称</td>
    		<td>价格</td>
    		<td>产地</td>
    	</tr>
    	<c:forEach items="${list }" var="flower">
    	<tr>
    		<td>${flower.num }</td>
    		<td>${flower.uname }</td>
    		<td>${flower.price }</td>
    		<td>${flower.production }</td>
    	</tr>	
    	</c:forEach>
    </table>
    <a href="main/insert.jsp" />点一下添加花的数据</a>
  </body>
</html>
