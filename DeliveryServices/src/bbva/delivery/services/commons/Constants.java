package bbva.delivery.services.commons;

public class Constants {

	public static final String RUTA_ARCH_DEFAULT		 				= "RUTA_ARCH_CONF" ; //La constante se encuentra originalmente en RIMAC_SEG_Lib.jar
	
	public static final String FILE_CONFIGURACION_DELIVERY_SERVICES		= "DELIVERYSERVICES";

	public static final String RUTA_PROPERTIES_CONFIGURACION 			= "BBVA" +
																			System.getProperty("file.separator")+"DELIVERYSERVICES" +
																			System.getProperty("file.separator")+"properties";
	
	public static final String RUTA_FILE_CONFIGURACION_LOG4J 			= "BBVA" +
																			System.getProperty("file.separator")+"DELIVERYSERVICES" +
																			System.getProperty("file.separator")+"properties" +
																			System.getProperty("file.separator")+"log4j.properties";
	
	public static final String RUTA_FILE_CONFIGURACION_APP 				= "BBVA" +
																			System.getProperty("file.separator")+"DELIVERYSERVICES" +
																			System.getProperty("file.separator")+"properties" +
																			System.getProperty("file.separator")+"DELIVERYSERVICES.properties";
	
	//Constantes para la lectura de Archivos
	public static final String ARCHIVO_RUTA_TEMPORAL 	 			= "temp";
	public static final String SEPARADOR 				 			= System.getProperty("file.separator");
	
	//Parametros SAS
	public static final String PARAMETRO_PRTWEB_POLIZAS 			= "PRTWEB_GRUPOPOLIZAS";
	
		//Parametros SAS - MIS SEGUROS
	public static final String PARAM_PWEB_SEG_GRUPOPROD 			= "PWEB_SEG_GRUPOPROD";
	public static final String PARAM_PWEB_SEG_PRODUCTO 				= "PWEB_SEG_PRODUCTO";

		//Parametros SAS - ALERTAS
	public static final String PARAM_PWEB_ALERT_GRUPOPRODUCTO		= "PWEB_ALERT_GRUPOPROD";
	public static final String PARAM_PWEB_ALERT_FRECUENCIA			= "PWEB_ALERT_FRECUENCIA";
	public static final String PARAM_PWEB_ALERT_OPCIONENV			= "PWEB_ALERT_OPCIONENV";
	public static final String PARAM_PWEB_ALERT_CODPROD				= "PWEB_ALERT_CODPROD";

		//Parametros SAS - REEMBOLSOS
	public static final String PARAM_PWEB_REEMB_MONEDAS				= "PWEB_REEM_MONEDAS";//"NPW_COMBO_MONEDA";
	public static final String PARAM_PWEB_REEMB_BANCOS				= "PWEB_REEM_BANCO";//"NPW_COMBO_BANCO";
	public static final String PARAM_PWEB_REEMB_TIPOCTA				= "PWEB_REEM_TIPOCTA";//"NPW_COMBO_TIPOCUENTABANCO";
	

	public static final String PARAM_PWEB_CLN_COSTOATENCION 		= "PWEB_CLN_COSTOATENC";
	public static final String PARAM_PEWB_CLN_BSQDEFAULT 			= "PWEB_CLN_BSQDEFAULT";

	public static final String PARAM_PEWB_TLL_BSQDEFAULT 			= "PWEB_TLL_BSQDEFAULT";
	public static final String PARAM_PEWB_CLN_TIPPROVEEDOR 			= "PWEB_CLN_TIPPROVEEDOR";

	
	//Parametros SAS - RECLAMOS
	public static final String PARAMETRO_PWEB_REC_ENT_BANCARIA		= "PWEB_REC_ENTBANCARIA";
	public static final String PARAMETRO_PWEB_REC_TIPO_CUENTA		= "PWEB_REC_TIPCTABANCARIA";
	public static final String PARAMETRO_PWEB_REC_TIPO_DOCUMENTO	= "PWEB_REC_TIPDOC";
	public static final String PARAMETRO_PWEB_REC_SERVICIOS_SALUD	= "PWEB_REC_SERVSALUD";
	public static final String PARAMETRO_PWEB_REC_SERVICIOS_SOAT	= "PWEB_REC_SERVSOAT";
	public static final String PARAMETRO_PWEB_REC_PROVEEDORES		= "PWEB_REC_PROVEEDORES";
	public static final String PARAMETRO_PWEB_REC_TIPO_MONEDA		= "PWEB_REC_MONEDAS";
	
