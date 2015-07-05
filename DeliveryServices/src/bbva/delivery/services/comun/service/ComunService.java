package bbva.delivery.services.comun.service;

import java.math.BigDecimal;
import java.util.List;

import bbva.delivery.services.comun.bean.ArchivoBlob;
import bbva.delivery.services.comun.bean.Atributo;
import bbva.delivery.services.comun.bean.CboDepartamento;
import bbva.delivery.services.comun.bean.CboDistrito;
import bbva.delivery.services.comun.bean.CboPais;
import bbva.delivery.services.comun.bean.CboProvincia;
import bbva.delivery.services.comun.bean.Constante;
import bbva.delivery.services.comun.bean.Parametro;
import bbva.delivery.services.comun.bean.Valor;

public interface ComunService {	
	
	/**
	 * Obtiene los valores de la constante registrada en base de datos
	 * @param ideConstante Identificador de la constate
	 * @return Datos de la constante
	 */
	Constante obtenerConstante(String ideConstante);
	
	/**
	 * Obtiene el parametro seg�n los filtros de b�squeda.
	 * 
	 * @param parametro los filtros para la b�squeda del parametro
	 * @return el parametro buscado
	 */
	Parametro obtenerParametro(Parametro parametro);
	
	/**
	 * Lista los parametros seg�n los filtros de b�squeda.
	 * 
	 * @param parametro los filtros para la b�squeda del parametro
	 * @return la lista de valores del parametro buscado seg�n los filtros
	 */
	List<Parametro> listarParametro(Parametro parametro);
	
	/**
	 * 
	 * @param param
	 */
	void obtenerListaParametros(Parametro param);
	
	/**
	 * @param ideplan
	 * @return
	 */
	String obtenerEstadoPlan(BigDecimal ideplan);
	
	/**
	 * @param ideplan
	 * @return
	 */
	String obtenerSinMonedaPlan(BigDecimal ideplan);
	
	/**
	 * @param param
	 * @return
	 */
	List<Valor> listarValoresxAtributoHijo(Atributo param);
	
	/**
	 * @param param
	 * @return
	 */
	List<Valor> listarValoresxAtributo(Atributo param);
		
	/**
	 * 
	 * @param param
	 */
	void mntArchivoblob(ArchivoBlob param);
	
	/**
	 * 
	 * @param param
	 */
	void actArchivoblob(ArchivoBlob param) ;
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	List<CboDepartamento> cboDepartamento(CboPais param);
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	List<CboProvincia> cboProvincia(CboDepartamento param);
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	List<CboDistrito> cboDistrito(CboProvincia param);
}