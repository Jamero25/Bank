package Telefonos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import Loguearse.Usuario;

public class telefonos {

	
	public static boolean GuardaDato(Usuario usuario) throws SQLException{
	     Connection miconexion=null; 
	     Boolean esValido = false;
	     
	     try {
				Class.forName("com.mysql.jdbc.Driver");
				miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
				Statement insql = (Statement) miconexion.createStatement();
				System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
				ResultSet resultado = insql.executeQuery("select * from telefonos where cuenta ='"+usuario.getCuenta().trim()+"' and mac='"+usuario.getMac().trim()+"'");
				if (resultado.next())
				{
					
					}else{
						insql.execute("insert into telefonos (cuenta, mac) values('"+usuario.getCuenta().trim()+"','"+usuario.getMac().trim()+"')");
						esValido=true;
					}
				}catch(Exception e){}
	     return esValido;
}}
