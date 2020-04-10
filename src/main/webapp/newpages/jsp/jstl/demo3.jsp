<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/4
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>jstl的foreach标签的使用</title>
</head>
<body>
<%
    String arrs[] = {"aa","bb","cc"};
    request.setAttribute("arrs",arrs);
%>
<c:forEach var="s" items="${arrs}">
    ${s}
</c:forEach>
<!-- 存map的值 然后遍历输出map的key和value -->
<%
    Map map = new HashMap();
    map.put("aa","aa");
    map.put("bb","bb");
    map.put("cc","33");
    request.setAttribute("map",map);
%>
<c:forEach var="s" items="${map}">
    ${s.key}的值是${s.value}
</c:forEach>
<!-- 从0开始，每次加2，一直到100  输出值 -->
<c:forEach var="i" begin="0" end="100" step="2">
    ${i}
</c:forEach>
<!-- 从100开始，每次加2，一直到200  其中输出的第3个数的颜色为蓝色 -->
<c:forEach var="i" begin="100" end="200" step="2" varStatus="status">
    <c:if test="${status.count % 3 ==0}">
        <font color="blue">${i}</font>
        <%System.out.println("\r");%>
    </c:if>
    <c:if test="${status.count % 3 != 0}">
        ${i}
        <%System.out.printf("");%>
    </c:if>
</c:forEach>
</body>
</html>
