<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/3/29
  Time: 11:04
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
    <div class="hezi" style="height:320px;">
        <p>添加新菜</p><br />
        <hr /><br />
        <form action="adddo.jsp" method="post" enctype="multipart/form-data" onsubmit="return checkfrm(this)">
            <table>
                <tr>
                    <td>菜&nbsp;&nbsp;名：</td>
                    <td><input type="text" name="foodname" class="tname" /></td>
                </tr>
                <tr>
                    <td>食&nbsp;&nbsp;材：</td>
                    <td><input type="text" name="remark" class="tname" /></td>
                </tr>
                <tr>
                    <td>价&nbsp;&nbsp;格：</td>
                    <td><input type="text" name="foodprice" class="tname" /></td>
                </tr>
                <tr>
                    <td>描&nbsp;&nbsp;述：</td>
                    <td><input type="text" name="description"  class="tname"/></td>
                </tr>
                <tr>
                    <td>上传图片：</td>
                    <td><input type="file" name="foodImage" class="tname" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="添加" class="btn" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div class="foot">
        <p class="myp"> 上海晖硕信息科技有限公司版权所有  沪ICP备13021836号-1 Copyright  2011-2016 canting.weimob.com.  All Rights Reserved </p>
        <p class="myp" >客服热线：400-9949-020 （09:00-18:00）</p>
    </div>
</div>
</body>
</html>
