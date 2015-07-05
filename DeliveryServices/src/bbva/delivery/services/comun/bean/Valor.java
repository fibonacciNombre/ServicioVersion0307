package bbva.delivery.services.comun.bean;

import java.io.Serializable;
import java.util.Map;

import commons.mapper.ResourceManager;

public class Valor implements Serializable{

	private static final long serialVersionUID = -9009014993535417981L;

	
	private Integer ideValor;
	private Integer ideAtributo;
	private String descripcion;
	private Integer orden;
	private String indActivo;
	private String usuCreacion;
	private String fecCreacion;
	private String usuModif;
	private String fecModif;
	
	public Valor(){}
	
	public Valor(Map<?,?> params) throws Exception {
		ResourceManager.populateDtoFromMap(this, params);
	}
	
	public Valor(Integer ideValor,Integer ideAtributo){
		this.ideValor = ideValor;
		this.ideAtributo = ideAtributo;
	}

	public Integer getIdeValor() {
		return ideValor;
	}

	public void setIdeValor(Integer ideValor) {
		this.ideValor = ideValor;
	}

	public Integer getIdeAtributo() {
		return ideAtributo;
	}

	public void setIdeAtributo(Integer ideAtributo) {
		this.ideAtributo = ideAtributo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getIndActivo() {
		return indActivo;
	}

	public void setIndActivo(String indActivo) {
		this.indActivo = indActivo;
	}

	public String getUsuCreacion() {
		return usuCreacion;
	}

	public void setUsuCreacion(String usuCreacion) {
		this.usuCreacion = usuCreacion;
	}

	public String getFecCreacion() {
		return fecCreacion;
	}

	public void setFecCreacion(String fecCreacion) {
		this.fecCreacion = fecCreacion;
	}

	public String getUsuModif() {
		return usuModif;
	}

	public void setUsuModif(String usuModif) {
		this.usuModif = usuModif;
	}

	public String getFecModif() {
		return fecModif;
	}

	public void setFecModif(String fecModif) {
		this.fecModif = fecModif;
	}
}
