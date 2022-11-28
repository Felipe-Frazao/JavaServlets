<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<form action="/gerenciador/entrada" method="post">
		Nome: <input type="text" name="login">
		Senha: <input type="password" name="senha">
		<input type="hidden" name="acao" value="LoginUsuario" />
		<input type="submit" value="Cadastrar">
	</form>
</body>
</html>