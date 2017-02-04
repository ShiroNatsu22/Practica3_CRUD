<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="/index" method="post">
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




<c:choose>
    <c:when test="${requestScope['uList'] != null}">
        <table>
            <tr>
                <th>User Name</th>
                <th>Password</th>
            </tr>
            <c:forEach items="${requestScope['uList']}" var="user">
                <tr>
                    <td><c:out value="${user.getName()}"/></td>
                    <td><c:out value="${user.getPassword()}"/></td>
                    <td><form action="/index" method="post"><button type="submit" name="deleteUser" value="${user.getName()}">Borra</button></form></td>
                </tr>
            </c:forEach>

        </table>
    </c:when>

</c:choose>
