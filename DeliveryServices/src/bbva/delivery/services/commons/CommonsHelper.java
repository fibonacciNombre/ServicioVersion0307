package bbva.delivery.services.commons;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import bbva.delivery.services.exception.ValidationException;

import commons.mapper.Utils;

public class CommonsHelper {

	private static final Logger logger = Logger.getLogger(CommonsHelper.class);	
	
	/**
	 * Metodo que devuelve la session
	 * @param request 
	 * @return Session
	 */
	public static String getSession(HttpServletRequest request) {
		HttpSession  session = null;
		session = request.getSession();
		
		return session.getId();
	}
	
	/**
	 * M�todo que valida la fuente del error para formatear el mensaje
	 * que sera enviado al cliente
	 * @param t Error generado
	 * @return Detalle del mensaje del error
	 */
	public static String getErrorMessage(Throwable t) {
		Throwable rootStack = null;
		String mensaje = null;
		String detalleError = null;
		String stack = null;
		int index = -1;
		
		try {
			mensaje = ExceptionUtils.getRootCauseMessage(t);
			
			if (mensaje.indexOf("ORA")>0) {
				detalleError = Utils.getMessageORA(mensaje);
			} else if ((t instanceof ValidationException) || (t instanceof
					com.rimac.sas.excepciones.ValidationException)) {
				detalleError = formatearMensajeErrorJson(
						ConstantsProperties.ORIGEN_ERROR_VALIDACION, t.getMessage(), "");
			} else {
				rootStack = ExceptionUtils.getRootCause(t);
				
				if (rootStack!=null) {
					stack = ExceptionUtils.getStackTrace(rootStack);
				} else {
					stack = ExceptionUtils.getStackTrace(t);
				}
				
				index = stack.indexOf("at org.springframework");
				
				if(index>0) {
					stack = stack.substring(0, index);
				}
				
				detalleError = formatearMensajeErrorJson(
						ConstantsProperties.ORIGEN_ERROR_EXCEPCION, mensaje, stack);
			}
		} catch(Exception e) {
			logger.error("Error al validar y formatear el mensaje de error");
			e.printStackTrace();
		}
		
		return detalleError;
	}
	
	/**
	 * M�todo que formatea el error a formato JSON
	 * @param origen Origen del error (exception, warning, validacion)
	 * @param msg Mensaje para el usuario
	 * @param msgCompleto Detaller del error
	 * @return Cadena en formato JSON
	 */
	private static String formatearMensajeErrorJson(String origen,
			String msg, String msgCompleto) {
		StringBuffer mensaje = new StringBuffer();
		mensaje.append("[");
		mensaje.append("{");
		mensaje.append("\'origen\':\'" + origen + "\',");
		mensaje.append("\'msg\':\'" + msg + "\',");
		mensaje.append("\'log\':\'" + msgCompleto.replaceAll("\r", "").replaceAll("\n", "<->"));
		mensaje.append("\'}");
		mensaje.append("]");
		
		return mensaje.toString();
	}

	/**
	 * M�todo que formatea el mensaje  que se escribira en el log con la 
	 * diferencia del tiempo actual con el que se le pasa como par�metro
	 * @param proceso Nombre del proceso del que se toma el tiempo de ejecuci�n
	 * @param tiempoInicio Tiempo en el que se inicion el proceso
	 * @return Mensaje con el tiempo que duro el proceso
	 */
	public static String tiempoEjecucion(String proceso, Date tiempoInicio) {
		Date tiempoFin = null;
		long tiempoEjecucion;
		StringBuilder sb = null;
		
		tiempoFin = new Date();
		tiempoEjecucion = tiempoFin.getTime() - tiempoInicio.getTime();
		sb = new StringBuilder();
		
		sb.append("Tiempo de ejecucion -> ");
		sb.append(proceso);
		sb.append(": ");
		sb.append(tiempoEjecucion);
		sb.append(" milisegundos");
		
		return  sb.toString();
	}
	/**
	 * Convierte un texto a BigDecimal, en caso no se pueda convertir
	 * se devolver� null.
	 *
	 * @param valor el texto a convertir a BigDecimal
	 * @return el BigDecimal resultado de la conversi�n
	 */
	public static BigDecimal getBigDecimal(String valor) {
		BigDecimal dato;
		
		try {
			dato = new BigDecimal(valor);
		} catch (Exception e) {
			dato = null;
		}
		
		return dato;
	}
	/**
	 * Convierte un texto a Integer, en caso no se pueda convertir
	 * se devolver� null.
	 *
	 * @param valor el texto a convertir a Integer
	 * @return el Integer resultado de la conversi�n
	 */
	public static Integer getInteger(String valor) {
		Integer dato;
		
		try {
			dato = Integer.parseInt(valor);
		} catch (Exception e) {
			dato = null;
		}
		
		return dato;
	}
	
	public static <T> T nvl(T obj, T obj2){
		return (obj != null)?obj:obj2;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void setIndexRow(List lista) {
		Object object = null;
		Method index = null;
		Class cls = null;

		try {
			Class parTypes[] = new Class[1];
			parTypes[0] = Integer.class;

			for (int i = 0; i < lista.size(); i++) {
				object = lista.get(i);
				cls = object.getClass();
				index = cls.getMethod("setIndexRow", parTypes);
				index.invoke(object, i + 1);
			}
		} catch (Exception e) {
			logger.info("Error al inviocar setIndexRow en los objetos -> "
					+ e.getMessage());
		}

	}
}
