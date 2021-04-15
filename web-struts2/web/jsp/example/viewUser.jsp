<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/jsp/example/header.jsp" %>
<fieldset>
    <legend>查看用户</legend>
    <a href="javascript:history.back()">返回</a>
    <!-- 显示的内容 -->
    <table border="1" width="538">
        <tr>
            <td>用户名：</td>
            <td>
                ${username}
            </td>
        </tr>
        <tr>
            <td>昵称：</td>
            <td>
                ${nickname}
            </td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>
                ${gender=='male'?'男':'女' }
            </td>
        </tr>
        <tr>
            <td>生日：</td>
            <td>
                <s:date name="birthday" format="yyyy年MM月dd日"/>
            </td>
        </tr>
        <tr>
            <td>学历：</td>
            <td>
                ${degrees}
            </td>
        </tr>
        <tr>
            <td>电话号码：</td>
            <td>
                ${phonenum}
            </td>
        </tr>
        <tr>
            <td>爱好：</td>
            <td>
                ${hobby}
            </td>
        </tr>
        <tr>
            <td>简历：</td>
            <td>
                <s:url namespace="/user" action="downloadResume" var="url">
                    <s:param name="id" value="id"></s:param>
                </s:url>
                <a href="#" onclick="openWindow('${url}','700','400')">
                    <s:property value="filename.substring(filename.indexOf('_')+1)"/>
                </a>
            </td>
        </tr>
        <tr>
            <td>简介：</td>
            <td>${description}
            </td>
        </tr>
    </table>
</fieldset>
<hr/>
<s:debug></s:debug>
</body>
</html>
