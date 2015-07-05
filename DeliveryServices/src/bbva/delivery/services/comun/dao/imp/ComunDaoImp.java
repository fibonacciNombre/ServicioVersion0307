package bbva.delivery.services.comun.dao.imp;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import bbva.delivery.services.commons.ConstantsProperties;
import bbva.delivery.services.comun.bean.ArchivoBlob;
import bbva.delivery.services.comun.bean.Atributo;
import bbva.delivery.services.comun.bean.CboDepartamento;
import bbva.delivery.services.comun.bean.CboDistrito;
import bbva.delivery.services.comun.bean.CboPais;
import bbva.delivery.services.comun.bean.CboProvincia;
import bbva.delivery.services.comun.bean.Constante;
import bbva.delivery.services.comun.bean.ListaParametroCursor;
import bbva.delivery.services.comun.bean.Parametro;
import bbva.delivery.services.comun.bean.Valor;
import bbva.delivery.services.comun.dao.ComunDao;

import com.rimac.sas.utiles.comunes.JdbcHelper;

@Repository("comunDao")
public class ComunDaoImp extends JdbcDaoBase implements ComunDao {
	
	private static final ResourceBundle resources = ResourceBundle.getBundle("configuracion");
	
	private String OWNER_ESQUEMA_COMUNES 	= resources.getString(ConstantsProperties.OWNER_ESQUEMA_COMUNES);
	private String PQ_COMUNES_COMUN 		= resources.getString(ConstantsProperties.PQ_COMUNES_COMUN);
	private String PQ_FICHA_TECNICA 		= resources.getString(ConstantsProperties.PQ_COMUNES_FICHATECNICA);
	
	private String OWNER_ESQUEMA_PRODUCTO 	= resources.getString(ConstantsProperties.OWNER_ESQUEMA_PRODUCTO);
	private String PQ_LISTAR_TABLAS_PROD  	= resources.getString(ConstantsProperties.PQ_PRODUCTO_LST_TABLAS_PROD);
	private String OWNER_ESQUEMA_TERCERO 	= resources.getString(ConstantsProperties.OWNER_ESQUEMA_TERCERO);
	private String PQ_TERCERO_PUNTOCONTACTO = resources.getString(ConstantsProperties.PQ_TERCERO_PUNTOCONTACTO);
	/*
	 * (non-Javadoc)
	 * @see rimac.portalweb.dao.ComunDaoImp#
	 * 		obtenerConstante(String)
	 */
	public Constante obtenerConstante(String ideConstante) {
		logger.info("Ejecutando m�todo: obtenerConstante");
		SimpleJdbcCall call = null;
		MapSqlParameterSource in = null;
		Map<String, Object> out = null;
		List<Constante> lstConstantes = null;
		
		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), 
				OWNER_ESQUEMA_COMUNES, PQ_COMUNES_COMUN,"sp_obt_constante");
		
		in = new MapSqlParameterSource();
		JdbcHelper.setInParameter(call,in,"a_ideconstante",Types.VARCHAR, ideConstante);
		JdbcHelper.setOutParameter(call, "a_cursor",OracleTypes.CURSOR, Constante.class);

		out = call.execute(in);
		lstConstantes = JdbcHelper.getListResultSet(out, "a_cursor", Constante.class);
		
		return (lstConstantes!=null && lstConstantes.size()>0)?lstConstantes.get(0):null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see rimac.portalweb.dao.ComunDaoImp#
	 * 		obtenerParametro(rimac.portalweb.bean.Parametro)
	 */	
	public Parametro obtenerParametro(Parametro parametro) {
		System.out.println("***************************parametro**********************");
//		System.out.println(ToStringBuilder.reflectionToString(parametro,ToStringStyle.MULTI_LINE_STYLE));
		logger.info("Ejecutando m�todo: obtenerParametro");
		SimpleJdbcCall call = null;
		MapSqlParameterSource in = null;
		Map<String, Object> out = null;
		List<Parametro> lista = null;
		
		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), 
				OWNER_ESQUEMA_COMUNES, PQ_COMUNES_COMUN,"sp_lst_parametro2");
		
		in = new MapSqlParameterSource();
		JdbcHelper.setInParameter(call,in,"a_idetippar",Types.VARCHAR, parametro.getIdeTipPar());
		JdbcHelper.setInParameter(call,in,"a_idetipparpadre",Types.VARCHAR, parametro.getIdeTipParPadre());
		JdbcHelper.setInParameter(call,in,"a_codigo",Types.VARCHAR, parametro.getCodigo());
		JdbcHelper.setInParameter(call,in,"a_abreviatura",Types.VARCHAR, parametro.getAbreviatura());
		JdbcHelper.setInParameter(call,in,"a_descripcion",Types.VARCHAR, parametro.getDescripcion());
		JdbcHelper.setInParameter(call,in,"a_descripcion2",Types.VARCHAR, parametro.getDescripcion2());
		JdbcHelper.setInParameter(call,in,"a_indactivo",Types.VARCHAR, parametro.getIndActivo());
		JdbcHelper.setInParameter(call,in,"a_masterdetail",Types.VARCHAR, parametro.getMasterDetail());
		JdbcHelper.setOutParameter(call, "v_cursor",OracleTypes.CURSOR, Parametro.class);

		out = call.execute(in);
		lista = JdbcHelper.getListResultSet(out, "v_cursor", Parametro.class);
		System.out.println("***************************parametro resultados..**********************");
