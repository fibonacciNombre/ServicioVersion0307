package bbva.delivery.services.service.imp;

import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import bbva.delivery.services.bean.ArchivoGenerado;
import bbva.delivery.services.bean.ArchivoPDF;
import bbva.delivery.services.bean.Courier;
import bbva.delivery.services.bean.Delivery;
import bbva.delivery.services.bean.EmbeddedImages;
import bbva.delivery.services.bean.EstadoRegistro;
import bbva.delivery.services.bean.InformarActivacionBBVA;
import bbva.delivery.services.bean.InformarEntregaCourier;
import bbva.delivery.services.bean.Parametro;
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
import bbva.delivery.services.bean.ValidarCourier;
import bbva.delivery.services.dao.DeliveryDao;
import bbva.delivery.services.dao.imp.DeliveryDaoImp;
import bbva.delivery.services.service.DeliveryService;

/**
 * @author dingan
 *
 */
@Service("deliveryService")
@Transactional(propagation=Propagation.SUPPORTS)
public class DeliveryServiceImp implements DeliveryService {
	
	private static Logger logger 					= Logger.getLogger(DeliveryServiceImp.class);
	//Constantes de encriptaciÃ³n
	private final static String ALG = "AES";
    private final static String CI = "AES/CBC/PKCS5Padding";
    private final static String KEY = "92AE31A79FEEB2A3";
    private final static String IV = "0123456789ABCDEF"; 
    
    //Transacciones
    private final static String CODIGO_TRX_CORRECTO = "0"; 
    private final static String MENSAJE_TRX_CORRECTO = "Transacción correcta";
    
    //Validar DNI
    private final static String CODIGO_USR_NOEXISTE= "002"; 
    private final static String MENSAJE_USR_NOEXISTE = "Usuario no existe"; 
    private final static String CODIGO_USR_ACTIVO= "000"; 
    private final static String MENSAJE_USR_ACTIVO = "Usuario activo"; 
    private final static String CODIGO_USR_INACTIVO= "001"; 
    private final static String MENSAJE_USR_INACTIVO = "Usuario inactivo"; 
    private final static String CODIGO_COURIER_INACTIVO= "003"; 
    private final static String MENSAJE_COURIER_INACTIVO = "Courier inactivo"; 
    
    //Datos Correos
    private final static String CODIGO_CORREO_CORRECTO = "0"; 
    private final static String MENSAJE_CORREO_CORRECTO = "Correo Enviado con Exito"; 
    private final static String CODIGO_CORREO_ERROR = "1"; 
    private final static String MENSAJE_CORREO_ERROR = "No se envió el correo, no existe entrega";
    
    //Parametros
    private final static String DELSERVICIOS_CORREO = "DELSERVICIOS_CORREO"; 

	@Autowired
	private DeliveryDao deliveryDao;

	
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("service ok");
		
