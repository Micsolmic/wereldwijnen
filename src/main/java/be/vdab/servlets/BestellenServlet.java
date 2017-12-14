package be.vdab.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Bestelbon;
import be.vdab.entities.Bestelregel;
import be.vdab.entities.Mandje;
import be.vdab.filters.JPAFilter;
import be.vdab.services.BestelbonService;
import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.Bestelbonlijn;

/**
 * Servlet implementation class BestellenServlet
 */
@WebServlet("/bestellen.htm")
public class BestellenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/bestellen.jsp";
	private final BestelbonService bbService = new BestelbonService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mandje mandje = (Mandje) request.getSession().getAttribute("mandje");
		request.setAttribute("mandje", mandje);	
		request.setAttribute("mandjeTotaal", mandje.berekenTotaal());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Mandje mandje = (Mandje) request.getSession().getAttribute("mandje");
		request.setAttribute("mandje", mandje);	
		request.setAttribute("mandjeTotaal", mandje.berekenTotaal());
	
		
		
		Map<String,String> fouten = new HashMap<>();
		
		if(request.getParameter("naam") == null || request.getParameter("naam").isEmpty()) {
			fouten.put("naam", " verplicht");			
		}
		if(request.getParameter("straat") == null || request.getParameter("straat").isEmpty()) {
			fouten.put("straat", " verplicht");			
		}
		
		try {			
			int huisnummer = Integer.valueOf(request.getParameter("huisnummer"));	
			if(huisnummer < 1) {throw new NumberFormatException();}
						
		}catch(NumberFormatException ex) {
			fouten.put("huisnummer", " positief getal");			
		}
		
		try {			
			int postcode = Integer.valueOf(request.getParameter("postcode"));	
			if(postcode < 1000 || postcode > 9999) {throw new NumberFormatException();}
						
		}catch(NumberFormatException ex) {
			fouten.put("postcode", " 4 cijfers");			
		}		
		
		if(request.getParameter("gemeente") == null || request.getParameter("gemeente").isEmpty()) {
			fouten.put("gemeente", " verplicht");			
		}
		
		if(!fouten.isEmpty()) {
			
			request.setAttribute("fouten", fouten);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}else {
			
			String naam = request.getParameter("naam");
			String straat = request.getParameter("straat");
			String huisnummer = request.getParameter("huisnummer");
			String postcode = request.getParameter("postcode");
			String gemeente = request.getParameter("gemeente");
			int bestelwijze = Integer.valueOf(request.getParameter("bestelwijze"));
			Adres adres = new Adres(straat, huisnummer, postcode, gemeente);
			
			Bestelbon bb = new Bestelbon(naam, adres, bestelwijze);
			bbService.createBestelbon(bb);
			int bonid = bb.getId();				
		    bbService.voegBestelbonlijnenAanDB(mandje, bb);
			
		    request.getSession().removeAttribute("mandje");
			
			response.sendRedirect(request.getContextPath()+"/succes.htm?bestelbon="+bonid);
			
			
			
		}
		
		
	}

}
