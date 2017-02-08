<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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




