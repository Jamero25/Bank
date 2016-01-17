package Auditoria;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cambiarmonto
 */
@WebServlet("/cambiarmonto")
public class cambiarmonto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cambiarmonto() {
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
		float variable;
		variable = Float.parseFloat(monto);
		Clientes clientes = new Clientes();
		clientes.setCuenta(cuenta);
		clientes.setMonto(variable);
		boolean esValido = false;
		try {
			esValido = Modificar.ModificaSaldo(clientes);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(esValido){
		parche = getServletContext().getRequestDispatcher("/ModificarOk.jsp");
		parche.forward(request, response);
		}
}}