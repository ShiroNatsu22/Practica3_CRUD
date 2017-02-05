<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                    <td><form action="/UserList" method="post"><button type="submit" name="deleteUser" value="${user.getName()}">Borra</button></form></td>
                </tr>
            </c:forEach>

        </table>
    </c:when>

</c:choose>
