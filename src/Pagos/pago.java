package Pagos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

import Loguearse.Usuario;

import com.mysql.jdbc.Statement;



public class pago {
	@SuppressWarnings("finally")
	public static int GuardarPago (Usuario objeto) throws SQLException {
		
		// TODO Auto-generated method stub
		 Connection miconexion=null;
		 int id = 0;
		 Random random = new Random();
			int ida = random.nextInt(999);
			System.out.print(ida);
		 DecimalFormat df = new DecimalFormat("0.00");
		 Locale locale = new Locale("es","VE");
		 NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		 nf.format(ida);
		 System.out.print(ida);
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
				Statement insql = (Statement) miconexion.createStatement();
				System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
				ResultSet resultado = insql.executeQuery("select * from contratos where contrato='"+objeto.getContrato().trim()+"'");
				if(resultado.next())
				{
					ResultSet resul = insql.executeQuery("select * from TTSERV where contrato='"+objeto.getContrato().trim()+"' or alias='"+objeto.getAlias().trim()+"'");
					if(resul.next())
					{
						id=2;
					}
					else{
				insql.execute("insert into TTSERV (alias, servicio, stats, cuenta, fechasoli, contrato) values ('"+objeto.getAlias().trim()+"'"+",'"+objeto.getServipago().trim()+"','1','"+ objeto.getCuenta().trim()+"','"+objeto.getFechapago().toString()+"','"+objeto.getContrato().trim()+"')");
				insql.execute("insert into ttsaldo(contrato, monto, cuenta, fechasoli) value('"+objeto.getContrato().trim()+"','"+ida+"','"+objeto.getCuenta().trim()+"','"+objeto.getFechapago().toString()+"')");
				id=100;
				}}
				else{
					id=1;
				}
		 }catch (Exception e) {
				
				e.printStackTrace();
			}finally{

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
