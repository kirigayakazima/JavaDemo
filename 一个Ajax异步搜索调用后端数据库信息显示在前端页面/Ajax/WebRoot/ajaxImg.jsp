<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajaxImg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script>
	function getData(){
		
		//获取用户信息
		var name=document.getElementById("uid").value;
		var ta=document.getElementById("ta");
		//创建ajax引擎
		var ajax;
		if(window.XMLHttpRequest){
			//兼容火狐
			ajax=new XMLHttpRequest();
		}else{
			ajax=new ActiveXObject("Msxm12.XMLHTTP");
		}
		/*var tr=ta.insertRow(1);
		var cell0=tr.insertCell(0);
		cell0.innerHTML="真的难受";*/
		//复写onreadystatechange
		ajax.onreadystatechange=function(){
			//判断ajax响应状态码
			if(ajax.readyState==4){
				//判断响应状态码
				if(ajax.status==200){
					//请求成功
					//获取响应数据
					var result=ajax.responseText; 
					eval("var u="+result);
					//var u=""+result;
					alert(u);
					//处理响应数据
					//获取table表格对象
					//插入新的行
					ta.innerHTML="";
					var tr=ta.insertRow(0);
					var cell0=tr.insertCell(0);
					cell0.innerHTML="编号";
					var cell1=tr.insertCell(1);
					cell1.innerHTML="名称";
					var cell2=tr.insertCell(2);
					cell2.innerHTML="战斗力";
					var cell3=tr.insertCell(3);
					cell3.innerHTML="价值";
					var cell4=tr.insertCell(4);
					cell4.innerHTML="位置";
					var cell5=tr.insertCell(5);
					cell5.innerHTML="描述";
					
					
					var tr=ta.insertRow(1);
					var cell0=tr.insertCell(0);
					cell0.innerHTML=u.uid;
					var cell1=tr.insertCell(1);
					cell1.innerHTML=u.name;
					var cell2=tr.insertCell(2);
					cell2.innerHTML=u.power;
					var cell3=tr.insertCell(3);
					cell3.innerHTML=u.money
					var cell4=tr.insertCell(4);
					cell4.innerHTML=u.loca;
					var cell5=tr.insertCell(5);
					cell5.innerHTML=u.dec;
					
				}
			}
		}
		ajax.open("get","user?name="+name);
		ajax.send(null);
	}
	
	</script>
	<style>
	*{
		padding:0;
		magrin:0
	}
		div{
			text-align: center;
		}
		.BarBox{
			margin:100px auto 0;
			width:700px;
			height:100px;
			background-color:#f567e1;
			border-radius:10px;
		}
		.ContentBox{
			text-align:center;
			border:blue 1px solid;
			height:500px;
		}
		table{
			margin:0 auto;
		}
		td{
			width:90px;
			height:30px;
			text-align:center;
		}
	</style>
	  </head>
  
  <body>
  <div>
  <div class="BarBox">
    <h3>欢迎查看动漫人物</h3>
    <br>
    <form>
    人物名称<input type="text" name="name" placeholder="Ami" id="uid" />
    	<input type="button" value="搜索" onclick="getData()"/>
    
   </div>
   <div class="ContentBox">
   	<table border="black 1px solid" id="ta">
   		<tr>
   
   		</tr>
   	</table>
   </div>
  </div>
  </body>
</html>
