package Auditoria;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Autenauditor
 */
@WebServlet("/Autenauditor")
public class Autenauditor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autenauditor() {
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
		String usuario= request.getParameter("nombre");
		String clave= request.getParameter("contraseña");
		String Error= "";
		
		if(usuario.equals("ADMIN01") && clave.equals("admin"));
		{
			parche = getServletContext().getRequestDispatcher("/auditor.jsp");
			HttpSession sesion = request.getSession(true);
			parche.forward(request, response);
		}
	
	}

}
