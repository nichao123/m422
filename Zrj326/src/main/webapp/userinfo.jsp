<%@ page import="pojo.Userinfo" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/3/29
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<script type="text/javascript" src="js/time.js"></script>

<body onload="showTime()">
<div class="box">
    <div class="top">
        <div id="topleft"></div>
        <div id="topright"> 当前用户：<font color="red"><%=session.getAttribute("uname")%></font> | 用户等级：普通用户/管理员


            | <a href="userinfo.jsp">用户管理</a> | <a href="buy.jsp"><img src="images/buycar.jpg" /></a> | <a href="outdo">注销</a> <a href="login.html">登陆</a> <a href="register.html">注册</a> </div>
    </div>
    <!-- 包含头信息 -->
    <div ><img src="images/eat.jpeg" width="825px"  height="250px"/> </div>
    <div class="menu"> |&nbsp;<a href="index.jsp">网站首页</a>&nbsp;|&nbsp;<a href="orderday.jsp">当日订餐详单</a>&nbsp;|&nbsp;<a
            href="meuncrit.jsp">菜品点评</a>&nbsp;|&nbsp;<a href="add.jsp">添加新菜</a>&nbsp;|&nbsp;<a
            href="suggestion.jsp">建议意见</a>&nbsp;|&nbsp;<a href="userAll">用户列表</a>&nbsp;|&nbsp;<a
            href="rechargeable.jsp">账号充值</a>&nbsp;| </div>
    <div class="logo"></div>

    <!--   -->
    <div class="welcome">
        <marquee behavior="alternate">
            欢迎<font color="red"><%=session.getAttribute("uname")%></font>进入 【<span>我的外卖</span>】网上订餐系统
        </marquee>
    </div>
    <div class="userinfo">
<%Userinfo userinfo= (Userinfo) session.getAttribute("user");
String admin="";
if (userinfo.getAdmin()==1){
    admin="管理员";
}else {
    admin="用户";
}%>
        <br />
        <p style="color:blue;font-size:30px;" align="center">用户信息</p>
        <br />
        <form action="userinfo" method="get">
        <table align="center" cellspacing="0" border="1" width="300" height="200">
            <tr>
                <td align="right">用 户 名：</td>
                <td><input type="text" name="realName"  value="<%=userinfo.getRealname()%>" /></td>
            </tr>
            <tr>
                <td align="right">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
                <td><input type="text" name="loginName" readonly="readonly" value="<%=userinfo.getLoginName()%>" /></td>
            </tr>
            <tr>
                <td align="right">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                <td><input type="text" name="loginPass" value="<%=userinfo.getLoginPass()%>" /></td>
            </tr>
            <tr>
                <td align="right">用户等级：</td>
                <td><input type="text" readonly="readonly" value="<%=admin%>" /></td>
            </tr>
            <tr>
                <td align="right">用户余额：</td>
                <td><input type="text" readonly="readonly" value="<%=userinfo.getAmount()%>" /></td>
            </tr>
            <tr>
                <td align="right">联系方式：</td>
                <td><input type="text" name="phone" value="<%=userinfo.getPhone()%>" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="修改信息"/>
                    <input type="button" value="取&nbsp;消" onclick="location.href='index.jsp'" />
                </td>
            </tr>
        </table>
        </form><br />
    </div>

    <div class="foot">

        <p class="myp"> 上海晖硕信息科技有限公司版权所有  沪ICP备13021836号-1 Copyright  2011-2016 canting.weimob.com.  All Rights Reserved </p>
        <p class="myp" >客服热线：400-9949-020 （09:00-18:00）</p>
    </div>
</div>
</body>
</html>
