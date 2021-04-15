<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/jsp/example/header.jsp" %>
<fieldset>
    <legend>添加新用户</legend>
    <a href="javascript:history.back()">返回</a>
    <!-- 显示的内容 -->
    <span class="error">
		<s:fielderror/>
		<s:actionerror/>
	</span>
    <s:form namespace="/user" action="editUser" enctype="multipart/form-data">
        <s:hidden name="id" value="%{id}"></s:hidden>
        <table border="1" width="538">
            <tr>
                <td>用户名：</td>
                <td>
                        ${username }
                </td>
            </tr>
            <tr>
                <td>昵称：</td>
                <td>
                    <s:textfield name="nickname"></s:textfield>
                </td>
            </tr>
            <tr>
                <td>性别：</td>
                <td>
                    <s:radio name="gender" list="#{'male':'男','female':'女'}"></s:radio>
                </td>
            </tr>
            <tr>
                <td>生日：</td>
                <td>
                    <s:date name="birthday" format="yyyy-MM-dd" var="sbirthday"/>
                    <!-- 在struts2的标签中，把字符串当做OGNL表达式要加上  百分号{字符串} -->
                    <s:textfield id="birthday" name="birthday" value="%{sbirthday}" readonly="false"
                                 onclick="return showCalendar('birthday', 'mm/dd/y');"></s:textfield>
                </td>
            </tr>
            <tr>
                <td>学历：</td>
                <td>
                    <s:select name="degrees" list="{'研究生','本科','专科','高中','初中','小学','胎教'}"
                              headerKey="" headerValue="--请选择--"></s:select>
                </td>
            </tr>
            <tr>
                <td>电话号码：</td>
                <td>
                    <s:textfield name="phonenum"></s:textfield>
                </td>
            </tr>
            <tr>
                <td>爱好：</td>
                <td>
                    <s:checkboxlist name="hobby" list="{'足球','篮球','乒乓球','台球','棒球'}"
                                    value="hobby.split(', ')"></s:checkboxlist>
                </td>
            </tr>
            <tr>
                <td>简历：</td>
                <td>
                    <div id="d1">
                        <s:url namespace="/user" action="downloadResume" var="url">
                            <s:param name="id" value="id"></s:param>
                        </s:url>
                        <a href="#" onclick="openWindow('${url}','700','400')">
                            <s:property value="filename.substring(filename.indexOf('_')+1)"/>
                        </a>
                        &nbsp;&nbsp;
                        <a href="javascript:reUpload()">重新上传</a>
                    </div>
                    <div id="d2" style="display: none">
                        <s:file name="resume"></s:file>
                        <a href="javascript:cancelUpload()">取消</a>
                    </div>
                </td>
            </tr>
            <tr>
                <td>简介：</td>
                <td>
                    <s:textarea name="description" rows="3" cols="28"></s:textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <s:submit value="保存"></s:submit>
                </td>
            </tr>
        </table>
    </s:form>
</fieldset>
<script type="text/javascript">
    function reUpload() {
        document.getElementById("d2").style.display = "block";
    }

    function cancelUpload() {
        document.getElementById("d2").style.display = "none";
    }
</script>
<hr/>
<s:debug></s:debug>
</body>
</html>
