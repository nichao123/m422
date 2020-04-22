<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/25 0025
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link href="css/login.css" type="text/css" rel="stylesheet" />
</head>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="js/login.js"></script>

<body>

<form action="" method="get" id="frm">
    <table>
        <caption>
            <div id="nameDiv" style="display: inline"></div>
        </caption>
        <tr>
            <td>用 户 名：</td>
            <td><input type="text" name="name" id="name"/></td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;码：</td>
            <td><input type="password" name="pass" id="pass"/></td>
        </tr>
        <tr align="center">
            <td colspan="2" ><input type="button" name="but" value="登录"/></td>
        </tr>
    </table>
</form>
</body>
</html>
