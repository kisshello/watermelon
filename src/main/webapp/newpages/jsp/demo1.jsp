<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/30
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" isELIgnored="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSP的注释</h1>
<%
  //单行注释
  /*多行
  注释了*/
    /**
     * 文档注释
     */
%>
<%-- jsp的注释 --%>
<%
    List list = new ArrayList();

    //int d = 1 / 0;
%>
<jsp:forward page="demo2.jsp"/>
<jsp:include page="index.jsp"/>
${msg}
</body>
</html>
