<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
HttpSession sesion = request.getSession();
String strError= (String) sesion.getAttribute("Error");

%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ERROR</title>
</head>
<body>
<div align="center">
<img src="bottom_banner.png" width="1300px" style=""></div>
<%if(strError!=null && !strError.equals("")) { %>
<div align="center">
<table>

<tr align="center">
<td align="center"><font face="verdana" size="4"><%=strError%></font></td>
</tr>

</table>

<% } %>
<A HREF="javascript:history.back()"> Volver Atrás </A>

</div>
</body>
</html>