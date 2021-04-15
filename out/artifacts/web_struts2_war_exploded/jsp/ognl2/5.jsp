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
    s:a
        作用：产生一个超链接
        属性：escapeAmp不要转移&
    使用理由：
        1、用起来简单方便
        2、支持URL地址重写：会话管理时，客户端禁用cookie时。
                    url----变为------url;jsessionid=xxx
        3、与struts2框架配合非常紧密。比如更改了动作的访问后缀
        4、支持请求参数传递（get方式），值为中文时，能自动进行url编码

    s:param
        作用：传递参数
        属性：
            value：ognl表达式。
 -->
<a href="${pageContext.request.contextPath}/ognl2/action4?username=管理员&password=123">戳我1</a>
<br/>

<hr/>
<s:a action="action4" escapeAmp="false" namespace="/ognl2">
    <s:param name="username" value="'管理员'"></s:param>
    <s:param name="password" value="123"></s:param>
    戳我2
</s:a>
<br/>
<hr/>
<!--
    s:action:
        作用：包含一个动作的执行结果。struts2中的动态包含
        属性：
            executeResult：把动作的执行结果显示出来
            直接执行action
 -->
<s:action name="action2" executeResult="true" namespace="/ognl2"></s:action>

<hr/>
<!--String ValueStack.findString(String ognl):框架内部把Date进行类型转换为了String（本地格式） -->
<br/>
<s:property value="birthday"/>
<br/>
<hr/>
<!-- s:date
        作用：格式化日期
        属性：
            name：ognl表达式。日期类型对象
            format：SimpleDateFormat中的格式
            var:把标签格式化号的日期字符串，取一个名字。放到了contextMap中
 -->
<s:date name="birthday" format="yyyy-MM-dd" var="sbirthday"/>

<input type="text" name="birthday" value="<s:property value="#sbirthday"/>"/>

<!--
    s:url
        作用：构建一个地址，给超链接用的。
        使用理由：
      1、用起来简单方便
      2、支持URL地址重写：会话管理时，客户端禁用cookie时。
                  url----变为------url;jsessionid=xxx
      3、与struts2框架配合非常紧密。比如更改了动作的访问后缀
      4、支持请求参数传递（get方式），值为中文时，能自动进行url编码

  s:param
      作用：传递参数
      属性：
          value：ognl表达式。
 -->
<s:url action="action4" var="url" namespace="/ognl2">
    <s:param name="username" value="'admin'"></s:param>
</s:url>

<input type="button" value="点我呀" onclick="jump()"/>
<script type="text/javascript">
    function jump() {
        window.location.href = '<s:property value="#url"/>';
    }
</script>
</body>
</html>
