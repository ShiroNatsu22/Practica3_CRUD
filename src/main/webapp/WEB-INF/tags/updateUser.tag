<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<form action="UserList" method="POST">

    <input type="hidden" name="oldName" value="<%= request.getParameter("updateUser") %>">
    Nombre actual: <input type="text" value="<%= request.getParameter("updateUser") %>" disabled>
    Nuevo nombre: <input type="text" name="newName" value="">
    <input type="submit">
</form>
