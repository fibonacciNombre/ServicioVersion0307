package bbva.delivery.services.commons;

public class ConstantsProperties {
	
	//Tipos de Error
	public static final String ORIGEN_ERROR_EXCEPCION 	 	= "exception";
	public static final String ORIGEN_ERROR_VALIDACION 	 	= "validation";
	
	//Owners de los esquemas de base de datos
	public static final String OWNER_ESQUEMA_ACUERDO 	 	= "owner.esquema.acuerdo";
	public static final String OWNER_ESQUEMA_COMUNES  	 	= "owner.esquema.comunes";
	public static final String OWNER_ESQUEMA_PRODUCTO 	 	= "owner.esquema.producto";
	public static final String OWNER_ESQUEMA_TERCERO 	 	= "owner.esquema.tercero";
	
	//Packages de base de datos
	public static final String PQ_ACUERDO_CERTIFICADO_V2 	= "package.acuerdo.certificadov2";
	
	public static final String PQ_ACUERDO_ALERTA 			= "package.acuerdo.alerta";
	public static final String PQ_ACUERDO_CARTA_GARANTIA	= "package.acuerdo.cartasgarantia";
	public static final String PQ_ACUERDO_REEMBOLSO			= "package.acuerdo.reembolso";
	public static final String PQ_ACUERDO_POLIZA_DIGITAL	= "package.acuerdo.polizadigital";
	
	public static final String PQ_TERCERO_TERCERO 			= "package.tercero.tercero";
	public static final String PQ_TERCERO_PUNTOCONTACTO 	= "package.tercero.puntocontacto";
	public static final String PQ_TERCERO_PERSONA			= "package.tercero.persona";
	
	public static final String PQ_COMUNES_COMUN 		 	= "package.comunes.comun";
	public static final String PQ_COMUNES_ASISTENCIA	 	= "package.comunes.asistencia";
	public static final String PQ_COMUNES_FICHATECNICA	 	= "package.comunes.fichatecnica";
	
	public static final String PQ_PRODUCTO_MANTENIMIENTO	= "package.producto.mantenimiento";
	public static final String PQ_PRODUCTO_PLAN_SALUD 	 	= "package.producto.plansalud";
	public static final String PQ_PRODUCTO_SALUD_COMP	 	= "package.producto.saludcomp";
	public static final String PQ_PRODUCTO_LST_TABLAS_PROD	= "package.producto.listartablas";
	
	//Constantes TIVOLI DIRECTORY SERVER
	public static final String TDS_LDAP_AUTHENTICATION		= "tds.authentification";
	public static final String TDS_LDAP_FACTORY 			= "tds.factory";
	public static final String TDS_LDAP_HOST 				= "tds.host";
	public static final String TDS_LDAP_PREFFIX_NAME 		= "tds.preffixname";
	public static final String TDS_LDAP_SUFFIX_NAME 		= "tds.suffixname";
	public static final String TDS_LDAP_ADMIN 				= "tds.admin";
	public static final String TDS_LDAP_PASSWORD 			= "tds.password";
	public static final String TDS_CRYPTOKEY				= "tds.cryptokey";
	
}
