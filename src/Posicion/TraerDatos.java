package Posicion;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Loguearse.Seguridad;
import Loguearse.Usuario;

/**
 * Servlet implementation class TraerDatos
 */
@WebServlet("/TraerDatos")
public class TraerDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraerDatos() {
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
		String nombre = request.getParameter("nombre");
		String cuenta = request.getParameter("cuenta");
		
		Usuario objeto = new Usuario();
		objeto.setCuenta(cuenta);
		objeto.setNombre(nombre);
		boolean esValido = false;
		try {
			esValido = Cuentaymonto.montos(objeto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(esValido)
		{
			parche = getServletContext().getRequestDispatcher("/Posicion.jsp");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("Usuario", objeto);
			parche.forward(request, response);
		}
		
	}

}
