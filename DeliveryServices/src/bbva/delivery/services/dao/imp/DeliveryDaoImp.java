package bbva.delivery.services.dao.imp;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import oracle.jdbc.OracleTypes;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import bbva.delivery.services.bean.ArchivoGenerado;
import bbva.delivery.services.bean.ArchivoPDF;
import bbva.delivery.services.bean.Courier;
import bbva.delivery.services.bean.Delivery;
import bbva.delivery.services.bean.Parametro;
import bbva.delivery.services.bean.RequestChangeEstadoRegistro;
import bbva.delivery.services.bean.RequestGetVisitasUsuario;
import bbva.delivery.services.bean.RequestInformarActivacionBBVA;
import bbva.delivery.services.bean.RequestInformarEntregaCourier;
import bbva.delivery.services.bean.RequestTransferirArchivo;
import bbva.delivery.services.bean.RequestValidarCourier;
import bbva.delivery.services.bean.Usuario;
import bbva.delivery.services.bean.ValidarCourier;
import bbva.delivery.services.bean.VisitasUsuario;
import bbva.delivery.services.commons.ConstantsProperties;
import bbva.delivery.services.comun.dao.imp.JdbcDaoBase;
import bbva.delivery.services.dao.DeliveryDao;
import bbva.delivery.services.util.JdbcHelper;

/**
 * @author dingan
 *
 */
@Repository("deliveryDao")
public class DeliveryDaoImp extends JdbcDaoBase implements DeliveryDao {
	
	private static DeliveryDaoImp instance;
	
	private static final ResourceBundle resources = ResourceBundle.getBundle("configuracion");
	
	private final static String ESQUEMA_BBVA 		= resources.getString(ConstantsProperties.OWNER_ESQUEMA_DELIVERY);
	private final static String PAQUETE_SERVICIO 	= resources.getString(ConstantsProperties.PQ_DEL_SERVICIO);
	private final static String PAQUETE_COURIER 	= resources.getString(ConstantsProperties.PQ_DEL_COURIER);
	private final static String PAQUETE_USUARIO 	= resources.getString(ConstantsProperties.PQ_DEL_USUARIO);
	private final static String PAQUETE_COMUN 		= resources.getString(ConstantsProperties.PQ_DEL_COMUN);
	
	public DeliveryDaoImp() {
		super();
	}
	
	public static DeliveryDaoImp getInstance() {
	    if (instance == null) {
		  instance = new DeliveryDaoImp();
	    }
	    return instance;
	}
	
