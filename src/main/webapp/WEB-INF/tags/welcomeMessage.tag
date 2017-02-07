<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Bienvenido  <% out.print(request.getUserPrincipal().getName()); %></h1>
