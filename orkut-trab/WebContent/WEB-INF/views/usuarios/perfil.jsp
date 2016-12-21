<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Perfil</title>
</head>
<body bgcolor=#FFC1C1>

<center>
<br/><br/><br/><br/>

<img src="http://bit.do/orkutt1">

<br/><br/><br/>
<table border="1">
	<tr>
		<td><b>Foto</b></td>
		<td><b>Nome</b></td>
		<td><b>Sobrenome</b></td>
		<td><b>Email</b></td>
	</tr>
	<tr>
		<td><img width="100" height="100" src='<c:url value="/resources/images/${usuario.login}.png" />' /> </td>
		<td> ${usuario.nome}</td>
		<td>${usuario.sobrenome}</td>
		<td>${usuario.email}</td>
	</tr>
</table>
</center>
</body>
</html>