package Pagos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Loguearse.Seguridad;
import Loguearse.Usuario;

import com.sun.xml.internal.txw2.Document;

/**
 * Servlet implementation class Pagos
 */
@WebServlet("/Pagos")
public class Pagos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pagos() {
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
		String servicio = request.getParameter("servicio");
		String status = request.getParameter("status");
		String cuent= request.getParameter("cuenta");
		String nombre=request.getParameter("nombre");
		String Error= "";
		String servi="";
		String stat="";
		   
		if(servicio.equals("Todos"))
		{
			servi = "TODOS";
		System.out.println("Seleccionó todos");
		if(status.equals("Todos"))
		{
			stat="TODOS";
			System.out.println("Todo en default");
		}
		if(status.equals("solvente"))
		{
			stat="SOLVENTE";
			System.out.println("Todos solventes");
		}
		if(status.equals("pagar"))
		{
			stat="PAGAR";
			System.out.println("Todos por pagar");
		}
			
		}
		if(servicio.equals("cantv"))
		{
			servi="CANTV";
		if(status.equals("Todos"))
			{
			stat="TODOS";
				System.out.println("Cantv todos");
			}
			if(status.equals("solvente"))
			{
				stat="SOLVENTE";
				System.out.println("Cantv solventes");
			}
			if(status.equals("pagar"))
			{
				stat="PAGAR";
				System.out.println("Cantv por pagar");
			}
			
		}
		if(servicio.equals("electricidad"))
		{
			servi="LUZ";
		if(status.equals("Todos"))
			{
			stat="TODOS";
				System.out.println("electricidad todos");
			}
			if(status.equals("solvente"))
			{
				stat="SOLVENTE";
				System.out.println("electricidad solventes");
			}
			if(status.equals("pagar"))
			{
				stat="PAGAR";
				System.out.println("electricidad por pagar");
			}
			
		}	if(servicio.equals("gas"))
		{
			servi="GAS";
		if(status.equals("Todos"))
			{
			stat="TODOS";
				System.out.println("gas todos");
			}
			if(status.equals("solvente"))
			{
				stat="SOLVENTE";
				System.out.println("gas solventes");
			}
			if(status.equals("pagar"))
			{
				stat="PAGAR";
				System.out.println("gas por pagar");
			}
			
		}
		
		Usuario objeto = new Usuario();
		objeto.setServicio(servi);
		objeto.setStatus(stat);
		objeto.setCuenta(cuent);
		objeto.setNombre(nombre);
		LinkedList<Usuario> listaContactos = new LinkedList<Usuario>();

		
			try {
				listaContactos = Filtrado.UsuarioValido(objeto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		parche = getServletContext().getRequestDispatcher("/Pagos_agregar_ver.jsp");
		HttpSession sesion = request.getSession(true);
		sesion.setAttribute("Usuario", objeto);
		parche.forward(request, response);
		
	}

}
