<%@page import="com.opensymphony.xwork2.ActionContext" %>
<%@page import="com.opensymphony.xwork2.util.ValueStack" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>必须做出来</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
        .odd {
            background-color: #c3f3c3;
        }

        .even {
            background-color: #f3c3f3;
        }

        .male {
            background-color: #c3f3c3;
        }

        .female {
            background-color: #f3c3f3;
        }
    </style>
</head>

<body>
<!--
    iterator:
    作用：类似jsp中jstl的forEach
    属性：
        value:是一个OGNL表达式，要遍历的数组或集合
        var:给当前遍历的元素指定一个变量名叫做s。放到了contextMap中
            如果不指定，当前元素存到root的栈顶。
        status:指定一个变量名，引用对象。放到了contextMap中
            该对象记录着当前元素的信息
            int getIndex():索引，从0开始
            int getCount():计数，从1开始
            boolean isFirst():是否是第一个
            boolean isLast():是否是最后一个
            boolean isOdd():是否是奇数
            boolean isEven():是否是偶数
 -->
<h5>表格1</h5>
<table border="1" width="600">
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>籍贯</th>
    </tr>
    <s:iterator value="students">
        <tr class="<s:property value='gender=="男"?"male":"female"'/>">
            <td><s:property value="name"/></td>
            <td><s:property value="gender"/></td>
            <td><s:property value="address"/></td>
        </tr>
    </s:iterator>
</table>

<h5>表格2</h5>
<table border="1" width="638">
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>故乡</th>
        <th>索引</th>
        <th>计数</th>
        <th>第一个</th>
        <th>最后一个</th>
        <th>奇</th>
        <th>偶</th>
    </tr>
    <s:iterator value="students" status="s">
        <tr class="<s:property value="#s.odd?'odd':'even'"/>">
            <td><s:property value="name"/></td>
            <td><s:property value="gender"/></td>
            <td><s:property value="address"/></td>
            <td><s:property value="#s.index"/></td>
            <td><s:property value="#s.count"/></td>
            <td><s:property value="#s.first"/></td>
            <td><s:property value="#s.last"/></td>
            <td><s:property value="#s.odd"/></td>
            <td><s:property value="#s.even"/></td>
        </tr>
    </s:iterator>

</table>

<h5>表格3(OGNL的El表达式)</h5>

<table border="1" width="638">
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>故乡</th>
        <th>索引</th>
        <th>计数</th>
        <th>第一个</th>
        <th>最后一个</th>
        <th>奇</th>
        <th>偶</th>
    </tr>
    <s:iterator value="students" status="s">
        <tr class="${s.odd?'odd':'even'}">
            <td>${name}</td>
            <td>${gender}</td>
            <td>${address}</td>
            <td>${s.index}</td>
            <td><s:property value="#s.count"/></td>
            <td><s:property value="#s.first"/></td>
            <td><s:property value="#s.last"/></td>
            <td><s:property value="#s.odd"/></td>
            <td><s:property value="#s.even"/></td>
        </tr>
    </s:iterator>
</table>

<s:debug></s:debug>

</body>
</html>

