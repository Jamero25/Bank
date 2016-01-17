package Mensaje;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Boton
 */
@WebServlet("/Boton")
public class Boton extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Boton() {
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
		
		boolean mensaje = false;
		System.out.println("PASO AL BOTON");
		RequestDispatcher parche;
		String dias= request.getParameter("dias");
		String cuenta = request.getParameter("cuenta");
		Datos datos = new Datos();
		datos.setDias(dias);
		datos.setCuenta(cuenta);
		mensaje = ConsultarPagos.Verifica(datos);
		
		//try {
			//mensaje = Enviar.EnviaMe();
		//} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		if(mensaje)
		{
			System.out.println("Se mando");
		}
		
	}

}
