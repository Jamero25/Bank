package Consulta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Loguearse.Usuario;
import Pagos.Filtrado;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.StringTokenizer;


/**
 * Servlet implementation class Consulta
 */
@WebServlet("/Consulta")
public class Consulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consulta() {
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
		String seleccion = request.getParameter("rango");
		String cuent= request.getParameter("cuenta");
		String Error= "";
		String fechaHoy="";
		String siete="";
		String fechaHasta="";
		String desde = request.getParameter("from");
		String hasta = request.getParameter("to");
		
		
	if("reciente".equals(seleccion))
	{
	
		Calendar c2 = new GregorianCalendar();
		 
		String dia, mes, annio;
		dia = Integer.toString(c2.get(Calendar.DATE));
		mes = Integer.toString(c2.get(Calendar.MONTH) +1);
		annio = Integer.toString(c2.get(Calendar.YEAR));
		System.out.println(dia + "-" +mes + "-"+ annio);
 		fechaHoy= (annio + "-" +mes+"-"+dia);
		c2.add(Calendar.DATE, -7);
		dia = Integer.toString(c2.get(Calendar.DATE));
		mes = Integer.toString(c2.get(Calendar.MONTH) +1);
		annio = Integer.toString(c2.get(Calendar.YEAR));
		System.out.println(dia + "-" +mes + "-"+ annio);
		siete = (annio + "-" +mes+"-"+dia);
		System.out.println(fechaHoy);
		System.out.println(siete);
			
	}
		if("mes".equals(seleccion)){
			
			Calendar c2 = new GregorianCalendar();
			String dia, mes, annio;
			mes = Integer.toString(c2.get(Calendar.MONTH)+1);
			dia = Integer.toString(c2.getActualMinimum(Calendar.DAY_OF_MONTH));
			annio = Integer.toString(c2.get(Calendar.YEAR));
			System.out.println(dia+"-"+mes+"-"+annio);
			siete = (annio + "-"+ mes+"-"+dia);
			dia = Integer.toString(c2.getActualMaximum(Calendar.DAY_OF_MONTH));
			System.out.println(dia+"-"+mes+"-"+annio);
			fechaHoy = (annio+"-"+mes+"-"+dia);
			System.out.println(siete);
			System.out.println(fechaHoy);
			
		}
		if("formatos".equals(seleccion)){
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

		}
		
		Usuario objeto = new Usuario();
		objeto.setFechaDesde(siete);
		objeto.setFechaHasta(fechaHoy);
		objeto.setCuenta(cuent);
		LinkedList<Usuario> listaContactos = new LinkedList<Usuario>();
		try {
			listaContactos = ListaCheques.UsuarioValido(objeto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(listaContactos);
		parche = getServletContext().getRequestDispatcher("/Consulta_busqueda.jsp");
		HttpSession sesion = request.getSession(true);
		sesion.setAttribute("Usuarios", objeto);
		parche.forward(request, response);
	}

}
