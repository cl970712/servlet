<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/3/20
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>登录成功</p>
<c:forEach items="${userList}" var="user">
    <table style="border: 1px solid black">
        <tr>
            <th align="center">Id:${user.id}</th>
            <th align="center">Username:${user.user}</th>
            <th align="center">Password:${user.pw}</th>
            <th><input type="button" value="delete" onclick="del(${user.id})"/></th>
        </tr>
    </table>
</c:forEach>

<script>

    list();

    function list() {
        window.location.href = "/loginServlet?type=getAll";
    }

    var del = function del(thisId) {
        if(confirm("真的要删除吗?")){
            var id = thisId;
            window.location.href = "/loginServlet?type=del&id=" + id + "";
            setTimeout("window.location.reload()",1000);
        }
    }
</script>


</body>
</html>
