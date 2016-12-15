<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Perfil</title>
</head>
<body>
<h2>${usuario.nome}</h2>
<td><img width="100" height="100" src='<c:url value="/resources/images/${usuario.login}.png" />' /> <br/>
   <b>Nome:</b> ${usuario.nome}</br>
   <b>Sobrenome:</b>  ${usuario.sobrenome}</br>
  <b> Email:</b>  ${usuario.email}</br>
</body>
</html>