package Pagos;

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
import Solicitud.Cheque;

/**
 * Servlet implementation class agregarpago
 */
@WebServlet("/agregarpago")
public class agregarpago extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public agregarpago() {
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
		String contrato= request.getParameter("contrato");
		
		String beneficiario= request.getParameter("beneficiario");
		String cedula = request.getParameter("cedula");
		String alias = request.getParameter("alias");
		String cuenta = request.getParameter("cuenta");
		String servicio = request.getParameter("servicio");
		String dia= request.getParameter("dia");
		String nombre= request.getParameter("nombre");
		String serv ="";
		
		if(servicio.equals("2"))
		{
			serv ="CANTV";
		}
		if(servicio.equals("3"))
		{
			 serv ="LUZ";
		}
		if(servicio.equals("4"))
		{
		 serv ="GAS";
		}
		Usuario objeto = new Usuario();
		objeto.setAlias(alias);
		objeto.setContrato(contrato);
		objeto.setBenepago(beneficiario);
		objeto.setCedulabene(cedula);
		objeto.setCuenta(cuenta);
		objeto.setServipago(serv);
		objeto.setFechapago(dia);
		objeto.setNombre(nombre);
		
		int id = 0;
		try {
		  	id = pago.GuardarPago(objeto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(id==100){
		parche = getServletContext().getRequestDispatcher("/PagoOk.jsp");
		HttpSession sesion = request.getSession(true);
		sesion.setAttribute("Usuario", objeto);
		parche.forward(request, response);
	}
		if(id==1){
			String mensaje ="Estimado usuario el número de contrato que usted suministró no se encuentra aplicado a ningún servicio existente en el país";
			objeto.setMensaje(mensaje);
			parche = getServletContext().getRequestDispatcher("/ErrorProceso.jsp");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("Usuario", objeto);
			parche.forward(request, response);
		}
		if(id==2){
			String mensaje ="Estimado usuario el servicio o el alias que asignó ya se encuentra registrado en el sistema, por favor verifique e intente nuevamente";
			objeto.setMensaje(mensaje);
			parche = getServletContext().getRequestDispatcher("/ErrorProceso.jsp");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("Usuario", objeto);
			parche.forward(request, response);
		}

}}
