package Telefonos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import Loguearse.Usuario;

public class QuitarDispositivo {

	
	public static boolean Quitadispo(Usuario usuario) throws SQLException {
		 Connection miconexion=null; 
		 
		 Boolean esValido =false;
		 
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
				Statement insql = (Statement) miconexion.createStatement();
				System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
				insql.execute("Delete from telefonos where cuenta='"+usuario.getCuenta().trim()+"' and mac='"+usuario.getMac().trim()+"'");
				
		 esValido = true;
}catch(Exception e){}
		 return esValido;
		 }
}