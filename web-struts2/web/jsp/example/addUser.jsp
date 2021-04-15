<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/jsp/example/header.jsp" %>
<fieldset>
    <legend>添加新用户Test</legend>
    <a href="javascript:history.back()">返回</a>
    <!-- 显示的内容 -->
    <span class="error">
		<s:fielderror/>
		<s:actionerror/>
	</span>
    <s:form namespace="/user" action="addUser" enctype="multipart/form-data">
        <table border="1" width="538">
            <tr>
                <td>用户名：</td>
                <td><s:textfield name="username"></s:textfield></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><s:password name="password"></s:password></td>
            </tr>
            <tr>
                <td>确认密码：</td>
                <td><s:password name="repassword"></s:password></td>
            </tr>
            <tr>
                <td>昵称：</td>
                <td><s:textfield name="nickname"></s:textfield></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td>
                    <s:radio name="gender" list="#{'male':'男','female':'女'}" value="'male'"/>
                </td>
            </tr>
            <tr>
                <td>生日：</td>
                <td>
                    <s:textfield id="birthday" name="birthday" readonly="false"
                                 onclick="return showCalendar('birthday', 'mm/dd/y');"/>
                </td>
            </tr>
            <tr>
                <td>学历：</td>
                <td>
                    <s:select name="degrees" list="{'研究生','本科','专科','高中','初中','小学','胎教'}"
                              headerKey="" headerValue="--请选择--"/>
                </td>
            </tr>
            <tr>
                <td>电话号码：</td>
                <td><s:textfield name="phonenum"/></td>
            </tr>
            <tr>
                <td>爱好：</td>
                <td>
                    <s:checkboxlist name="hobby" list="{'足球','篮球','乒乓球','台球','棒球'}"/>
                </td>
            </tr>
            <tr>
                <td>简历：</td>
                <td><s:file name="resume"/></td>
            </tr>
            <tr>
                <td>简介：</td>
                <td><s:textarea name="description" rows="3" cols="28"/></td>
            </tr>
            <tr>
                <td colspan="2"><s:submit value="保存"/></td>
            </tr>
        </table>
    </s:form>
</fieldset>
<hr/>
<s:debug></s:debug>
</body>
</html>