	//CODIGOC DE PARAMETROS SAS
		//CODIGOC - MIS SEGUROS
	public static final String CODIGOC_GRUPOPROD_VIDA_REP 			= "GP_VIDA_REP";
	public static final String CODIGOC_GRUPOPROD_OTROS_REP 			= "GP_OTROS_REP";
	
	public static final String CODIGOC_PROD_VEHI_AX	 				= "P_VEHI_AX";
	public static final String CODIGOC_PROD_VEHI_SAS 				= "P_VEHI_SAS";
	public static final String CODIGOC_PROD_SOAT_AX	 				= "P_SOAT_AX";
	public static final String CODIGOC_PROD_SOAT_SAS 				= "P_SOAT_SAS";
	public static final String CODIGOC_PROD_DOMI_AX	 				= "P_DOMI_AX";
	public static final String CODIGOC_PROD_DOMI_SAS 				= "P_DOMI_SAS";

		//CODIGOC - ALERTAS
	public static final String CODIGOC_CODPROD_VEHI_ALERT			= "P_VEHI_ALERTAS";
	public static final String CODIGOC_CODPROD_VIDA_ALERT			= "P_VIDA_ALERTAS";
	public static final String CODIGOC_CODPROD_DOMI_ALERT 			= "P_DOMI_ALERTAS";
	public static final String CODIGOC_CODPROD_SALU_ALERT			= "P_SALU_ALERTAS";
	public static final String CODIGOC_CODPROD_OTROS_ALERT			= "P_OTROS_ALERTAS";
	public static final String CODIGOC_P_CODPROD_ALERTAS			= "P_CODPROD_ALERTAS";
	
		//CODIGOC - PARAMETRO TALLER SUCURSAL
	public static final String CODIGOC_TALLER_SUCURSAL_CLSVEH 		= "ATRIB_CLSVEH_MARCA";
	public static final String CODIGOC_TALLER_SUCURSAL_TIPVEH 		= "ATRIB_TIPVEH_MARCA";
	public static final String CODIGOC_TALLER_SUCURSAL_MRCVEH 		= "ATRIB_MARCA";
	public static final String CODIGOC_TALLER_SUCURSAL_SERVICIO 	= "ATRIB_SERVICIO";
		
	public static final String CODIGOC_CMBFRECUENCIA_ALERT			= "C_DIASALERTAS";
	public static final String CODIGOC_CMBOPCIONENVIO_ALERT			= "C_ENVIOALERTA";
	
	//Constantes para el portal web
	public static final String GRUPO_COMPONENTES_OTROS 				= "OTROS";

	//Constantes Generales
	public static final String TIPO_DATOS_SEGUROS 					= "0";
	public static final String TIPO_REPORTE_CUOTAS_HISTORICO		= "0";
	public static final String TIPO_REPORTE_CUOTAS_PENDIENTES		= "1";
	public static final String TIPO_REPORTE_CUOTAS_TODAS			= "2";
	
	public static final int NRO_MAX_CUOTAS_PAGADAS			= 3;
	public static final String ESTADO_CUOTAS_ANULADAS 		= "ANULADO";
	public static final String ESTADO_CUOTAS_VENCIDAS 		= "VENCIDO";
	public static final String ESTADO_CUOTAS_PENDIENTES 	= "PENDIENTE";
	public static final String ESTADO_CUOTAS_COBRADO_DE 	= "COBRADO/DE";
	public static final String ESTADO_CUOTAS_COBRADA 		= "COBRADA";
	public static final String CERTIFICADO_CUOTAS_MULTIPLE	= "M�ltiple";
	
