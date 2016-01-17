package Anulacion;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Loguearse.Usuario;

/**
 * Servlet implementation class anulacheque
 */
@WebServlet("/anulacheque")
public class anulacheque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public anulacheque() {
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
		String cuenta = request.getParameter("cuenta");
		String nombre = request.getParameter("nombre");
		Usuario objeto = new Usuario();
		objeto.setNombre(nombre);
		objeto.setCuenta(cuenta);
		LinkedList<Usuario> listacheques = new LinkedList<Usuario>();
		
		try{
			listacheques = BuscaCheques.Listado(objeto);
		}
		
		catch (Exception e){}
		
		System.out.println(listacheques);
		parche = getServletContext().getRequestDispatcher("/Anulacion_cheque.jsp");
		HttpSession sesion = request.getSession(true);
		sesion.setAttribute("Usuarios", objeto);
		parche.forward(request, response);
	}

}
