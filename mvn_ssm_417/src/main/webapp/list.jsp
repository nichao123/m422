<%--
  Created by IntelliJ IDEA.
  User: 44401
  Date: 2020/4/15
  Time: 11:16
  To change this template use File | Settings | File Templates.
<%--
  Created by IntelliJ IDEA.
  User: 44401
  Date: 2020/4/11
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link href="css/find.css" rel="stylesheet"/>
    <script type="text/javascript">
        function funDel(id){
            //判断
            if(window.confirm("您确定要删除吗？")){
                //跳转处理数据
                 window.location="del?foodId="+id;
            }
        }
    </script>
</head>
<body>
<div class="dv">
    <a class="pp" href="saveFood.jsp">添加</a><p/>
    <p class="page">
    <form action ="list" method="post" >
        菜品名：<input type="text"  name="foodName" value="${foodinfo.foodName}"/>
        价格：<input type="text"  name="foodPrice" value="${foodinfo.foodPrice}"/>

        <input type="submit" value="查询">
    </form>
    </p>
    <table border="1">
        <caption><h2>菜品基本信息</h2></caption>
        <tr>
            <td>编号</td>
            <td>菜品名</td>
            <td>备注</td>
            <td>价格</td>
            <td>描述</td>
            <td>参考图</td>
            <td>操作</td>
        </tr>

        <c:if test="${pageInfo.list.size()==0}">
        <tr><td colspan="8"> 没有您要查找的数据</td></tr>
        </c:if>

        <c:if test="${pageInfo.list.size()!=0}">
        <c:forEach var="food" items="${pageInfo.list}">
            <tr>
                <td>${food.foodId}</td>
                <td>${food.foodName}</td>
                <td>${food.remark}</td>
                <td>${food.foodPrice}</td>
                <td>${food.description}</td>
                <td>${food.foodImage}</td>

                <td>
                    <a href="${pageContext.request.contextPath}/find?foodId=${food.foodId}">详情</a>
                    <a href="${pageContext.request.contextPath}/edit?foodId=${food.foodId}">修改</a>
                    <a href="javascript:funDel(${food.foodId})">删除</a></td>
            </tr>
        </c:forEach>

    </table>
        <p class="page">
            第${pageInfo.pageNum}/ ${pageInfo.pages}页 &nbsp; 共${pageInfo.total} 条  &nbsp;
            <a href="list?pageCurrent=1&foodName=${foodinfo.foodName}&foodPrice=${foodinfo.foodPrice}">首页</a> &nbsp;

            <c:if test="${!pageInfo.isFirstPage}">
              <a href="list?pageCurrent=${pageInfo.prePage}&foodName=${foodinfo.foodName}&foodPrice=${foodinfo.foodPrice}">上一页</a>&nbsp;
            </c:if>

            <a href="list?pageCurrent=${pageInfo.nextPage}&foodName=${foodinfo.foodName}&foodPrice=${foodinfo.foodPrice}">下一页</a>&nbsp;
            <a href="list?pageCurrent=${pageInfo.pages}&foodName=${foodinfo.foodName}&foodPrice=${foodinfo.foodPrice}">尾页</a>&nbsp;

            <c:forEach var="i" begin="1" end="${pageInfo.pages}">
            <a href="list?pageCurrent=${i}">${i}</a>&nbsp;
            </c:forEach>
        <p>
    </c:if>

</div>
</body>
</html>


<script type="text/javascript">
    function funAdmin(vl){
    //   document.getElementById("admin").value(vl);
    }
</script>