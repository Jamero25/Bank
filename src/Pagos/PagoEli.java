package Pagos;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Loguearse.Usuario;

/**
 * Servlet implementation class PagoEli
 */
@WebServlet("/PagoEli")
public class PagoEli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagoEli() {
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
		
		
		RequestDispatcher parche;
		
		String alias = request.getParameter("seleccion");
		String nombre = request.getParameter("nombre");
		String cuenta = request.getParameter("cuenta");
		
		Usuario objeto = new Usuario();
		objeto.setAlias(alias);
		objeto.setNombre(nombre);
		objeto.setCuenta(cuenta);
		boolean esValido = false;
		try{
			esValido = QuitarPago.PagoActualiza(objeto);
		}
		catch(Exception e)
		{}
		if(esValido){
			
			parche = getServletContext().getRequestDispatcher("/Pagoborrado.jsp");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("Usuario", objeto);
			parche.forward(request, response);
		}
		
		
	}

}
