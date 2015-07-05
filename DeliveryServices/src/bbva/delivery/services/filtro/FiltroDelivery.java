package bbva.delivery.services.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FiltroDelivery implements Filter {

	
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");
	}

	
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		String requestURI = request.getRequestURI();
		
		if(requestURI.equals("/PORTALWEB/mapa")|| requestURI.equals("/PORTALWEB/mapa/")){
        	String toReplace = "/html-commons/mapa-pivotal.jsp";
            req.getRequestDispatcher(toReplace).forward(req, res);
            System.out.println("***"+toReplace);
		}else if(requestURI.equals("/PORTALWEB/reclamos")|| requestURI.equals("/PORTALWEB/reclamos/")){
        	String toReplace = "/jsp/externo/reclamosexternos.jsp";
            req.getRequestDispatcher(toReplace).forward(req, res);
            System.out.println("***"+toReplace);
		}else{
			System.out.println("doFilter");
			chain.doFilter(req, res);			
		}
	}

//	private void registerCharacterEncodingFilter(ServletContext servletContext) {
//	    CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
//	    encodingFilter.setEncoding("UTF-8");
//	    encodingFilter.setForceEncoding(true);
//	    FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", encodingFilter);
//	    characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
//	}
//	
	
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}

}
