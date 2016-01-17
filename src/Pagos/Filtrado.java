package Pagos;

import java.sql.Connection;
import Loguearse.Usuario;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;


import com.mysql.jdbc.Statement;

public class Filtrado {

	  @SuppressWarnings("finally")
		
	public static LinkedList<Usuario>  UsuarioValido(Usuario objeto) throws SQLException{
	     Connection miconexion=null; 
		boolean esValido= false;
		LinkedList<Usuario> listaContactos = new LinkedList<Usuario>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
			Statement insql = (Statement) miconexion.createStatement();
			System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
			ResultSet resultado = null;
			if (objeto.getServicio().equals("TODOS"))
						
			{
				if(objeto.getStatus().equals("TODOS"))
				{
					 resultado = insql.executeQuery("select * from TTSERV where cuenta='"+ objeto.getCuenta()+"'");
				}
				if(objeto.getStatus().equals("SOLVENTE"))
				{
					 resultado = insql.executeQuery("select * from TTSERV where stats=0 and cuenta='"+ objeto.getCuenta()+"'");
				}
				if(objeto.getStatus().equals("PAGAR"))
				{
					 resultado = insql.executeQuery("select * from TTSERV where stats=1 and cuenta='"+ objeto.getCuenta()+"'");
				}
			}
			if (objeto.getServicio().equals("CANTV"))
			{
				if(objeto.getStatus().equals("TODOS"))
				{
					 resultado = insql.executeQuery("select * from TTSERV where servicio = 'CANTV' and cuenta='"+ objeto.getCuenta()+"'");
				}
				if(objeto.getStatus().equals("SOLVENTE"))
				{
					 resultado = insql.executeQuery("select * from TTSERV where servicio = 'CANTV' and stats=0 and cuenta='"+ objeto.getCuenta()+"'");
				}
				if(objeto.getStatus().equals("PAGAR"))
				{
					 resultado = insql.executeQuery("select * from TTSERV where servicio = 'CANTV' and stats=1 and cuenta='"+ objeto.getCuenta()+"'");
				}
			}
			if (objeto.getServicio().equals("LUZ"))
			{
				if(objeto.getStatus().equals("TODOS"))
				{
					 resultado = insql.executeQuery("select * from TTSERV where servicio = 'LUZ' and cuenta='"+ objeto.getCuenta()+"'");
				}
				if(objeto.getStatus().equals("SOLVENTE"))
				{
					 resultado = insql.executeQuery("select * from TTSERV where servicio = 'LUZ' and stats=0 and cuenta='"+ objeto.getCuenta()+"'");
				}
				if(objeto.getStatus().equals("PAGAR"))
				{
					 resultado = insql.executeQuery("select * from TTSERV where servicio = 'LUZ' and stats=1 and cuenta='"+ objeto.getCuenta()+"'");
				}
			}
			if (objeto.getServicio().equals("GAS"))
			{
				if(objeto.getStatus().equals("TODOS"))
				{
					 resultado = insql.executeQuery("select * from TTSERV where servicio = 'GAS' and cuenta='"+ objeto.getCuenta()+"'");
				}
				if(objeto.getStatus().equals("SOLVENTE"))
				{
					 resultado = insql.executeQuery("select * from TTSERV where servicio = 'GAS' and stats=0 and cuenta='"+ objeto.getCuenta()+"'");
				}
				if(objeto.getStatus().equals("PAGAR"))
				{
				 resultado = insql.executeQuery("select * from TTSERV where servicio = 'GAS' and stats=1 and cuenta='"+ objeto.getCuenta()+"'");
				}
			}
			
			
			
			while(resultado.next()){
					Usuario objeto1 = new Usuario();
					objeto1.setAlias(resultado.getString("alias"));
					objeto1.setServicio(resultado.getString("servicio"));
					objeto1.setStats(resultado.getBoolean("stats"));
					listaContactos.add(objeto1);
			}
			System.out.println("Esto es lo que da"+ listaContactos);
	} catch (Exception e) {
							
								e.printStackTrace();
							}finally{
		
		try {
			if(miconexion!=null && !miconexion.isClosed()){
				miconexion.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
		
		return listaContactos;
		
	}
}
	
	            
	        
	    
	

