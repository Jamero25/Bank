package Olvido;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;



import Loguearse.Usuario;

public class Cambiarlo {

	public static Boolean clavenueva(Usuario usuario) throws SQLException{
	     Connection miconexion=null; 
		Boolean esValido=false;
		String result = null;
		try {
			result = md5(usuario.getClavenueva().trim());
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
			insql.execute("update login set clave='"+result.trim()+"' where usuario='"+usuario.getUsuario().trim()+"'");
			insql.execute("update login set tipo='0' where usuario='"+usuario.getUsuario().trim()+"'");
			ResultSet resultado = insql.executeQuery("select * from login where usuario='" + usuario.getUsuario().trim()+"'");
			if (resultado.next()){
				usuario.setNombre(resultado.getString("nombre"));
				usuario.setCedula(resultado.getString("cedula"));
				ResultSet resul = insql.executeQuery("select * from  TTDAT where  cedula ='" + usuario.getCedula().trim()+"'");
				if(resul.next())
				{
				usuario.setCuenta(resul.getString("cuenta"));
				esValido=true;
				}
			}
		}catch(Exception e){}
		
		
		return esValido;
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