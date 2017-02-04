<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="/index" method="post">
    <label>Nombre:</label>
    <input type="text" name="roleName">
    <label>Descripcion:</label>
    <input type="text" name="desc">
    <input type="submit">

</form>


<c:choose>
    <c:when test="${requestScope['rList'] != null}">
        <table>
            <tr>
                <th>Role</th>
                <th>Desccription</th>
            </tr>
                        <c:forEach items="${requestScope['rList']}" var="role">
                <tr>
                    <td><c:out value="${role.getRoleName()}"/></td>
                    <td><c:out value="${role.getRoleDesc()}"/></td>
                    <td><form action="/index" method="post"><button type="submit" name="deleteRole" value="${role.getRoleName()}">Borra</button></form></td>
                </tr>
            </c:forEach>

        </table>
    </c:when>

</c:choose>
