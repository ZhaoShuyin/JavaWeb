<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>OGNL的基本使用</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	 <%--
  	 ActionContext ac = ActionContext.getContext();
  	 out.println(ac.get("p")+"<br/>");
  	  --%>
  	 <!-- 从contextMap中根据key找value,OGNL写法　　井key -->
  	 <s:property value="#key1"/><br/>
  	 <s:property value="#session.key2"/><br/>
  	 <s:property value="#application.key3"/><br/>
	 <%--attr page >> request >> session >> application--%>
  	 <s:property value="#attr.key2"/><br/>
     <s:debug></s:debug>
  </body>
</html>
