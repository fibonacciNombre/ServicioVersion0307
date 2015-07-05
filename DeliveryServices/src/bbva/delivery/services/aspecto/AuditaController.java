package bbva.delivery.services.aspecto;

import java.io.Reader;
import java.io.StringReader;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import bbva.delivery.services.commons.CommonsHelper;
import commons.framework.BaseController;

@Aspect
public class AuditaController {
	
	private static Logger logger = Logger.getLogger(
			AuditaController.class.getName());
	
	/**
	 * Permite definir la expresi�n para filtrar los metodos que ser�n 
	 * interceptados en los controladores
	 */
	@Pointcut("execution(* org.springframework.web.servlet.mvc.AbstractController.handleRequest(..)) "
			+ "&& @target(bbva.delivery.services.anotaciones.AdviceController))")
	public void metodosController() {
	}
	
	/**
	 * M�todo que se ejecutar� al llamar a los m�todos de los controladores
	 * que hagan match con la expresion definida en metodosController()
	 * @param joinPoint Permite invocar al m�todo del controlador
	 */
	
	@Around("metodosController()")
	public Object auditarController(ProceedingJoinPoint joinPoint) {
		
		logger.debug("#########################################");
		Object result					= null;
		BaseController controller 		= null;
		HttpServletRequest request 		= null;
		HttpServletResponse response 	= null;
		Date tiempoInicio 				= null;
		String metodoEjecutado 			= null;
		String mensajeError				= null;
		
		try {
			logger.debug("Ejecutando metodo que intercepta a los controllers");
			
			tiempoInicio 	= new Date();
			
			controller 		= (BaseController) joinPoint.getTarget();
			
			request 		= (HttpServletRequest) joinPoint.getArgs()[0];
			
			response	 	= (HttpServletResponse) joinPoint.getArgs()[1];
			
			response.setContentType("text/html; charset=UTF-8");

			System.out.println("request		--> "	+ joinPoint.getArgs()[0]);
			
			System.out.println("response	--> "	+ joinPoint.getArgs()[1]);
			
			metodoEjecutado = controller.getClass().getName() + "." +
					request.getParameter("method");
			
			result = joinPoint.proceed();
			
			logger.info(CommonsHelper.tiempoEjecucion(metodoEjecutado,
					tiempoInicio));
			
		} catch(Throwable t) {
			System.out.println(CommonsHelper.getErrorMessage(t));
			String jsonCommonsHelper = CommonsHelper.getErrorMessage(t).replaceAll("\r", "").replaceAll("\n", "-").replaceAll("'", "\"").replaceAll("\t", " ");

			Reader targetReader = new StringReader(jsonCommonsHelper.substring(1, jsonCommonsHelper.length()-1));
			JSONObject jsonObject;
			try {
				jsonObject = (JSONObject)new JSONParser().parse(targetReader);

				mensajeError = "[{" +
								"\"estado\"  :\"error\","+
								"\"origen\"  :\"DeliveryServices\"," +
								"\"codigo\"  :\""+metodoEjecutado+"\"," +
								"\"mensaje\" :\""+jsonObject.get("log")+"\"" +
								"}]";
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			System.out.println("ERROR AuditaController");
			System.out.println(mensajeError);
			logger.debug(mensajeError);

			controller.escribirTextoSalida(response, mensajeError);
			logger.error("Error ejecutar-> " + metodoEjecutado + " : " + t);
			t.printStackTrace();
		}
		
		return result;
	}
	
}