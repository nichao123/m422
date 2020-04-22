<%@ page import="pojo.Userinfo" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/3/29
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<script type="text/javascript" src="js/time.js"></script>
<script type="text/javascript" src="js/rechargeable.js"></script>
<script src="js/jquery-3.4.1.js" type="text/javascript"></script>
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
    <div>
        <div id="content" style="text-align: center" >
            <br/>
            <form action="rechargeable" method="post" id="frm">
                <span id="chazhao"></span>
                <div>充值账号：<input type="text" name="loginname" class="tname"/>&nbsp;<input style="width:50px;" type="submit" value="查找" class="btn" name="submit"/></div>
            </form>
            <br /><br />
            <br />
            <br />
            <div>
                <center>
                    <table width=400 cellpadding="0" cellspacing="0" bordercolor="#ECE9D8">
                        <tr align="center" height=30>
                            <th colspan="4">请核对信息</th>
                        </tr>
                        <tr align="center" bgcolor=#ECE9D8 height="25">
                            <th>用户名</th>
                            <th>真是姓名</th>
                            <th>联系方式</th>
                            <th>余额</th>
                        </tr>
                        <%Userinfo userinfo0= (Userinfo) session.getAttribute("user");
                          Userinfo userinfo1= (Userinfo) request.getAttribute("user");
                        if (userinfo1!=null){
                        %>
                        <tr align="center" height="25" id="xinxi">
                            <td><%=userinfo1.getLoginName()%></td>
                            <td><%=userinfo1.getRealname()%></td>
                            <td><%=userinfo1.getPhone()%></td>
                            <td><%=userinfo1.getAmount()%></td>
                        </tr>
                        <%}else if (userinfo0!=null){%>
                            <tr align="center" height="25" id="xinxi">
                            <td><%=userinfo0.getLoginName()%></td>
                            <td><%=userinfo0.getRealname()%></td>
                            <td><%=userinfo0.getPhone()%></td>
                            <td><%=userinfo0.getAmount()%></td>
                        </tr>
                        <%}else {%>
                        <%}%>
                    </table>
                </center>
            </div>
            <form action="rechargeabledo" method="post" onsubmit="return rechar()">
                <%if (userinfo1!=null){%>
                <input type="hidden" value="<%=userinfo1.getLoginName()%>" name="loginname"/>
                <div class="c1" style="margin-top:40px;">充值金额：<input type="text" name="amount" class="tname"/>&nbsp;<input style="width:50px;" type="submit" value="充值"  class="btn"/></div>
                <% }else if (userinfo0!=null){%>
                <input type="hidden" value="<%=userinfo0.getLoginName()%>" name="loginname"/>
                <div class="c1" style="margin-top:40px;">充值金额：<input type="text" name="amount" class="tname"/>&nbsp;<input style="width:50px;" type="submit" value="充值"  class="btn"/></div>
                <%}else {%>
                <input type="hidden" value="<%=session.getAttribute("uname")%>" name="loginname"/>
                <div class="c1" style="margin-top:40px;">充值金额：<input type="text" name="amount" class="tname"/>&nbsp;<input style="width:50px;" type="submit" value="充值"  class="btn"/></div>
               <% }
                %>
            </form><br/><br />
        </div>

    </div>
    <div class="foot">
        <p class="myp"> 上海晖硕信息科技有限公司版权所有  沪ICP备13021836号-1 Copyright  2011-2016 canting.weimob.com.  All Rights Reserved </p>
        <p class="myp" >客服热线：400-9949-020 （09:00-18:00）</p>
    </div>
</div>
</body>
</html>
