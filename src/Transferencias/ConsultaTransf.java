package Transferencias;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Loguearse.Usuario;

/**
 * Servlet implementation class ConsultaTransf
 */
@WebServlet("/ConsultaTransf")
public class ConsultaTransf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaTransf() {
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
		String cuentabene = request.getParameter("combo");
		String nombre = request.getParameter("nombre");
		String cuenta = request.getParameter("cuenta");
		
		Usuario objeto = new Usuario();
		objeto.setCuentabene(cuentabene);
		objeto.setNombre(nombre);
		objeto.setCuenta(cuenta);
		boolean verificar = false;
		try {
			verificar = ListaTransferencias.ListarUsuario(objeto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(verificar)
		{
			parche = getServletContext().getRequestDispatcher("/Transferencia_listado.jsp");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("Usuario", objeto);
			parche.forward(request, response);
			
		}
		
	}

}