	//trae un usuario
	@SuppressWarnings("unchecked")
	public Usuario getUsuario(Usuario usuario){
		logger.debug("INI DAO: Ejecutando metodo getUsuario");
		System.out.println("INI DAO: Ejecutando metodo getUsuario");
		List<Usuario> usr = null;
		MapSqlParameterSource in = null;
		
		SimpleJdbcCall call= null;
		Map<String, Object> out = null;
		in = new MapSqlParameterSource();
		
		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), ESQUEMA_BBVA, PAQUETE_SERVICIO, "sp_obt_usuario_servicio");
		
		JdbcHelper.setInOutParameter(call,in,"a_codusuario",Types.VARCHAR,usuario.getCodusuario());
		JdbcHelper.setOutParameter(call, "a_cursor", OracleTypes.CURSOR, Usuario.class);
		
		out = call.execute(in);
		
		usr = (List<Usuario>) out.get("a_cursor");
		
		System.out.println("FIN DAO: Ejecutando metodo getUsuario");
		logger.debug("FIN DAO: Ejecutando metodo getUsuario");
		
		return usr.get(0);

	}
	
	@SuppressWarnings("unchecked")
	public List<Delivery> lstDelivery(Delivery param){
		logger.debug("INI DAO: Ejecutando metodo lstDelivery");
		System.out.println("INI DAO: Ejecutando metodo lstDelivery");
		List<Delivery> lista = null;
		
		MapSqlParameterSource in = null;
		
		SimpleJdbcCall call= null;
		Map<String, Object> out = null;
		in = new MapSqlParameterSource();
		
		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), ESQUEMA_BBVA, PAQUETE_COURIER, "sp_lst_delivery");
		
		JdbcHelper.setInParameter(call, in, "a_nrodocumentocli", OracleTypes.VARCHAR, param.getNrodocumentocli());
		JdbcHelper.setInParameter(call, in, "a_nombrescli", OracleTypes.VARCHAR, param.getNombrescli());
		JdbcHelper.setInParameter(call, in, "a_nrodocumentocou", OracleTypes.VARCHAR, param.getNrodocumentocli());
		JdbcHelper.setInParameter(call, in, "a_nombrecou", OracleTypes.VARCHAR, param.getNombrescli());
		JdbcHelper.setOutParameter(call, "a_cursor", OracleTypes.CURSOR, Delivery.class);
		
		out = call.execute(in);
		
		lista = (List<Delivery>) out.get("a_cursor");
		System.out.println("FIN DAO: Ejecutando metodo lstDelivery");
		logger.debug("FIN DAO: Ejecutando metodo lstDelivery");
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Courier> obtenerListaCourier(){
		logger.debug("INI DAO: Ejecutando metodo obtenerListaCourier");
		System.out.println("INI DAO: Ejecutando metodo obtenerListaCourier");
		List<Courier> lista = null;
		
		MapSqlParameterSource in = null;
		
		SimpleJdbcCall call= null;
		Map<String, Object> out = null;
		in = new MapSqlParameterSource();

		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), ESQUEMA_BBVA, PAQUETE_COURIER, "sp_lst_courier");
		
		JdbcHelper.setInParameter(call, in, "a_codbbva", OracleTypes.VARCHAR, "");
		JdbcHelper.setInParameter(call, in, "a_rznsocial", OracleTypes.VARCHAR, "");
		JdbcHelper.setInParameter(call, in, "a_nrodocumentocou", OracleTypes.VARCHAR, "");
		JdbcHelper.setInParameter(call, in, "a_idpestado", OracleTypes.NUMERIC, 1);
		JdbcHelper.setOutParameter(call, "a_cursor", OracleTypes.CURSOR, Courier.class);
		
		out = call.execute(in);
		
		lista = (List<Courier>) out.get("a_cursor");
		System.out.println("FIN DAO: Ejecutando metodo obtenerListaCourier");
		logger.debug("FIN DAO: Ejecutando metodo obtenerListaCourier");
		return lista;
	}
	
	public Usuario addUsuario(Usuario usuario){
		logger.debug("INI DAO: Ejecutando metodo addUsuario");
		System.out.println("INI DAO: Ejecutando metodo addUsuario");
		Usuario usr = new Usuario();
		MapSqlParameterSource in = null;
		
		SimpleJdbcCall call= null;
		Map<String, Object> out = null;
		in = new MapSqlParameterSource();
		
		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), ESQUEMA_BBVA, PAQUETE_USUARIO, "sp_mnt_usuario");
		
		JdbcHelper.setInOutParameter(call,in,"a_idusuario",Types.NUMERIC, usuario.getIdeusuario());
		JdbcHelper.setInParameter(call, in, "a_contrasena", OracleTypes.VARCHAR, usuario.getContrasena());
		JdbcHelper.setInParameter(call, in, "a_idtercero", OracleTypes.NUMERIC, usuario.getIdtercero());
		JdbcHelper.setInParameter(call, in, "a_idperfil", OracleTypes.NUMERIC, usuario.getIdperfil());
		JdbcHelper.setInParameter(call, in, "a_idpestado", OracleTypes.NUMERIC, usuario.getIdpestado());
		JdbcHelper.setInParameter(call, in, "a_codusuario", OracleTypes.VARCHAR, usuario.getCodusuario());
		JdbcHelper.setInParameter(call, in, "a_historial", OracleTypes.VARCHAR, usuario.getHistorial());
		JdbcHelper.setInParameter(call, in, "a_comentario", OracleTypes.VARCHAR, usuario.getComentario());
		JdbcHelper.setInParameter(call, in, "a_usuario", OracleTypes.VARCHAR, usuario.getUsuario());
