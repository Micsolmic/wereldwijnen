package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.repositories.LandenRepository;
import be.vdab.repositories.SoortenRepository;


@WebServlet("/index.htm")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "WEB-INF/JSP/index.jsp";
	public final transient LandenRepository lRepo = new LandenRepository();
	public final transient SoortenRepository sRepo = new SoortenRepository();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("land", lRepo.getLandmetId(1));
		request.getRequestDispatcher(VIEW).forward(request, response);
		
		
	}

}
