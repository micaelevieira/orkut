<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar Comunidade</title>
</head>
<body>

<form:form modelAttribute="comunidade" action="inserirComunidade" method="post">
	Nome: <form:input path="nome" /><br /> 
	
	Imagem: <form:input path="imagem" /> <br />
	
	<input type="submit" value="OK">
</form:form>

</body>
</html>