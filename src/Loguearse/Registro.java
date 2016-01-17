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
 * Servlet implementation class Registro
 */
@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
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
		String cuenta = request.getParameter("tarjeta");
		String contraseña = request.getParameter("contraseña");
		String cedula = request.getParameter("cedula");
		String codigo = request.getParameter("codigo");
		String Error= "";
		Usuario objeto = new Usuario();
		objeto.setTarjeta(cuenta);
		objeto.setContra(contraseña);
		objeto.setCedula(cedula);
		objeto.setCodigo(codigo);
		boolean aceptado = false;
		try {
			aceptado = Creacion.UsuarioCreacion(objeto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(aceptado){
			parche = getServletContext().getRequestDispatcher("/Registro.jsp");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("Usuario", objeto);
			parche.forward(request, response);
			}else 
			{
				objeto=null;
				Error = "Los datos que suminstró no son correctos o ya se encuentra registrado en el sistema, verifique e intente de nuevo";
				parche = getServletContext().getRequestDispatcher("/Error.jsp");
				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("Error", Error);
				parche.forward(request, response);
			}
		
		
		
	}

}
