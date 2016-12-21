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
<center>
<h4>Amigos</h4>

<table border="1">
<c:forEach var="u" items="${amigos}">
		<tr>
			<td><a href='<c:url value="/perfil/${u.usuarioAlvo.usuId}"></c:url>'>${u.usuarioAlvo.nome} ${u.usuarioAlvo.sobrenome}</a></td>
			<td><img width="100" height="100" src='<c:url value="/resources/images/${u.usuarioAlvo.login}.png" />' /> </td>	
		</tr>
</c:forEach> 
</table>
</center>
</body>
</html>