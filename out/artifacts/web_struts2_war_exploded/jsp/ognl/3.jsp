<%@page import="com.opensymphony.xwork2.util.ValueStack" %>
<%@page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
<hr/>
<%--
ValueStack vs = ActionContext.getContext().getValueStack();
out.println("size:"+vs.size()+"<br/>");
 --%>
<!-- 取root中对象的属性，直接写属性名即可
    month:属性,从栈顶对象依次搜索
-->
<hr/>
<s:property value="month"/><br/>
<hr/>
<s:property value="key1"/><br/>
<hr/>
<s:property value="key2"/><br/>
<hr/>
<!-- 砍掉root的第一个对象后再找 -->
<s:property value="[1]"/><br/>
<hr/>
<s:debug></s:debug>
</body>
</html>
