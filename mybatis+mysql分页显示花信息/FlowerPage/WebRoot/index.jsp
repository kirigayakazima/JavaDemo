<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
				border: black 1px solid;
			}
			.warning{
				color: deeppink;
				font-size: 17px;
				height: 25px;
				font-weight: 600;
				border: black 1px solid;
				line-height: 25px;
			}
		</style>
  </head>
  
  <body>
   	<div class="bigBox">
				<div class="insertBox">
					<table border="1">
						<tr>
							<th>编号</th>
							<th>名称</th>
							<th>价格</th>
							<th>产地</th>
						</tr>
						<c:forEach items="${pi.list }" var="pi">
							<tr>
								<td>${pi.num }</td>
								<td>${pi.uname }</td>
								<td>${pi.price }</td>
								<td>${pi.production }</td>
							</tr>	
						</c:forEach>
						
					</table>
					<a href="show?pageNumber=${pi.pageNumber-1 }&pageSize=${pi.pageSize }" <c:if test="${pi.pageNumber<=1 }"> onclick="javascript:return false;"</c:if> >上一页</a>
  					<a href="show?pageNumber=${pi.pageNumber+1 }&pageSize=${pi.pageSize }" <c:if test="${pi.pageNumber>=pi.total }"> onclick="javascript:return false;"</c:if> >下一页</a>
			</div>
		</div>
  </body>
</html>
