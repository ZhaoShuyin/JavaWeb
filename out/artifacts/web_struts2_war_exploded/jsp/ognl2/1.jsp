<%@page import="com.opensymphony.xwork2.ActionContext" %>
<%@page import="com.opensymphony.xwork2.util.ValueStack" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
<!--Action.name -->
<h5>使用 'value=name' 获取(Action.name) name :</h5>
<s:property value="name"/><br/>
<hr/>
<s:property value="#p"/><br/>
<hr/>
<s:property value="p"/><br/>
<hr/>
<%
    ValueStack vs = ActionContext.getContext().getValueStack();
    //Object name = vs.findValue("name");
    String name = vs.findString("name");//直接获取String类型的数据
    out.print(name + "<br/>");
    String p = vs.findString("#key1");//获取contextMap中的数据
    out.print(p + "<br/>");
    String p1 = vs.findString("key1");  //p是OGNL表达式
    //搜索root中所有对象的p属性，找到就显示；如果找不到，变为了key，到contextMap中找对应的value
    out.print(p1 + "<br/>");
%>
<hr/>
<s:debug></s:debug>
</body>
</html>
