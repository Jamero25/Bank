package Auditoria;

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
 * Servlet implementation class agregar
 */
@WebServlet("/agregar")
public class agregar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public agregar() {
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
		String cuenta= request.getParameter("cuenta");
		String monto= request.getParameter("monto");
		String tarjeta= request.getParameter("tarjeta");
		String clave= request.getParameter("clave");
		String cedula= request.getParameter("cedula");
		String nombre= request.getParameter("nombre");
		String correo= request.getParameter("correo");
		String numero= request.getParameter("numero");
		String codigo = request.getParameter("codigo");
		String especial = request.getParameter("claveespecial");
		float variable;
		variable = Float.parseFloat(monto);
		Clientes clientes = new Clientes();
		clientes.setCuenta(cuenta);
		clientes.setMonto(variable);
		clientes.setTarjeta(tarjeta);
		clientes.setClave(clave);
		clientes.setCedula(cedula);
		clientes.setNombre(nombre);
		clientes.setCorreo(correo);
		clientes.setNumero(numero);
		clientes.setCodigo(codigo);
		clientes.setEspecial(especial);
		boolean esValido = false;
		try {
			esValido = Incluir.nuevoCliente(clientes);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(esValido){
		parche = getServletContext().getRequestDispatcher("/AceptarOk.jsp");
		parche.forward(request, response);
		}
	}}