<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<script type="text/javascript">
function abrir_ventana_total(x) {
	y = screen.availWidth;
	z = screen.availHeight;
	var ventana = window.open(x, x, "width="+y+", height="+z+", status=no, scrollbars=no, toolbars=no, menubar=no");
	ventana.moveTo(0,0);
}
</script>
<link rel="stylesheet" type="text/css" href="default.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auditoría</title>
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
<div id="header">
<img src="logo.png" width="200px">
<br><br><h1> Auditor </h1>

</div>
<div id="navigation">
<table>
<ul class="navegador" style="height: 534px; width: 307px; ">
  <li><a class="desplegable" href="#" title="Cuenta">Cuentas</a>
    <ul class="subnavegador">
      <li><a href="Agregar.jsp" title="Posición Global">Agregar</a></li>
      <li><a href="Modificar.jsp" title="MÁS">Modificar</a></li>
    </ul>
  </li>
  <li><a class="desplegable" href="#"  title="Cheques">Mensajes</a>
    <ul class="subnavegador">
       <li><a href="Mensajes.jsp" title="Solicitud">Enviar</a></li>
     
    </ul>
  </li>
   
	</table>
</div>

<div id="content">

</div>
</body>
</html>