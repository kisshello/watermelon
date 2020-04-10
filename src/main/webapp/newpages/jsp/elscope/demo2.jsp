<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/2
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取数组中的数据</title>
</head>
<body>

<%
 String[] arrs = {"aa","bb","cc"};
 request.setAttribute("arrs",arrs);
 request.setAttribute("n1",10);
 request.setAttribute("n2",20);
%>
第一条数据：${arrs[0]}
相加之和为：${n1+n2}

</body>
</html>
