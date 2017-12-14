package be.vdab.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.vdab.entities.Bestelregel;
import be.vdab.entities.Mandje;
import be.vdab.entities.Wijn;
import be.vdab.services.WijnService;

/**
 * Servlet implementation class WijnToevoegenServlet
 */
@WebServlet("/wijntoevoegen.htm")
public class WijnToevoegenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW ="/WEB-INF/JSP/wijntoevoegen.jsp";
	private final transient WijnService wService = new WijnService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("wijnid")!=null) {
		int wijnid = Integer.valueOf(request.getParameter("wijnid"));
		request.setAttribute("wijn", wService.getWijnMetId(wijnid));
	}
		
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String aantal = request.getParameter("flessen");
		int aantalInt;
		try {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
			aantalInt = Integer.valueOf(aantal);
			if(aantalInt < 1) {throw new NumberFormatException();}
			
			int wijnid = Integer.valueOf(request.getParameter("wijnid"));
			Bestelregel bblijn = new Bestelregel(aantalInt, wService.getWijnMetId(wijnid));
			
			//voeg bestellijn toe aan mandje en bewaar mandje als sessionAttribuut
			Mandje mandje;
			HttpSession session = request.getSession();
			if(session.getAttribute("mandje")==null) {
				mandje = new Mandje();				
			}else {
				mandje = (Mandje) session.getAttribute("mandje");
			}
			
			mandje.lijnToevoegen(bblijn);		
			session.setAttribute("mandje", mandje);
			
			response.sendRedirect(request.getContextPath());
			
			
		}catch(NumberFormatException ex) {
			request.setAttribute("fout", "een geheel getal groter dan 0");
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
		
		
	}

}
