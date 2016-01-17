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
<link rel="stylesheet" type="text/css" href="default.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenidos al banco TAL</title>
 <script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
 
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){ // Script del Navegador 
		$("ul.subnavegador").not('.selected').hide();
		$("a.desplegable").click(function(e){
                    var desplegable = $(this).parent().find("ul.subnavegador");
                    $('.desplegable').parent().find("ul.subnavegador").not(desplegable).slideUp('slow');
                    desplegable.slideToggle('slow');
                    e.preventDefault();
                })
            });
	</script>
	<style type="text/css">
html,body{margin:0;padding:0}
 /*body{font: 76% arial,sans-serif} */
p{margin:0 10px 10px}
a{display:block;color: #981793;padding:10px}
 div#header h1{height:80px;line-height:80px;margin:0;
  padding-left:10px;background: #EEE;color: #79B30B}
/*div#content p{line-height:1.4} */
  /* div#navigation{background:#B9CAFF} */
div#extra{background:#FF8539}
div#footer{background: #333;color: #FFF}
div#footer p{margin:0;padding:5px 10px}

div#wrapper{float:right;width:100%;margin-right:-33%}
div#content{margin-right:10%}
div#navigation{float:left;width:32.9%}
div#extra{float:left;clear:left;width:32.9%}
div#footer{clear:both;width:100%}
</style>
    <script type="text/javascript">
    $('#content').empty();
      $(document).ready(function() {
	$('#navigation li a').click(function(e) {
		e.preventDefault(); // Previene la acción por defecto, que sería enviarte a otra página
		var href = $(this).attr('href'); // Esta línea extrae el contenido del atributo href del enlace clickeado

	if (href!="#")
		{
		$('#content').empty(); // Limpia el div 'contenido'
		$('#content').load(href); // Esta línea simplemente carga el contenido dentro del div 'contenido'
		}});
      });
      </script>
  
  

	<meta charset="utf-8">
	<title></title>
	<link href="css/ui-lightness/jquery-ui-1.10.4.custom.css" rel="stylesheet">
	<script src="js/jquery-1.10.2.js"></script>
	<script src="js/jquery-ui-1.10.4.custom.js"></script>
	<script>
	$(function() {

		$( "#datepicker" ).datepicker({
			inline: true
		});

		// Hover states on the static widgets
		$( "#dialog-link, #icons li" ).hover(
			function() {
				$( this ).addClass( "ui-state-hover" );
			},
			function() {
				$( this ).removeClass( "ui-state-hover" );
			}
		);
	});
	</script>
	<style>
	p{
		font: 60% "Trebuchet MS", sans-serif;
		margin: 0px;
	}
	.demoHeaders {
		margin-top: 2em;
	}
	#dialog-link {
		padding: .4em 1em .4em 10px;
		text-decoration: none;
		position: relative;
	}
	#dialog-link span.ui-icon {
		margin: 0 5px 0 0;
		position: absolute;
		left: .2em;
		top: 50%;
		margin-top: -8px;
	}
	#icons {
		margin: 0;
		padding: 0;
	}
	#icons li {
		margin: 2px;
		position: relative;
		padding: 4px 0;
		cursor: pointer;
		float: left;
		list-style: none;
	}
	#icons span.ui-icon {
		float: left;
		margin: 0 4px;
	}
	.fakewindowcontain .ui-widget-overlay {
		position: absolute;
	}
	</style>
	
	<script>
  $(function() {
    $( "#from" ).datepicker({
      defaultDate: "+1w",
    //  changeMonth: true,
      numberOfMonths: 1,
      maxDate :0,
      onClose: function( selectedDate ) {
        $( "#to" ).datepicker( "option", "minDate", selectedDate );
      }
    });
    $( "#to" ).datepicker({
      defaultDate: "+1w",
      maxDate :0,
   //   changeMonth: true,
      numberOfMonths: 1,
      onClose: function( selectedDate ) {
        $( "#from" ).datepicker( "option", "maxDate", selectedDate );
      }
    });
  });
  </script>
  
  <script type="text/javascript">

function validar()
{ 
	var formatos = document.getElementById('rango');
	
	var from =        document.getElementById('from');
	var to = document.getElementById('to');


	if(document.seleccion.from.disabled == false)
		{
	if(document.seleccion.from.value.length ==0)
		{
		alert("Debe seleccionar una fecha Desde");
		return false;
		}	
}
	if(document.seleccion.to.disabled == false)
		{
		if(document.seleccion.to.value.length == 0){
			alert("Debe seleccionar fecha Hasta");
			return false;
		}
		}
	return true;
}
</script>

  </head>
<body>
<div align="center">
<img src="bottom_banner.png" width="1300px" style=""></div>
<div id="header">
<br><br><h1 align="center" style="color: #38557E;"><font face="verdana" size="4">Hola  <%=objeto.getNombre() %>, bienvenido a GIBANK</font></h1>
<form name="salir"  action='./salir' method="post">
<p align="right"><input type="submit" value="Salir" style="color:red;  background:white; font-size: 40; font-family: verdana; width:120px; height:25px"></p>
</form>

