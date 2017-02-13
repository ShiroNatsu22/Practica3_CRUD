<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="RoleList" method="POST">

    <input type="hidden" name="oldRole" value="<%= request.getParameter("updateRole") %>">
    Rol actual: <input type="text" value="<%= request.getParameter("updateRole") %>" disabled>
    Nuevo rol: <input type="text" name="newRole" value="">
    <input type="submit">
</form>
