<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Empresas</title>
</head>
<body>
	<c:if test="${ not empty empresa }">
		nova empresa cadastrada, ${ empresa}
	</c:if>
	
	<c:if test="${ empty empresa }">
		Nenhuma empresa cadastrada
	</c:if>
	
	<ul>
		<c:forEach items="${ empresas }" var="empresa">
			<li> ${ empresa.nome } - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>  </li>
			<li><a href="/gerenciador/"></a>
		</c:forEach>
	</ul>

</body>
</html>