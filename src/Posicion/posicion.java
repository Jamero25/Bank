package Posicion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Loguearse.Usuario;

/**
 * Servlet implementation class posicion
 */
@WebServlet("/posicion")
public class posicion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public posicion() {
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
		String desde = request.getParameter("from");
		String hasta = request.getParameter("to");
		String fechaHoy="";
		String siete="";
		String dia, mes, annio;
		StringTokenizer tokens=new StringTokenizer(desde, "/");
		dia= tokens.nextToken();
		mes = tokens.nextToken();
		annio= tokens.nextToken();
		siete = (annio + "-" +mes+"-"+dia);
		System.out.println(siete);
		StringTokenizer tokenss=new StringTokenizer(hasta, "/");
		dia= tokenss.nextToken();
		mes = tokenss.nextToken();
		annio= tokenss.nextToken();
		fechaHoy = (annio+"-"+mes+"-"+dia);
		System.out.println(fechaHoy);
		
		Usuario objeto = new Usuario();
		objeto.setCuenta(cuenta);
		objeto.setNombre(nombre);
		objeto.setFechaDesde(siete);
		objeto.setFechaHasta(fechaHoy);
		LinkedList<Usuario> listaContactos = new LinkedList<Usuario>();
		try {
			listaContactos = Descripcion.DatosTransacciones(objeto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			parche = getServletContext().getRequestDispatcher("/Posicion.jsp");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("Usuario", objeto);
			parche.forward(request, response);
	
		
		
		
		
	}

}
