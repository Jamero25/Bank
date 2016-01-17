<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro nuevo usuario</title>

<script languaje="javascript">
function validarNum(num,e)
{

		 var keynum;
		 var keychar;
		 var numcheck;
		  if(window.event){ /*/ IE*/
		   keynum = e.keyCode
		  }
		  else if(e.which){ /*/ Netscape/Firefox/Opera/*/
		   keynum = e.which
		  }
		  if((keynum>=35 && keynum<=37) ||keynum==8||keynum==9||keynum==46||keynum==39) {
		   return true;
		  }
		  if((keynum>=95&&keynum<=105)||(keynum>=48&&keynum<=57)){
		   return true;
		  }else {
		   return false;
		  }
		}

function validar()
{ 
	var tarjeta = document.getElementById("tarjeta").value;
	var contrasena =     document.getElementById("identi").value;
	var codigo = 		document.getElementById("codigo").value;
	var cedula = document.getElementById("cedula").value;
	
	
	if (tarjeta.length == 0 || tarjeta.length < 16)
	{
		alert("Por favor ingrese los números de su tarjeta");
		return false;
	}
	if (contrasena.length == 0 || contrasena.length <4)
		{
		alert("Por favor ingrese la contraseña");
		return false; 
		}
	if(cedula.length == 0 || cedula.length<6)
	{
	alert("Por favor ingrese la cedula");
	return false;
	}
	if(codigo.length == 0 || codigo.length<3)
		{
		alert("Por favor ingrese el código de validación de su tarjeta");
		return false;
		}
	
	
	return true;
}
</script>
</head>
<body>
<div align="center">
<img src="bottom_banner.png" width="1300px" style=""></div>

<form name="Datos"  action='./Registro' method="post" onsubmit="return validar()">
<h3 align="center">REGISTRO DE USUARIO</h3><br><br><br>
<p align="center"><font face="verdana" size="4">Estimado usuario por favor ingrese los datos solicitados.</font></p>
<p align="center"><font face="verdana" size="4"> Número de tarjeta:</font> <input id="tarjeta" type="text" name="tarjeta" maxlength="16" size="22" onkeydown="return validarNum(this, event)"><br><br>
<font face="verdana" size="4">Clave: </font> 							   <input id="identi" type="password" name="contraseña" maxlength="4" size="5" onkeydown="return validarNum(this, event)"><br><br>
<font face="verdana" size="4">Cédula de identidad:</font><select>
  <option value="venezolano">V</option>
  <option value="Extranjero">E</option>
  <option value="Pasaporte">P</option>
  <option value="Juridico">J</option>
</select> <input id="cedula" type="text" name="cedula" maxlength="8" size="10" onkeydown="return validarNum(this, event)"><br><br>
<font face="verdana" size="4">Código de Verificación: </font> <input id="codigo" type="text" name="codigo"  maxlength="3" size="4" onkeydown="return validarNum(this, event)">
<br><br>
<input type="submit" value="Enviar" style="color: green; background:white; font-size: 40; font-family: verdana; width:70px; height:25px">   
<input type="reset" value="Limpiar" style="color: green; background:white; font-size: 40; font-family: verdana; width:70px; height:25px"> </p>
</form> 
</body>
</html>