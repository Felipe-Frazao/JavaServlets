<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/gerenciador/alteraEmpresa" method="post">
		Nome: <input type="text" name="nome" value="${empresa.nome }">
		Data: <input type="text" name="data" value="<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>"/>
		<input type="hidden" name="id" value="${empresa.id }" />
		<input type="submit" value="Cadastrar">
	</form>
</body>
</html>