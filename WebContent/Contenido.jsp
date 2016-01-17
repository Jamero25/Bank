<%@page import="com.sun.org.apache.xpath.internal.operations.Variable"%>
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
<script type="text/javascript">
function abrir_ventana_total(x) {
	y = screen.availWidth;
	z = screen.availHeight;
	var ventana = window.open(x, x, "width="+y+", height="+z+", status=no, scrollbars=no, toolbars=no, menubar=no");
	ventana.moveTo(0,0);
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<img src="compu3.jpg" width="500px" style=""></div>
</body>
</html>