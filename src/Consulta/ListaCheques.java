package Consulta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.mysql.jdbc.Statement;

import Loguearse.Usuario;

public class ListaCheques {

	public static LinkedList<Usuario>  UsuarioValido(Usuario objeto) throws SQLException{
	     Connection miconexion=null; 
	
		LinkedList<Usuario> listaContactos = new LinkedList<Usuario>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			miconexion = DriverManager.getConnection( "jdbc:mysql://localhost:3306/prueba", "root", "mero2511");
			Statement insql = (Statement) miconexion.createStatement();
			System.out.println( "Si he llegado hasta aquí es que se ha producido la conexión");
			ResultSet resultado = insql.executeQuery("select * from TTSOLIC where cuenta='"+ objeto.getCuenta()+"' and fechasoli between '"+objeto.getFechaDesde()+"' and '"+objeto.getFechaHasta()+"'");
		


			while(resultado.next()){
					Usuario objeto1 = new Usuario();
					objeto1.setBeneficiario(resultado.getString("beneficiario"));
					objeto1.setMonto(resultado.getFloat("monto"));
					objeto1.setFechasoli(resultado.getDate("fechasoli"));
					objeto1.setDescrip(resultado.getString("descripcion"));
					
					listaContactos.add(objeto1);
					System.out.println(objeto1);
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		return listaContactos;
		}}
