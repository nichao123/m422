<%--
  Created by IntelliJ IDEA.
  User: 44401
  Date: 2020/4/13
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/login" method="post">
    <p>用户名：
        <input type="text" name="uname"/>
    </p>

    <p>密码：
        <input type="password" name="upass"/>
    </p>

    <p>
        <input type="submit" name="sub" value="登录"/>
    </p>
</form>
</body>
</html>
