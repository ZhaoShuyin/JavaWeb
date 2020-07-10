<%--
  Created by IntelliJ IDEA.
  User: pengyang
  Date: 2020/4/9
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax案例02</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xmlHttp.js"></script>

    <script type="text/javascript">
        window.onload = function () {
            console.log("window.onload");
            var xhr = getXMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4) {
                    if (xhr.status == 200) {
                        //调用 评估 方法
                        var json = eval("(" + xhr.responseText + ")");
                        // var json = xhr.responseText;
                        alert(json);
                        var divmenu = document.getElementById("divmenu");
                        for (var i = 0; i < json.length; i++) {
                            console.log(json[i]);
                            divmenu.innerHTML +=
                                "<div onclick='showValue(this)'>"
                                + json[i] + "</div>";
                        }
                    }
                }
            }
            xhr.open("POST", "${pageContext.request.contextPath}/ajax02?time=" + new Date().getTime(), true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            xhr.send(data = "");
        }

        function showValue(obj) {
            alert(obj.innerText);
        }
    </script>
</head>
<body>
<div onclick="showValue(this)">原始</div>
<hr/>
<div id="divmenu"></div>
</body>
</html>
