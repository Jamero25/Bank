<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Olvido de clave</title>
	<script languaje="javascript">
function validar()
{ 
	var tarjeta = document.getElementById("tarjeta").value;
	var contrasena =     document.getElementById("identi").value;
	var codigo = 		document.getElementById("codigo").value;
	
	
	if (tarjeta.length == 0 || tarjeta.length < 16)
	{
		alert("Por favor ingrese los n�meros de su tarjeta");
		return false;
	}
	if (contrasena.length == 0 || contrasena.length <4)
		{
		alert("Por favor ingrese la contrase�a");
		return false; 
		}
	
	if(codigo.length == 0 || codigo.length<3)
		{
		alert("Por favor ingrese el c�digo de validaci�n de su tarjeta");
		return false;
		}
	
	return true;
}
function validarNum(num,e)
{
    var val = num;
    var filter = /^[0-9]+[\.]?[0-9]{0,2}$/;
    keynum = (document.all) ? e.keyCode : e.which;

    if (keynum == 0 || keynum==8)
    {
        return true;
    }

    keychar = String.fromCharCode(keynum);
    return filter.test(val+keychar);
}
</script>

</head>
<body>
<div align="center">
<img src="bottom_banner.png" width="1300px" style=""></div>
<h1 align="center"><font face="verdana" size="4">Recuperaci�n de clave</font></h1>
<form name="Datos"  action='./Olvido' method="post" onsubmit="return validar()">
<p align="center"><font face="verdana" size="4">N�mero de tarjeta:</font> <input id="tarjeta" type="text" name="tarjeta" maxlength="20" size="22" onkeypress="return validarNum(this.value,event); "><br><br>
<font face="verdana" size="4">Clave:  </font><input id="identi" type="password" name="contrase�a" maxlength="4" size="5" onkeypress="return validarNum(this.value,event); "><br><br>
<font face="verdana" size="4">C�digo de Verificaci�n: </font> <input id="codigo" type="text" name="codigo"  maxlength="3" size="5" onkeypress="return validarNum(this.value,event); ">
<br><br></p>
<p align="center"><input type="submit" value="Enviar" style="color: green; background:white; font-size: 40; font-family: verdana; width:70px; height:25px">  
<input type="reset" value="Limpiar" style="color: green; background:white; font-size: 40; font-family: verdana; width:70px; height:25px"> </p>
</form>
</body>
</html>