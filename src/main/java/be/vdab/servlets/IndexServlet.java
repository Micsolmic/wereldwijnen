package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.repositories.LandenRepository;
import be.vdab.repositories.SoortenRepository;
import be.vdab.services.LandenService;
import be.vdab.services.SoortenService;


@WebServlet("/index.htm")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "WEB-INF/JSP/index.jsp";
	public final transient LandenService lService = new LandenService();
	public final transient SoortenService sService = new SoortenService();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String landid = request.getParameter("landid");
		if(landid != null) {
			request.setAttribute("land", lService.getLandMetId(Integer.valueOf(landid)));			
		}
		String soortId = request.getParameter("soortid");
		if(soortId != null) {
		    request.setAttribute("gekozenSoort", sService.getSoortMetId(Integer.valueOf(soortId)));			
		}
		
		request.getRequestDispatcher(VIEW).forward(request, response);
		
		
	}

}
