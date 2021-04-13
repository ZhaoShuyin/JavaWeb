<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>信息注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<span style="color:red">
  		<s:fielderror/>
  		<s:actionerror/>
  	</span>
    <form action="${pageContext.request.contextPath}/valid/reg" method="post">
    	<table border="1" width="738">
    		<tr>
    			<td>姓名：</td>
    			<td><input type="text" name="name" value="${name}"/></td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td><input type="text" name="password" value="${password}"/></td>
    		</tr>
    		<tr>
    			<td>确认密码：</td>
    			<td><input type="text" name="repassword" value="${repassword}"/></td>
    		</tr>
    		<tr>
    			<td>年龄：</td>
    			<td><input type="text" name="age" value="${age}"/></td>
    		</tr>
    		<tr>
    			<td>性别：</td>
    			<td>
    				<input id="genderMale" type="radio" name="gender" ${gender=="男"?'checked="checked"':'' } value="男"/><label for="genderMale">男</label>
    				<input id="genderFemale" type="radio" name="gender"  ${gender=="女"?'checked="checked"':'' } value="女"/><label for="genderFemale">女</label>
    			</td>
    		</tr>
    		<tr>
    			<td>生日：</td>
    			<td>
    			<fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd" var="d"/>
    			<input type="text" name="birthday" value="${d}"/>默认格式：本地格式</td>
    		</tr>
    		<tr>
    			<td>邮箱：</td>
    			<td><input type="text" name="email" value="${email}"/></td>
    		</tr>
    		<tr>
    			<td>个人网址：</td>
    			<td><input type="text" name="url" value="${url}"/>协议：主机（端口）：资源地址</td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="注册"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
