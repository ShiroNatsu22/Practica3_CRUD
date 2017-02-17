<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>



<c:choose>
    <c:when test="${requestScope['admin'] != null}">
        <c:choose>
            <c:when test="${requestScope['admin']}">
                <h1> CREAR ROLS</h1>

                <tag:nav></tag:nav>
                <form action="RoleForm" method="post">
                    <label>Nombre:</label>
                    <input type="text" name="roleName">
                    <label>Descripcion:</label>
                    <input type="text" name="desc">
                    <input type="submit">

                </form>
            </c:when>
            <c:otherwise>
                <p>No tienes permiso , vuelve al <a href="index.jsp">indice</a></p>
            </c:otherwise>
        </c:choose>
    </c:when>
</c:choose>
