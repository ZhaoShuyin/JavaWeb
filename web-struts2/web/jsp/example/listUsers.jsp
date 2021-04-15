<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/jsp/example/header.jsp" %>
<fieldset>
    <legend>查询条件</legend>
    <s:form namespace="/user" action="findUser">
        <table>
            <tr>
                <td>用户昵称：<s:textfield name="nickname" size="5"/>&nbsp;&nbsp;</td>
                <td>学历：<s:select name="degrees" list="{'研究生','本科','专科','高中','初中','小学','胎教'}"
                                 headerKey="" headerValue="--请选择--"></s:select>&nbsp;&nbsp;
                </td>
                <td>性别：<s:select name="gender" list="#{'male':'男','female':'女'}" headerKey=""
                                 headerValue="--请选择--"/>&nbsp;&nbsp;
                </td>
                <td>是否上传简历：<s:select name="filename" list="#{'t':'是','f':'否'}" headerKey=""
                                     headerValue="--请选择--"/>&nbsp;&nbsp;
                </td>
            </tr>
            <tr>
                <td colspan="4" align="right">
                    <s:submit value="查询"></s:submit>
                </td>
            </tr>
        </table>
    </s:form>
</fieldset>
<br/>
<fieldset>
    <legend>用户查询结果</legend>
    <a href="${pageContext.request.contextPath}/jsp/example/addUser.jsp">添加用户</a>
    <!-- 显示的内容 -->
    <s:if test="users.size()==0">
        <h1>对不起！没有任何用户信息，请先添加</h1>
    </s:if>
    <s:else>
        <table border="1" width="80%">
            <tr>
                <th>用户名</th>
                <th>昵称</th>
                <th>性别</th>
                <th>联系电话</th>
                <th>学历</th>
                <th>修改</th>
                <th>查看</th>
                <th>删除</th>
            </tr>
            <s:iterator value="users" status="s">
                <tr class="${s.odd?'odd':'even'}">
                    <td>${username}</td>
                    <td>${nickname}</td>
                    <td>${gender=='male'?'男':'女'}</td>
                    <td>${phonenum}</td>
                    <td>${degrees}</td>
                    <td>
                        <s:a namespace="/user" action="editUserUI">
                            <s:param name="id" value="id"></s:param>
                            修改
                        </s:a>
                    </td>
                    <td>
                        <!-- /user/showUser?id=2 -->
                        <s:a namespace="/user" action="showUser">
                            <s:param name="id" value="id"></s:param>
                            查看
                        </s:a>
                    </td>
                    <td>
                        <a href="javascript:toDelete(${id})">删除</a>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </s:else>
</fieldset>
<s:url namespace="/user" action="deleteUser" var="url"/>
<script type="text/javascript">
    function toDelete(userId) {
        var sure = confirm("确定要删除吗？");
        if (sure) {
            location.href = "${url}?id=" + userId;
        }
    }
</script>
<hr/>
<s:debug></s:debug>
</body>
</html>
