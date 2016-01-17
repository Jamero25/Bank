package Auditoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;



public class Incluir {

	public static Boolean nuevoCliente (Clientes usuario) throws SQLException {
		Connection miconexion=null; 
		boolean esValido= false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
			Statement insql = (Statement) miconexion.createStatement();
			System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
			insql.execute("insert into ttdat(tarjeta, clave, cedula, codigo, cuenta, nombre, correo, numero, claveseguridad) values('"+usuario.getTarjeta().trim()+"','"+usuario.getClave()+"','"+usuario.getCedula().trim()+"','"+usuario.getCodigo().trim()+"','"+usuario.getCuenta().trim()+"','"+usuario.getNombre().trim()+"','"+usuario.getCorreo().trim()+"','"+usuario.getNumero().trim()+"','"+usuario.getEspecial().trim()+"')");
			insql.execute("insert into ttcun(cuenta, monto) values('"+usuario.getCuenta().trim()+"','"+usuario.getMonto()+"')");
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
