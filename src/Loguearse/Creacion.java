package Loguearse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Creacion {

	@SuppressWarnings("finally")
	public static boolean UsuarioCreacion(Usuario usuario) throws SQLException{
		 Connection miconexion=null; 
		boolean esValido= false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
			Statement insql = (Statement) miconexion.createStatement();
			System.out.println( "CONEXION CON REGISTRO");
			ResultSet resultado = insql.executeQuery("select * from TTDAT where tarjeta='" + usuario.getTarjeta().trim()+"'");
			if (resultado.next())
			{
			if (resultado.getString("clave").equals(usuario.getContra())) 
				{
				if(resultado.getString("cedula").equals(usuario.getCedula()))
					{
					if(resultado.getString("codigo").equals(usuario.getCodigo()))
						{
						usuario.setCuenta(resultado.getString("cuenta"));
						usuario.setNombre(resultado.getString("nombre"));
						ResultSet resul = insql.executeQuery("select * from login where cedula ='" + usuario.getCedula().trim()+"'");
						if(resul.next())
						{
							esValido=false;
						}
						else{
										esValido= true;
						}}
					}
			    }
			}
		
							
	
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
		
		 return esValido;
		}
		
	}
}

