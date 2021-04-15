<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>主页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/calendar/calendar.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/calendar/calendar.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/public.js"></script>

	<style type="text/css">
		.odd{
			background-color: #c3f3c3;
		}
		.even{
			background-color: #f3c3f3;
		}
		.error{
			color: red;
		}
	</style>
  </head>
  
  <body>
  	<div>
  		<s:if test="#session.user!=null">
    		欢迎您：${session.user.nickname}
    		<s:a namespace="/user" action="logout">注销</s:a>
    	</s:if>
    	<s:else>
    		<a href="${pageContext.request.contextPath}/jsp/example/login.jsp">登陆</a>
    	</s:else>
   	</div>
   	<div style="text-align: right;">
   		今天是：<%=new Date().toLocaleString()%>
   	</div>
   	<hr/>
   	<s:a namespace="/user" action="listUsers">用户管理</s:a>
   	<hr/>

