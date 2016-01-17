<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import= "Loguearse.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

HttpSession sesion = request.getSession();

Usuario objeto = (Usuario)sesion.getAttribute("Usuario");

%>

<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p align="center"><font face="verdana" size="4">Estimado usuario, este segmento ha sido diseñado para que usted vea sus solicitudes.</font> <br>

 <input type="hidden" name="nombre" value="<%= objeto.getNombre()  %>">
   <a href="Consulta_busqueda.jsp" target="_self"> <input type="button" value="Entrar" style="color: blue; background:white; font-size: 40; font-family: verdana; width:80px; height:25px"></p> </a>
</div>
</body>
</html>