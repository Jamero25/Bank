package Posicion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.LinkedList;

import com.mysql.jdbc.Statement;

import Loguearse.Usuario;

public class Descripcion {

	
	public static LinkedList<Usuario>  DatosTransacciones(Usuario objeto) throws SQLException{
		
		Connection miconexion=null; 
	
		LinkedList<Usuario> listaContactos = new LinkedList<Usuario>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
			Statement insql = (Statement) miconexion.createStatement();
			System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
			ResultSet resulmonto = insql.executeQuery("select * from TTCUN where cuenta='"+ objeto.getCuenta().trim()+"'");
			if(resulmonto.next())
			{
			
				objeto.setTotal(resulmonto.getDouble("monto"));
				
			}
			ResultSet resultado = insql.executeQuery("select * from movimientos where cuenta='"+ objeto.getCuenta()+"' and fecha between '"+objeto.getFechaDesde()+"' and '"+objeto.getFechaHasta()+"'");
			while(resultado.next()){
				Usuario objeto1 = new Usuario();
				objeto1.setDescripcion(resultado.getString("descripcion"));
				objeto1.setMontoopera(resultado.getFloat("monto"));
				objeto1.setFechasoli(resultado.getDate("fecha"));
				listaContactos.add(objeto1);
				System.out.println(objeto1);
				
		}
		
	}catch (Exception e) {
		
		e.printStackTrace();
	}
	return listaContactos;
	}}

		
		