package bbva.delivery.services.comun.dao;

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

public interface ComunDao{
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
	 * @param atributo
	 * @return
	 */
	List<Valor> listarValoresxAtributoHijo(Atributo atributo);
	
	/**
	 * @param atributo
	 * @return
	 */
	List<Valor> listarValoresxAtributo(Atributo atributo);
	
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
	 * M�todo para listar departamentos en un combo
	 * @param param Filtro(tipo CboPais) para la b�squeda de departamentos
	 * @return Lista de Departamentos 
	 */
	public List<CboDepartamento> cboDepartamento(CboPais param);
	
	/**
	 * M�todo para listar provincias en un combo
	 * @param param Filtro(tipo CboDepartamento) para la b�squeda de provincias
	 * @return  Lista de Provincias
	 */
	public List<CboProvincia> cboProvincia(CboDepartamento param);

	/**
	 * M�todo para listar distritos en un combo
	 * @param param Filtro(tipo CboProvincia) para la b�squeda de distritos
	 * @return Lista de Distritos
	 */
	public List<CboDistrito> cboDistrito(CboProvincia param);
}