package Transferencias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import Loguearse.Usuario;

import com.mysql.jdbc.Statement;



public class VerificaCuenta {
	
	public static int Verificacion(Usuario datos) throws SQLException{
		Connection miconexion=null; 
		int id = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
			Statement insql = (Statement) miconexion.createStatement();
			System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
			ResultSet resultado = insql.executeQuery("select * from ttdat where cuenta='" + datos.getCuentabene().trim()+"'");
			if (resultado.next()){
				
				ResultSet resul = insql.executeQuery("select * from tttransfer where cuentaorigen='"+datos.getCuenta().trim()+"' and cuentadestino='"+datos.getCuentabene().trim()+"' or alias ='"+datos.getAlias().trim()+"'");
				if (resul.next())
				{
					id=1;
				}else{
				id=100;
				insql.execute("insert into tttransfer(cuentaorigen, cuentadestino, alias) value('"+datos.getCuenta().trim()+"','"+datos.getCuentabene().trim()+"','"+datos.getAlias().trim()+"')");

              
			}}else{
				id=2;
			}
		}catch(Exception e)
		{}
			
		
		return id;

}
}
