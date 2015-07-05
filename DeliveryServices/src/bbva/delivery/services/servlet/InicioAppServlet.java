package bbva.delivery.services.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import sas.seguridad.commons.ConfigurationProperties;
import bbva.delivery.services.commons.Constants;

public class InicioAppServlet extends HttpServlet {

	private static final long serialVersionUID = 8815884570144835030L;	
	private static Logger logger = Logger.getLogger(InicioAppServlet.class.getName());
	
	public InicioAppServlet() {
		super();
	}
	
	public void destroy() {
		super.destroy(); 
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request,response);
	}
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/html");
	}
	
	@SuppressWarnings("unused")
	public void init() throws ServletException {
		ServletContext servletContext = null;
		String rutaLog4j = null;
		
		try {
			rutaLog4j = System.getProperty(ConfigurationProperties.RUTA_ARCH_DEFAULT)+
					Constants.RUTA_FILE_CONFIGURACION_LOG4J;
			
			PropertyConfigurator.configure(rutaLog4j);
			
			System.out.println("Informacion acerca de la configuracion del log4j");
			System.out.println("RUTA -> " + rutaLog4j);
			System.out.println("Obteniendo los parametros de verificaci�n");
			
			logger.info("[---- INICIADO APLICACION DELIVERY SERVICIOS ----]");
			
			servletContext = super.getServletContext();
			
		} catch (Exception e) {
			logger.error("Error al iniciar parametros de la aplicacion", e);
		}
		
		logger.info("INICIO PARAMETROS DE CONTEXTO FINALIZADO");
	}
}
