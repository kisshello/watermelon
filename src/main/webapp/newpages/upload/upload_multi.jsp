<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/5
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function add() {
            //获得id为div1的元素
            var div1Element = document.getElementById("div1");
            div1Element.innerHTML += "<div><input type='file' name='upload' /> <input type='button' value='删除' onclick='del(this)' /></div>";
        }
        function del(who) {
            var divv = who.parentNode;
            who.parentNode.parentNode.removeChild(who.parentNode);
        }
    </script>
</head>
<body>
<h1>多文件上传</h1>

<form action="${pageContext.request.contextPath}/UploadServlet" method="post" enctype="multipart/form-data">
    <input type="button" value="添加" onclick="add()" />
    <input type="submit" value="上传" />
    <div id="div1">

    </div>
</form>
</body>
</html>
