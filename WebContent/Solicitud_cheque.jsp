<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "Loguearse.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
HttpSession sesion = request.getSession();

Usuario objeto = (Usuario)sesion.getAttribute("Usuario");

%>
<html>
<head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
	<script languaje="javascript">


	
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
	var beneficiario = document.getElementById("Beneficiario").value;
	var monto =     document.getElementById("Monto").value;
	var cedula = 	document.getElementById("cedula").value;
	
	if (beneficiario.length == 0 || beneficiario.length <= 5 || /^\s+$/.test(beneficiario))
	{
		alert("Por favor ingrese un beneficiario");
		return false;
	}
	if (monto.length == 0)
		{
		alert("Por favor ingrese el monto");
		return false;
		}
	if(monto < 300)
		{
		alert("Estimado usuario recuerde que la solicitud de Cheque de Gerencia debe ser por un monto mayor a BsF. 300");
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
	
	
	<script type="text/javascript">	
	
	var estados = [{'id_estado':'1','estado':'DISTRITO CAPITAL'},
	   			{'id_estado':'15','estado':'MIRANDA'}];
	var municipios = [{'id_municipio':'1','id_estado':'1','municipio':'LIBERTADOR'},
						{'id_municipio':'2','id_estado':'15','municipio':'BARUTA'},
						{'id_municipio':'3','id_estado':'15','municipio':'CHACAO'},
						{'id_municipio':'4','id_estado':'15','municipio':'EL HATILLO'},
						{'id_municipio':'5','id_estado':'15','municipio':'SUCRE'}];

	var parroquias = [{'id_parroquia':'1','id_municipio':'1','id_estado':'1','parroquia':'Oficina Altagracia'},
	{'id_parroquia':'2','id_municipio':'1','id_estado':'1','parroquia':'Oficina Antimano'},
	{'id_parroquia':'3','id_municipio':'1','id_estado':'1','parroquia':'Oficina Candelaria'},
	{'id_parroquia':'4','id_municipio':'1','id_estado':'1','parroquia':'Oficina Caricuao'},
	{'id_parroquia':'5','id_municipio':'1','id_estado':'1','parroquia':'Oficina Catedral'},
	{'id_parroquia':'6','id_municipio':'1','id_estado':'1','parroquia':'Oficina Coche'},
	{'id_parroquia':'7','id_municipio':'1','id_estado':'1','parroquia':'Oficina El Junquito'},
	{'id_parroquia':'8','id_municipio':'1','id_estado':'1','parroquia':'Oficina EL Paraiso'},
	{'id_parroquia':'9','id_municipio':'1','id_estado':'1','parroquia':'Oficina El Recreo'},
	{'id_parroquia':'10','id_municipio':'1','id_estado':'1','parroquia':'Oficina El Valle'},
	{'id_parroquia':'11','id_municipio':'1','id_estado':'1','parroquia':'Oficina La Pastora'},
	{'id_parroquia':'12','id_municipio':'1','id_estado':'1','parroquia':'Oficina La Vega'},
	{'id_parroquia':'13','id_municipio':'1','id_estado':'1','parroquia':'Oficina Macarao'},
	{'id_parroquia':'14','id_municipio':'1','id_estado':'1','parroquia':'Oficina San Agustin'},
	{'id_parroquia':'15','id_municipio':'1','id_estado':'1','parroquia':'Oficina San Bernardino'},
	{'id_parroquia':'16','id_municipio':'1','id_estado':'1','parroquia':'Oficina San Jose'},
	{'id_parroquia':'17','id_municipio':'1','id_estado':'1','parroquia':'Oficina San Juan'},
	{'id_parroquia':'18','id_municipio':'1','id_estado':'1','parroquia':'Oficina San Pedro'},
	{'id_parroquia':'19','id_municipio':'1','id_estado':'1','parroquia':'Oficina Santa Rosalia'},
	{'id_parroquia':'20','id_municipio':'1','id_estado':'1','parroquia':'Oficina Santa Teresa'},
	{'id_parroquia':'21','id_municipio':'1','id_estado':'1','parroquia':'Oficina Sucre'},
	{'id_parroquia':'22','id_municipio':'1','id_estado':'1','parroquia':'Oficina 23 de Enero'},
	{'id_parroquia':'23','id_municipio':'2','id_estado':'15','parroquia':'Oficina El Cafetal'},
	{'id_parroquia':'24','id_municipio':'2','id_estado':'15','parroquia':'Oficina Las Minas'},
	{'id_parroquia':'25','id_municipio':'2','id_estado':'15','parroquia':'Oficina Nuestra Señora del Rosario'},
	{'id_parroquia':'26','id_municipio':'3','id_estado':'15','parroquia':'Oficina Chacao'},
	{'id_parroquia':'27','id_municipio':'4','id_estado':'15','parroquia':'Oficina El HATILLO'},
	{'id_parroquia':'28','id_municipio':'5','id_estado':'15','parroquia':'Oficina Leoncio Martínez'},
	{'id_parroquia':'29','id_municipio':'5','id_estado':'15','parroquia':'Oficina Petare'},
	{'id_parroquia':'30','id_municipio':'5','id_estado':'15','parroquia':'Oficina Caucagüita'},
	{'id_parroquia':'31','id_municipio':'5','id_estado':'15','parroquia':'Oficina Filas de Mariche'},
	{'id_parroquia':'32','id_municipio':'5','id_estado':'15','parroquia':'Oficina La Dolorita'}];
		$(document).ready(function() {
		var sestados = '<option value=""></option>';
		$(estados).each(function(i){
			sestados += '<option value="'+this.id_estado+'">'+this.estado+'</option>';
		});
		$('#estados').html(sestados);
		$('#estados').change(function(){ // evento que al ser modificado el select estados es llamado
			var estado = $('#estados').val(); //obtenemos el estado seleccionado
			var pmunicipios = $.grep(municipios,function(n,i){return (n.id_estado == estado); }); //filtramos por estado
			var smunicipios = '<option value=""></option>';
			$(pmunicipios).each(function(i){ //recorremos cada uno de los municipios previamente filtrados
				smunicipios += '<option value="'+this.id_municipio+'">'+this.municipio+'</option>'; //vamos  creando el select
			});
			$('#municipios').html(smunicipios); //el html generado se asigna al select de municipios
			$('#parroquias').html('');
		});
		$('#municipios').change(function(){
			var estado = $('#estados').val();
			var municipio = $('#municipios').val();
			var pparroquias = $.grep(parroquias,function(n,i){return (n.id_estado == estado && n.id_municipio == municipio ); });
			var sparroquias = '<option value=""></option>';
			$(pparroquias).each(function(i){
				sparroquias += '<option value="'+this.id_parroquia+'">'+this.parroquia+'</option>';
			});
			$('#parroquias').html(sparroquias);
		});
	});
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solicitud</title>
</head>
<body>
<div id="content">
<form name="Solicitud" action="Confirmacion_cheque.jsp" method="post" onsubmit="return validar()" >
<div align="center">
<br> <p align="center"><font face="verdana" size="4">SOLICITUD</font></p>
<br><br>

<p align="center"><font face="verdana" size="4"><label for='estados'>Estados</label><select name="estados" id='estados'></select></font></p>
<p align="center"><font face="verdana" size="4"><label for='municipios'>Municipios</label><select name="estados" id='municipios'></select></font></p>
	<h3 align="center">Seleccionar Oficina Comercial</h3>
	
	<p align="center"><font face="verdana" size="4"><label for='parroquias'>Oficina</label><select name="estado" id='parroquias'></select></font></p>
	
	<h3 align="center">Datos del Cheque</h3><br>
	<p align="center"><font face="verdana" size="4">Beneficiario</font>
	<input id="Beneficiario" name="Beneficiario" type="text"  maxlength="40" size="50"  onChange="javascript:this.value=this.value.toUpperCase();javascript:while(''+this.value.charAt(0)==' ')this.value=this.value.substring(1,this.value.length);javascript:while(''+this.value.charAt(this.value.length-1)==' ')this.value=this.value.substring(0,this.value.length-1);" onkeydown="return validarLetras(event)"/></p><br><br>
	<p align="center"><font face="verdana" size="4">Cédula de identidad:</font>
	<select id="tipocedula" name="tipocedula">
  <option value="Venezolano">V</option>
  <option value="Extranjero">E</option>
  <option value="Pasaporte">P</option>
  <option value="Juridico">J</option>
</select></p> <input align="middle" id="cedula" type="text" name="cedula" maxlength="9" onkeydown="return validarNumer(this, event)"><br><br>
	<p align="center"><font face="verdana" size="4">Monto (BsF)</font>
	<input id="Monto" name="Monto" type="text" maxlength="9" onkeypress="return validarNume(this.value,event); " onBlur="this.value= NumberFormat(this.value, '2', '.', ',')" /></p><br>
<br>

<p align="center" style="margin-left:500px;">
	<input type="submit" value="Aceptar" style="color: blue; background:white; font-size: 40; font-family: verdana; width:70px; height:25px;" ></p>
	</div>
</form>
</div>
</body>
</html>