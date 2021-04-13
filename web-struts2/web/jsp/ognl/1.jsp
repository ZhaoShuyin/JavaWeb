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
  	<!-- s:property:
  			作用：输出表达式的值到页面上
  			属性：
  				value:取值是一个OGNL表达式
  		OGNL表达式的字符和字符串数据类型：
  			'a':字符直接量
  			'ab':字符串直接量
  			"a":字符串直接量
  	 -->
  	<!-- 调用实例方法 -->
    <s:property value="'abcd'.length()"/><br/>
    <s:property value="'abcd'.toUpperCase()"/><br/>
    <hr/>
    <!-- 调用静态变量 -->
    <s:property value="@java.lang.Integer@MAX_VALUE"/><br/>
    <hr/>
     <!--调用静态方法:
     	struts2中默认禁用OGNL调用静态方法。
     	struts.ognl.allowStaticMethodAccess=false
      -->
     <s:property value="@java.lang.Math@abs(-100)"/><br/>
     <s:debug></s:debug>
  </body>
</html>
