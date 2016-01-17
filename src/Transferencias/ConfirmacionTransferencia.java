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
 * Servlet implementation class ConfirmacionTransferencia
 */
@WebServlet("/ConfirmacionTransferencia")
public class ConfirmacionTransferencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmacionTransferencia() {
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
		String cuentabene = request.getParameter("cuentabeneficiario");
		String cedulabene = request.getParameter("cedulabene");
		String beneficiario = request.getParameter("beneficiario");
		String monto = request.getParameter("montotransferir");
		String claveseguridad = request.getParameter("claveespecial");
		float variable;
		variable = Float.parseFloat(monto);
		Usuario objeto = new Usuario();
		objeto.setCuenta(cuenta);
		objeto.setNombre(nombre);
		objeto.setCuentabene(cuentabene);
		objeto.setCedulabene(cedulabene);
		objeto.setBeneficiario(beneficiario);
		objeto.setMontotransfe(variable);
		objeto.setClaveespecial(claveseguridad);
		boolean Realizar = false;
		try {
			Realizar = RealizarTransferencia.GuardarTransf(objeto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Realizar)
		{
			parche = getServletContext().getRequestDispatcher("/Transferencia_ok.jsp");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("Usuario", objeto);
			parche.forward(request, response);
			
		}else{
			String mensaje ="Estimado usuario ocurrió un error al momento de generar su transacción";
			objeto.setMensaje(mensaje);
			parche = getServletContext().getRequestDispatcher("/ErrorProceso.jsp");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("Usuario", objeto);
			parche.forward(request, response);
			
		}
		
		
	}

}
