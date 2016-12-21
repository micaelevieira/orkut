<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forum</title>
</head>
<body bgcolor=#FFC1C1>
<center>
<h3>Mensagens</h3>
	<table border="1">
		<c:forEach var="mensagem" items="${forum.mensagem}">
   			<tr>
   				<td>
	   			  <img width="100" height="100" src='<c:url value="/resources/images/${mensagem.usuario.login}.png" />' /> 		   			   			
   			   		<td>	<a href='<c:url value="/perfil/${mensagem.usuario.usuId}"></c:url>'>${mensagem.usuario.nome} ${mensagem.usuario.sobrenome}</a></td>
   			   		</td>
			   		<td>${mensagem.texto}</td>
			   	</tr>
			   	</c:forEach>
	   </table>
   
 
   <h3>Nova Mensagem</h3>
	<form
		action='<c:url value="/detalhesComunidade/detalhesForum/enviarMensagem/${comunidade.comuId}/${forum.forId}"></c:url>'
		method="post" enctype="multipart/form-data">

		<label for="texto"><b>Texto:</b></label> <input id="texto" name="texto"> 
			 <input type="submit" value="Enviar"></i>
		</button>
	</form>
	</center>
</body>
</html>