	public static final String CFG_CLASEGRUPO_SALUD			= "COMP";
	public static final String CFG_TIPOGRUPO_SALUD			= "SAL";
	public static final String ESTADO_ACTIVO				= "ACT";
	public static final String CODIGO_PRODUCTO_EPS			= "CTE_PWEB_EPS";
	public static final String ESTADO_VIGENTE				= "VIGENTE";
	public static final String ESTADO_AL_DIA				= "AL DIA";
	public static final String CODIGO_ESTADO_PAGO_AL_DIA	= "0";
	public static final String CODIGO_ESTADO_PAGO_VENCIDO	= "1";
	public static final String INDICADOR_VIGENTE			= "S";
	public static final String CUOTAS_MULTIPLES				= "M�ltiple";
	public static final String IND_ACTIVO					= "1";
	public static final String IND_INACTIVO					= "0";
	public static final String IND_NO_DETERMINADO			= "NO DETERMINADO";
	
	
	//Constantes Mis-Seguros
	public static final String TIP_SEGURO_EPS			= "EPS";
	public static final String TIP_SEGURO_SALUD			= "SALUD";
	public static final String TIP_SEGURO_VIDA			= "VIDA";
	public static final String TIP_SEGURO_VEHICULAR		= "VEHICULAR";
	public static final String TIP_SEGURO_SOAT			= "SOAT";
	public static final String TIP_SEGURO_DOMICILIARIO	= "DOMICILIARIO";
	public static final String TIP_SEGURO_OTROS			= "OTROS";	
	public static final String COMP_NOMBRE_DEFAULT		= "M�S COBERTURAS";
	
	public static final String RUTA_PDF_TEMP_PATH			= "temp";
	public static final Integer CCM_NOTIF_ESTADO_PENDIENTE	= 0;
	public static final Integer CCM_NOTIF_ESTADO_ENVIADO	= 1;
	public static final Integer CCM_NOTIF_ESTADO_ANULADO	= 2;
	public static final String CCM_NOTIF_ERROR				= "ERROR";
	public static final String CCM_NOTIF_OK					= "OK";
	public static final String CCM_NOTIF_CORREO_ENVIADO		= "Enviado";
	public static final String CCM_NOTIF_CORREO_ENVIAR_SI	= "S";
	public static final String CCM_NOTIF_CORREO_ENVIAR_NO	= "N";
	public static final String TIP_COMPONENTE_COBERTURA		= "COB";
	public static final String TIP_COMPONENTE_SERVICIO		= "SER";
	public static final Integer COMP_SERVICIO_EVENTOMAXIMO	= 3;
	//Constantes Alertas
	public static final String TIPO_DATOS_ALERTAS	  		= "0";
	public static final String TIPO_REPORTE_ALERTAS	 		= "1";
		
	//Constantes TIPO DE MEDIO DE CONTACTO
	public static final String TMC_EMAIL					= "CE";
	public static final String TMC_TELEF					= "TLF";
	
	//Constantes INDICADORES DE MODIFICACION DE DATOS DE USUARIO EN EL LDAP
	public static final String ACCION_LDAP_PWDTEMPORAL		= "1";
	public static final String ACCION_LDAP_MODIFDATOS		= "2";
	public static final String ACCION_LDAP_MODIFPREGSEG		= "3";
	public static final String ACCION_LDAP_MODIFPWD			= "4";
	public static final String ACCION_LDAP_MODIFCORREO		= "5";
	
