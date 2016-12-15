<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/bootstrap.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>

<div class="jumbotron">
  <div class="container">
    
<h2>BEM-VINDO(A) ${usuario_logado.nome}!</h2>
<ul>
	<li><a href="encontrarAmigos"> Encontrar Amigos</a></li>
	<li>Amigos </li>
	<li>Minhas Fotos</li>
	<li> Comunidades Seguidas</li>
	<li><a href="comunidades">Comunidades</a> </li>
	<li><a href="logout"> Logout</a>
</ul>
  </div>
</div>
</body>
</html>