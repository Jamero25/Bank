package Transferencias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.mysql.jdbc.Statement;

import Loguearse.Usuario;

public class RealizarTransferencia {

	
	public static boolean GuardarTransf(Usuario usuario) throws SQLException{
		  Connection miconexion=null; 
			boolean esValido= false;
			   Calendar c2 = new GregorianCalendar();
				 
				String dia, mes, annio;
				dia = Integer.toString(c2.get(Calendar.DATE));
				
				mes = Integer.toString(c2.get(Calendar.MONTH) +1);
				annio = Integer.toString(c2.get(Calendar.YEAR));
				System.out.println(dia + "-" +mes + "-"+ annio);
		 		String fechaHoy= (annio + "-" +mes+"-"+dia);
			try {
				Class.forName("com.mysql.jdbc.Driver");
				miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
				Statement insql = (Statement) miconexion.createStatement();
				System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
				ResultSet clave = insql.executeQuery("select * from ttdat where claveseguridad='"+usuario.getClaveespecial().trim()+"' and cuenta='"+usuario.getCuenta().trim()+"'");
				if(clave.next())
				{
				ResultSet comprobar = insql.executeQuery("select monto from ttcun where cuenta='"+usuario.getCuenta().trim()+"'");
				if(comprobar.next())
				{
					usuario.setSaldodisponible(comprobar.getFloat("monto"));
					
				}
				if(usuario.getSaldodisponible()>=usuario.getMontotransfe())
				{
				insql.execute("insert into ttauditransfe(cuentaorigen, cuentabeneficiario, monto, fecha) values('"+usuario.getCuenta().trim()+"','"+usuario.getCuentabene().trim()+"','"+usuario.getMontotransfe()+"','"+fechaHoy+"')");
				insql.execute("insert into movimientos(cuenta, descripcion, monto, fecha) values('"+usuario.getCuenta().trim()+"','Transferencia a :"+usuario.getBeneficiario()+"','"+usuario.getMontotransfe()+"','"+fechaHoy+"')");
				esValido=true;
				}
				if(usuario.getSaldodisponible()<usuario.getMontotransfe())
				{
					
				}
				}
	}catch(Exception e)
	{}
			
  	   return esValido;	
}}
