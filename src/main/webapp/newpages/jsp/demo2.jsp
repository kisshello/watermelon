<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/2
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo2</title>
</head>
<body>
<%
    System.out.println(request.getAttribute("requestName"));
    System.out.println(session.getAttribute("sessionName"));
    System.out.println(application.getAttribute("applicationName"));
%>
<%=request.getAttribute("requestName")+"demo2的"
%>
</body>
</html>
