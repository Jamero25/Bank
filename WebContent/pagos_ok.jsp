<%@page import="Pagos.Pagos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import= "Loguearse.Usuario" %>
    <%@page import= "java.util.LinkedList" %>
   <%@page import= "Pagos.Filtrado" %>
    
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
<br><br><br>
<form name="Lista"  action='./PagoEli' method="post">

<%
LinkedList<Usuario> lista = Filtrado.UsuarioValido(objeto);

if(lista.size()==0)
{
%>
<h2>Estimado usuario actualmente no cuenta con servicios que cuenten con los rangos establecidos.</h2>
<%}else{ %>
<table border="1" WIDTH=400>
<tr>
<td>Selección</td>
<td>Alias</td>
<td>Servicio</td>
<td>Status</td>
</tr>
<%

for (int i=0; i<lista.size(); i++)
{
	String stats= lista.get(i).getStatus().toString();
	String value= lista.get(i).getAlias().toString();
	String mensaje ="";
	if(stats.equals("0"))
	{
		mensaje = "Solvente";
	}
	else
	{
		mensaje="Por Pagar";
	}
   
   out.println("<tr>"); 
   out.println("<td> <input type='radio' name='seleccion' id='seleccion' value='"+value+"' onclick='document.Lista.boton.disabled = false;' >");
   out.println("<td>"+lista.get(i).getAlias() +"</td>");
   out.println("<td>"+lista.get(i).getServicio()+"</td>");
   out.println("<td>"+mensaje+"</td>");
   out.println("</tr>");
}%>

</table>
<br><br> 

  <input type="hidden" name="nombre" value="<%= objeto.getNombre()  %>">
  <input type="hidden" name="cuenta" value="<%= objeto.getCuenta() %>">
<input type="submit" value="Borrar" name="boton" disabled="disabled" /><br><br>
<%} %>
</form>
</body>
</html>