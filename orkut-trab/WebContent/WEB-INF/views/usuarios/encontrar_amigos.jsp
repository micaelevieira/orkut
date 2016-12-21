<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuários</title>
</head>
<body bgcolor=#FFC1C1>
<center>
<h4>Escolha seus amigos</h4>

<form action="inserirAmizade" method="post">
	<table border="1">
		<c:forEach var="usuario" items="${potenciais_amigos}">
			<tr>
				<td>${usuario.nome}</td>
				<td><img width="100" height="100" src='<c:url value="/resources/images/${usuario.login}.png" />' /></td>
				<td><form:checkbox path="amizade.amigos" value="${usuario.usuId }" /></td>
			</tr>
		</c:forEach>		
	</table><br />
	<input type="submit" value="OK" />
</form>
</center>
</body>


</html>