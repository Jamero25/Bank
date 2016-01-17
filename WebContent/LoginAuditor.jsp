<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auditoría</title>
</head>
<body>
<form name="Datos"  action='./Autenauditor' method="post">
<h3 align="center">Por favor ingrese los datos solicitados</h3><br><br><br>
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
</body>
</html>