package Solicitud;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Imprimir2
 */
@WebServlet("/Imprimir2")
public class Imprimir2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Imprimir2() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			try
			{
			    String nFile = "C:\\Users/Usuario/Desktop/eclipse-jee-juno-SR1-win32-x86_64/eclipse/Test1.pdf";		
			   FileInputStream archivo = new FileInputStream(nFile); 
			  int longitud = archivo.available();
			   byte[] datos = new byte[longitud];
			    archivo.read(datos);
			   // archivo.close();
			    
			    response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition","attachment;filename="+nFile);    
			    
			   ServletOutputStream ouputStream = response.getOutputStream();
			    ouputStream.write(datos);
			    ouputStream.flush();
			   ouputStream.close();
			    	
			}
			catch(Exception e)
			{ 
			    e.printStackTrace();
			}  
		
	
		} 
		
		
	}}


