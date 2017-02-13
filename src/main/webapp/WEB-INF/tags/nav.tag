<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${requestScope['admin'] != null}">
        <c:choose>
            <c:when test="${requestScope['admin']}">
                <a href="index.jsp">index</a>
                <a href="UserList">Lista de usuarios</a>
                <a href="UserForm"> Crear usuario</a>
                <a href="RoleList"> Lista de roles</a>
                <a href="CreateRole.jsp">Crear Rol</a>
                <a href="logout.jsp">Salir</a>
            </c:when>
            <c:otherwise>
                <a href="index.jsp">index</a>
                <a href="UserList">Listaa de usuarios</a>
                <a href="RoleList"> Lista de roles</a>
                <a href="logout.jsp">Salir</a>
            </c:otherwise>
        </c:choose>
    </c:when>
</c:choose>
