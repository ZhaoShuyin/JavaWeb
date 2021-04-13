<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>文件上传</title>
    
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
    <form action="${pageContext.request.contextPath}/upload/upload1" method="post" enctype="multipart/form-data">
    	name:<input type="text" name="name"/><br/>
    	photo:<input type="file" name="photo"/><br/>
    	<input type="submit" value="submit"/>
    </form>
  </body>
</html>
