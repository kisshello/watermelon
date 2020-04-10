<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/4
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>TJST的if标签的使用</title>
</head>
<body>
<c:set var="num" value="15"/>
<c:if test="${num>10}">
    <font color="red">
        这个数字是大于10的
    </font>
</c:if>
<c:if var="flag" test="${num<10}">
    <font color="black">
        这个数字是小于10的
    </font>
</c:if>
if的值是  ${flag}
</body>
</html>
