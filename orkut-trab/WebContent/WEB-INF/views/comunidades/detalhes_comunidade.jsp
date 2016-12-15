<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${comunidade.nome}</title>
</head>
<body>
	<form action="criarForum" method="post" enctype="multipart/form-data">
		<input type="hidden" name="comuId" value="${comunidade.comuId }">
		<input type="text" name="titulo">
		<input type="submit" value="Criar Forum">
	</form>
	<form action="participarComunidade" method="post">
		
		<input type="submit" value="Participar">
		</form>
	<ul>
		<c:forEach var="forum" items="${comunidade.forum}">
			<li> <a href="detalhesForum/${comunidade.comuId}/${forum.forId}"/ > ${forum.titulo }</a> </li>
		</c:forEach>
	</ul>	
</body>
</html>