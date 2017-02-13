<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<c:choose>
    <c:when test="${requestScope['admin'] != null}">
        <c:choose>
            <c:when test="${requestScope['admin']}">
                <h1>CREAR USUARIOS</h1>
                <tag:nav></tag:nav>
                <form action="UserForm" method="post">
                    <label>Nombre:</label>
                    <input type="text" name="name">
                    <label>Contraseña:</label>
                    <input type="password" name="pass">
                    <label>Rol:</label>
                    <select name="role" multiple>
                        <c:forEach items="${requestScope['rList']}" var="role">
                            <option>
                                    ${role.getRoleName()}
                            </option>
                        </c:forEach>
                    </select>
                    <input type="submit">

                </form>
            </c:when>
            <c:otherwise>
                <p>No tienes permiso , vuelve al <a href="index.jsp">indice</a></p>
            </c:otherwise>
        </c:choose>
    </c:when>
</c:choose>






