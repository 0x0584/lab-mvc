package Ctrl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DbProduit;
import Metier.Produit;

@WebServlet(name = "Insert", urlPatterns = { "/Insert" })
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Insert() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			DbProduit.addProduit(new Produit(null, request
					.getParameter("design"), Float.parseFloat(request
					.getParameter("prix")), Integer.parseInt(request
					.getParameter("qte"))));
			response.sendRedirect("index.jsp");
		} catch (NumberFormatException | SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			response.getWriter().println(e.getMessage());
		}
	}

}
