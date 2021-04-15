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
<!--
    iterator:
    作用：类似jsp中jstl的forEach
    属性：
        value:是一个OGNL表达式，要遍历的数组或集合
        var:给当前遍历的元素指定一个变量名叫做s。放到了contextMap中
            如果不指定，当前元素存到root的栈顶。

 -->
strs: => <s:property value="strs"/>
<hr/>
<!-- 遍历：数组元素 -->
遍历：数组元素 1
<br/>
<s:iterator value="strs" var="s">
    <s:property value="#s"/>
    <br/>
</s:iterator>
<hr/>

遍历：数组元素 2
<br/>
<s:iterator value="strs">
    <s:property/>
    <br/>
</s:iterator>
<hr/>

遍历：集合元素 list
<br/>
<s:iterator value="list">
    <s:property/>
    <br/>
</s:iterator>
<hr/>

遍历：集合元素 set
<br/>
<s:iterator value="set">
    <s:property/>
    <br/>
</s:iterator>
<hr/>

遍历：集合元素 map Map.Entry 形式
<br/>
<s:iterator value="map">
    <!-- map中的元素是：Map.Entry :getKey()  getValue() -->
key:<s:property value="key"/>=value:<s:property value="value"/><br/>
</s:iterator>
<hr/>

遍历：集合元素 map Map.Entry(var) 形式
<br/>
<s:iterator value="map" var="me">
    <!-- map中的元素是：Map.Entry: :getKey() getValue()
    contextMap:me=Map.Entry
    -->
    key:<s:property value="#me.key"/>=value:<s:property value="#me.value"/><br/>
</s:iterator>
<hr/>

<s:debug></s:debug>

</body>
</html>