	//Constantes INDICADORES DE LOGIN
	public static final String ACCION_WEB_ACCESOS_CORRECTOS			= "1";
	public static final String ACCION_WEB_ACCESOS_INCORRECTOS		= "2";
	public static final String ACCION_WEB_RENOVAR_PASSWORD			= "3";
	public static final String ACCION_WEB_PRIMER_LOGIN				= "4";
	public static final String ACCION_WEB_RENOVAR_DATOSCONTACTO		= "5";
	public static final String ACCION_WEB_MODIFPASSWORD				= "6";
	public static final String ACCION_WEB_MODIFPREGSEC				= "7";
	
	//Constantes INDICADORES DE ESTADOS DEL USUARIOWEB
	public static final Integer USR_STS_REGTEMPORAL			= 1;
	public static final Integer USR_STS_REGDEFINITIVO		= 2;
	public static final Integer USR_STS_RNVPASSWORD			= 3;
	public static final Integer	USR_STS_BLOQUEADO			= 4;
	public static final Integer	USR_STS_RVNDATOSCONTACTO	= 5;
	public static final Integer	USR_STS_MODIFPASSWORD		= 6;
	public static final Integer	USR_STS_MODIFPREGSEC		= 7;
	
	//Constantes RESPUESTA ESCENARIOS LOGIN
	public static final String RSP_ERROR_CONEXION			= "-1";
	public static final String RPS_LOGIN_USER_PRIMER_LOGIN	= "0";
	public static final String RSP_LOGIN_USER_NO_EXISTE		= "1";
	public static final String RSP_LOGIN_USER_CRED_INVALIDA	= "2";
	public static final String RSP_LOGIN_USER_CRED_VALIDA	= "3";
	public static final String RSP_LOGIN_USER_BLOQUEADO		= "4";
	public static final String RSP_LOGIN_USER_REG_DIRECCION	= "5";
		
	//Constantes REQ ATTRIBUTE SESSION
	public static final String REQ_ATTR_LOGINWEB			= "LOGINWEB";
	public static final String REQ_ATTR_USUARIOWEB			= "USUARIOWEB";
	public static final String REQ_ATTR_IDETERCERO			= "IDETERCERO";
	public static final String REQ_ATTR_CODEXTERNO			= "CODEXTERNO";
	public static final String REQ_ATTR_NRODOCUMENTO		= "NRODOCUMENTO";
	
//	public static final String REQ_ATTR_VALIDACION_LOGIN	= "VALIDA_LOGIN";
//	public static final String REQ_ATTR_MENSAJE_LOGIN		= "MENSAJE_LOGIN";		
//	public static final String REQ_ATTR_IDPTIPODOCUMENTO	= "TIPODOCUMENTO";	
//	public static final String REQ_ATTR_PASSWORD			= "PASSWORD";	
//	public static final String REQ_ATTR_NUMINTENTO			= "NUM_INTENTO";
	
	public static final String REQ_SESSION_USUARIO			= "USUARIOWEB";
	public static final String REQ_SESSION_PERSONA			= "PERSONAWEB";
	public static final String REQ_SESSION_DIRECCION		= "DIRECCIONWEB";
	public static final String REQ_SESSION_TELEFONO			= "TELEFONOWEB";
	public static final String REQ_SESSION_CORREO			= "CORREOWEB";
	
	public static final String REQ_SESSION_INDMOBILE		= "INDMOBILE";
	public static final String REQ_SESSION_TOKENID			= "TOKENID";
	
	//Constantes Registro Usuario/Direccion
	public static final String USO_DIRECCION_PWEB				="12|";
	public static final String USO_DIRECCION_CORRESPONDENCIA	="13|";
	public static final String ESTADO_USUARIO_ACT				="ACT";
	public static final String IND_DIR_PRINCIPAL_NO				="N";
	public static final String TIPO_VIA_CALLE					="CL";
	
	//Constantes Maximos Intentos Antes de Bloqueo
	public static final Integer MAX_INTENTO_BLOQ			= 5;
	
	//Constantes Core Busqueda Polizas
	public static final Integer RIMAC_SALUD_CORE 			= 1;
	public static final Integer REPLICA_CORE 	 			= 2;
	public static final Integer AX_CORE 					= 3;
	public static final Integer SAS_CORE 					= 4;
	
