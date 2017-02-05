<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:choose>
<c:when test="${requestScope['uList'] != null}">
    <table>
        <tr>

            <th>role</th>
            <th>desc</th>
        </tr>

        <c:forEach items="${requestScope['rList']}" var="role">
            <tr>
                <td><c:out value="${role.getRoleName()}"/></td>
                <td><c:out value="${role.getRoleDesc()}"/></td>
            </tr>
        </c:forEach>

    </table>
</c:when>

</c:choose>


