<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>信息注册</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
</head>

<body>
<%--显示提示信息--%>
<span style="color:red">
  		<s:fielderror/>
  	</span>
<form action="${pageContext.request.contextPath}/regist/regist" method="post">
    <table border="1" width="438">
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="name" value="${name}"/></td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><input type="text" name="age" value="${age}"/></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>
                <input id="genderMale" type="radio"
                       name="gender" ${gender=="男"?'checked="checked"':'' } value="男"/><label
                    for="genderMale">男</label>
                <input id="genderFemale" type="radio"
                       name="gender"  ${gender=="女"?'checked="checked"':'' } value="女"/><label
                    for="genderFemale">女</label>
            </td>
        </tr>
        <tr>
            <td>生日：</td>
            <td><input type="text" name="birthday" value="${birthday}"/>默认格式：本地格式</td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="注册"/></td>
        </tr>
    </table>
</form>
</body>