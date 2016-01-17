package Loguearse;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Incorpora
 */
@WebServlet("/Incorpora")
public class Incorpora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Incorpora() {
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
		String usuario= request.getParameter("usuario");
		String clave= request.getParameter("clave");
		String cedula = request.getParameter("cedula");
		String nombre = request.getParameter("nombre");
		String Error= "";
		Usuario objeto = new Usuario();
		objeto.setUsuario(usuario);
		objeto.setClave(clave);
		objeto.setCedula(cedula);
		objeto.setNombre(nombre);
		boolean esValido = false;
		try {
			esValido = NuevoUsuario.Usuarios(objeto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(esValido){
			parche = getServletContext().getRequestDispatcher("/Index.jsp");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("Usuario", objeto);
			parche.forward(request, response);
			}else 
			{
				objeto=null;
				Error = "Por favor introduzca los datos nuevamente";
				parche = getServletContext().getRequestDispatcher("/Registro.jsp");
				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("Error", Error);
				parche.forward(request, response);
			}
			
	}

	

}
