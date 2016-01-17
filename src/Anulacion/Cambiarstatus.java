package Anulacion;

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
 * Servlet implementation class Cambiarstatus
 */
@WebServlet("/Cambiarstatus")
public class Cambiarstatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cambiarstatus() {
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
		String id = request.getParameter("seleccion");
		String nombre = request.getParameter("nombre");
		String cuenta = request.getParameter("cuenta");
		int idche= Integer.parseInt(id);
		Usuario objeto = new Usuario();
		objeto.setId(id);
		objeto.setIdcheque(idche);
		objeto.setNombre(nombre);
		objeto.setCuenta(cuenta);
		Boolean esValido = false;
		try{
		esValido = CambiarDescri.Cambia(objeto);
		}catch(Exception e){}
		if(esValido){
			parche = getServletContext().getRequestDispatcher("/Anulacion_ok.jsp");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("Usuarios", objeto);
			parche.forward(request, response);
		}
		
	}

}