//		for(Parametro t: lista){
//			System.out.println(ToStringBuilder.reflectionToString(t,ToStringStyle.MULTI_LINE_STYLE));	
//		}
		
		
		return (lista != null && lista.size() > 0)? lista.get(0) : new Parametro();
	}

	/* (non-Javadoc)
	 * @see rimac.portalweb.comun.dao.ComunDao#listarParametro(rimac.portalweb.comun.bean.Parametro)
	 */
	public List<Parametro> listarParametro(Parametro parametro) {
		logger.info("Ejecutando m�todo: obtenerParametro");
		SimpleJdbcCall call = null;
		MapSqlParameterSource in = null;
		Map<String, Object> out = null;
		
		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), 
				OWNER_ESQUEMA_COMUNES, PQ_COMUNES_COMUN,"sp_lst_parametro2");
		
		in = new MapSqlParameterSource();
		JdbcHelper.setInParameter(call,in,"a_idetippar",Types.VARCHAR, parametro.getIdeTipPar());
		JdbcHelper.setInParameter(call,in,"a_idetipparpadre",Types.VARCHAR, parametro.getIdeTipParPadre());
		JdbcHelper.setInParameter(call,in,"a_codigo",Types.VARCHAR, parametro.getCodigo());
		JdbcHelper.setInParameter(call,in,"a_abreviatura",Types.VARCHAR, parametro.getAbreviatura());
		JdbcHelper.setInParameter(call,in,"a_descripcion",Types.VARCHAR, parametro.getDescripcion());
		JdbcHelper.setInParameter(call,in,"a_descripcion2",Types.VARCHAR, parametro.getDescripcion2());
		JdbcHelper.setInParameter(call,in,"a_indactivo",Types.VARCHAR, parametro.getIndActivo());
		JdbcHelper.setInParameter(call,in,"a_masterdetail",Types.VARCHAR, parametro.getMasterDetail());
		JdbcHelper.setOutParameter(call, "v_cursor",OracleTypes.CURSOR, Parametro.class);

		out = call.execute(in);
		
		return JdbcHelper.getListResultSet(out, "v_cursor", Parametro.class);
	}
	
	/* (non-Javadoc)
	 * @see rimac.portalweb.comun.dao.ComunDao#obtenerListaParametros(rimac.portalweb.comun.bean.Parametro)
	 */
	@SuppressWarnings("unchecked")
	public void obtenerListaParametros(Parametro param) {
		
		SimpleJdbcCall call = null;
		SqlParameterSource in = null;
		Map<String, Object> out = null;
  
		call = new SimpleJdbcCall(getJdbcTemplate()).
							withSchemaName(resources.getString(ConstantsProperties.OWNER_ESQUEMA_COMUNES)).
							withCatalogName(resources.getString(ConstantsProperties.PQ_COMUNES_COMUN)).
							withProcedureName("SP_LISTA_PARAMETRO").
							withoutProcedureColumnMetaDataAccess().
							declareParameters(
									new SqlParameter("a_idetippar", Types.VARCHAR),
									new SqlOutParameter("a_cursor", OracleTypes.CURSOR, 
								    new BeanPropertyRowMapper<ListaParametroCursor>(ListaParametroCursor.class))
									);
		
		in = new MapSqlParameterSource().addValue("a_idetippar", param.getIdeTipPar());
  
		out = call.execute(in);
  
		param.setCursor((List<ListaParametroCursor>) out.get("a_cursor"));
	}
	
	/* (non-Javadoc)
	 * @see rimac.portalweb.comun.dao.ComunDao#obtenerEstadoPlan(java.math.BigDecimal)
	 */
	public String obtenerEstadoPlan(BigDecimal ideplan) {
		logger.debug("Ejecutando m�todo obtenerEstadoPlan");
		String resultado = null;
		SimpleJdbcCall call = null;
		MapSqlParameterSource in = null;
		in = new MapSqlParameterSource();
		
		call = JdbcHelper.initializeSimpleJdbcCallFunction(getJdbcTemplate(), 
				OWNER_ESQUEMA_PRODUCTO,
				PQ_LISTAR_TABLAS_PROD,
				"fn_obt_stsplan");
		
		JdbcHelper.setOutParameter(call, "return", Types.VARCHAR);
		JdbcHelper.setInParameter(call, in, "a_ideplan", Types.NUMERIC, ideplan);
				
		resultado = call.executeFunction(String.class, in);
		
		return resultado;
	}

	
	/* (non-Javadoc)
	 * @see rimac.portalweb.comun.dao.ComunDao#obtenerSinMonedaPlan(java.math.BigDecimal)
	 */
	public String obtenerSinMonedaPlan(BigDecimal ideplan) {
		logger.debug("Ejecutando m�todo obtenerSinMonedaPlan");
		String resultado = null;
		SimpleJdbcCall call = null;
		MapSqlParameterSource in = null;
		in = new MapSqlParameterSource();
		
		call = JdbcHelper.initializeSimpleJdbcCallFunction(getJdbcTemplate(), 
				OWNER_ESQUEMA_PRODUCTO,
				PQ_LISTAR_TABLAS_PROD,
				"fn_obt_simmonedaplan");
		
		JdbcHelper.setOutParameter(call, "return", Types.VARCHAR);
		JdbcHelper.setInParameter(call, in, "a_ideplan", Types.NUMERIC, ideplan);
				
		resultado = call.executeFunction(String.class, in);
		
		return resultado;
    }
	
	/* (non-Javadoc)
	 * @see rimac.portalweb.comun.dao.ComunDao#listarValoresxAtributoHijo(rimac.portalweb.comun.bean.Atributo)
	 */
	public List<Valor> listarValoresxAtributoHijo(Atributo atributo){
		logger.info("Ejecutando m�todo: listarValoresxAtributoHijo");
		SimpleJdbcCall call = null;
		MapSqlParameterSource in = null;
		Map<String, Object> out = null;
		
		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), 
				OWNER_ESQUEMA_COMUNES, PQ_FICHA_TECNICA,"sp_lst_valorxidevalorp");//"sp_obt_cfg_valorh");
		
		in = new MapSqlParameterSource();
		
		JdbcHelper.setInParameter(call,in,"a_ideatributo",	Types.NUMERIC, atributo.getIdeAtributo());
		JdbcHelper.setInParameter(call,in,"a_idevalorp",	Types.NUMERIC, atributo.getIdeValor());
		
