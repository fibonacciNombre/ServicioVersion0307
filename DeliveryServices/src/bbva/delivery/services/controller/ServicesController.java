package bbva.delivery.services.controller;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jboss.resteasy.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bbva.delivery.services.bean.ArchivoPDF;
import bbva.delivery.services.bean.RequestChangeEstadoRegistro;
import bbva.delivery.services.bean.RequestGetVisitasUsuario;
import bbva.delivery.services.bean.RequestInformarActivacionBBVA;
import bbva.delivery.services.bean.RequestInformarEntregaCourier;
import bbva.delivery.services.bean.RequestTransferirArchivo;
import bbva.delivery.services.bean.RequestValidarCourier;
import bbva.delivery.services.bean.ResponseChangeEstadoRegistro;
import bbva.delivery.services.bean.ResponseGetVisitasUsuario;
import bbva.delivery.services.bean.ResponseInformarActivacionBBVA;
import bbva.delivery.services.bean.ResponseInformarEntregaCourier;
import bbva.delivery.services.bean.ResponseObtenerListaCourier;
import bbva.delivery.services.bean.ResponseTransferirArchivo;
import bbva.delivery.services.bean.ResponseValidarCourier;
import bbva.delivery.services.bean.Tx;
import bbva.delivery.services.bean.Usuario;
import bbva.delivery.services.service.DeliveryService;


/**
 * @author dingan
 *
 */

@Controller
@RequestMapping(value = "/services")
public class ServicesController {
	
	private static Logger logger 					= Logger.getLogger(ServicesController.class);
	
	//Autorizaciones
	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHENTICATION_SCHEME  = "Basic";
	
	//Transacciones
    private final static String CODIGO_TRX_ERROR = "1"; 
    private final static String MENSAJE_TRX_ERROR = "La autorizacion de autenticacion no es valido.";
	
	@Autowired
	DeliveryService deliveryService;
	//INICIO DE LOS SERVICIOS
	
