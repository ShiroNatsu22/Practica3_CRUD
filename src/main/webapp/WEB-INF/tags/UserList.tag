<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${requestScope['uList'] != null}">
        <table>
            <tr>
                <th>User Name</th>
            </tr>
            <c:forEach items="${requestScope['uList']}" var="user">
                <tr>
                    <td><c:out value="${user.getName()}"/></td>
                    <c:choose>
                        <c:when test="${requestScope['admin']}">
                            <td><form action="updateUser.jsp" method="get"><button type="submit" name="updateUser" value="${user.getName()}">Edita</button></form></td>
                            <td><form action="UserList" method="post"><button type="submit" name="deleteUser" value="${user.getName()}">Borra</button></form></td>
                        </c:when>
                    </c:choose>
                </tr>
            </c:forEach>

        </table>
    </c:when>

</c:choose>
