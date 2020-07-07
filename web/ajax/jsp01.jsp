<%--
  Created by IntelliJ IDEA.
  User: pengyang
  Date: 2020/4/9
  Time: 09:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax案例01</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xh.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/my.js"></script>
    <script type="text/javascript">
        //<![CDATA[
        //验证用户名
        function checkname(obj) {
            var value = obj.value;
            if (value != "" && trim(value) != "") {
                var xhr = getXMLHttpRequest();
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4) {
                        if (xhr.status == 200) {
                            //接收响应正文
                            var msg = xhr.responseText;
                            //把响应正文显示到span标签中
                            var spanobj = document.getElementById(obj.name);
                            spanobj.innerHTML = msg;
                            document.getElementById("regist").disabled = false;
                        }
                    }
                }
                xhr.open("POST", "${pageContext.request.contextPath}/ajax01?time=" + new Date().getTime(), true);
                xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                xhr.send(data = "type=check&username=" + obj.value);//post方式请求时，正文的写法
            } else {
                console.warn("空不处理");
            }
        }
        //]]>

        //<![CDATA[
        function register(obj) {
            var username = document.getElementsByName("username")[0].value;
            var password = document.getElementsByName("password")[0].value;
            var n = trim(username) == "";
            var p = trim(password) == "";
            if (n || p) {
                alert("不可为空: " + n + " - " + p);
                return;
            }
            var xhr = getXMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4) {
                    if (xhr.status == 200) {
                        alert(xhr.responseText);
                        obj.disabled = true;
                    }
                }
            }
            xhr.open("POST", "${pageContext.request.contextPath}/ajax01?time=" + new Date().getTime(), true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            xhr.send(data = "type=regist&username=" + username + "&password=" + password);//post方式请求时，正文的写法
        }

        //]]>
    </script>
</head>
<body>
用户名：<input type="text" name="username" onblur="checkname(this)"/>
<br/>
<span id="username" style="color:aquamarine"></span>
<br/>
密码：<input type="password" name="password"/>
<br/>
<br/>
<button id="regist" type="button" disabled="disabled" onclick="register(this)">注册</button>
</body>
</html>