	//Constantes Id Modulo Notificaciones
	public static final String PARAM_IDMODULOS				= "PWEB_IDMOD_NOTIFICACION";
	public static final String MODULO_LOGIN					= "MOD_PERFIL";
	public static final String MODULO_CCM					= "MOD_CCM";
	public static final String MODULO_CARTASGARANTIA	 	= "MOD_CARTASGARANTIA";
	
	//Constantes Defaults Buscador Clinicas
	public static final String DFT_CLINICAS_PAIS				= "IDEPAIS";
	public static final String DFT_CLINICAS_DEPARTAMENTO		= "IDEDEPARTAMENTO";
	public static final String DFT_CLINICAS_PROVINCIA			= "IDEPROVINCIA";
	public static final String DFT_CLINICAS_DISTRITO			= "IDEDISTRITO";
	public static final String DFT_CLINICAS_CLINICA				= "IDETERCERO";
	public static final String DFT_CLINICAS_PRODUCTO_PRINCIPAL	= "IDEAX_PRODPRINCIPAL";
	public static final String DFT_CLINICAS_PRODUCTO_SECUNDARIO	= "IDEAX_PRODSECUNDARIO";
	public static final String DFT_CLINICAS_CATEGORIA			= "CATEGORIACOB";
	public static final String DFT_CLINICAS_COBERTURA			= "COBERTURA";
	public static final String DFT_CLINICAS_COSTO				= "COSTO";
	public static final String DFT_CLINICAS_PARENTESCO			= "PARENTESCO";
	public static final String DFT_CLINICAS_DISTANCIA_METROS	= "DISTANCIA_METROS";
	
	//Constantes Defaults Buscador Talleres
	public static final String DFT_TALLERES_PAIS				= "IDEPAIS";
	public static final String DFT_TALLERES_DEPARTAMENTO		= "IDEDEPARTAMENTO";
	public static final String DFT_TALLERES_PROVINCIA			= "IDEPROVINCIA";
	public static final String DFT_TALLERES_DISTRITO			= "IDEDISTRITO";
	public static final String DFT_TALLERES_IDPTIPOTALLER		= "IDPTIPOTALLER";
	public static final String DFT_TALLERES_IDPTIPOTALLER_TODOS	= "T";
	
	public static final String DFT_TALLERES_IDEVALCLSVEH		= "IDEVALCLSVEH";
	public static final String DFT_TALLERES_IDEVALTIPOVEH		= "IDEVALTIPOVEH";
	public static final String DFT_TALLERES_IDEMARCA			= "IDEMARCA";
	public static final String DFT_TALLERES_DISTANCIA_METROS	= "DISTANCIA_METROS";
	
	//CONSULTA SERVICIOS DE CLINICAS EN RS
	public static final Integer CLINICAS_CONSULTA_SAS			= 1;
	public static final Integer CLINICAS_CONSULTA_RS			= 0;
	public static final String CLINICAS_SIMBOLO_SOLES_RS		= "S/";
	public static final String CLINICAS_SIMBOLO_SOLES_SAS		= "S/.";
	
	//Cosntante cron. de notificacion de envio Cartas Garantia
	public static final String CRON_EXPRESSION_CG				= "0 0/30 * * * ?";
		
	//Tipo Parametros
	public static final String PARAMETRO_TALLER_SUCURSAL = "TER_TALLERSUCURSAL";
	public static final String PARAMETRO_TIPO_TALLER 	 = "LUG_TIPOLUGARTALLER";
	
	//Usuario para campos de auditoria
	public static final String USUARIO_PWEB						= "PWEB";
	
	//Estados de un transaccion en el DeliveryServices	
	public static final Integer TRANSACCION_STATUS_OK			= 0;
	public static final Integer TRANSACCION_STATUS_ERROR		= 1;
}
