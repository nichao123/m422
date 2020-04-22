<%@ page import="java.util.List" %>
<%@ page import="pojo.Userinfo" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/3/29
  Time: 11:22
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
        <marquee behavior="alternate">欢迎<font color="red"><%=session.getAttribute("uname")%></font>进入 【<span>我的外卖</span>】网上订餐系统</marquee>
    </div>

    <center>
        <div class="userinfo">

            <table align="center" cellspacing="0" border="1" width="500">
                <caption><p style="color:#366;font-size:20px;" align="center">用户列表</p></caption>
                <tr height="30">
                    <th>用户帐号</th>
                    <th>用户名</th>
                    <th>联系方式</th>
                    <th>余额</th>
                </tr>
                <%
                    List<Userinfo> list= (List<Userinfo>) request.getAttribute("userlist");
                    for (Userinfo user:
                         list) {
                %>
                <tr style="color:gray;" height="30">
                    <td><%=user.getLoginName()%></td>
                    <td><%=user.getRealname()%></td>
                    <td><%=user.getPhone()%></td>
                    <td><%=user.getAmount()%></td>
                </tr>
                <%}%>
            </table><br />
        </div>
        <br/>
    </center>
    <div class="foot">
        <p class="myp"> 上海晖硕信息科技有限公司版权所有  沪ICP备13021836号-1 Copyright  2011-2016 canting.weimob.com.  All Rights Reserved </p>
        <p class="myp" >客服热线：400-9949-020 （09:00-18:00）</p>
    </div>
</div>
</body>
</html>
