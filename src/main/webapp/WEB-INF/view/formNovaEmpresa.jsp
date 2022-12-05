<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:import url="logout-parcial.jsp"/>

	<form action="/gerenciador/entrada" method="post">
		Nome: <input type="text" name="nome">
		Data: <input type="text" name="data">
		<input type="hidden" name="acao" value="NovaEmpresa" />
		<input type="submit" value="Cadastrar">
	</form>
</body>
</html>