//		JdbcHelper.setInParameter(call,in,"p_descripcion",	Types.VARCHAR, atributo.getDescripcion());
//		JdbcHelper.setInParameter(call,in,"p_idatributop",	Types.NUMERIC, atributo.getIdeAtributoRel());
//		JdbcHelper.setInParameter(call,in,"p_idatributo",	Types.NUMERIC, atributo.getIdeAtributo());
//		JdbcHelper.setInParameter(call,in,"p_grupoficha",	Types.NUMERIC, atributo.getGrupoFicha());
		JdbcHelper.setOutParameter(call,  "c_cursor",	OracleTypes.CURSOR, Valor.class);

		out = call.execute(in);
		return JdbcHelper.getListResultSet(out, "c_cursor", Valor.class);	
	}
	
	/* (non-Javadoc)
	 * @see rimac.portalweb.comun.dao.ComunDao#listarValoresxAtributo(rimac.portalweb.comun.bean.Atributo)
	 */
	public List<Valor> listarValoresxAtributo(Atributo atributo){
		logger.info("Ejecutando m�todo: listarValoresxAtributo");
		SimpleJdbcCall call = null;
		MapSqlParameterSource in = null;
		Map<String, Object> out = null;
		
		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), 
				OWNER_ESQUEMA_COMUNES, PQ_FICHA_TECNICA,"sp_lst_valor");
		
		in = new MapSqlParameterSource();
		JdbcHelper.setInParameter(call,in,"p_idatributo",	Types.NUMERIC, atributo.getIdeAtributo());
		JdbcHelper.setOutParameter(call,  "p_resultado",	OracleTypes.CURSOR, Valor.class);

		out = call.execute(in);
		return JdbcHelper.getListResultSet(out, "p_resultado", Valor.class);
	}
	
	public void mntArchivoblob(ArchivoBlob param) {      
		logger.info("Ejecutando m�todo mntArchivoblob");
		SimpleJdbcCall call = null;
		SqlParameterSource in = null;
		Map<String, Object> out = null;

		call = new SimpleJdbcCall(getJdbcTemplate()).
				withSchemaName(OWNER_ESQUEMA_COMUNES).
				withCatalogName(PQ_COMUNES_COMUN).
				withProcedureName("SP_MNT_ARCHIVOBLOB").
				withoutProcedureColumnMetaDataAccess().
				declareParameters(
						new SqlInOutParameter("a_idearchivoblob", Types.INTEGER),
						new SqlParameter("a_archivoblob", Types.BINARY),
						new SqlParameter("a_nomarchivo", Types.VARCHAR),
						new SqlParameter("a_nomarchivo2", Types.VARCHAR),
						new SqlParameter("a_extension", Types.VARCHAR),
						new SqlParameter("a_bytes", Types.VARCHAR),
						new SqlParameter("a_descripcion", Types.VARCHAR));
					
		in = new MapSqlParameterSource().
				addValue("a_idearchivoblob", param.getIdearchivoblob()).
				addValue("a_archivoblob", param.getArchivoblob()).
				addValue("a_nomarchivo", param.getNomarchivo()).
				addValue("a_nomarchivo2", param.getNomarchivo2()).
				addValue("a_extension", param.getExtension()).
				addValue("a_bytes", param.getBytes()).
				addValue("a_descripcion", param.getDescripcion());
		
		out = call.execute(in);		
		param.setIdearchivoblob((Integer)out.get("a_idearchivoblob"));      
  }
  
  public void actArchivoblob(ArchivoBlob param) {      
		logger.info("Ejecutando m�todo actArchivoblob");
		SimpleJdbcCall call = null;
		SqlParameterSource in = null;
		Map<String, Object> out = null;
//		System.out.println(ToStringBuilder.reflectionToString(param,ToStringStyle.MULTI_LINE_STYLE));
		call = new SimpleJdbcCall(getJdbcTemplate()).
				withSchemaName(OWNER_ESQUEMA_COMUNES).
				withCatalogName(PQ_COMUNES_COMUN).
				withProcedureName("sp_act_archivoblob").
				withoutProcedureColumnMetaDataAccess().
				declareParameters(
						new SqlInOutParameter("a_idearchivoblob", Types.INTEGER),
						new SqlParameter("a_descripcion", Types.VARCHAR));
					
		in = new MapSqlParameterSource().
				addValue("a_idearchivoblob", param.getIdearchivoblob()).
				addValue("a_descripcion", param.getDescripcion());
				
		
		out = call.execute(in);		
		param.setIdearchivoblob((Integer)out.get("a_idearchivoblob"));      
  }
  
  /**
 	 * M�todo para listar departamentos en un combo
 	 * @param param Filtro(tipo CboPais) para la b�squeda de departamentos
 	 * @return Lista de Departamentos 
 	 */
 	  public List<CboDepartamento> cboDepartamento(CboPais param) {
 		
 		logger.info("Ejecutando m�todo: cboDepartamento");
 		List<CboDepartamento> departamentos = null;
 		SimpleJdbcCall call = null;
 		MapSqlParameterSource in = null;
 		Map<String, Object> out = null;
 		
 		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), 
 				  OWNER_ESQUEMA_TERCERO, 
 				  PQ_TERCERO_PUNTOCONTACTO, 
 				  "SP_CBO_DEPARTAMENTO");
 		
 		in = new MapSqlParameterSource();
 		JdbcHelper.setInParameter(call,in,"a_idepais",Types.NUMERIC, param.getIdepais());
 		JdbcHelper.setOutParameter(call, "a_cursor",OracleTypes.CURSOR, CboDepartamento.class);
 		out = call.execute(in);
 		
 		departamentos = JdbcHelper.getListResultSet(out, "a_cursor", CboDepartamento.class);
 		
 		return departamentos; 
 	      
 	  }
 	
 	  
 	 /**
 	 * M�todo para listar provincias en un combo
 	 * @param param Filtro(tipo CboDepartamento) para la b�squeda de provincias
 	 * @return  Lista de Provincias
 	 */
 	  public List<CboProvincia> cboProvincia(CboDepartamento param) {
 	    
 		logger.info("Ejecutando m�todo: cboProvincia");
 		List<CboProvincia> lstProvincias = null;
 		SimpleJdbcCall call = null;
 		MapSqlParameterSource in = null;
 		Map<String, Object> out = null;
 		
 		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), 
 				  OWNER_ESQUEMA_TERCERO, 
 				  PQ_TERCERO_PUNTOCONTACTO, 
 				  "SP_CBO_PROVINCIA");
 		
 		in = new MapSqlParameterSource();
 		JdbcHelper.setInParameter(call,in,"a_idedepartamento",Types.NUMERIC, param.getIdedepartamento());
 		JdbcHelper.setOutParameter(call, "a_cursor",OracleTypes.CURSOR, CboProvincia.class);
 		out = call.execute(in);
 		
 		lstProvincias = JdbcHelper.getListResultSet(out, "a_cursor", CboProvincia.class);
 		
 		return lstProvincias;   
 	  }
 	  
 	  /**
 	  * M�todo para listar distritos en un combo
 	  * @param param Filtro(tipo CboProvincia) para la b�squeda de distritos
 	  * @return Lista de Distritos
 	  */
 	  public List<CboDistrito> cboDistrito(CboProvincia param) {
 	    logger.info("Ejecutando m�todo: cboDistrito");
 	    
 		List<CboDistrito> lstDistrito = null;
 		SimpleJdbcCall call = null;
 		MapSqlParameterSource in = null;
 		Map<String, Object> out = null;
 		
 		call = JdbcHelper.initializeSimpleJdbcCallProcedure(getJdbcTemplate(), 
 				  OWNER_ESQUEMA_TERCERO, 
 				  PQ_TERCERO_PUNTOCONTACTO, 
 				  "SP_CBO_DISTRITO");
 		
 		in = new MapSqlParameterSource();
 		JdbcHelper.setInParameter(call,in,"a_ideprovincia",Types.NUMERIC, param.getIdeprovincia());
 		JdbcHelper.setOutParameter(call, "a_cursor",OracleTypes.CURSOR, CboDistrito.class);
 		out = call.execute(in);
 		
 		lstDistrito = JdbcHelper.getListResultSet(out, "a_cursor", CboDistrito.class);
 		
 		return lstDistrito;
 	  }
}
