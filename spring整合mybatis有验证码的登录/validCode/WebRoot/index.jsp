<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
		<script type="text/javascript">
			$(function(){
				$("a").click(function(){
					
					$("img").attr("src","demo?data="+new Date());
					return false;
				})
			})
		</script>
		<style>
			*{
				margin: 0;
				padding: 0;
			}
			.Box1{
				height: 600px;
				
			}
			.Box2{
				margin: 120px auto 0;
				width: 500px;
				height: 280px;
				background-color: #00FFFF;
				border-radius: 15px;
			}
			.both{
				width: 320px;
				height: 50px;
				margin:20px auto 0;
				
				text-align: center;
			}
			input{
				height: 30px;
				
				margin:15px auto ;
			}
			.left{
				float:right
			}
		</style>
	</head>
	<body>
		<div class="Box1">
			<div class="Box2">
			${error }
				<form action="login" method="post">
					<div class="both">
						用户名：<input type="text" name="username" placeholder="请输入用户名"/>
					</div>
					<div class="both">
						密码：<input type="text" name="password" placeholder="请输入密码"/>
					</div>
					<div class="both">
						验证码：<input type="text" name="code" placeholder="请输入验证码"/>	<img src="demo" width="80px" height="30px"/>
						<div class="left"><a href="reset">看不清楚</a></div>
					</div>
					<div class="both">
						<input value="登录" type="submit" />
						<input value="重置" type="reset" />
					</div>
					
					
				</form>
			</div>
		</div>
	</body>
</html>
