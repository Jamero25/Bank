<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import= "Loguearse.Usuario" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

HttpSession sesion = request.getSession();

Usuario objeto = (Usuario)sesion.getAttribute("Usuario");

Locale locale = new Locale("es", "VE");
NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
String monto = request.getParameter("Monto");
float variable;
variable = Float.parseFloat(monto);

%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="default.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenidos al banco TAL</title>
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
body{font: 76% arial,sans-serif}
p{margin:0 10px 10px}
a{display:block;color: #981793;padding:10px}
div#header h1{height:80px;line-height:80px;margin:0;
  padding-left:10px;background: #EEE;color: #79B30B}
div#content p{line-height:1.4}
  /* div#navigation{background:#B9CAFF} */
div#extra{background:#FF8539}
div#footer{background: #333;color: #FFF}
div#footer p{margin:0;padding:5px 10px}

div#wrapper{float:right;width:100%;margin-right:-33%}
div#content{margin-right:33%}
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
      <li><a href="Posicion1.jsp" title="Posición Global" style="color: #2E4769;"><font face="verdana" size="4">Posición Global</font></a></li>

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
<p align="center"><font face="verdana" size="4">CONFIRMACIÓN</font></p><br><br><br>
<form name="Datos_Interno"  action='./Solicitud' method="post">
<table align="center">
<tr>
<td align="center"><h3><font face="verdana" size="4">Beneficiario:</font></h3></td>
<td align="center"><h3><%= request.getParameter("Beneficiario") %></h3></td>
</tr>
<tr>
<td align="center"><h3><font face="verdana" size="4">Monto:</font></h3></td>
<td align="center"><h3><%= nf.format(variable) %></h3></td>
</tr>
<tr>
<td align="center"><h3><font face="verdana" size="4">Cuenta:</font></h3></td>
<td align="center"><h3><%=objeto.getCuenta() %></h3></td>
</tr>
<tr>
<td align="center"><h3><font face="verdana" size="4">Oficina:</font></h3></td>
<td align="center"><h3><%= request.getParameter("estado")%></h3></td>
</tr>
</table>

 <input type="hidden" name="Beneficiario" value="<%= request.getParameter("Beneficiario")%>">
  <input type="hidden" name="Monto" value="<%= request.getParameter("Monto")%>">
  <input type="hidden" name="cuenta" value ="<%= objeto.getCuenta()  %>">
  <input type="hidden" name="tipoci" value="<%= request.getParameter("tipocedula") %>">
  
  <input type="hidden" name="nombre" value="<%= objeto.getNombre()  %>">
   
<div align="center"><input type="submit" value="Aceptar"style="color: blue; background:white; font-size: 40; font-family: verdana; width:80px; height:25px"></div>
 <input type="button" value="Cancelar" name="Back2" onclick="history.back()" />
 
</form>
</div>
</body>
</html>







