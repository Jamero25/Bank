package Pagos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import Loguearse.Usuario;

public class QuitarPago {

	
	public static boolean PagoActualiza(Usuario usuario) throws SQLException{
	     Connection miconexion=null; 
		boolean esValido= false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
			Statement insql = (Statement) miconexion.createStatement();
			System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
			insql.execute("Delete from ttserv where alias='"+usuario.getAlias().trim()+"' and cuenta='"+usuario.getCuenta().trim()+"'");
			ResultSet resultado = insql.executeQuery("select * from ttdat where cuenta='"+usuario.getCuenta().trim()+"'");
			if(resultado.next())
			{
				usuario.setNombre(resultado.getString("nombre"));
			}
			esValido=true;
			
}catch(Exception e){}
		return esValido;
	}
}
