package bbva.delivery.services.comun.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import commons.mapper.ResourceManager;

public class Atributo implements Serializable{
	
	private static final long serialVersionUID = -2250065509423406726L;
	
	private Integer ideAtributo;
	private Integer ideVisualizar;
	private Integer ideTipoDato;
	private String descripcion;
	private String abreviatura;
	private String indActivo;
	private String progValidacion;
	private String nomTabDatos;
	private String campoCodigo;
	private String campoDescripcion;
	private String usuCreacion;
	private Date fecCreacion;
	private String usuModif;
	private Date fecModif;
	
	private List<Valor> valores;
	private Integer ideAtributoRel;
	private String ideValor;
	private Integer grupoFicha;
	

	public Atributo(){}
	
	public Atributo(Map<?,?> map) throws Exception {
		ResourceManager.populateDtoFromMap(this, map);
	}

	public Atributo(Integer ideAtributo, String descripcion,
			Integer ideAtributoRel, Integer grupoficha) {
		super();
		this.ideAtributo = ideAtributo;
		this.descripcion = descripcion;
		this.ideAtributoRel = ideAtributoRel;
		this.grupoFicha = grupoficha;
	}

	public Integer getIdeAtributo() {
		return ideAtributo;
	}

	public void setIdeAtributo(Integer ideAtributo) {
		this.ideAtributo = ideAtributo;
	}

	public Integer getIdeVisualizar() {
		return ideVisualizar;
	}

	public void setIdeVisualizar(Integer ideVisualizar) {
		this.ideVisualizar = ideVisualizar;
	}

	public Integer getIdeTipoDato() {
		return ideTipoDato;
	}

	public void setIdeTipoDato(Integer ideTipoDato) {
		this.ideTipoDato = ideTipoDato;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getIndActivo() {
		return indActivo;
	}

	public void setIndActivo(String indActivo) {
		this.indActivo = indActivo;
	}

	public String getProgValidacion() {
		return progValidacion;
	}

	public void setProgValidacion(String progValidacion) {
		this.progValidacion = progValidacion;
	}

	public String getNomTabDatos() {
		return nomTabDatos;
	}

	public void setNomTabDatos(String nomTabDatos) {
		this.nomTabDatos = nomTabDatos;
	}

	public String getCampoCodigo() {
		return campoCodigo;
	}

	public void setCampoCodigo(String campoCodigo) {
		this.campoCodigo = campoCodigo;
	}

	public String getCampoDescripcion() {
		return campoDescripcion;
	}

	public void setCampoDescripcion(String campoDescripcion) {
		this.campoDescripcion = campoDescripcion;
	}

	public String getUsuCreacion() {
		return usuCreacion;
	}

	public void setUsuCreacion(String usuCreacion) {
		this.usuCreacion = usuCreacion;
	}

	public Date getFecCreacion() {
		return fecCreacion;
	}

	public void setFecCreacion(Date fecCreacion) {
		this.fecCreacion = fecCreacion;
	}

	public String getUsuModif() {
		return usuModif;
	}

	public void setUsuModif(String usuModif) {
		this.usuModif = usuModif;
	}

	public Date getFecModif() {
		return fecModif;
	}

	public void setFecModif(Date fecModif) {
		this.fecModif = fecModif;
	}

	public List<Valor> getValores() {
		return valores;
	}

	public void setValores(List<Valor> valores) {
		this.valores = valores;
	}

	public Integer getIdeAtributoRel() {
		return ideAtributoRel;
	}

	public void setIdeAtributoRel(Integer ideAtributoRel) {
		this.ideAtributoRel = ideAtributoRel;
	}

	public String getIdeValor() {
		return ideValor;
	}

	public void setIdeValor(String ideValor) {
		this.ideValor = ideValor;
	}

	public Integer getGrupoFicha() {
		return grupoFicha;
	}

	public void setGrupoFicha(Integer grupoFicha) {
		this.grupoFicha = grupoFicha;
	}

}
