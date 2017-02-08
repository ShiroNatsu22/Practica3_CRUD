<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:choose>
<c:when test="${requestScope['rList'] != null}">
    <table>
        <tr>

            <th>role</th>
            <th>desc</th>
        </tr>

        <c:forEach items="${requestScope['rList']}" var="role">
            <tr>
                <td><c:out value="${role.getRoleName()}"/></td>
                <td><c:out value="${role.getRoleDesc()}"/></td>
                <td><form action="RoleList" method="post"><button type="submit" name="deleteRole" value="${role.getRoleName()}">Borra</button></form></td>
            </tr>
        </c:forEach>

    </table>
</c:when>

</c:choose>


