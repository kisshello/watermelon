<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/13
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>文件上传</h1>
<h3>${msg}</h3>
<form action="${pageContext.request.contextPath}/UploadServlet" method="post" enctype="multipart/form-data">
    文件描述：<input type="text" name="info">
    文件上传：<input type="file" name="upload">
    <input type="submit" name="提交">
</form>
</body>
</html>
