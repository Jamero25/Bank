package Posicion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import Loguearse.Usuario;

public class Cuentas {

	
	public static boolean Datosusuario(Usuario usuario) throws SQLException{
	     Connection miconexion=null; 
		boolean esValido= false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
			Statement insql = (Statement) miconexion.createStatement();
			System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
		ResultSet resulmonto = insql.executeQuery("select * from TTCUN where cuenta='"+ usuario.getCuenta().trim()+"'");
		if(resulmonto.next())
		{
			usuario.setTotal(resulmonto.getDouble("monto"));
			esValido= true;
		}
		}catch(Exception e){}
		
		return esValido;
		
}

}