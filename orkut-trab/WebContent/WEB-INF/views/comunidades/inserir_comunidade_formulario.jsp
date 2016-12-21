<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar Comunidade</title>
</head>
<body bgcolor=#FFC1C1>
<center>
<br /><br /><br /><br />
<form action="inserirComunidade" method="post" enctype="multipart/form-data">
	Nome: <input type="text" name="nome"><br/>
	Descrição: <input type="text" name="descricao"><br /> 
			
	Categoria: <select size="1" name="catId">
		<c:forEach var="categoria" items="${categorias}">
			<option value = ${categoria.catId } >${categoria.nome}</option>
		</c:forEach>
	</select> 
			
	Imagem: <input type="file" name="image" /><br />
	
	
	
	<input type="submit" value="Criar Comunidade">
</form>
</center>
</body>
</html>