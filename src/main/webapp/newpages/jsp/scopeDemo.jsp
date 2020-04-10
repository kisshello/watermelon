<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/2
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scopeDemo</title>
</head>
<body>
<%
    request.setAttribute("requestName","requestScope");
    session.setAttribute("sessionName","sessionAttribute");
    application.setAttribute("applicationName","applicationScope");
%>
<%=
request.getAttribute("requestName")
%>
<%
request.getRequestDispatcher("demo2.jsp").forward(request,response);
%>
</body>
</html>
