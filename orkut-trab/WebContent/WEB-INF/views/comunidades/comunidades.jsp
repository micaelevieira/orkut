<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor=#FFC1C1>

<a href="inserirComunidadeFormulario">Criar Comunidade</a>
<center>

<table border="1">

<tr>
	<td> Foto</td>
	<td> Nome</td>
	<td> Descrição</td>
</tr>
	<c:forEach var="comunidade" items="${comunidades}">
		<tr>
			<td><img width="100" height="100" src='<c:url value="/resources/images/${comunidade.nome}.png" />' /></td>
			<td>${comunidade.nome}</td>
			<td>${comunidade.descricao}</td>
			<td><a href="detalhesComunidade/${comunidade.comuId }" >Visitar</a></td>
			<td><a href="participarComunidade/${comunidade.comuId }" > Participar</a></td> 	
		</tr>
	</c:forEach>
	
</table>
</center>

</body>
</html>