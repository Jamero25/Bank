<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import= "Loguearse.Usuario" %>
    <%@page import= "java.util.LinkedList" %>
     <%@page import= "Posicion.Descripcion" %>
    
    
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
<table border="1" WIDTH=400>
<tr>
<td>Descripcion</td>
<td>Monto</td>
<td>Fecha de solicitud</td>
</tr>
<% 
LinkedList<Usuario> lista = Descripcion.DatosTransacciones(objeto);
for (int i=0; i<lista.size(); i++)
{
   out.println("<tr>"); 
   out.println("<td>"+lista.get(i).getDescripcion() +"</td>");
   out.println("<td>"+lista.get(i).getMontoopera()+"</td>");
   out.println("<td>"+lista.get(i).getFechasoli()+"</td>");
   out.println("</tr>");
}%>
</table>
<br>
</body>
</html>