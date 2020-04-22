<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/3/29
  Time: 11:05
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
            欢迎<font color="red"> XXX</font>进入 【<span>我的外卖</span>】网上订餐系统
        </marquee>
    </div>
    <div id="buy"><center>
        <table width="400" cellspacing="0" height="120">
            <thead align="center">
            <tr>
                <td>食物名称</td>
                <td>单价</td>
                <td>购买数量</td>
                <td>总价</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody align="center">

            <span>您还没有选购任何食物哟！</span>

            <form action="changNum.jsp" method="post" name="frm1">
                <tr>
                    <td>青菜</td>
                    <td>4.50</td>
                    <td>
                        <input type="hidden" name="foodid" value="2"  />
                        <img src="images/jian.gif" onclick="jian(frm1)">
                        <input type="text" size="1" name="num" value="1" onclick="changeNum(frm1)" />
                        <img src="images/jia.gif" onclick="jia(frm1)">
                    </td>
                    <td>12.5</td>
                    <td><a href="deldo.jsp?id=1">删除</a></td>
                </tr>
            </form>
            <tr  align="left">
                <td colspan="5">您的菜单：选择了2个菜，共需支付67.5元。<br />您的账号余额:120元！</td>
            </tr>
            <tr>
                <td colspan="5">
                    <input type="button" value="继续选购" onclick="location.href='index.html'" />

                    <input type="button" value="付款" disabled="disabled" />				<input type="button" value="付款" onclick="location.href='pay.html?count=1'" />

                </td>
            </tr>
            </tbody>
        </table></center><br />
    </div>
    <div class="foot">
        <p class="myp"> 上海晖硕信息科技有限公司版权所有  沪ICP备13021836号-1 Copyright  2011-2016 canting.weimob.com.  All Rights Reserved </p>
        <p class="myp" >客服热线：400-9949-020 （09:00-18:00）</p>
    </div>
</div>
</body>
</html>
