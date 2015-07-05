package bbva.delivery.services.secure;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

public class AuthenticationTokenProcessingFilter extends GenericFilterBean {

	private final static String USERNAME = "USERNAME";
	private final static String PASSWORD = "PASSWORD";
	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	
	private final static String CODIGO_TRX_ERROR_AUTH = "1"; 
    private final static String MENSAJE_TRX_ERROR_AUTH = "No se envía datos de Autenticación";
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException  {
		
		String authorization = null;

        try {
	        HttpServletRequest h = (HttpServletRequest) request;
	        System.out.println(h.getHeader(AUTHORIZATION_PROPERTY));
	        authorization = h.getHeader(AUTHORIZATION_PROPERTY);
	                
	        if (authorization == null || authorization.isEmpty()) {
	        	System.out.println("No se encontro Autenticación");
	            this.customPoint(response, CODIGO_TRX_ERROR_AUTH, MENSAJE_TRX_ERROR_AUTH);
	        }else{
	                System.out.println("Authorization found");
	                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	                UserDetails userDetails = new User(USERNAME, PASSWORD, true, true, true, true,authorities);
	                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword());
	                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest) request));
	                SecurityContextHolder.getContext().setAuthentication(authentication);   
	                chain.doFilter(request, response);
	        }
	        
        } catch (Exception e) {
        	e.printStackTrace();
        	StringWriter errors = new StringWriter();
        	e.printStackTrace(new PrintWriter(errors));
			System.out.println("Error 500 : Error de proceso");
			this.customPoint(response, CODIGO_TRX_ERROR_AUTH, errors.toString());
			
		}
    }
	
	@SuppressWarnings("unchecked")
	public void customPoint(ServletResponse response, String codError, String descError) throws IOException{
		 HttpServletResponse k = (HttpServletResponse) response;
         k.setContentType("application/json");
         PrintWriter out = response.getWriter();
         JSONObject obj = new JSONObject();
         JSONObject obj1 = new JSONObject();
         obj1.put("codigo", codError);
         obj1.put("mensaje", descError);
         obj.put("tx", obj1);
         obj.put("rpta", null);
         out.print(obj);
	}
}