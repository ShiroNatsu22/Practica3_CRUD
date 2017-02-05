<%--
  Created by IntelliJ IDEA.
  User: Joshua
  Date: 05/02/2017
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %><html>
<head>
    <title>Llistat d'usuaris</title>
</head>
<body>
<h1>LLISTA D'USUARIS</h1>

<a href="index.jsp">Index</a>
<a href="CreateRole.jsp">Crear rol</a>
<a href="/UserForm">Crear user</a>
<a href="/RoleList">Llista de rols</a>

<tag:UserList></tag:UserList>
<tag:findUser></tag:findUser>
</body>
</html>
