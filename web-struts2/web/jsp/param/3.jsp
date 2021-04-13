<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
    <form action="${pageContext.request.contextPath}/param/par3" method="post">
    	<!-- person.name
    		先调用动作类的getPerson()得到Person对象
    		再调用person对象的setName("用户输入的值")
    	 -->
    	name:<input type="text" name="person.name"/><br/>
    	age:<input type="text" name="person.age"/><br/>
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>
