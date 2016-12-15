<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastre-se</title>
</head>
<body>

<form action="inserirUsuario" method="post" enctype="multipart/form-data">
	Nome: <input type="text" name="nome"><br />
	Sobrenome: <input type="text" name="sobrenome"><br />
	Email: <input type="text" name="email"><br />
	Login: <input type="text" name="login"><br />
	Senha: <input type="password" name="senha"><br />
	Repetir Senha: <input type="password" name="repetir"><br />
	Imagem: <input type="file" name="image" /><br />
	
	<input type="submit" value="OK">
</form>
</body>
</html>