package Transferencias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.mysql.jdbc.Statement;

import Loguearse.Usuario;

public class ConsultaAfiliados {

	public static LinkedList<Usuario>  Afiliado(Usuario objeto) throws SQLException{
	     Connection miconexion=null; 
		boolean esValido= false;
		LinkedList<Usuario> listaContactos = new LinkedList<Usuario>();
		
	try {
			Class.forName("com.mysql.jdbc.Driver");
			miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
			Statement insql = (Statement) miconexion.createStatement();
			System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
			ResultSet resultado = insql.executeQuery("select * from tttransfer where cuentaorigen='"+ objeto.getCuenta()+"'");
			while(resultado.next()){
				Usuario objeto1 = new Usuario();
				objeto1.setCuentabene(resultado.getString("cuentadestino"));
				objeto1.setAlias(resultado.getString("alias"));
				listaContactos.add(objeto1);
				System.out.println(objeto1);
		}
		
	}catch (Exception e) {
		
		e.printStackTrace();
	}
	return listaContactos;
	}}

