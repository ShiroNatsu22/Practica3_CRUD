<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<html>
<body>
<a href="RoleList.jsp">Llista de rols</a>
<a href="CreateRole.jsp">Crear rols</a>
<a href="CreateUser.jsp">Crear usuaris</a>
<a href="UserList.jsp"> Llista d'usuaris</a>
<tag:listRole></tag:listRole>
<br>
<br>
<br>
<br>
<tag:formUser></tag:formUser>
<br>
<br>
<br>
<br>
<tag:formRol></tag:formRol>
<br>
<br>
<br>
<br>
<tag:findUser></tag:findUser>
</body>
</html>