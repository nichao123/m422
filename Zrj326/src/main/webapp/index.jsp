<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/3/29
  Time: 10:58
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
            欢迎<font color="red"> <%=session.getAttribute("uname")%></font>进入 【<span>我的外卖</span>】网上订餐系统
        </marquee>
    </div>
    <div class="main">
        <p align="center"><span>*</span>----------以下为本店所出售食物，欢迎选购----------<span>*</span></p>
        <ul>
            <li>
                <table cellspacing="0">
                    <tr>
                        <td width="80">米饭</td>
                        <td align="right"> ￥<span>1.0</span></td>
                        <td align="right"><a href="foodinfo.html?id=1"> <img src="images/detail_cn.gif"  /> </a></td>
                    </tr>
                </table>
            </li>
            <li>
                <table cellspacing="0">
                    <tr>
                        <td width="80">水煮肉片</td>
                        <td align="right"> ￥<span>35.0</span></td>
                        <td align="right"><a href="foodinfo.html?id=1"> <img src="images/detail_cn.gif"  /> </a></td>
                    </tr>
                </table>
            </li>
            <li>
                <table cellspacing="0">
                    <tr>
                        <td width="80">酸辣茄子</td>
                        <td align="right"> ￥<span>18.0</span></td>
                        <td align="right"><a href="foodinfo.html?id=1"> <img src="images/detail_cn.gif"  /> </a></td>
                    </tr>
                </table>
            </li>
            <li>
                <table cellspacing="0">
                    <tr>
                        <td width="80">酸辣茄子</td>
                        <td align="right"> ￥<span>18.0</span></td>
                        <td align="right"><a href="foodinfo.html?id=1"> <img src="images/detail_cn.gif"  /> </a></td>
                    </tr>
                </table>
            </li>
            <li>
                <table cellspacing="0">
                    <tr>
                        <td width="80">酸辣茄子</td>
                        <td align="right"> ￥<span>18.0</span></td>
                        <td align="right"><a href="foodinfo.html?id=1"> <img src="images/detail_cn.gif"  /> </a></td>
                    </tr>
                </table>
            </li>
        </ul>
    </div>
    <div id="page"> 共有 <span>3</span> 页，当前第 <span>1</span> 页
        跳到第
        <select>
            <option value="1"> 1</option>
            <option value="2"> 2</option>
            <option value="3"> 3</option>
        </select>
        页 <a href="index.jsp">首页</a> <a href="index.jsp">上一页</a> <a href="index.jsp">下一页</a> <a href="index.jsp">尾页</a> </div>
    <div class="foot">
        <p class="myp"> 上海晖硕信息科技有限公司版权所有  沪ICP备13021836号-1 Copyright  2011-2016 canting.weimob.com.  All Rights Reserved </p>
        <p class="myp" >客服热线：400-9949-020 （09:00-18:00）</p>
    </div>
</div>
</body>
</html>
