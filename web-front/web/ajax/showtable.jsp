<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.zsy.domain.*" %>
<%@ page import="com.zsy.domain.Student" %>
<html>
<head>
    <title>JSP显示表格</title>
</head>
<body>
<%--生成一个集合：在实际开发中都是从数据库中查出来的 --%>
<% List<Student> slist = new ArrayList<Student>();
    slist.add(new Student(1, "张军威", 61, 76, 69));
    slist.add(new Student(2, "陈涔", 72, 77, 89));
    slist.add(new Student(3, "张景鹏", 81, 25, 81));
    slist.add(new Student(4, "何兆伟", 75, 96, 80));
    slist.add(new Student(5, "杜巍锋", 56, 87, 79));
%>
<%--遍历集合显示到浏览器--%>
<table align="center" border="1">
    <caption>学生成绩表</caption>
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>语文成绩</th>
        <th>英语成绩</th>
        <th>数学成绩</th>
    </tr>
    <% for (Student student : slist) {%>
    <tr>
        <td><%=student.getId() %>
        </td>
        <td><%=student.getName()%>
        </td>
        <td><%=student.getChinese()%>
        </td>
        <td><%=student.getEnglish()%>
        </td>
        <td><%=student.getMath()%>
        </td>
    </tr>
    <%}%>
</table>
</body>
</html>
