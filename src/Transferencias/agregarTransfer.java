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

import Loguearse.Seguridad;
import Loguearse.Usuario;

/**
 * Servlet implementation class agregarTransfer
 */
@WebServlet("/agregarTransfer")
public class agregarTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public agregarTransfer() {
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
		String cuentabene = request.getParameter("cuentabene");
		String beneficiario= request.getParameter("beneficiario");
		String cedula = request.getParameter("cedula");
		String alias = request.getParameter("alias");
		String cuenta =  request.getParameter("cuenta");
		String nombre = request.getParameter("nombre");
		
		Usuario objeto = new Usuario();
		objeto.setCuentabene(cuentabene);
		objeto.setBeneficiario(beneficiario);
		objeto.setCedula(cedula);
		objeto.setAlias(alias);
		objeto.setCuenta(cuenta);
		objeto.setNombre(nombre);
		int id = 0;
		
		try {
			id = VerificaCuenta.Verificacion(objeto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(id==100)
		{
			parche = getServletContext().getRequestDispatcher("/AgregarTransfer_ok.jsp");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("Usuario", objeto);
			parche.forward(request, response);
		}
		if(id==2){
			String mensaje ="Estimado usuario el número de cuenta que usted ingresó no se encuentra asignada en nuestra entidad financiera, por favor verifique e intente nuevamente";
			objeto.setMensaje(mensaje);
			parche = getServletContext().getRequestDispatcher("/ErrorProceso.jsp");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("Usuario", objeto);
			parche.forward(request, response);
		}
		if(id==1){
			String mensaje ="Estimado usuario la cuenta o el alias que usted suminstró ya se encuentra registrado en el sistema, por favor verifique e intente de nuevo.";
			objeto.setMensaje(mensaje);
			parche = getServletContext().getRequestDispatcher("/ErrorProceso.jsp");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("Usuario", objeto);
			parche.forward(request, response);
		}
		
		
		
		
		
		
	}

}
