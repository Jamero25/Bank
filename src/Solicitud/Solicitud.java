package Solicitud;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

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
 * Servlet implementation class Solicitud
 */
@WebServlet("/Solicitud")
public class Solicitud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Solicitud() {
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
				String Beneficiario = request.getParameter("Beneficiario");
				String monto= request.getParameter("Monto");
				String cuenta= request.getParameter("cuenta");
				String nombre = request.getParameter("nombre");
				
				
				float variable;
				variable = Float.parseFloat(monto);
			
				Usuario objeto = new Usuario();
				objeto.setBeneficiario(Beneficiario);
				objeto.setMonto(variable);
				objeto.setCuenta(cuenta);
				objeto.setNombre(nombre);
				int id = 0;
				try {
				  	id = Cheque.SolicitudCheque(objeto);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(id==1){
					String mensaje ="Estimado usuario Usted ya realizó una misma solicitud con datos iguales, por favor verifique e intente de nuevo.";
					objeto.setMensaje(mensaje);
					parche = getServletContext().getRequestDispatcher("/ErrorProceso.jsp");
					HttpSession sesion = request.getSession(true);
					sesion.setAttribute("Usuario", objeto);
					parche.forward(request, response);
				}
				if(id==2){
				parche = getServletContext().getRequestDispatcher("/SolicitudOk.jsp");
				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("Usuario", objeto);
				parche.forward(request, response);
				}
				if(id==4){
					String mensaje ="Estimado usuario su solicitud no puede ser realizada, por favor verifique e intente de nuevo.";
					objeto.setMensaje(mensaje);
					parche = getServletContext().getRequestDispatcher("/ErrorProceso.jsp");
					HttpSession sesion = request.getSession(true);
					sesion.setAttribute("Usuario", objeto);
					parche.forward(request, response);
				}
				
	}

}