</div>

<div id="navigation">
<table>
<ul class="navegador" style="height: 534px; width: 307px; ">
  <li><a class="desplegable" href="#" title="Cuenta" style="color: #2E4769;"><font face="verdana" size="4">Cuenta</font></a>
    <ul class="subnavegador">
      <li><a href="Posicion1.jsp" title="Posición Global" style="color: #2E4769;"><font face="verdana" size="4">Saldos y Movimientos</font></a></li>

    </ul>
  </li>
  <li><a class="desplegable" href="#"  title="Cheques" style="color: #2E4769;"><font face="verdana" size="4">Cheques</font></a>
    <ul class="subnavegador">
       <li><a href="Solicitud_cheque.jsp" title="Solicitud" style="color: #2E4769;"><font face="verdana" size="4">Solicitud</font></a></li>
       <li><a href="Consulta_cheque.jsp" title="Consulta" style="color: #2E4769;"><font face="verdana" size="4">Consulta</font></a></li>
        <li><a href="Presentacion_anulacion.jsp" title="Anulación" style="color: #2E4769;"><font face="verdana" size="4">Anulación</font></a></li>
    </ul>
  </li>
   <li><a class="desplegable" href="#" title="Transferencias" style="color: #2E4769;"><font face="verdana" size="4">Transferencias</font></a>
				<ul class="subnavegador">
       <li><a href="Transferencia_solicitud.jsp" title="Mismo Banco" style="color: #2E4769;"><font face="verdana" size="4">Mismo Banco</font></a></li>
       <li><a href="Transferencias_directorio.jsp" title="Directorio" style="color: #2E4769;"><font face="verdana" size="4">Directorio</font></a></li>
    </ul>
</li>
  <li><a class="desplegable" href="#" title="Pagos" style="color: #2E4769;"><font face="verdana" size="4">Pagos</font></a>
				<ul class="subnavegador">
       <li><a href="pago_propio.jsp" title="Propios" style="color: #2E4769;"><font face="verdana" size="4">Propios</font></a></li>
        <li><a href="directorio_agregar.jsp" title="Directorio" style="color: #2E4769;"><font face="verdana" size="4">Directorio</font></a></li>
    </ul>
</li>
 <li><a class="desplegable" href="#" title="BancaMovil" style="color: #2E4769;"><font face="verdana" size="4">BancaMovil</font></a>
				<ul class="subnavegador">
       <li><a href="Afiliar_tlf.jsp" title="Afiliar teléfono" style="color: #2E4769;"><font face="verdana" size="4">Afiliar teléfono</font></a></li>
       <li><a href="VerAfiliados.jsp" title="Configuración de dispositivos" style="color: #2E4769;"><font face="verdana" size="4">Configuración de dispositivos</font></a></li>
    </ul>
</li>

</ul>
	</table>
</div>
<div id="content">

<br><br>
<p align="center"><font face="verdana" size="4" style="color: #38557E;">CHEQUE > CONSULTA</font></p>
<br><br><br>
<p align="center"><font face="verdana" size="4" style="color: #38557E;">Seleccione el rango de los cheques que desea visualizar, si deja la opción por defecto se mostrará el detalle de los últimos siete días.</font></p>
<br><br><br>

<p align="center"><font face="verdana" size="4" style="color: #38557E;">Tipo de Consulta</font></p>
<br><br>
<form name="seleccion" method="post" action="./Consulta" onsubmit="return validar()">
<div align="center">
<input type="radio" name="rango" value="reciente" onclick="document.seleccion.from.disabled= true; document.seleccion.to.disabled= true" checked><font face="verdana" size="4" style="color: #38557E;">Últimos 7 días</font><br>
<input type="radio" name="rango" value="mes" onclick="document.seleccion.from.disabled= true; document.seleccion.to.disabled= true"><font face="verdana" size="4" style="color: #38557E;">Mes en curso</font><br><br>
<input type="radio" name="rango" id="formatos" value="formatos" onclick="document.seleccion.from.disabled = false; document.seleccion.to.disabled = false"><font face="verdana" size="4" style="color: #38557E;">Rango de fechas</font>

<br><br>
 <label for="from"><font face="verdana" size="4" style="color: #38557E;">Desde</font></label>
<input type="text" id="from" name="from" disabled readonly="readonly">
<label for="to"><font face="verdana" size="4" style="color: #38557E;">Hasta</font></label>
<input type="text" id="to" name="to" disabled readonly="readonly">


</div>

	 <input type="hidden" name="cuenta" value="<%= objeto.getCuenta()%>">
<p align="center">
<br>
	<input type="submit" value="aceptar" style="color: blue; background:white; font-size: 40; font-family: verdana; width:70px; height:25px;"></p>
</form>
<div> 
<jsp:include page="Listado_solicitud.jsp" flush="true"/></div>
</div>
</body>
</html>