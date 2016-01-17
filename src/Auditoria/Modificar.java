package Auditoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Modificar {

	


public static Boolean ModificaSaldo (Clientes usuario) throws SQLException {
	Connection miconexion=null; 
	boolean esValido= false;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
		Statement insql = (Statement) miconexion.createStatement();
		System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
		insql.execute("update ttcun set monto='"+usuario.getMonto()+"' where cuenta='"+usuario.getCuenta().trim()+"';");
		esValido=true;
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
