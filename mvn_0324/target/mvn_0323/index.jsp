<%@page language="java" pageEncoding="utf-8" %>
<html>

<body>
<h2>Hello World!</h2>

<%--session是JSP内置对象--%>
 <h1> <%=session.getAttribute("uname")%></h1>
<%--mvn_0324_war_exploded/--%>
 <a href="ds">安全退出</a>
</body>
</html>
