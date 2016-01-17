package Solicitud;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Statement;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeBodyPart;

import Loguearse.Usuario;

public class Cheque {
	 @SuppressWarnings("finally")
		
	/**
	 * @param args
	 */
	public static int SolicitudCheque (Usuario usuario) throws SQLException {
		// TODO Auto-generated method stub
		   Connection miconexion=null; 
		   
		   Calendar c2 = new GregorianCalendar();
			 
			String dia, mes, annio;
			dia = Integer.toString(c2.get(Calendar.DATE));
			mes = Integer.toString(c2.get(Calendar.MONTH) +1);
			annio = Integer.toString(c2.get(Calendar.YEAR));
			System.out.println(dia + "-" +mes + "-"+ annio);
	 		String fechaHoy= (annio + "-" +mes+"-"+dia);
		 int id = 0;
		 Random random = new Random();
			int ida = random.nextInt(9999);
			System.out.print(ida);
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
				Statement insql = (Statement) miconexion.createStatement();
				System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
				ResultSet verificar =  insql.executeQuery("Select * from ttaudisolic where cuenta='"+usuario.getCuenta().trim()+"' and beneficiario='"+usuario.getBeneficiario().trim()+"' and monto='"+usuario.getMonto()+"' and fecha='"+fechaHoy+"'");
				if(verificar.next())
				{
					id=1;
				}
				else{
					ResultSet comprobar = insql.executeQuery("select monto from ttcun where cuenta='"+usuario.getCuenta().trim()+"'");
					if(comprobar.next())
					{
						usuario.setSaldodisponible(comprobar.getFloat("monto"));
					}
					if(usuario.getSaldodisponible()>=usuario.getMonto())
					{
					
				insql.execute("insert into TTSOLIC (beneficiario, monto, cuenta, fechasoli, descripcion, id) values ('"+usuario.getBeneficiario().trim()+"'"+",'"+usuario.getMonto()+"','"+usuario.getCuenta().trim()+"','"+ fechaHoy+"','Solicitud Abierta','"+ida+"')");
				insql.execute("insert into ttaudisolic(cuenta, beneficiario, monto, fecha) values('"+usuario.getCuenta().trim()+"','"+usuario.getBeneficiario().trim()+"','"+usuario.getMonto()+"','"+fechaHoy+"')");
				insql.execute("insert into movimientos(cuenta, descripcion, monto, fecha) values('"+usuario.getCuenta()+"',' Solicitud Cheque: "+usuario.getBeneficiario()+"','"+usuario.getMonto()+"','"+fechaHoy+"')");
				id=2;  
				Statement consulta = (Statement) miconexion.createStatement();
				ResultSet resultado = consulta.executeQuery("select correo from ttdat where cuenta ='"+ usuario.getCuenta()+"'");
				while(resultado.next()){
					Usuario objeto = new Usuario();
					objeto.setCorreo(resultado.getString("correo"));
				try
		        {
		            // Propiedades de la conexión
		            Properties props = new Properties();
		            props.setProperty("mail.smtp.host", "smtp.gmail.com");
		            props.setProperty("mail.smtp.starttls.enable", "true");
		            props.setProperty("mail.smtp.port", "587");
		            props.setProperty("mail.smtp.user", "globalinbank@gmail.com");
		            props.setProperty("mail.smtp.auth", "true");
	System.out.println("Paso por el correo");
		            // Preparamos la sesion
		            Session session = Session.getDefaultInstance(props);
		            BodyPart texto = new javax.mail.internet.MimeBodyPart();
		            texto.setText("Estimado usuario su solicitud de Cheque de Gerencia ha sido emitida de manera satisfactoria.");
		            BodyPart adjunto = new javax.mail.internet.MimeBodyPart();
		            adjunto.setDataHandler(new DataHandler(new FileDataSource("C:\\Users/Usuario/Desktop/eclipse-jee-juno-SR1-win32-x86_64/eclipse/Test1.pdf")));
		            MimeMultipart multipart = new MimeMultipart();
		            multipart.addBodyPart(texto);
		            multipart.addBodyPart(adjunto);
		            
		            

		            // Construimos el mensaje
		            MimeMessage message = new MimeMessage(session);
		            message.setFrom(new InternetAddress("globalinbank@gmail.com"));
		            message.addRecipient(
		                Message.RecipientType.TO,
		                new InternetAddress(""+objeto.getCorreo()+""));
		            message.setSubject("Solicitud Cheque de Gerencia");
		            message.setText(
		                "Estimado usuario su solicitud de Cheque de Gerencia ha sido emitida de manera satisfactoria.");
		            message.setContent(multipart);

		            // Lo enviamos.
		            Transport t = session.getTransport("smtp");
		            t.connect("globalinbank@gmail.com", "usm1234usm1234");
		            t.sendMessage(message, message.getAllRecipients());

		            // Cierre.
		            t.close();
		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
		        }}
				
				
				}if(usuario.getSaldodisponible()<usuario.getMonto())
				{
					insql.execute("insert into TTSOLIC (beneficiario, monto, cuenta, fechasoli, descripcion) values ('"+usuario.getBeneficiario().trim()+"'"+",'"+usuario.getMonto()+"','"+usuario.getCuenta().trim()+"','"+ fechaHoy+"','Solicitud no procesada por monto insuficiente')");
					id=4;
				}
					
		 }
		 }
		 catch (Exception e) {
					
					e.printStackTrace();
				}
		 
		 finally{

		try {
		if(miconexion!=null && !miconexion.isClosed()){
		miconexion.close();
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return id;
		}
		}
		}
		 
	

	
