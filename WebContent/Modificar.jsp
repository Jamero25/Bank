<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



<script languaje="javascript">
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
Modificar saldo
<form name="auditoria"  action='./cambiarmonto' method="post">

Cuenta :
<input id="cuenta" name="cuenta" type="text" maxlength="20" size="21" onkeydown="return validarNumer(this, event)"/>
<br><br>
Monto :
<input id="monto" name="monto" type="text" maxlength="8" onkeypress="return validarNume(this.value,event); " onBlur="this.value= NumberFormat(this.value, '2', '.', ',')"/>
<br><br>
<input type="submit" value="Aceptar" />

</form>
</body>
</html>