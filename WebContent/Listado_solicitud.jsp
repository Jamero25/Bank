<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ page import= "Consulta.Consulta" %>
   <%@page import= "Loguearse.Usuario" %>
    <%@page import= "java.util.LinkedList" %>
   <%@page import= "Consulta.ListaCheques" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

HttpSession sesion = request.getSession();

Usuario objeto = (Usuario)sesion.getAttribute("Usuarios");
Locale locale = new Locale("es", "VE");
NumberFormat nf = NumberFormat.getCurrencyInstance(locale);

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><br><br><br>
<% 
LinkedList<Usuario> lista = ListaCheques.UsuarioValido(objeto);


if (objeto.getFechaDesde().equals(""))
{%>

<%}else{ 
	
	if(lista.size()==0)
	{
		%>	
		<br><br>
<h2 align="right"><font face="verdana" size="4" >Estimado usuario Usted no cuenta con registros en la fecha seleccionada</font></h2>
<%}
	if(lista.size()>0){ %>


<table border="2" >
<tr>

<td style="width: 250px; "  BACKGROUND="verde.jpg">Beneficiario</td>
<td  style="width: 200px; " BACKGROUND="verde.jpg">Monto</td>
<td style="width: 390px; "  BACKGROUND="verde.jpg">Fecha de solicitud</td>
<td style="width: 500px; "  BACKGROUND="verde.jpg">Descripción</td>
</tr>
<%
	
for (int i=0; i<lista.size(); i++)
{
	float cuenta = lista.get(i).getMonto();
   out.println("<tr>"); 
   out.println("<td>"+lista.get(i).getBeneficiario() +"</td>");
   out.println("<td>"+nf.format(cuenta)+"</td>");
   out.println("<td>"+lista.get(i).getFechasoli()+"</td>");
   out.println("<td>"+lista.get(i).getDescrip()+"</td>");
   out.println("</tr>");
}
}
}
%>


</table>
<br>

</body>
</html>