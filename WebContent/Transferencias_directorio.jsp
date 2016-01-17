<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script languaje="javascript">
function isNumberKey(evt)
	{
	var charCode = (evt.which) ? evt.which : event.keyCode
	if (charCode > 31 && (charCode < 48 || charCode > 57))
		{
	return false;
		}
 
		return true;
}
function validarNumer(num,e)
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
function validarLetras(e) { // 1
    tecla = (document.all) ? e.keyCode : e.which;
    if (tecla==8) return true; // backspace
    if (tecla==32) return true; // espacio
    if (e.ctrlKey && tecla==86) { return false; } //Ctrl v
    if (e.ctrlKey && tecla==67) { return false;} //Ctrl c
    if (e.ctrlKey && tecla==88) { return true;} //Ctrl x
    if (tecla==97) return false;
    if (tecla==98) return false;
    if (tecla==99) return false;
    if (tecla==100) return false;
    if (tecla==101) return false;
    if (tecla==102) return false;
    if (tecla==103) return false;
    if (tecla==104) return false;
    if (tecla==105) return false;
    if (tecla==106) return false;
    if (tecla==107) return false;
    if (tecla==109) return false;
    if (tecla==110) return false;
    if (tecla==111) return false;
    
 
    patron = /[a-zA-Z]/; //patron
 
    te = String.fromCharCode(tecla);
    return patron.test(te); // prueba de patron
  }
function validar()
{ 
	var cuenta = document.getElementById("cuentabene").value;
	var beneficiario =        document.getElementById("Beneficiario").value;
	var cedula =        document.getElementById("cedula").value;
	var alias =        document.getElementById("alias").value;

	
	if (cuenta.length == 0)
		{
		alert("Por favor ingrese la cuenta a transferir");
		return false;
		}
	if (beneficiario.length == 0)
	{
		alert("Por favor ingrese un beneficiario");
		return false;
	}
	if (cedula.length == 0)
	{
	alert("Por favor ingrese la cédula del beneficiario");
	return false;
	}
	if (alias.length == 0)
	{
	alert("Por favor ingrese el alias");
	return false;
	}
	
	return true;
}
</script>
</head>
<body>
<p align="center"><font face="verdana" size="4">Afiliación de cuentas</font></p>
<br><br>
<form name="transferencias"  action='Confirma_Transferencia.jsp' method="post" onsubmit="return validar()">
<table border="1" width="500" align="center">
	<tr>
	<td align="center">Cuenta:</td>
	<td align="center">    <br> <input id="cuentabene" name="cuentabene" type="text" maxlength="20" size="21" onkeydown="return validarNumer(this, event)" /><br><br></td>
	</tr>
	<tr>
	<td align="center">Beneficiario:</td>
	<td align="center"> <br><input id="Beneficiario" name="Beneficiario" type="text" maxlength="40" size="50"  onChange="javascript:this.value=this.value.toUpperCase();javascript:while(''+this.value.charAt(0)==' ')this.value=this.value.substring(1,this.value.length);javascript:while(''+this.value.charAt(this.value.length-1)==' ')this.value=this.value.substring(0,this.value.length-1);" onkeydown="return validarLetras(event)"/><br><br></td>
	</tr>
	<tr>
	<td align="center">Cédula:</td>
	<td align="center"><br> <input id="cedula" name="cedula" type="text" maxlength="9" onkeydown="return validarNumer(this, event)" /><br><br></td>
	</tr>
	<tr>
	<td align="center">Alias:</td>
	<td align="center"> <br><input id="alias" name="alias" size="15" maxlength="20" type="text" onChange="javascript:this.value=this.value.toUpperCase();javascript:while(''+this.value.charAt(0)==' ')this.value=this.value.substring(1,this.value.length);javascript:while(''+this.value.charAt(this.value.length-1)==' ')this.value=this.value.substring(0,this.value.length-1);" onkeydown="return validarLetras(event)"/><br><br></td>
	</tr>


	</table>
	
	<br><br>
	<p align="center"><input type="submit" value="ACEPTAR" style="color: blue; background:white; font-size: 40; font-family: verdana; width:80px; height:25px"></p>
</form>
</body>
</html>