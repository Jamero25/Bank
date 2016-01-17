package Olvido;

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
 * Servlet implementation class Primera
 */
@WebServlet("/Primera")
public class Primera extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Primera() {
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
		String clave1= request.getParameter("contra1");
		String clave2= request.getParameter("contra2");
		String usuar = request.getParameter("usuario");
		
		if(clave1.equals(clave2))
		{
			Usuario objeto = new Usuario();
			objeto.setClavenueva(clave1);
			objeto.setUsuario(usuar);
			boolean esValido = false;
			try{
				esValido = Cambiarlo.clavenueva(objeto);
			}
			catch(Exception e){}
			if(esValido){
				parche = getServletContext().getRequestDispatcher("/Index.jsp");
				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("Usuario", objeto);
				parche.forward(request, response);
				
			}
		}else{
			
		}
		
		
	}

}
