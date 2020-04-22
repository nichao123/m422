<%--
  Created by IntelliJ IDEA.
  User: 44401
  Date: 2020/4/11
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改用户</title>
    <link href="css/index.css" rel="stylesheet"/>
</head>
<body>
<div class="dv">
    <form method="post" action="/update">
        <table border="1"  align="center">
            <caption><h2>修改菜品信息</h2></caption>

            <tr>
                <td>菜品名</td>
                <td>
                    <input type="text" name="foodName" value="${food.foodName}"/>
                    <%--隐藏域 存放ID--%>
                    <input type="hidden" name="foodId" value="${food.foodId}"/>
                </td>
            </tr>
            <tr>
                <td>备注</td>
                <td>
                    <input type="text" name="remark" value="${food.remark}"/>
                </td>
            </tr>
            <tr>
                <td>价格</td>
                <td>
                    <input type="text" name="foodPrice" value="${food.foodPrice}"/>
                </td>
            </tr>
            <tr>
                <td>描述</td>
                <td>
                    <input type="text" name="description" value="${food.description}"/>
                </td>
            </tr>

            <tr>
                <td>参考图</td>
                <td>
                    <input type="text" name="foodImage" value="${food.foodImage}"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="提交"/>
                    &nbsp;    &nbsp;  &nbsp;<a href="list">返回</a>
                </td>
            </tr>
        </table>

    </form>
</div>
</body>
</html>
