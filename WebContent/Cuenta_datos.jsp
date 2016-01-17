<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import= "Loguearse.Usuario" %>
      <%@page import= "java.util.LinkedList" %>
     <%@page import= "Posicion.Descripcion" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
Double cuenta =0.00;
HttpSession sesion = request.getSession();
Usuario objeto = (Usuario)sesion.getAttribute("Usuario");
cuenta =  objeto.getTotal();
LinkedList<Usuario> lista = Descripcion.DatosTransacciones(objeto);

DecimalFormat df = new DecimalFormat("0.00");
Locale locale = new Locale("es","VE");
NumberFormat nf = NumberFormat.getCurrencyInstance(locale);

%>
 
<html>

<head>


</head>
<body>

<% 

if (objeto.getFechaDesde().equals(""))
{%>

<%}else{ 
	
	if(lista.size()==0)
	{
		%>	
		<br><br>
<h2>Estimado usuario Usted no cuenta con registros en la fecha seleccionada</h2>
<%}
	if(lista.size()>0){ %>

<br><br>
<form name="posicion_global" method="post" action="./detallado" onsubmit="return validar()">

<br><br><br>

<table border="1" align="center">
<tr>
<td  align="center" style="width: 250px; " BACKGROUND="verde.jpg">Descripcion</td>
<td align="center" style="width: 250px; " BACKGROUND="verde.jpg">Monto</td>
<td align="center" style="width: 250px; " BACKGROUND="verde.jpg">Fecha de solicitud</td>
</tr>
<% 

for (int i=0; i<lista.size(); i++)
{
	float monto = lista.get(i).getMontoopera();
	
   out.println("<tr>"); 
   out.println("<td align='center'>"+lista.get(i).getDescripcion() +"</td>");
   out.println("<td align='center'>"+nf.format(monto)+"</td>");
   out.println("<td align='center'>"+lista.get(i).getFechasoli()+"</td>");
   out.println("</tr>");
}
 out.println("");%>

<% }} %>

</table>
         
<br><br><br><br><br><br><br><br>
</form>
<br><br><br><br><br><br><br><br>
</body>
</html>