<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="UserList" method="GET">
    <label>Buscar Usuario</label>
    <input type="text" name="findUser">
    <input type="checkbox" name="fillRole" value="fillRole">
    <input type="submit">
</form>
<c:choose>
    <c:when test="${requestScope['findUser'] != null}">
       <p>${requestScope['findUser'].getName()}
           <c:forEach items="${requestScope['findUser'].getRoles()}" var="role">
               <c:out value="${role.getRoleName()}"/>
           </c:forEach>
       </p>
    </c:when>
    <c:when test="${requestScope['error'] != null}">
        <p style="color: red">${requestScope['error']}</p>
    </c:when>

</c:choose>