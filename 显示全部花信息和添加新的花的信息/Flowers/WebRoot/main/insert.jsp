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
    
    <title>My JSP 'insert.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
			<style>
			*{
				padding: 0;
				margin: 0;
			}
			.bigBox{
				margin: 100px auto 0;
				width: 500px;
				height: 600px;
				border: aqua 1px soild;
				background-color: #F0F8FF;
				text-align: center;
				border-radius: 15px;
			}
			.insertBox{
				margin: 0 auto;
			}
			.form-text{
				color: #00FFFF;
				font-size: 30px;
				margin-bottom:20px ;
			}
			.common{
				text-align: center;
				top: 25px;
				margin: 0 auto 25px;
				//border: #000000 1px solid;
				width: 350px;
				height: 100px;
				border-radius: 5px;
			}
			input{
				width: 200px;
				height: 35px;
				margin: 10px auto;
				border-radius: 5px;
			}
			.btn1:hover{
				opacity: 0.8;	
				cursor: pointer;
			}
			.btn1{
				color: #FFFFFF;
				font-size: 20px;
			}
			.warning{
				color: deeppink;
				font-size: 17px;
				height: 25px;
				font-weight: 600;
				line-height: 25px;
			}
		</style>
  </head>
  
  <body>
 	<div class="bigBox">
				<div class="insertBox">
					<form action="insert" method="post">
						<div class="form-text">
							添加花的信息
						</div>
						<div class="common">
							花的名称：<input type="text" name="uname" placeholder="填入花的名称">
						</div>
						<div class="common">
							花的价格：<input type="text" name="price" placeholder="填入花的价格">
						</div>
						<div class="common">
							花的产地：<input type="text" name="production" placeholder="填入花的产地">
						</div>
						<div class="warning"><c:out value="${str }"></c:out></div>
						<input class="btn1" type="submit" value="提交"><br>
					</form>
				</div>
		</div>
  </body>
</html>
