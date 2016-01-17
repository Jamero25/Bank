package Solicitud;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import Loguearse.Usuario;

/**
 * Servlet implementation class Imprimir
 */
@WebServlet("/Imprimir")
public class Imprimir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Imprimir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		RequestDispatcher parche;
		String Beneficiario = request.getParameter("Beneficiario");
		String Monto= request.getParameter("Monto");
		String cuenta= request.getParameter("cuenta");
		String Error= "";
		PDF.main(null);
		System.out.print("PASO POR AQUI" );
		DatosImprimir objeto = new DatosImprimir();
		objeto.setBeneficiario(Beneficiario);
		objeto.setMonto(Monto);
		objeto.setCuenta(cuenta);
		boolean esValido = false;
		try {
			esValido = ImprimirClass.imprimircla(objeto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(esValido)
		{
			  try {
	        	     File path = new File("C:\\Users/Usuario/Desktop/eclipse-jee-juno-SR1-win32-x86_64/eclipse/Test1.pdf");
	        	    Desktop.getDesktop().open(path);
	        	  
	        	   Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"Test1.pdf");
	        	     System.out.println("Final");
	        	     
	        	 	parche = getServletContext().getRequestDispatcher("/SolicitudOk.jsp");
	        		HttpSession sesion = request.getSession(true);
	        		sesion.setAttribute("Usuarios", objeto);
	        		parche.forward(request, response);
	        	}catch (IOException ex) {
	        	     ex.printStackTrace();
	        	
		}
		
	
		} 
		
		
	}}


