package bbva.delivery.services.comun.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import commons.mapper.ResourceManager;
/**
 * Parametro Bean
 */
public class Parametro implements Serializable{

	private static final long serialVersionUID = 7026094276995793104L;
	
	private String idePar;
	private String codExterno;
	private String ideTipPar;
	private String ideTipParPadre;

	private String codigo;
	private String codigon;
	private String codigoc;
	private String abreviatura;
	private String descripcion;
	private String descripcion2;
	private String indActivo;
	private String masterDetail;
	private String refmigracionrs;
	
	private List<ListaParametroCursor>  cursor;
	
	private String indexrow;
    
	public Parametro() {}

	public Parametro(Map<?,?> map) throws Exception {
		ResourceManager.populateDtoFromMap(this, map);
	}
	
	public Parametro(String ideTippar) {
		this.ideTipPar = ideTippar;
	}
	
//	public Parametro(String ideTippar, String abreviatura) {
	public Parametro(String ideTippar, String codigo) {
		this.ideTipPar = ideTippar;
//		this.abreviatura = abreviatura;
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getCodigon() {
		return codigon;
	}

	public void setCodigon(String codigon) {
		this.codigon = codigon;
	}

	public String getCodigoc() {
		return codigoc;
	}

	public void setCodigoc(String codigoc) {
		this.codigoc = codigoc;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIndexrow() {
		return indexrow;
	}

	public void setIndexrow(String indexrow) {
		this.indexrow = indexrow;
	}

	public String getIdeTipPar() {
		return ideTipPar;
	}

	public void setIdeTipPar(String ideTipPar) {
		this.ideTipPar = ideTipPar;
	}

	public String getIdeTipParPadre() {
		return ideTipParPadre;
	}

	public void setIdeTipParPadre(String ideTipParPadre) {
		this.ideTipParPadre = ideTipParPadre;
	}

	public String getIndActivo() {
		return indActivo;
	}

	public void setIndActivo(String indActivo) {
		this.indActivo = indActivo;
	}

	public String getMasterDetail() {
		return masterDetail;
	}

	public void setMasterDetail(String masterDetail) {
		this.masterDetail = masterDetail;
	}

	public String getIdePar() {
		return idePar;
	}

	public void setIdePar(String idePar) {
		this.idePar = idePar;
	}

	public String getCodExterno() {
		return codExterno;
	}

	public void setCodExterno(String codExterno) {
		this.codExterno = codExterno;
	}

	public String getDescripcion2() {
		return descripcion2;
	}

	public void setDescripcion2(String descripcion2) {
		this.descripcion2 = descripcion2;
	}
	
	public List<ListaParametroCursor> getCursor() {
		return cursor;
	}

	public void setCursor(List<ListaParametroCursor> cursor) {
		this.cursor = cursor;
	}

	public String getRefmigracionrs() {
		return refmigracionrs;
	}

	public void setRefmigracionrs(String refmigracionrs) {
		this.refmigracionrs = refmigracionrs;
	}
	
}