	/**
	 * //RF - 04: Servicio que valida el DNI del courier
	 * @param requestValidarCourier
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/validarDNICourier", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseValidarCourier validarDNICourier(@RequestBody RequestValidarCourier requestValidarCourier, HttpServletResponse response, HttpServletRequest request) throws Exception {
		logger.info("INI Controller: Ejecutando metodo validarDNICourier");
		System.out.println("INI Controller: Ejecutando metodo validarDNICourier");
		
		if(this.customAutorization(request)){
			System.out.println("header Authorization   --> "+ request.getHeader(AUTHORIZATION_PROPERTY));
			System.out.println("FIN Controller: Ejecutando metodo validarDNICourier");
			logger.info("FIN Controller: Ejecutando metodo validarDNICourier");
			return deliveryService.validarDNICourier(requestValidarCourier);
        }else{
            System.out.println("invalid authorization");
            ResponseValidarCourier responseValidarCourier = new ResponseValidarCourier();
            Tx tx = new Tx();
            tx.setCodigo(CODIGO_TRX_ERROR);
            tx.setMensaje(MENSAJE_TRX_ERROR);
            responseValidarCourier.setTx(tx);
            return responseValidarCourier;
        }
		
	 }
	
	
	/**
	 * //RF - 05: Lista de entregas que tiene un usuario.
	 * @param requestGetVisitasUsuario
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getVisitasUsuario", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseGetVisitasUsuario getVisitasUsuario(@RequestBody RequestGetVisitasUsuario requestGetVisitasUsuario ,HttpServletResponse response, HttpServletRequest request) throws Exception {
		logger.info("INI Controller: Ejecutando metodo getVisitasUsuario");
		System.out.println("INI Controller: Ejecutando metodo getVisitasUsuario");
		
		if(this.customAutorization(request)){
			System.out.println("header Authorization   --> "+ request.getHeader(AUTHORIZATION_PROPERTY));
			System.out.println("FIN Controller: Ejecutando metodo getVisitasUsuario");
			logger.info("FIN Controller: Ejecutando metodo getVisitasUsuario");
			return deliveryService.getVisitasUsuario(requestGetVisitasUsuario);
        }else{
            System.out.println("invalid authorization");
            ResponseGetVisitasUsuario responseGetVisitasUsuario = new ResponseGetVisitasUsuario();
            Tx tx = new Tx();
            tx.setCodigo(CODIGO_TRX_ERROR);
            tx.setMensaje(MENSAJE_TRX_ERROR);
            responseGetVisitasUsuario.setTx(tx);
            return responseGetVisitasUsuario;
        }

	}
	
	
	/**
	 * //RF - 20: Cambia el estado de la entrega
	 * @param requestChangeEstadoRegistro
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeEstadoRegistro", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseChangeEstadoRegistro changeEstadoRegistro(@RequestBody RequestChangeEstadoRegistro requestChangeEstadoRegistro, HttpServletResponse response, HttpServletRequest request) throws Exception {
		logger.info("INI Controller: Ejecutando metodo changeEstadoRegistro");
		System.out.println("INI Controller: Ejecutando metodo changeEstadoRegistro");
			
		if(this.customAutorization(request)){
			System.out.println("header Authorization   --> "+ request.getHeader(AUTHORIZATION_PROPERTY));
			System.out.println("FIN Controller: Ejecutando metodo changeEstadoRegistro");
			logger.info("FIN Controller: Ejecutando metodo changeEstadoRegistro");
			return deliveryService.changeEstadoRegistro(requestChangeEstadoRegistro);
        }else{
            System.out.println("invalid authorization");
            ResponseChangeEstadoRegistro responseChangeEstadoRegistro = new ResponseChangeEstadoRegistro();
            Tx tx = new Tx();
            tx.setCodigo(CODIGO_TRX_ERROR);
            tx.setMensaje(MENSAJE_TRX_ERROR);
            responseChangeEstadoRegistro.setTx(tx);
            return responseChangeEstadoRegistro;
        }
	}
	
	
	
	/**
	 * //RF - 03: Lista los couriers
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/obtenerListaCourier", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseObtenerListaCourier obtenerListaCourier(HttpServletResponse response, HttpServletRequest request) throws Exception {
		logger.info("INI Controller: Ejecutando metodo obtenerListaCourier");
		System.out.println("INI Controller: Ejecutando metodo obtenerListaCourier");
	
		if(this.customAutorization(request)){
			System.out.println("header Authorization   --> "+ request.getHeader(AUTHORIZATION_PROPERTY));
			System.out.println("FIN Controller: Ejecutando metodo obtenerListaCourier");
			logger.info("FIN Controller: Ejecutando metodo obtenerListaCourier");
			return deliveryService.obtenerListaCourier();
        }else{
            System.out.println("invalid authorization");
            ResponseObtenerListaCourier responseObtenerListaCourier = new ResponseObtenerListaCourier();
            Tx tx = new Tx();
            tx.setCodigo(CODIGO_TRX_ERROR);
            tx.setMensaje(MENSAJE_TRX_ERROR);
            responseObtenerListaCourier.setTx(tx);
            return responseObtenerListaCourier;
        }

    }
	
	
	
	/**
	 * //RF-07-A1: Envio de correo al courier informando el estado de la entrega
	 * @param requestInformarEntregaCourier
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/informarEntregaCourier", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseInformarEntregaCourier informarEntregaCourier(@RequestBody RequestInformarEntregaCourier requestInformarEntregaCourier,HttpServletResponse response, HttpServletRequest request) throws Exception {
		logger.info("INI Controller: Ejecutando metodo informarEntregaCourier");
		System.out.println("INI Controller: Ejecutando metodo informarEntregaCourier");
		
		if(this.customAutorization(request)){
			System.out.println("header Authorization   --> "+ request.getHeader(AUTHORIZATION_PROPERTY));
			System.out.println("FIN Controller: Ejecutando metodo informarEntregaCourier");
			logger.info("FIN Controller: Ejecutando metodo informarEntregaCourier");
			return deliveryService.informarEntregaCourier(requestInformarEntregaCourier);
        }else{
            System.out.println("invalid authorization");
            ResponseInformarEntregaCourier responseInformarEntregaCourier = new ResponseInformarEntregaCourier();
            Tx tx = new Tx();
            tx.setCodigo(CODIGO_TRX_ERROR);
            tx.setMensaje(MENSAJE_TRX_ERROR);
            responseInformarEntregaCourier.setTx(tx);
            return responseInformarEntregaCourier;
        }

    }
	

	/**
	 * 	//RF-07-A2: Envio de correo al BBVA cuando se activa una tarjeta
	 * @param requestInformarActivacionBBVA
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/informarActivacionBBVA", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseInformarActivacionBBVA informarActivacionBBVA(@RequestBody RequestInformarActivacionBBVA requestInformarActivacionBBVA, HttpServletResponse response, HttpServletRequest request) throws Exception {
		logger.info("INI Controller: Ejecutando metodo informarActivacionBBVA");
		System.out.println("INI Controller: Ejecutando metodo informarActivacionBBVA");

		if(this.customAutorization(request)){
			System.out.println("header Authorization   --> "+ request.getHeader(AUTHORIZATION_PROPERTY));
			System.out.println("FIN Controller: Ejecutando metodo informarActivacionBBVA");
			logger.info("FIN Controller: Ejecutando metodo informarActivacionBBVA");
			return deliveryService.informarActivacionBBVA(requestInformarActivacionBBVA);
        }else{
            System.out.println("invalid authorization");
            ResponseInformarActivacionBBVA responseInformarActivacionBBVA = new ResponseInformarActivacionBBVA();
            Tx tx = new Tx();
            tx.setCodigo(CODIGO_TRX_ERROR);
            tx.setMensaje(MENSAJE_TRX_ERROR);
            responseInformarActivacionBBVA.setTx(tx);
            return responseInformarActivacionBBVA;
        }

    }
	
	
	
	/**
	 * //RF-22: Guarda el Archivo PDF(Formato Base64) de la entrega como un CLOB
	 * @param requestTransferirArchivo
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/transferirArchivo", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseTransferirArchivo transferirArchivo(@RequestBody RequestTransferirArchivo requestTransferirArchivo, HttpServletResponse response, HttpServletRequest request) throws Exception {
		logger.info("INI Controller: Ejecutando metodo transferirArchivo");
		System.out.println("INI Controller: Ejecutando metodo transferirArchivo");

		if(this.customAutorization(request)){
			System.out.println("header Authorization   --> "+ request.getHeader(AUTHORIZATION_PROPERTY));
			System.out.println("FIN Controller: Ejecutando metodo transferirArchivo");
			logger.info("FIN Controller: Ejecutando metodo transferirArchivo");
			return deliveryService.transferirArchivo(requestTransferirArchivo);
        }else{
            System.out.println("invalid authorization");
            ResponseTransferirArchivo responseTransferirArchivo = new ResponseTransferirArchivo();
            Tx tx = new Tx();
            tx.setCodigo(CODIGO_TRX_ERROR);
            tx.setMensaje(MENSAJE_TRX_ERROR);
            responseTransferirArchivo.setTx(tx);
            return responseTransferirArchivo;
        }

    }
	
	
	
	/**
	 * //Vista del PDF: Trae el PDF de la entrega de BD y lo coloca como archivo PDF en un archivo
	 * temporal del Servidor.
	 * @param archivoPDF
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getArchivoPDF", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ArchivoPDF getArchivoPDF(@RequestBody ArchivoPDF archivoPDF, HttpServletResponse response, HttpServletRequest request) throws Exception {
		logger.info("INI Controller: Ejecutando metodo getArchivoPDF");
		System.out.println("INI Controller: Ejecutando metodo getArchivoPDF");
		String ruta = "";
		System.out.println("header Authorization   --> "+ request.getHeader(AUTHORIZATION_PROPERTY));
		ruta = request.getSession().getServletContext().getRealPath("/")+System.getProperty("file.separator");
		System.out.println("ruta -->" + ruta);
		System.out.println("FIN Controller: Ejecutando metodo getArchivoPDF");
		logger.info("FIN Controller: Ejecutando metodo getArchivoPDF");
		return deliveryService.getArchivoPDF(archivoPDF, ruta);        

    }
	
	//Validacion de Usuario y Password 
	public boolean customAutorization( HttpServletRequest h) throws IOException{
		logger.info("INI: Ejecutando metodo customAutorization");
		System.out.println("INI: Ejecutando metodo customAutorization");
		String authorization = null;
		String encodedUserPassword = null;
		String usernameAndPassword = null;
		try {
			authorization = h.getHeader(AUTHORIZATION_PROPERTY);
			System.out.println("AUTHORIZATION_PROPERTY: " + authorization);
	    	encodedUserPassword = authorization.replaceFirst(AUTHENTICATION_SCHEME + " ", ""); 
	 		usernameAndPassword = new String(Base64.decode(encodedUserPassword));
	 		System.out.println("usernameAndPassword --> "+usernameAndPassword);
	 		
	 		final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
		    final String username = tokenizer.nextToken();
		    final String password = tokenizer.nextToken();
		    
		    System.out.println("username --> "+username);
		    System.out.println("password --> "+password);
		    
		    Usuario u = new Usuario();
		    u.setCodusuario(username);
		    u.setContrasena(password);
		    System.out.println("FIN: Ejecutando metodo customAutorization");
			logger.info("FIN: Ejecutando metodo customAutorization");
		    return deliveryService.validarUsuario(u);
		} catch (Exception e) {
			return false;
		}
	}
	
	//Agregar un usuario para los Servicios
	@RequestMapping(value = "/addUsuario", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Usuario addUsuario(@RequestBody Usuario usuario, HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		System.out.println("header Authorization   --> "+ request.getHeader(AUTHORIZATION_PROPERTY));
		return deliveryService.addUsuario(usuario);
	}
	
}
