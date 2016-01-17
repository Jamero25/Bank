<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "java.io.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GIBANK Acceso</title>


	<script languaje="javascript">
function excel(){
 var direccionExcel="C:\\Users/Usuario/Desktop/eclipse-jee-juno-SR1-win32-x86_64/eclipse/Test1.pdf";
		  //window.open(direccionExcel, 'Donwload');
		 window.open(direccionExcel,'','menubar=yes');
		} 
		</script>
</head>
<body>
<div align="center">
<img src="bottom_banner.png" width="1300px" style=""></div>

<form name="Datos"  action='./Autenticacion' method="post">
<h3 align="center">Estimado usuario, por favor ingrese los datos requeridos para el acceso a su banca en línea</h3><br><br><br>
<table align="center">
<tr>
<td><font face="verdana" size="4">Usuario:</font></td>
<td><input id="nombre" type="text" name="nombre" maxlength="10" onChange="javascript:this.value=this.value.toUpperCase();"></td>
</tr>
<tr>
<td><font face="verdana" size="4">Clave:</font></td>
<td><input id="contraseña" type="password" name="contraseña" maxlength="10"></td>
</tr>
</table>

<p align="center"><input type="submit" value="Enviar" style="color: green; background:white; font-size: 40; font-family: verdana; width:70px; height:25px"> 
<input type="reset" value="Limpiar" style="color: green; background:white; font-size: 40; font-family: verdana; width:70px; height:25px"> </p>


</form>
<div>
<p align="center"> <input type="submit" value="Olvido de clave" onClick= "location.href = 'Olvido_clave.jsp'" style="color:#215021;  background:white; font-size: 40; font-family: verdana; width:120px; height:25px">
<br><br>
<input type="submit" value="Registrarse" onClick= "location.href = 'Registrar.jsp'" style="color: green; background:white; font-size: 40; font-family: verdana; width:90px; height:25px"></p>
</div>
</body>
</html>