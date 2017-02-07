<%--
  Created by IntelliJ IDEA.
  User: Joshua
  Date: 05/02/2017
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logOut</title>
</head>
<body>
<%
    session.invalidate();
    response.sendRedirect("index.jsp");
%>
</body>
</html>
