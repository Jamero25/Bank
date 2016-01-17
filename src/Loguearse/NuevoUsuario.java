package Loguearse;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import Loguearse.Usuario;


public class NuevoUsuario {

	public static boolean Usuarios (Usuario usuario) throws SQLException{
		 Connection miconexion=null; 
		boolean esValido= false;

String result = null;
try {
	result = md5(usuario.getClave());
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
System.out.print(result);
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
			Statement insql = (Statement) miconexion.createStatement();
			System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
			ResultSet resultado = insql.executeQuery("select * from login where usuario='" + usuario.getUsuario().trim()+"'");
			if (resultado.next()){
				esValido=false;
			}else {
		      insql.execute("insert into login (usuario, clave, nombre, cedula, tipo) values ('"+usuario.getUsuario().trim()+"'"+",'"+result.trim()+"','"+usuario.getNombre().trim()+"','"+usuario.getCedula().trim()+"', '0')");
				esValido=true;
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
	
	public static String md5(String clear) throws Exception {
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    byte[] b = md.digest(clear.getBytes());
	    int size = b.length;
	    StringBuffer h = new StringBuffer(size);
	    //algoritmo y arreglo md5
	        for (int i = 0; i < size; i++) {
	            int u = b[i] & 255;
	                if (u < 16) {
	                    h.append("0" + Integer.toHexString(u));
	                }
	               else {
	                    h.append(Integer.toHexString(u));
	               }
	           }
	      //clave encriptada
	      return h.toString();
	    }
}