//		JdbcHelper.setOutParameter(call, "a_cursor", OracleTypes.CURSOR, Usuario.class);
		
		out = call.execute(in);
		
		usr.setIdeusuario(Integer.parseInt(((BigDecimal) out.get("a_idusuario")).toString()));
		System.out.println("FIN DAO: Ejecutando metodo addUsuario");
		logger.debug("FIN DAO: Ejecutando metodo addUsuario");
		
		return usr;
	}
	
	@SuppressWarnings("unchecked")
	public Usuario obtUsuario(Integer id){
		logger.debug("INI DAO: Ejecutando metodo obtUsuario");
		System.out.println("INI DAO: Ejecutando metodo obtUsuario");
		List<Usuario> usr = null;
		MapSqlParameterSource in = null;
		
		SimpleJdbcCall call= null;
		Map<String, Object> out = null;
		in = new MapSqlParameterSource();
		
		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), ESQUEMA_BBVA, PAQUETE_USUARIO, "sp_obt_usuario");
		
		JdbcHelper.setInOutParameter(call,in,"a_idusuario",Types.NUMERIC,id);

		JdbcHelper.setOutParameter(call, "a_cursor", OracleTypes.CURSOR, Usuario.class);
		
		out = call.execute(in);
		
		usr = (List<Usuario>) out.get("a_cursor");
		
		System.out.println("FIN DAO: Ejecutando metodo obtUsuario");
		logger.debug("FIN DAO: Ejecutando metodo obtUsuario");
		
		return usr.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<VisitasUsuario> getVisitasUsuario( RequestGetVisitasUsuario requestGetVisitasUsuario, String fecha){
		logger.debug("INI DAO: Ejecutando metodo getVisitasUsuario");
		System.out.println("INI DAO: Ejecutando metodo getVisitasUsuario");
		List<VisitasUsuario> visitasUsuarios = null;
		MapSqlParameterSource in = null;
		
		SimpleJdbcCall call= null;
		Map<String, Object> out = null;
		in = new MapSqlParameterSource();
		
		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), ESQUEMA_BBVA, PAQUETE_SERVICIO, "sp_lst_visitas_usuario");
		
		JdbcHelper.setInParameter(call, in, "a_codbbva", OracleTypes.VARCHAR, requestGetVisitasUsuario.getCodbbva());
		JdbcHelper.setInParameter(call, in, "a_nrodocumento", OracleTypes.VARCHAR, requestGetVisitasUsuario.getDni());
		JdbcHelper.setInParameter(call, in, "a_fecentrega", OracleTypes.VARCHAR, fecha);
		JdbcHelper.setOutParameter(call, "a_cursor", OracleTypes.CURSOR, VisitasUsuario.class);
		
		out = call.execute(in);
		
		visitasUsuarios = (List<VisitasUsuario>) out.get("a_cursor");
		
		logger.debug("FIN DAO: Ejecutando metodo getVisitasUsuario");
		System.out.println("FIN DAO: Ejecutando metodo getVisitasUsuario");
		
		return visitasUsuarios;
	}
	
	@SuppressWarnings("unchecked")
	public List<ValidarCourier> validarDNICourier( RequestValidarCourier requestValidarCourier){
		logger.debug("INI DAO: Ejecutando metodo validarDNICourier");
		System.out.println("INI DAO: Ejecutando metodo validarDNICourier");
		List<ValidarCourier> validarCourier = null;
		MapSqlParameterSource in = null;
		
		SimpleJdbcCall call= null;
		Map<String, Object> out = null;
		in = new MapSqlParameterSource();
		
		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), ESQUEMA_BBVA, PAQUETE_SERVICIO, "sp_validar_usuario");
		
		JdbcHelper.setInParameter(call, in, "a_codbbva", OracleTypes.VARCHAR, requestValidarCourier.getCodbbva());
		JdbcHelper.setInParameter(call, in, "a_nrodocumento", OracleTypes.VARCHAR, requestValidarCourier.getDni());
		JdbcHelper.setOutParameter(call, "a_cursor", OracleTypes.CURSOR, ValidarCourier.class);
		
		out = call.execute(in);
		
		validarCourier = (List<ValidarCourier>) out.get("a_cursor");
		
		System.out.println("FIN DAO: Ejecutando metodo validarDNICourier");
		logger.debug("FIN DAO: Ejecutando metodo validarDNICourier");
		
		return validarCourier;
	}
	
	
	@SuppressWarnings("unchecked")
	public RequestChangeEstadoRegistro changeEstadoRegistro( RequestChangeEstadoRegistro requestChangeEstadoRegistro){
		logger.debug("INI DAO: Ejecutando metodo changeEstadoRegistro");
		System.out.println("INI DAO: Ejecutando metodo changeEstadoRegistro");
		List<RequestChangeEstadoRegistro> rcer = null;
		MapSqlParameterSource in = null;
		
		SimpleJdbcCall call= null;
		Map<String, Object> out = null;
		in = new MapSqlParameterSource();
		
		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), ESQUEMA_BBVA, PAQUETE_SERVICIO, "sp_act_delivery_entrega");

		JdbcHelper.setInParameter(call, in, "a_iddelivery", OracleTypes.NUMERIC, requestChangeEstadoRegistro.getCodigoEntrega());
		JdbcHelper.setInParameter(call, in, "a_estado", OracleTypes.NUMERIC, requestChangeEstadoRegistro.getEstado());
		JdbcHelper.setInParameter(call, in, "a_motivo", OracleTypes.VARCHAR, requestChangeEstadoRegistro.getMotivo());
		JdbcHelper.setInParameter(call, in, "a_codbbva", OracleTypes.VARCHAR, requestChangeEstadoRegistro.getCodbbva());
		JdbcHelper.setInParameter(call, in, "a_nrodocumento", OracleTypes.VARCHAR, requestChangeEstadoRegistro.getDni());
		JdbcHelper.setInParameter(call, in, "a_historial", OracleTypes.VARCHAR, ToStringBuilder.reflectionToString(requestChangeEstadoRegistro,ToStringStyle.MULTI_LINE_STYLE));
		JdbcHelper.setOutParameter(call, "a_cursor", OracleTypes.CURSOR, RequestChangeEstadoRegistro.class);
		
		
		out = call.execute(in);
		
		rcer = (List<RequestChangeEstadoRegistro>) out.get("a_cursor");
		
		requestChangeEstadoRegistro.setCodigo(rcer.get(0).getCodigo());
		requestChangeEstadoRegistro.setMensaje(rcer.get(0).getMensaje());
		
		System.out.println("FIN DAO: Ejecutando metodo changeEstadoRegistro");
		logger.debug("FIN DAO: Ejecutando metodo changeEstadoRegistro");
		
		return requestChangeEstadoRegistro;
	}
	
	@SuppressWarnings("unchecked")
	public List<Delivery> informarEntregaCourier( RequestInformarEntregaCourier requestInformarEntregaCourier){
		logger.debug("INI DAO: Ejecutando metodo informarEntregaCourier");
		System.out.println("INI DAO: Ejecutando metodo informarEntregaCourier");
		List<Delivery> deliveries = null;
		MapSqlParameterSource in = null;
		
		SimpleJdbcCall call= null;
		Map<String, Object> out = null;
		in = new MapSqlParameterSource();
		
		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), ESQUEMA_BBVA, PAQUETE_SERVICIO, "sp_obt_delivery_servicio");
		
		JdbcHelper.setInParameter(call, in, "a_nrodocumento", OracleTypes.VARCHAR, requestInformarEntregaCourier.getDni());
		JdbcHelper.setInParameter(call, in, "a_codbbva", OracleTypes.VARCHAR, requestInformarEntregaCourier.getCodbbva());
		JdbcHelper.setInParameter(call, in, "a_iddelivery", OracleTypes.NUMERIC, requestInformarEntregaCourier.getCodigoEntrega());
		JdbcHelper.setOutParameter(call, "a_cursor", OracleTypes.CURSOR, Delivery.class);
		
		out = call.execute(in);
		
		deliveries = (List<Delivery>) out.get("a_cursor");
		
		System.out.println("FIN DAO: Ejecutando metodo informarEntregaCourier");
		logger.debug("FIN DAO: Ejecutando metodo informarEntregaCourier");
		
		return deliveries;
	}
	
	@SuppressWarnings("unchecked")
	public List<Delivery> informarActivacionBBVA( RequestInformarActivacionBBVA requestInformarActivacionBBVA){
		logger.debug("INI DAO: Ejecutando metodo informarActivacionBBVA");
		System.out.println("INI DAO: Ejecutando metodo informarActivacionBBVA");
		List<Delivery> deliveries = null;
		MapSqlParameterSource in = null;
		
		SimpleJdbcCall call= null;
		Map<String, Object> out = null;
		in = new MapSqlParameterSource();
		
		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), ESQUEMA_BBVA, PAQUETE_SERVICIO, "sp_obt_delivery_servicio");
		
		JdbcHelper.setInParameter(call, in, "a_nrodocumento", OracleTypes.VARCHAR, requestInformarActivacionBBVA.getDni());
		JdbcHelper.setInParameter(call, in, "a_codbbva", OracleTypes.VARCHAR, null);
		JdbcHelper.setInParameter(call, in, "a_iddelivery", OracleTypes.NUMERIC, requestInformarActivacionBBVA.getCodigoEntrega());
		JdbcHelper.setOutParameter(call, "a_cursor", OracleTypes.CURSOR, Delivery.class);
		
		out = call.execute(in);
		
		deliveries = (List<Delivery>) out.get("a_cursor");
		
		System.out.println("FIN DAO: Ejecutando metodo informarActivacionBBVA");
		logger.debug("FIN DAO: Ejecutando metodo informarActivacionBBVA");
		
		return deliveries;
	}
	
	@SuppressWarnings("unchecked")
	public ArchivoGenerado transferirArchivo( RequestTransferirArchivo requestTransferirArchivo){
		logger.debug("INI DAO: Ejecutando metodo transferirArchivo");
		System.out.println("INI DAO: Ejecutando metodo transferirArchivo");
		List<ArchivoGenerado> rcer = null;
		MapSqlParameterSource in = null;
		
		SimpleJdbcCall call= null;
		Map<String, Object> out = null;
		in = new MapSqlParameterSource();
		
		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), ESQUEMA_BBVA, PAQUETE_SERVICIO, "sp_act_delivery_archivo_pdf");

		JdbcHelper.setInParameter(call, in, "a_iddelivery", OracleTypes.NUMERIC, requestTransferirArchivo.getCodigoEntrega());
		//JdbcHelper.setInParameter(call, in, "a_codbbva", OracleTypes.VARCHAR, requestChangeEstadoRegistro.getCodbbva());
		JdbcHelper.setInParameter(call, in, "a_archivodeliverypdf", OracleTypes.CLOB, requestTransferirArchivo.getArchivo());
		//JdbcHelper.setInParameter(call, in, "a_historial", OracleTypes.VARCHAR, ToStringBuilder.reflectionToString(requestTransferirArchivo,ToStringStyle.MULTI_LINE_STYLE));
		JdbcHelper.setOutParameter(call, "a_cursor", OracleTypes.CURSOR, ArchivoGenerado.class);
		
		
		out = call.execute(in);
		
		rcer = (List<ArchivoGenerado>) out.get("a_cursor");
		
		System.out.println("FIN DAO: Ejecutando metodo transferirArchivo");
		logger.debug("FIN DAO: Ejecutando metodo transferirArchivo");
		
		return rcer.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<ArchivoPDF> getArchivoPDF( ArchivoPDF archivoPDF){
		logger.debug("INI DAO: Ejecutando metodo getArchivoPDF");
		System.out.println("INI DAO: Ejecutando metodo getArchivoPDF");
		List<ArchivoPDF> rcer = null;
		MapSqlParameterSource in = null;
		
		SimpleJdbcCall call= null;
		Map<String, Object> out = null;
		in = new MapSqlParameterSource();
		
		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), ESQUEMA_BBVA, PAQUETE_SERVICIO, "sp_obt_delivery_archivo_pdf");

		JdbcHelper.setInParameter(call, in, "a_iddelivery", OracleTypes.NUMERIC, archivoPDF.getCodigoEntrega());
		//JdbcHelper.setInParameter(call, in, "a_codbbva", OracleTypes.VARCHAR, requestChangeEstadoRegistro.getCodbbva());
		//JdbcHelper.setInParameter(call, in, "a_archivodeliverypdf", OracleTypes.CLOB, archivoPDF.getArchivo());
		//JdbcHelper.setInParameter(call, in, "a_historial", OracleTypes.VARCHAR, ToStringBuilder.reflectionToString(requestTransferirArchivo,ToStringStyle.MULTI_LINE_STYLE));
		JdbcHelper.setOutParameter(call, "a_cursor", OracleTypes.CURSOR, ArchivoPDF.class);
		
		
		out = call.execute(in);
		
		rcer = (List<ArchivoPDF>) out.get("a_cursor");
		
		System.out.println("FIN DAO: Ejecutando metodo getArchivoPDF");
		logger.debug("FIN DAO: Ejecutando metodo getArchivoPDF");
		
		return rcer;
	}
	
	@SuppressWarnings("unchecked")
	public List<Parametro> getParametros(String idparametrotipo){
		
		logger.debug("INI DAO: Ejecutando metodo getParametros");
		System.out.println("INI DAO: Ejecutando metodo getParametros");
		List<Parametro> rcer = null;
		MapSqlParameterSource in = null;
		
		SimpleJdbcCall call= null;
		Map<String, Object> out = null;
		in = new MapSqlParameterSource();
		
		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), ESQUEMA_BBVA, PAQUETE_COMUN, "sp_lst_parametro");

		JdbcHelper.setInParameter(call, in, "a_idparametrotipo", OracleTypes.VARCHAR, idparametrotipo);
		JdbcHelper.setOutParameter(call, "a_cursor", OracleTypes.CURSOR, Parametro.class);
		
		out = call.execute(in);
		
		rcer = (List<Parametro>) out.get("a_cursor");
		
		System.out.println("FIN DAO: Ejecutando metodo getParametros");
		logger.debug("FIN DAO: Ejecutando metodo getParametros");
		
		return rcer;
	}

}

