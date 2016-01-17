package Transferencias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

import Loguearse.Usuario;

public class ListaTransferencias {
	public static boolean ListarUsuario(Usuario usuario) throws SQLException{
		 Connection miconexion=null; 
		boolean esValido= false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
			Statement insql = (Statement) miconexion.createStatement();
			System.out.println( "CONEXION CON REGISTRO");
			ResultSet resultado = insql.executeQuery("select * from TTDAT where cuenta='" + usuario.getCuentabene().trim()+"'");
			if (resultado.next())
			{
				usuario.setBeneficiario(resultado.getString("nombre"));
				usuario.setCedulabene(resultado.getString("cedula"));
				esValido= true;
			}
			}catch(Exception e){}
	return esValido;		
}
}
