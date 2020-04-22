<%@ page import="org.hlx.service.UsersService" %>
<%@ page import="org.hlx.service.impl.UsersServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hlx.pojo.Users" %><%--
  Created by IntelliJ IDEA.
  User: 44401
  Date: 2020/3/26
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        <!--
        .style1 {
            color: #000066;
            font-weight: bold;
        }
        .style2 {color: #FF0000}
        -->
    </style>
</head>
<body bgcolor="#CCCCFF">
<table width="490" border="0" align="center">
    <tr>
        <td align="center"><img src="image/header.gif" width="468" height="60"></td>
    </tr>
    <tr>
        <td align="center"> 【<a href="all">用户管理</a>】【<a href="listNews.html">新闻管理</a>】【商铺管理】【论坛管理】【<a href="welcome.html">网站首页</a>】</td>
    </tr>
</table>
<br>
<table width="350" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td height="54" align="center"><span class="style1"><font size="7"><b><font face="华文彩云" size="6" color="#666699">用户列表显示：</font></b></font></span></td>
    </tr>
    <tr>
        <td>
            <table width="100%" border="1" align="center" bordercolor="#660033" bgcolor="#99CCCC" cellspacing="1">
                <tr align="center">
                    <td width="25%">编号</td>
                    <td width="40%">用户名</td>
                    <td>用户密码</td>
                </tr>
                <%

                    //获得保存的数据
                    List<Users> list = (List<Users>) request.getAttribute("list");

                    //循环
                    for (Users user:
                            list ) {

                %>
                <tr align="center">
                    <%--<td width="25%"><a href="userinfo.jsp?id=<%=user.getId() %>&name=<%=user.getName() %>&pass=<%=user.getPass() %>"><%=user.getId() %></a></td>--%>

                    <td width="25%"><a href="find?id=<%=user.getId() %>"><%=user.getId() %></a></td>s
                    <td width="40%"><%=user.getName() %></td>
                    <td><%=user.getPass() %></td>
                </tr>

                <%}%>

            </table></td>
    </tr>

    <tr>
        <td align="center" height="40"><span class="style2">权利保留！！！</span></td>
    </tr>
</table>
</body>
</html>