		deliveryDao.test();
	}
	
	public void validarUsuarioToken(Usuario usuario) throws Exception{
		logger.info("INI Service: Ejecutando metodo validarUsuarioToken");
		System.out.println("INI Service: Ejecutando metodo validarUsuarioToken");
		
		DeliveryDaoImp daoImp = new DeliveryDaoImp();
		String usuarioPassword = null;
		String cadenaEncriptada = null;
		String cadenaDesencriptada = null;
		
		String token = UUID.randomUUID().toString();
		System.out.println("token random --> "+ token);
		daoImp.validarUsuarioToken(usuario);
		
		usuarioPassword = usuario.getUsuario()+":"+usuario.getContrasena();
		cadenaEncriptada = this.encriptar(KEY, IV, usuarioPassword);
		cadenaDesencriptada = this.desencriptar(KEY, IV, cadenaEncriptada);
		System.out.println("Encrip --> "+ cadenaEncriptada);
		System.out.println("Desencrip --> "+ cadenaDesencriptada);
		
		System.out.println("FIN Service: Ejecutando metodo validarUsuarioToken");
		logger.info("FIN Service: Ejecutando metodo validarUsuarioToken");
	}
	
	public String encriptar(String key, String iv, String cleartext) throws Exception{
		
		logger.info("INI Service: Ejecutando metodo encriptar");
		System.out.println("INI Service: Ejecutando metodo encriptar");
		
		Cipher cipher = Cipher.getInstance(CI);
		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), ALG);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
		byte[] encrypted = cipher.doFinal(cleartext.getBytes());
		
		System.out.println("FIN Service: Ejecutando metodo encriptar");
		logger.info("FIN Service: Ejecutando metodo encriptar");
		return new String(encodeBase64(encrypted));
		
	}
	
	public String desencriptar(String key, String iv, String encrypted) throws Exception{
		logger.info("INI Service: Ejecutando metodo desencriptar");
		System.out.println("INI Service: Ejecutando metodo desencriptar");
		
		Cipher cipher = Cipher.getInstance(CI);
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), ALG);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        byte[] enc = decodeBase64(encrypted);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
        byte[] decrypted = cipher.doFinal(enc);
        
        System.out.println("FIN Service: Ejecutando metodo desencriptar");
		logger.info("FIN Service: Ejecutando metodo desencriptar");
        return new String(decrypted);
	}
	
	public boolean validarUsuario(Usuario usuario) throws Exception{
		logger.info("INI Service: Ejecutando metodo validarUsuario");
		System.out.println("INI Service: Ejecutando metodo validarUsuario");
		Usuario usr = deliveryDao.getUsuario(usuario);
		if(usr != null){
			if(usuario.getCodusuario().equals(usr.getCodusuario()) && usuario.getContrasena().equals(usr.getContrasena())){
				return true;
			}
		}
		System.out.println("FIN Service: Ejecutando metodo validarUsuario");
		logger.info("FIN Service: Ejecutando metodo validarUsuario");
		return false;
	}
	
	public ResponseValidarCourier validarDNICourier(RequestValidarCourier requestValidarCourier){
		logger.info("INI Service: Ejecutando metodo validarDNICourier");
		System.out.println("INI Service: Ejecutando metodo validarDNICourier");
		ResponseValidarCourier responseValidarCourier = new ResponseValidarCourier();
		
		List<ValidarCourier> validarCouriers = deliveryDao.validarDNICourier(requestValidarCourier);
		Tx tx = new Tx();
		tx.setCodigo(CODIGO_TRX_CORRECTO);
		tx.setMensaje(MENSAJE_TRX_CORRECTO);
		responseValidarCourier.setTx(tx);
		    
		if(validarCouriers.isEmpty()){
			ValidarCourier courier = new ValidarCourier();
			courier.setCodigo(CODIGO_USR_NOEXISTE);
			courier.setMensaje(MENSAJE_USR_NOEXISTE);
			responseValidarCourier.setValidarCourier(courier);
		}else{
			ValidarCourier courier = validarCouriers.get(0);
			if("0".equals(courier.getEstadocourier())){
				courier.setCodigo(CODIGO_COURIER_INACTIVO);
				courier.setMensaje(MENSAJE_COURIER_INACTIVO);
				responseValidarCourier.setValidarCourier(courier);
			}
			
			if("1".equals(courier.getEstadocourier())){
				if("1".equals(courier.getEstadotercero())){
					courier.setCodigo(CODIGO_USR_ACTIVO);
					courier.setMensaje(MENSAJE_USR_ACTIVO);
					responseValidarCourier.setValidarCourier(courier);
				}else{
					courier.setCodigo(CODIGO_USR_INACTIVO);
					courier.setMensaje(MENSAJE_USR_INACTIVO);
					responseValidarCourier.setValidarCourier(courier);
				}
			}
		}

		System.out.println("FIN Service: Ejecutando metodo validarDNICourier");
		logger.info("FIN Service: Ejecutando metodo validarDNICourier");
		
		return responseValidarCourier;
	}
	
	public ResponseGetVisitasUsuario getVisitasUsuario(RequestGetVisitasUsuario requestGetVisitasUsuario){
		logger.info("INI Service: Ejecutando metodo getVisitasUsuario");
		System.out.println("INI Service: Ejecutando metodo getVisitasUsuario");
		
		ResponseGetVisitasUsuario responseGetVisitasUsuario =  new ResponseGetVisitasUsuario();
		String fecha = requestGetVisitasUsuario.getDia()+"/"+requestGetVisitasUsuario.getMes()+"/"+requestGetVisitasUsuario.getAnio();
		
		Tx tx = new Tx();
		tx.setCodigo(CODIGO_TRX_CORRECTO);
		tx.setMensaje(MENSAJE_TRX_CORRECTO);
		
		responseGetVisitasUsuario.setVisitasUsuarios(deliveryDao.getVisitasUsuario(requestGetVisitasUsuario, fecha));
		responseGetVisitasUsuario.setTx(tx);
		
		System.out.println("FIN Service: Ejecutando metodo getVisitasUsuario");
		logger.info("FIN Service: Ejecutando metodo getVisitasUsuario");
		return responseGetVisitasUsuario;
	}
	
	public ResponseChangeEstadoRegistro changeEstadoRegistro(RequestChangeEstadoRegistro requestChangeEstadoRegistro){
		
		logger.info("INI Service: Ejecutando metodo changeEstadoRegistro");
		System.out.println("INI Service: Ejecutando metodo changeEstadoRegistro");
		
		ResponseChangeEstadoRegistro responseChangeEstadoRegistro =  new ResponseChangeEstadoRegistro();
		Tx tx = new Tx();
		tx.setCodigo(CODIGO_TRX_CORRECTO);
		tx.setMensaje(MENSAJE_TRX_CORRECTO);
		RequestChangeEstadoRegistro rcr = deliveryDao.changeEstadoRegistro(requestChangeEstadoRegistro);
		
		EstadoRegistro estadoRegistro = new EstadoRegistro();
		estadoRegistro.setCodigo(rcr.getCodigo());
		estadoRegistro.setMensaje(rcr.getMensaje());
		estadoRegistro.setEstado(rcr.getEstado());
		estadoRegistro.setMotivo(rcr.getMotivo());
		estadoRegistro.setCodigoEntrega(rcr.getCodigoEntrega().toString());
		responseChangeEstadoRegistro.setTx(tx);
		responseChangeEstadoRegistro.setEstadoRegistro(estadoRegistro);
		
		System.out.println("FIN Service: Ejecutando metodo changeEstadoRegistro");
		logger.info("FIN Service: Ejecutando metodo changeEstadoRegistro");
		
		return responseChangeEstadoRegistro;
	}

	public ResponseObtenerListaCourier obtenerListaCourier(){
		logger.info("INI Service: Ejecutando metodo obtenerListaCourier");
		System.out.println("INI Service: Ejecutando metodo obtenerListaCourier");
		
		ResponseObtenerListaCourier responseObtenerListaCourier = new ResponseObtenerListaCourier();
		Tx tx = new Tx();
		tx.setCodigo(CODIGO_TRX_CORRECTO);
		tx.setMensaje(MENSAJE_TRX_CORRECTO);
		List<Courier> couriers = new ArrayList<Courier>();
		couriers = deliveryDao.obtenerListaCourier();
		responseObtenerListaCourier.setListaCourier(couriers);
		responseObtenerListaCourier.setTx(tx);
		
		System.out.println("FIN Service: Ejecutando metodo obtenerListaCourier");
		logger.info("FIN Service: Ejecutando metodo obtenerListaCourier");
		
		return responseObtenerListaCourier;
		
	}
	
	public ResponseInformarEntregaCourier informarEntregaCourier(RequestInformarEntregaCourier requestInformarEntregaCourier){
		logger.info("INI Service: Ejecutando metodo informarEntregaCourier");
		System.out.println("INI Service: Ejecutando metodo informarEntregaCourier");
		
		ResponseInformarEntregaCourier responseInformarEntregaCourier = new ResponseInformarEntregaCourier();
		List<Delivery> deliveries = deliveryDao.informarEntregaCourier(requestInformarEntregaCourier);
		Delivery delivery = null;
		InformarEntregaCourier  j = null;
		String bodyEntrega = "";
		String subjectEntrega = "";
		String cc = "";
		String cco = "";
		
		if(!deliveries.isEmpty()){
			delivery = deliveries.get(0);
			j = new InformarEntregaCourier();
			
			List<Parametro> parametros= deliveryDao.getParametros(DELSERVICIOS_CORREO);
			
			for(Parametro parametro : parametros ){
				if("BODY_ENTREGA".equals(parametro.getCodigoc())){
					bodyEntrega = parametro.getDescripcion();
				}
				if("SUBJECT_ENTREGA".equals(parametro.getCodigoc())){
					subjectEntrega = parametro.getDescripcion();
				}
				if("CC".equals(parametro.getCodigoc())){
					cc = parametro.getDescripcion();
				}
				if("CCO".equals(parametro.getCodigoc())){
					cco = parametro.getDescripcion();
				}
			}
			
			bodyEntrega = bodyEntrega.replace("{TERCERO}", delivery.getNombretercero());
			bodyEntrega = bodyEntrega.replace("{CODIGOENTREGA}", delivery.getIddelivery().toString());
			bodyEntrega = bodyEntrega.replace("{ESTADO}", requestInformarEntregaCourier.getEstado());
			bodyEntrega = bodyEntrega.replace("{OBSERVACIONES}", requestInformarEntregaCourier.getObservaciones());
			bodyEntrega = bodyEntrega.replace("{FECHAHORA}", requestInformarEntregaCourier.getFechaHora());
					
			this.envioCorreo(subjectEntrega, bodyEntrega, null, delivery.getCorreocourier(), cc, cco);
			j.setCodigo(CODIGO_CORREO_CORRECTO);
			j.setMensaje(MENSAJE_CORREO_CORRECTO);
			responseInformarEntregaCourier.setInformarEntregaCourier(j);
		}else{
			j = new InformarEntregaCourier();
			j.setCodigo(CODIGO_CORREO_ERROR);
			j.setMensaje(MENSAJE_CORREO_ERROR);
			responseInformarEntregaCourier.setInformarEntregaCourier(j);
		}
		
		Tx tx = new Tx();
		tx.setCodigo(CODIGO_TRX_CORRECTO);
		tx.setMensaje(MENSAJE_TRX_CORRECTO);
		responseInformarEntregaCourier.setTx(tx);
		
		System.out.println("FIN Service: Ejecutando metodo informarEntregaCourier");
		logger.info("FIN Service: Ejecutando metodo informarEntregaCourier");
		
		return responseInformarEntregaCourier;
	}
	
	public ResponseInformarActivacionBBVA informarActivacionBBVA(RequestInformarActivacionBBVA requestInformarActivacionBBVA){
		logger.info("INI Service: Ejecutando metodo informarActivacionBBVA");
		System.out.println("INI Service: Ejecutando metodo informarActivacionBBVA");
		
		ResponseInformarActivacionBBVA responseInformarActivacionBBVA = new ResponseInformarActivacionBBVA();
		List<Delivery> deliveries = deliveryDao.informarActivacionBBVA(requestInformarActivacionBBVA);
		Delivery delivery = null;
		InformarActivacionBBVA  j = null;
		String bodyActivacion = "";
		String subjActivacion = "";
		String cc = "";
		String cco = "";
		String correo_bbva = "";
		
		if(!deliveries.isEmpty()){
			delivery = deliveries.get(0);
			j = new InformarActivacionBBVA();
			
			List<Parametro> parametros= deliveryDao.getParametros(DELSERVICIOS_CORREO);
			
			for(Parametro parametro : parametros ){
				if("BODY_ACTIVACION".equals(parametro.getCodigoc())){
					bodyActivacion = parametro.getDescripcion();
				}
				if("SUBJECT_ACTIVACION".equals(parametro.getCodigoc())){
					subjActivacion = parametro.getDescripcion();
				}
				if("CC".equals(parametro.getCodigoc())){
					cc = parametro.getDescripcion();
				}
				if("CCO".equals(parametro.getCodigoc())){
					cco = parametro.getDescripcion();
				}
				if("CORREO_BBVA".equals(parametro.getCodigoc())){
					correo_bbva = parametro.getDescripcion();
				}
			}
			
			bodyActivacion = bodyActivacion.replace("{CLIENTE}", delivery.getNombrescli());
			bodyActivacion = bodyActivacion.replace("{CODIGOENTREGA}", delivery.getIddelivery().toString());
			bodyActivacion = bodyActivacion.replace("{FECHAHORA}", requestInformarActivacionBBVA.getFechaHora());

			this.envioCorreo(subjActivacion, bodyActivacion, null, correo_bbva, cc, cco);
			j.setCodigo(CODIGO_CORREO_CORRECTO);
			j.setMensaje(MENSAJE_CORREO_CORRECTO);
			responseInformarActivacionBBVA.setInformarActivacionBBVA(j);
		}else{
			j = new InformarActivacionBBVA();
			j.setCodigo(CODIGO_CORREO_ERROR);
			j.setMensaje(MENSAJE_CORREO_ERROR);
			responseInformarActivacionBBVA.setInformarActivacionBBVA(j);
		}

		Tx tx = new Tx();
		tx.setCodigo(CODIGO_TRX_CORRECTO);
		tx.setMensaje(MENSAJE_TRX_CORRECTO);
		responseInformarActivacionBBVA.setTx(tx);
		
		System.out.println("FIN Service: Ejecutando metodo informarActivacionBBVA");
		logger.info("FIN Service: Ejecutando metodo informarActivacionBBVA");
		
		return responseInformarActivacionBBVA;
	}
	
	public ResponseTransferirArchivo transferirArchivo(RequestTransferirArchivo requestTransferirArchivo){
		
		logger.info("INI Service: Ejecutando metodo transferirArchivo");
		System.out.println("INI Service: Ejecutando metodo transferirArchivo");
		
		ResponseTransferirArchivo responseTransferirArchivo = new ResponseTransferirArchivo();
		Tx tx = new Tx();
		tx.setCodigo(CODIGO_TRX_CORRECTO);
		tx.setMensaje(MENSAJE_TRX_CORRECTO);
		ArchivoGenerado archivoGenerado =deliveryDao.transferirArchivo(requestTransferirArchivo);
		if(requestTransferirArchivo.getCodigoEntrega() == null || ("").equals(requestTransferirArchivo.getCodigoEntrega().toString().trim())){
			//
		}else{
			archivoGenerado.setCodigoEntrega(requestTransferirArchivo.getCodigoEntrega().toString());
		}
		responseTransferirArchivo.setArchivoGenerado(archivoGenerado);
		responseTransferirArchivo.setTx(tx);
		
		System.out.println("FIN Service: Ejecutando metodo transferirArchivo");
		logger.info("FIN Service: Ejecutando metodo transferirArchivo");
		
		return responseTransferirArchivo;
	}
	
	public ArchivoPDF getArchivoPDF(ArchivoPDF archivoPDF, String ruta) throws Exception{
		logger.info("INI Service: Ejecutando metodo getArchivoPDF");
		System.out.println("INI Service: Ejecutando metodo getArchivoPDF");
		
		byte[] getArchivoPDF = null;
		String file = null;
		File f = null;
		String nombreArchivo = "";
		List<ArchivoPDF> list = deliveryDao.getArchivoPDF(archivoPDF);
		ArchivoPDF pdf = new ArchivoPDF();
		DateFormat parser = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String fechaFile = parser.format(new Date());

		if(!list.isEmpty()){
			pdf = list.get(0);
			nombreArchivo = "delivery_" + pdf.getCodigoEntrega() + "_" + fechaFile + ".pdf";
			file = ruta + "temp" + "/" + nombreArchivo;
			
			if(pdf.getArchivo() != null){
				getArchivoPDF = pdf.getArchivo().getBytes();
				if(getArchivoPDF == null || getArchivoPDF.length == 0){
					logger.debug("No Se obtuvo Array de Bytes del PDF");
					pdf.setArchivo(file);
					pdf.setCodigo("1");
					pdf.setMensaje("No tiene pdf");
					
					System.out.println("FIN Service: Ejecutando metodo getArchivoPDF");
					logger.info("FIN Service: Ejecutando metodo getArchivoPDF");
					
					return pdf;
				}else{
					byte[] bfo = Base64.decodeBase64(getArchivoPDF);
					f = new File(file);
	
					FileOutputStream fos = new FileOutputStream(f);
					fos.write(bfo);
					fos.flush();
					fos.close();
					
					file = "temp/"+nombreArchivo;
					pdf.setArchivo(file);
					pdf.setCodigo("0");
					pdf.setMensaje("Exito");
				}
			}else{
				pdf.setArchivo(null);
				pdf.setCodigo("1");
				pdf.setMensaje("No tiene pdf");
				
				System.out.println("FIN Service: Ejecutando metodo getArchivoPDF");
				logger.info("FIN Service: Ejecutando metodo getArchivoPDF");
				
				return pdf;
			}
		}else{
			pdf.setArchivo(file);
			pdf.setCodigo("1");
			pdf.setMensaje("El código de delivery no existe");
		}
		
		System.out.println("FIN Service: Ejecutando metodo getArchivoPDF");
		logger.info("FIN Service: Ejecutando metodo getArchivoPDF");
		
		return pdf;
	}
	
	public Usuario addUsuario(Usuario usuario) throws Exception{
		logger.info("INI Service: Ejecutando metodo addUsuario");
		System.out.println("INI Service: Ejecutando metodo addUsuario");
		
		usuario.setContrasena(this.encriptar(KEY, IV, usuario.getContrasena()));
		usuario.setIdpestado(1);
		usuario.setUsuario("DELIVERY_BBVA");
		
		System.out.println("FIN Service: Ejecutando metodo addUsuario");
		logger.info("FIN Service: Ejecutando metodo addUsuario");
		
		return deliveryDao.obtUsuario(deliveryDao.addUsuario(usuario).getIdeusuario());
	}
	
	public void envioCorreo(String subject, String body, String adjunto, String para, String copia, String copiaoculta){
		logger.info("INI Service: Ejecutando metodo envioCorreo");
		System.out.println("INI Service: Ejecutando metodo envioCorreo");
		
		String userAuth = null;
		String passAuth = null;
		String host = null;
		List<String> to = new ArrayList<String>();
		List<String> cc = new ArrayList<String>();
		List<String> cco = new ArrayList<String>();
		List<String> listAdjunto =  null;
		String subjectMail = null;
		String bodyMail = null;
		String from = null;
	    
		List<Parametro> parametros= deliveryDao.getParametros(DELSERVICIOS_CORREO);
		
		for(Parametro parametro : parametros ){
			if("FROM".equals(parametro.getCodigoc())){
				from = parametro.getAbreviatura();
			}
			if("USERAUTH".equals(parametro.getCodigoc())){
				userAuth = parametro.getAbreviatura();
			}
			if("PASSAUTH".equals(parametro.getCodigoc())){
				passAuth = parametro.getAbreviatura();
			}
			if("HOST".equals(parametro.getCodigoc())){
				host = parametro.getAbreviatura();
			}
		}
		
		//from = FROM;
		to.add(para);
		cc.add(copia);
		cco.add(copiaoculta);
		subjectMail = subject;
		bodyMail = body;
		
		if(!(adjunto == null)){
			listAdjunto = new ArrayList<String>();
			listAdjunto.add(adjunto);
		}
		
		//userAuth = USERAUTH;
		//passAuth = PASSAUTH;
		//host = HOST;

		this.sendGeneral(from, to, cc, cco, subjectMail,
				bodyMail, listAdjunto, null, null, null, userAuth,
				passAuth, host);	
		
		System.out.println("FIN Service: Ejecutando metodo envioCorreo");
		logger.info("FIN Service: Ejecutando metodo envioCorreo");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void sendGeneral(String from,List<String> to,List<String> cc,List<String> bcc,String subjectMail,String bodyMail,//elementos principales
								   List<String> attachment,List<EmbeddedImages> embeddedImages ,//elementos adicionales sino mandar null
								   String acuserecibo,String urlAcuse,//Acuse de recibo 1=SI,0 ï¿½ null=NO
								   String userAuth,String passAuth,String host) //parametros de autentificacion
	{
		logger.info("INI Service: Ejecutando metodo sendGeneral");
		System.out.println("INI Service: Ejecutando metodo sendGeneral");
		
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.user", userAuth);
		properties.setProperty("mail.smtp.auth", "true");
		
		//Si el host es gmail
		if("smtp.gmail.com".equals(host))
		{
			properties.setProperty("mail.smtp.starttls.enable", "true");
			properties.setProperty("mail.smtp.port", "587");
		}
        
		try{
			//Creamos sesion
			Session session = Session.getDefaultInstance(properties);
			MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setSubject(subjectMail);
            //List a InternetAddress (TO)
            ArrayList addresses=new ArrayList();
            Iterator iter = to.iterator();
            while (iter.hasNext()){
            	addresses.add(new InternetAddress(iter.next().toString()));
            }
            InternetAddress[] adreessesArray=(InternetAddress[])addresses.toArray(new InternetAddress[addresses.size()]);
            message.addRecipients(Message.RecipientType.TO,adreessesArray);
            //List a InternetAddress (CC)
            if(cc!=null && cc.size()>0){
                addresses=new ArrayList();
                iter = cc.iterator();
                while (iter.hasNext()){
                	addresses.add(new InternetAddress(iter.next().toString()));
                }
                adreessesArray=(InternetAddress[])addresses.toArray(new InternetAddress[addresses.size()]);
                message.addRecipients(Message.RecipientType.CC,adreessesArray);
            }
            //List a InternetAddress (BCC)
            if(bcc!=null && bcc.size()>0){
                addresses=new ArrayList();
                iter = bcc.iterator();
                while (iter.hasNext()){
                	addresses.add(new InternetAddress(iter.next().toString()));
                }
                adreessesArray=(InternetAddress[])addresses.toArray(new InternetAddress[addresses.size()]);
                message.addRecipients(Message.RecipientType.BCC,adreessesArray);
            }
            //Body y adjuntos
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            
            //Editando para acuse de recibe 
            if(acuserecibo!=null)
            {
            	if("1".equals(acuserecibo)){
            		if(bodyMail.indexOf("</body>")>0)
            			bodyMail=bodyMail.replace("</body>", "<img src=\""+urlAcuse+"\" width=\"1px\" HEIGHT=\"1px\"></body>");
            		else
            			bodyMail=bodyMail+"<img src=\""+urlAcuse+"\" width=\"1px\" HEIGHT=\"1px\">";
            	}
            }
            
            messageBodyPart.setContent(bodyMail,"text/html");
            System.out.println("Enviando...=====>"+bodyMail);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            
            //Se adjuntan los archivos al correo
            if( attachment!=null && attachment.size()>0 ){
               for( String rutaAdjunto : attachment ){
                   messageBodyPart = new MimeBodyPart();
                   File f = new File(rutaAdjunto);
                   if( f.exists() ){
                      DataSource source = new FileDataSource( rutaAdjunto );
                      messageBodyPart.setDataHandler( new DataHandler(source) );
                      messageBodyPart.setFileName( f.getName() );
                      multipart.addBodyPart(messageBodyPart);
                   }
               }
            }
            message.setContent(multipart);
            //bodyMail
            if( embeddedImages!=null && embeddedImages.size()>0 ){
            	for( EmbeddedImages datos : embeddedImages ){
            		messageBodyPart = new MimeBodyPart();
            		File f = new File(datos.getPath());
            		if( f.exists() ){
            			messageBodyPart.attachFile(datos.getPath());
            			messageBodyPart.setHeader("Content-ID", datos.getId());
            			multipart.addBodyPart(messageBodyPart);
            			
            		}
            	}
            }
            message.setContent(multipart);
            
            Transport t = session.getTransport("smtp");
            t.connect(userAuth, passAuth);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
			
		}
		catch (AddressException e) {
			e.printStackTrace();
	    	throw new RuntimeException("" + e, e);
		}
		catch (IOException e) {
			e.printStackTrace();
	    	throw new RuntimeException("" + e, e);
		}
		catch (MessagingException mex) {
		      	mex.printStackTrace();
		    	throw new RuntimeException("" + mex, mex);
	    }
		
		System.out.println("FIN Service: Ejecutando metodo sendGeneral");
		logger.info("FIN Service: Ejecutando metodo sendGeneral");
	}
	
}