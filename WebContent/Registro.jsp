<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import= "Loguearse.Usuario" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
HttpSession sesion = request.getSession();

Usuario objeto = (Usuario)sesion.getAttribute("Usuario");

%>
<script type="text/javascript">
function validarForm(formulario)
{
	var usuario = document.getElementById("usuario").value;
	var clave =     document.getElementById("clave").value;
	
	if(usuario.length ==0 || usuario.length <6)
		{
		alert("Debe ingresar un usuario de más de 6 caracteres");
		return false;
		}
	if(clave.length ==0 || clave.length <6)
	{
	alert("Debe ingresar una clave de más de 6 caracteres");
	return false;
	}
	
return true;
}


</script>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<img src="bottom_banner.png" width="1300px" style=""></div>
<p align="center"><font face="verdana" size="4">Complete los datos de su banca por internet</font></p>

<form name="Datos_Interno"  action='./Incorpora' method="post" onsubmit="return validarForm(this);">
<h1></h1>
<p align="center"> <font face="verdana" size="4">Cuenta:</font> <input id="cuenta" type="text" name="cuenta" value="<%=objeto.getCuenta() %>" readonly><br><br>
<font face="verdana" size="4">Nombre: </font> <input id="nombre" type="text" name="nombre" value="<%=objeto.getNombre() %>" readonly><br><br>
<font face="verdana" size="4">Cedula:</font> <input id="cedula" type="text" name="cedula" value="<%=objeto.getCedula() %>" readonly><br><br>
<font face="verdana" size="4">Usuario: </font> <input id="usuario" type="text" name="usuario" maxlength="10" onChange="javascript:this.value=this.value.toUpperCase();" ><br><br>
<font face="verdana" size="4"> Contraseña:</font>  <input id="clave" type="password" name="clave" maxlength="10">
<br><br></p>
<p align="center">
<input type="submit" value="Enviar" style="color: green; background:white; font-size: 40; font-family: verdana; width:70px; height:25px">   
<input type="reset" value="Limpiar" style="color: green; background:white; font-size: 40; font-family: verdana; width:70px; height:25px"> </p>
</form> 
</body>
</html>