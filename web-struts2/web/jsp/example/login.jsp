<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>用户登陆</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<span style="color:red">
  		<s:actionmessage/>
  	</span>
<s:form namespace="/user" action="login">
    用户名：<s:textfield name="username"></s:textfield><br/>
    密&nbsp;&nbsp;码：<s:password name="password"></s:password><br/>
    <s:submit value="登陆"></s:submit>
</s:form>
<hr/>
<s:debug></s:debug>
</body>
</html>
