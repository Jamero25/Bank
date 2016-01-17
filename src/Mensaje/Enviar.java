package Mensaje;

import giovynet.serial.Baud;
import giovynet.serial.Com;
import giovynet.serial.Parameters;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.PrintStream;
import java.util.Enumeration;


public class Enviar {

	public static boolean EnviaM()
	{
		boolean esValido= false;
		try{
			Enumeration<?> comports = CommPortIdentifier.getPortIdentifiers();
			CommPortIdentifier myCPI = null;
			PrintStream myPS;
			myCPI = (CommPortIdentifier) comports.nextElement();
			myCPI.getName().equals("COM3");
			CommPort puerto = myCPI.open("AT", 1000);
			
			System.out.println("Paso despues aqui");
			SerialPort mySP = (SerialPort) puerto;
			Character enter=13;
			myPS = new PrintStream(mySP.getOutputStream());
			myPS.print("AT");
			myPS.print(enter);
			myPS.print("AT+CMGF=1");
			myPS.print(enter);
			Character ctrlz=26;
		
			try{
				
				Thread.sleep(2000);}
			catch (Exception e){}
			myPS.print("AT+CMGS=\"+584129043282\"");
			myPS.print(enter);
			
			myPS.print("Mensaje de Prueba desde aqu");
			myPS.print(ctrlz);
			puerto.close();	
			esValido=true;
			System.out.print(myPS);

		}
		catch (Exception e){}
		
		return esValido;
		}
	
	
	@SuppressWarnings("deprecation")
	public static boolean EnviaMe() throws Exception
	{
		boolean esValido= false;
		try {
			Parameters settings = new Parameters();
			settings.setPort("COM3");
			settings.setBaudRate(Baud._1200);
			settings.setMinDelayWrite(10);
			Com com3 = new Com(settings);
			Character enter=13;
		com3.sendString("AT");
			com3.sendString("AT+CMGF=1");
			com3.sendString(enter.toString());
			com3.sendString("AT+CMGS=\"+584129043281\"");
			com3.sendString(enter.toString());
			com3.sendString("Estimado Usuario le recordamos que el descuento de su pago se ha efectuado satisfactoriamente"+'\u001a');
			com3.close();
			esValido= true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return esValido;
		
	}
}
