package Anulacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Loguearse.Usuario;

public class CambiarDescri {

	public static boolean Cambia(Usuario usuario) throws SQLException {
		 Connection miconexion=null; 
		 Boolean esValido =false;
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
				ResultSet result = insql.executeQuery("select * from ttsolic where id='"+usuario.getIdcheque()+"'");
				if(result.next())
				{
					usuario.setBeneficiario(result.getString("beneficiario"));
					usuario.setMonto(result.getFloat("monto"));
					insql.execute("Update ttsolic set descripcion='Solicitud Anulada' where id="+usuario.getIdcheque());
					esValido=true;
					insql.execute("Delete from ttaudisolic where beneficiario ='"+usuario.getBeneficiario().trim()+"' and monto='"+usuario.getMonto()+"' and fecha='"+fechaHoy+"'");
				}
				
				
	}catch(Exception e){}
		 return esValido;
}}
