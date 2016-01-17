package Solicitud;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Enviarcorreo {
	 public static void main(String[] args)
	    {
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
	            message.setFrom(new InternetAddress("j.mero25@gmail.com"));
	            message.addRecipient(
	                Message.RecipientType.TO,
	                new InternetAddress("j.mero25@gmail.com"));
	            message.setSubject("Hola");
	            message.setText(
	                "Mensajito con Java Mail" + "de los buenos." + "poque si");

	            // Lo enviamos.
	            Transport t = session.getTransport("smtp");
	            t.connect("j.mero25@gmail.com", "mero2511");
	            t.sendMessage(message, message.getAllRecipients());

	            // Cierre.
	            t.close();
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	}

