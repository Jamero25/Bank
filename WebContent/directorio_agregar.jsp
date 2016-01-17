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
	var beneficiario = document.getElementById("Beneficiario").value;
	var contrato =        document.getElementById("contrato").value;
	var cedula =        document.getElementById("cedula").value;
	var alias =        document.getElementById("alias").value;
	var dia =        document.getElementById("dia").value;


	if (contrato.length == 0)
		{
		alert("Por favor ingrese el id de contrato");
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
	if(dia >31)
		{
		alert("El día no puede ser mayor a 30 - 31");
		return false;
		}
	
	return true;
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
	</script>
	<script type="text/javascript">
  function comprobar(){
    var titulacion = document.getElementById('titulacion');
    var rango = document.getElementById('rango');
    
    if(rango.value > 1)
    {
    	titulacion.style.visibility = "visible";
      titulacion.style.display = 'block';
    }
    
 
    else
    {
      titulacion.style.display = 'none';
    }
  }
</script>
</head>
<body>
<br><p align="center"><font face="verdana" size="4">Estimado usuario mediante esta función podrá agregar los servicios que serán programados a su cuenta.<br><br>

Por favor seleccione el servicio a agregar.<br><br></font></p>
<label>
<form name="pagos" action="Confirmacion_servicio.jsp" method="post" onsubmit="return validar()">

   <p align="center" ><select onchange="comprobar();" name="rango" id="rango">
      <option value="1">Seleccione</option>
      <option value="2">CANTV</option> 
      <option value="3">ELECTRICIDAD</option> 
      <option value="4">GAS PDVSA</option> 
    </select></p>
  </label>


<div id="titulacion" style="visibility: hidden;" align="center">
 
 <label>

<h1>Datos del Servicio</h1><br>
	<table border="1" width="300">
	<tr>
	<td align="center">ID Contrato:</td>
	<td align="center">    <br> <input id="contrato" name="contrato" type="text" maxlength="10"  onkeydown="return validarNumer(this, event)" /><br><br></td>
	</tr>
	<tr>
	<td align="center">Beneficiario</td>
	<td align="center"> <br><input id="Beneficiario" name="Beneficiario" type="text"  maxlength="40" size="50"  onChange="javascript:this.value=this.value.toUpperCase();javascript:while(''+this.value.charAt(0)==' ')this.value=this.value.substring(1,this.value.length);javascript:while(''+this.value.charAt(this.value.length-1)==' ')this.value=this.value.substring(0,this.value.length-1);" onkeydown="return validarLetras(event)"/><br><br></td>
	</tr>
	<tr>
	<td align="center">Cédula:</td>
	<td align="center"><br> <input id="cedula" name="cedula" type="text" maxlength="8"   onkeypress="return isNumberKey(event)" /><br><br></td>
	</tr>
	<tr>
	<td align="center">Alias:</td>
	<td align="center"> <br><input id="alias" name="alias" type="text"  onChange="javascript:this.value=this.value.toUpperCase();javascript:while(''+this.value.charAt(0)==' ')this.value=this.value.substring(1,this.value.length);javascript:while(''+this.value.charAt(this.value.length-1)==' ')this.value=this.value.substring(0,this.value.length-1);"/><br><br></td>
	</tr>
	<tr>
	<td align="center">Fecha de Pago:</td>
	<td align="center"> <br><input id="dia" name="dia"  maxlength="2" type="text"/><br><br></td>
	</tr>
	</table>
	
	<br><br>
<p align="center"><input type="submit" value="aceptar" style="color: blue; background:white; font-size: 40; font-family: verdana; width:80px; height:25px"></p>


</form>

  </label>
</div>

</body>
</html>