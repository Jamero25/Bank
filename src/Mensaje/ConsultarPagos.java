package Mensaje;

import giovynet.serial.Baud;
import giovynet.serial.Com;
import giovynet.serial.Parameters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import Loguearse.Usuario;

import com.mysql.jdbc.Statement;

public class ConsultarPagos {
	
	
	public static boolean Verifica(Datos datos)
	{
		Com settings = null;
		 Connection miconexion=null; 
		 Calendar c2 = new GregorianCalendar();
		 
			String dia, mes, annio;
			dia = Integer.toString(c2.get(Calendar.DATE));
			mes = Integer.toString(c2.get(Calendar.MONTH) +1);
			annio = Integer.toString(c2.get(Calendar.YEAR));
			System.out.println(dia + "-" +mes + "-"+ annio);
	 		String fechaHoy= (annio + "-" +mes+"-"+dia);
	 		String cuenta = "Esta es la cuenta";
			boolean esValido= false;
			LinkedList<Datos> listaContactos = new LinkedList<Datos>();
			settings = conectarpuerto();
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
			Statement insql =(Statement) miconexion.createStatement();
			System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
			ResultSet resultado = insql.executeQuery("select sum(monto), cuenta from ttsaldo where fechasoli='" + datos.getDias()+"' group by cuenta;");
			//ResultSet resultado = insql.executeQuery("select * from ttsaldo where fechasoli='"+datos.getDias()+"'");
			while(resultado.next()){
				Datos objeto1 = new Datos();
				objeto1.setMontototal(resultado.getDouble("sum(monto)"));
				objeto1.setCuentaconsulta(resultado.getString("cuenta"));
				listaContactos.add(objeto1);
			}
			for(int i=0; i<listaContactos.size(); i++)
			{
			
			ResultSet result = insql.executeQuery("select * from ttcun where cuenta='"+listaContactos.get(i).getCuentaconsulta()+"'");
			if(result.next()){
			datos.setDisponible(result.getDouble("monto"));
			}
			ResultSet resu = insql.executeQuery("select * from ttdat where cuenta='"+listaContactos.get(i).getCuentaconsulta()+"'");
			if(resu.next())
			{
				datos.setNumero(resu.getString("numero"));
			}
			if(datos.getDisponible()>listaContactos.get(i).getMontototal()){
				
				insql.execute("insert into audisms(telefono, fecha, descripcion, cuenta) values ('"+datos.getNumero().trim()+"','"+fechaHoy.trim()+"','Pagos descontados','"+listaContactos.get(i).getCuentaconsulta().trim()+"')");
				insql.execute("insert into smstrigger(cuenta, monto, fecha) values('"+listaContactos.get(i).getCuentaconsulta().trim()+"','"+listaContactos.get(i).getMontototal()+"','"+fechaHoy.trim()+"')");

				String mensaje ="Estimado Usuario, GIBANK le informa que los pagos de sus servicios han sido descontados";
				enviarmensaje(mensaje, datos.getNumero(), settings);
				try{
					Thread.sleep(5000);
					}catch(Exception ex){
					ex.printStackTrace();
					}
				/*try {
					Parameters settings = new Parameters();
					settings.setPort("COM3");
					settings.setBaudRate(Baud._1200);
					settings.setMinDelayWrite(10);
					Com com3 = new Com(settings);
					Character enter=13;
					com3.sendString("AT");
					com3.sendString("AT+CMGF=1");
					com3.sendString(enter.toString());
					  com3.sendString("AT+CMGS=\""+datos.getNumero().trim()+"\"");
					//com3.sendString("AT+CGMS=\""+datos.getNumero().trim()+"\"");
					//com3.sendString("AT+CMGS=\"+584129043281\"");
					com3.sendString(enter.toString());
					com3.sendString(mensaje+'\u001a');
					//com3.sendString("Estimado Usuario le recordamos que el descuento de su pago se ha efectuado satisfactoriamente"+'\u001a');
					com3.close();
					esValido= true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
			}
			if(datos.getDisponible()<datos.getMontototal()){
				String mensaje ="Estimado Usuario su monto no es suficiente";
				insql.execute("insert into audisms(telefono, fecha, descripcion, cuenta) values ('"+datos.getNumero().trim()+"','"+fechaHoy.trim()+"','Servicios sin pagar','"+listaContactos.get(i).getCuentaconsulta().trim()+"')");
				
				enviarmensaje(mensaje, datos.getNumero(), settings);
				try{
					Thread.sleep(5000);
					}catch(Exception ex){
					ex.printStackTrace();
					}
				/*try {
					Parameters settings = new Parameters();
					settings.setPort("COM3");
					settings.setBaudRate(Baud._1200);
					settings.setMinDelayWrite(10);
					Com com3 = new Com(settings);
					Character enter=13;
				com3.sendString("AT");
					com3.sendString("AT+CMGF=1");
					com3.sendString(enter.toString());
					com3.sendString("AT+CGMS=\""+datos.getNumero()+"\"");
					//com3.sendString("AT+CMGS=\"+584129043281\"");
					com3.sendString(enter.toString());
					com3.sendString(mensaje+'\u001a');
					//com3.sendString("Estimado Usuario le recordamos que el descuento de su pago se ha efectuado satisfactoriamente"+'\u001a');
					com3.close();
					esValido= true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
			}
		}}catch(Exception e){}
		try {
			settings.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esValido;
	}
		
	private static Com conectarpuerto() {
		Parameters settings = null;
		Com com3 =null;
		try {
			settings = new Parameters();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		settings.setPort("COM3");
		settings.setBaudRate(Baud._1200);
		settings.setMinDelayWrite(10);
		try {
			com3 = new Com(settings);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return com3;
		
	}




	private static void enviarmensaje(String mensaje, String numero, Com com3) {
	
		try {
			
			Character enter=13;
			com3.sendString("AT");
			com3.sendString("AT+CMGF=1");
			com3.sendString(enter.toString());
			  com3.sendString("AT+CMGS=\""+numero+"\"");
			//com3.sendString("AT+CGMS=\""+datos.getNumero().trim()+"\"");
			//com3.sendString("AT+CMGS=\"+584129043281\"");
			com3.sendString(enter.toString());
			com3.sendString(mensaje+'\u001a');
			//com3.sendString("Estimado Usuario le recordamos que el descuento de su pago se ha efectuado satisfactoriamente"+'\u001a');
			//com3.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
