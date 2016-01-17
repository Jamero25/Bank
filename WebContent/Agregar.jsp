<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script languaje="javascript">

function validar()
{ 
	var cuenta = document.getElementById("cuenta").value;
	var monto =     document.getElementById("monto").value;
	var tarjeta = 	document.getElementById("tarjeta").value;
	var clave = 	document.getElementById("clave").value;
	
	
	var codigo = document.getElementById("codigo").value;
	var cedula =     document.getElementById("cedula").value;
	var nombre = 	document.getElementById("nombre").value;
	var correo = 	document.getElementById("correo").value;
	var numero = 	document.getElementById("numero").value;
	var claveespecial = 	document.getElementById("claveespecial").value;
	
	if (nombre.length == 0 || nombre.length <= 5 || /^\s+$/.test(nombre))
	{
		alert("Por favor ingrese un nombre");
		return false;
	}
	if (monto.length == 0)
		{
		alert("Por favor ingrese el monto");
		return false;
		}
	if (correo.length == 0)
	{
	alert("Por favor ingrese el correo");
	return false;
	}
	
	if (numero.length == 0)
	{
	alert("Por favor ingrese el numero");
	return false;
	}
	if (claveespecial.length == 0)
	{
	alert("Por favor ingrese su clave especial");
	return false;
	}
	if (cuenta.length == 0 || cuenta.length<20)
	{
	alert("Por favor ingrese una cuenta");
	return false;
	}
	if (tarjeta.length == 0 || tarjeta.length<16)
	{
	alert("Por favor ingrese una cuenta");
	return false;
	}
	if (clave.length == 0 || clave.length<4)
	{
	alert("Por favor ingrese una clave");
	return false;
	}
	if (codigo.length == 0 || codigo.length<3)
	{
	alert("Por favor ingrese una clave");
	return false;
	}
	
	if(monto < 1000)
		{
		alert("Estimado usuario recuerde que para la apertura de una cuenta el monto inicial no debe ser menor a BsF. 1000");
		return false;
		}
	if(cedula.length==0 || cedula.length<=5){
		alert("Por favor ingrese la cedula");
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
	function isNumberKey(evt)
	{
	var charCode = (evt.which) ? evt.which : event.keyCode
	if (charCode > 31 && (charCode < 48 || charCode > 57))
		{
	return false;
		}
 
		return true;
}
	
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
	function validarNume(num,e)
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
<br><br>

Agregar cuenta

<form name="agregar"  action='./agregar' method="post" onsubmit="return validar()">

Cuenta :
<input id="cuenta" name="cuenta" type="text" maxlength="20" size="21" onkeydown="return validarNumer(this, event)"/>
<br><br>
Monto :
<input id="monto" name="monto" type="text" maxlength="8" onkeypress="return validarNume(this.value,event); " onBlur="this.value= NumberFormat(this.value, '2', '.', ',')"/>
<br><br>
Tarjeta :
<input id="tarjeta" name="tarjeta" type="text" maxlength="16" size="17" onkeydown="return validarNumer(this, event)"/>
<br><br>
Clave :
<input id="clave" name="clave" type="text" maxlength="4" size="5"  onkeydown="return validarNumer(this, event)"/>
<br><br>
Codigo :
<input id="codigo" name="codigo" type="text" maxlength="3" size="5" onkeydown="return validarNumer(this, event)"/>
<br><br>
Cédula :
<input id="cedula" name="cedula" type="text" maxlength="10" size="11" onkeydown="return validarNumer(this, event)"/>
<br><br>
Nombre :
<input id="nombre" name="nombre" type="text" maxlength="30" size="35"  onChange="javascript:this.value=this.value.toUpperCase();javascript:while(''+this.value.charAt(0)==' ')this.value=this.value.substring(1,this.value.length);javascript:while(''+this.value.charAt(this.value.length-1)==' ')this.value=this.value.substring(0,this.value.length-1);" onkeydown="return validarLetras(event)"/>
<br><br>
Correo :
<input id="correo" name="correo" type="text" maxlength="30" size="35"/>
<br><br>
Numero :
<input id="numero" name="numero" type="text" maxlength="13" size="15"/>
<br><br>
Clave Especial :
<input id="claveespecial" name="claveespecial" type="text" maxlength="12" size="15"/>
<br><br>

<input type="submit" value="Aceptar" />

</form>
</body>
</html>