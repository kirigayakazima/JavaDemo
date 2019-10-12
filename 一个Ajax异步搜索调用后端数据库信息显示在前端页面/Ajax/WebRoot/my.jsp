<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'my.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function getData(){
		//创建ajax引擎对象
		var ajax;
		if(window.XMLHttpRequest){
			ajax=new XMLHttpRequest();
		}else{
			ajax=new ActiveXObject("Msxm12.XMLHTTP");
		}
		
		复写onreadystatechange函数 
		ajax.onreadystatechange=function(){
			if(ajax.readyState==4){
				if(ajax.status==200){
					 //获取响应内容
		            var result=ajax.responseText;
		            //获取div元素对象
		            var showdiv=document.getElementById("showdiv");
		            showdiv.innerHTML=result;
				}else if(ajax.status==404){
					var showdiv=document.getElementById("showdiv");
		            showdiv.innerHTML="请求资源不存在";
				}else if(ajax.status==500){
					var showdiv=document.getElementById("showdiv");
		            showdiv.innerHTML="服务器繁忙";
				}
	          }
			//当响应结果没来的时候就加载这个图片
			else{
					var showdiv=document.getElementById("showdiv");
		            showdiv.innerHTML="<img src='img/miku.jpg' width='100px' height='100px' />";
				}
		}
		//发送请求
		ajax.open("get", "ajax",true);
		ajax.send(null);
	}
	</script>
<style type="text/css">
#showdiv{
		border:black 1px solid;
		width:200px;
		height:100px;
		;
}
</style>

</head>
  
  <body>
   <h3>测试页面</h3>
   <hr>
   <input type="submit" value="测试" onclick="getData()"/>
   <br>
   <div id="showdiv"></div>
  </body>
</html>
