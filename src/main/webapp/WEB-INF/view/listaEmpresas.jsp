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

	<c:import url="logout-parcial.jsp"></c:import>

	 Usuario Logado: ${usuarioLogado.login }

    <br>
    <br>
    <br>

	<c:if test="${ not empty empresa }">
		nova empresa cadastrada, ${ empresa}
	</c:if>
	
	
	<ul>
		<c:forEach items="${ empresas }" var="empresa">
			<li> 
				${ empresa.nome } - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/> 
				<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remove</a>
				<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">altera</a>
			</li>
		</c:forEach>
	</ul>

</body>
</html>