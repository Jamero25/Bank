package Telefonos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.mysql.jdbc.Statement;

import Loguearse.Usuario;

public class TraerDispositivos {

	public static LinkedList<Usuario>  Listado(Usuario objeto) throws SQLException{
	     Connection miconexion=null; 
	
		LinkedList<Usuario> listaContactos = new LinkedList<Usuario>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
			Statement insql = (Statement) miconexion.createStatement();
			System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
			ResultSet resultado = insql.executeQuery("select * from telefonos where cuenta='"+objeto.getCuenta().trim()+"'");
			while(resultado.next()){
				Usuario objeto1 = new Usuario();
				objeto1.setMac(resultado.getString("mac"));
				listaContactos.add(objeto1);
				System.out.println(objeto1);
		}
		
	}catch (Exception e) {
		
		e.printStackTrace();
	}
	return listaContactos;
	}}

			
	