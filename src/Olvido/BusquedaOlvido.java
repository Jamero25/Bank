package Olvido;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.mysql.jdbc.Statement;

import Loguearse.Usuario;

public class BusquedaOlvido {

	
	public static boolean Recuperacion(Usuario usuario) throws SQLException{
	     Connection miconexion=null; 
		boolean esValido= false;
		Random random = new Random();
		int ida = random.nextInt(99999);
		System.out.print(ida);
		String  provisional= "GIBANK"+ida;
		String result = null;
		try {
			result = md5(provisional);
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
			ResultSet resultado = insql.executeQuery("Select * from ttdat where tarjeta='"+usuario.getTarjeta().trim()+"' and clave ='"+usuario.getClave().trim()+"' and codigo='"+usuario.getCodigo().trim()+"'");
			if(resultado.next()){
				usuario.setCedula(resultado.getString("cedula"));
				usuario.setCorreo(resultado.getString("correo"));
				insql.execute("update login set clave='"+result.trim()+"' where cedula='"+usuario.getCedula().trim()+"'");
				insql.execute("Update login set tipo ='1' where cedula='"+usuario.getCedula().trim()+"'");
				
				
				try
		        {
		            // Propiedades de la conexión
		            Properties props = new Properties();
		            props.setProperty("mail.smtp.host", "smtp.gmail.com");
		            props.setProperty("mail.smtp.starttls.enable", "true");
		            props.setProperty("mail.smtp.port", "587");
		            props.setProperty("mail.smtp.user", "j.mero25@gmail.com");
		            props.setProperty("mail.smtp.auth", "true");
	System.out.println("Paso por el correo");
		            // Preparamos la sesion
		            Session session = Session.getDefaultInstance(props);
		     
		            // Construimos el mensaje
		            MimeMessage message = new MimeMessage(session);
		            message.setFrom(new InternetAddress("globalinbank@gmail.com"));
		            message.addRecipient(
		                Message.RecipientType.TO,
		                new InternetAddress(""+usuario.getCorreo()+""));
		            message.setSubject("Acceso Provisional al Portal de GIBANK");
		            message.setText(
		                "Estimado usuario atendiendo a su solicitud de olvido de clave, hemos generado una clave provisional la cuál deberá cambiar al ingresar al portal, su clave es :"+provisional.trim());
		            

		            // Lo enviamos.
		            Transport t = session.getTransport("smtp");
		           // t.connect("globalinbank@gmail.com", "usm1234usm1234");
		            t.connect("j.mero25@gmail.com", "mero19902511");
		            t.sendMessage(message, message.getAllRecipients());

		            // Cierre.
		            t.close();
		            esValido=true;
		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
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
