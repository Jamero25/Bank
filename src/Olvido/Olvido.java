package Olvido;

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
 * Servlet implementation class Olvido
 */
@WebServlet("/Olvido")
public class Olvido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Olvido() {
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
		String tarjeta= request.getParameter("tarjeta");
		String clave= request.getParameter("contraseña");
		String codigo = request.getParameter("codigo");
		Usuario objeto = new Usuario();
		objeto.setTarjeta(tarjeta);
		objeto.setClave(clave);
		objeto.setCodigo(codigo);
		boolean esValido = false;
		try {
			esValido = BusquedaOlvido.Recuperacion(objeto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(esValido)
		{
			parche = getServletContext().getRequestDispatcher("/Cambio_Ok.jsp");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("Usuario", objeto);
			parche.forward(request, response);
		}
		
	}

}
