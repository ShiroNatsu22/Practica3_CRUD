<%--
  Created by IntelliJ IDEA.
  User: Joshua
  Date: 05/02/2017
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title></title>
</head>
<body>
<tag:nav></tag:nav>
<h2>Login Demo Using j_security_check</h2>
<form name="loginForm" method="POST" action="j_security_check">
    <p>User name: <input type="text" name="j_username" size="20"/></p>
    <p>Password: <input type="password" size="20" name="j_password"/></p>
    <p>  <input type="submit" value="Submit"/></p>
</form>
</body>
</html>
