<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import= "Loguearse.Usuario" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

HttpSession sesion = request.getSession();

Usuario objeto = (Usuario)sesion.getAttribute("Usuario");

%>
<<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<img src="bottom_banner.png" width="1300px" style=""></div>
<h1 align="center"><font face="verdana" size="4">Estimado Usuario por favor ingrese su nueva clave de acceso al portal</font></h1>

<form name="Actualiza"  action='./Primera' method="post">
<p align="center"><font face="verdana" size="4">Contraseña: </font><input id="contra1" type="password" name="contra1" maxlength="10" size="22"><br><br>
<font face="verdana" size="4">Repita su contraseña:  </font><input id="contra2" type="password" name="contra2" maxlength="10" size="22"><br><br>
<br><br></p>
 <input type="hidden" name="usuario" value="<%= objeto.getUsuario()  %>">
<p align="center"><input type="submit" value="Enviar" style="color:#215021;  background:white; font-size: 40; font-family: verdana; width:120px; height:25px"> 
<input type="reset" value="Limpiar" style="color:#215021;  background:white; font-size: 40; font-family: verdana; width:120px; height:25px"></p>
</form>
</body>
</html>