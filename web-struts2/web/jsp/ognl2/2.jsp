<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>title</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<!-- 
  		property:
  		作用：输出表达式的值到页面上（原理：ValueStack.findValue("OGNL表达式")）
  		属性：
  			value：ognl表达式。比如name：先搜索root中对象的属性；再搜索contextMap中的key值。
  					value属性可以省略，默认输出栈顶对象。
  	 -->
  	<s:property value="name"/><br/>              <!-- 输出属性 -->
  	<s:property/><br/>                           <!-- 输出栈顶对象 -->
  	<s:property value="top"/><br/>               <!-- 输出栈顶对象:top是OGNL的特殊变量，指向的栈顶对象 -->

  	<s:property default="没有" value="abc"/>
	<br/>
  	<s:property value="'<hr/>'"/>
	<br/>
  	<s:property value="'<hr/>'" escapeHtml="false"/>
	<br/>
  	成绩：<s:property value="grade"/><br/>

  	<!-- if elseif else
  		作用：java语言中的逻辑判断
  		属性：
  			test：ognl表达式，表达式的值必须返回boolean的
  		 -->

  	<s:if test='grade=="A"'>优秀</s:if>
  	<s:elseif test='grade=="B"'>良好</s:elseif>
  	<s:else>尚需努力</s:else>
  	<hr/>

	<s:debug></s:debug>

  </body>
</html>
