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

import sun.applet.Main;




/**
 * Servlet implementation class Autenticacion
 */
@WebServlet("/Autenticacion")
public class Autenticacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
     
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autenticacion() {
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
		String usuario= request.getParameter("nombre");
		String clave= request.getParameter("contraseña");
		String Error= "";
		
	
		
		
		
		if (usuario!=null && !usuario.equalsIgnoreCase("") &&  clave !=null && !clave.equalsIgnoreCase(""))
				{
			Usuario objeto = new Usuario();
			objeto.setUsuario(usuario);
			objeto.setClave(clave);
			int id = 1;
			try {
				id = Seguridad.UsuarioValido(objeto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(id==2){
			parche = getServletContext().getRequestDispatcher("/Index.jsp");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("Usuario", objeto);
			parche.forward(request, response);
			}if(id==1)
			{
				objeto=null;
				Error = "El usuario no existe o uno de los datos es incorrecto, verifique e intente de nuevo";
				parche = getServletContext().getRequestDispatcher("/Error.jsp");
				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("Error", Error);
				parche.forward(request, response);
			}if(id==3)
			{
		
				parche = getServletContext().getRequestDispatcher("/CambioClave.jsp");
				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("Usuario", objeto);
				parche.forward(request, response);
			}
			
			
				}else{
					Error = "No se especificarion los datos del usuario";
					parche = getServletContext().getRequestDispatcher("/Error.jsp");
					HttpSession sesion = request.getSession(true);
					sesion.setAttribute("Error", Error);
					parche.forward(request, response);
				}
	
	}

}
