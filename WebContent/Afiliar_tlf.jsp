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

<script languaje="javascript">
function validar()
{ 
	var mac = document.getElementById("mac").value;


	if (mac.length == 0 || mac.length<17)
		{
		alert("Por favor ingrese la direcci�n MAC de su dispositivo m�vil");
		return false;
		}
	
	return true;
}
</script>
</head>
<body>
	Estimado usuario, GIBANK le ofrece la opci�n de afiliar dispositivos m�viles para el acceso a su banca m�vil.
	
	
<br><br>

Estimado Usuario por favor escriba la direcci�n MAC que se encuentra en su tel�fono.

<form name="agregar_telefono"  action='./anadir' method="post" onsubmit="return validar()">

Direcci�n MAC : <input id="mac" name="mac" type="text" maxlength="17" size="18"/>
<br><br>
  <input type="hidden" name="cuenta" value ="<%= objeto.getCuenta()  %>">  
    <input type="hidden" name="nombre" value ="<%= objeto.getNombre()  %>">  

<input type="submit" value="Aceptar" />

</form>
</body>
</html>