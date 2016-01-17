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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script languaje="javascript">
function validar(evt)
{
	var charCode = (evt.which) ? evt.which : event.keyCode;
	if (charCode==8) return true; 
	patron = /^(\d{1,3},)*\d{1,3}(\.\d+)?$/
		
	te = String.fromCharCode(charCode);  
    return patron.test(te);  

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


function validarForm(formulario)
{
	var monto = document.getElementById("montotransferir").value;

	if(monto.length ==0)
		{
		alert("Debe ingresar un monto");
		return false;
		}
	if(monto==0)
		{
		alert("Debe ingresar un monto mayor a 0");
		return false;
		}
	if(monto<5)
		{
		alert("Estimado usuario el monto mínimo para realizar las transferencias debe ser mayor a BsF. 5");
		return false;
		}

return true;
}
</script>
</head>
<body>

<form name="datos_Beneficiario_agregado"  action="ConfirmacionTransferencia.jsp" method="post" onsubmit="return validarForm(this);" >
<table>
<% if(objeto.getCuentabene().trim()!="") 
{%>
<tr>
<td align="center"><h3>Cuenta:</h3></td>
<td align="center"><h3><%= objeto.getCuentabene() %></h3></td>
</tr>
<tr>
<td align="center"><h3>Beneficiario:</h3></td>
<td align="center"><h3><%= objeto.getBeneficiario() %></h3></td>
</tr>
<tr>
<td align="center"><h3>Cédula:</h3></td>
<td align="center"><h3><%= objeto.getCedulabene() %></h3></td>
</tr>
<tr>
<td align="center"><h3>Monto:</h3></td>
<td><input id="montotransferir"  name="montotransferir"  maxlength="9" type="text" onkeypress="return validarNum(this.value,event); " onBlur="this.value= NumberFormat(this.value, '2', '.', ',')" ></td>
</tr>
</table>

<input type="hidden" name="cuentabeneficiario" value ="<%= objeto.getCuentabene()%>" >
 <input type="hidden" name="beneficiario"       value="<%= objeto.getBeneficiario()    %>">
  <input type="hidden" name="cedulabene" value="<%= objeto.getCedulabene() %>">
 <input type="hidden" name="cuenta" value ="<%= objeto.getCuenta()  %>">
 <input type="hidden" name="nombre" value ="<%= objeto.getNombre() %>">
<input type="submit" value="Enviar">  
<%} %>
</form>
</body>
</html>