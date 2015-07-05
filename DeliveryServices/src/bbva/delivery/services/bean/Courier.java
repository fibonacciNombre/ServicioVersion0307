package bbva.delivery.services.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Courier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -571304242362469320L;
	
	private Integer idCourier;
	
	private String codBbva;
	
	private String nombre;
	
	private String rznSocial;
	
	private String telfFijo;
	
	private String telfMovil;
	
	private String observacion;
	
	private String nroDocumentocou;
	
	private Integer idpTipoDocumento;
	
	private String direccion;

	public Integer getIdCourier() {
		return idCourier;
	}

	public void setIdCourier(Integer idCourier) {
		this.idCourier = idCourier;
	}

	public String getCodBbva() {
		return codBbva;
	}

	public void setCodBbva(String codBbva) {
		this.codBbva = codBbva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRznSocial() {
		return rznSocial;
	}

	public void setRznSocial(String rznSocial) {
		this.rznSocial = rznSocial;
	}

	public String getTelfFijo() {
		return telfFijo;
	}

	public void setTelfFijo(String telfFijo) {
		this.telfFijo = telfFijo;
	}

	public String getTelfMovil() {
		return telfMovil;
	}

	public void setTelfMovil(String telfMovil) {
		this.telfMovil = telfMovil;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getNroDocumentocou() {
		return nroDocumentocou;
	}

	public void setNroDocumentocou(String nroDocumentocou) {
		this.nroDocumentocou = nroDocumentocou;
	}

	public Integer getIdpTipoDocumento() {
		return idpTipoDocumento;
	}

	public void setIdpTipoDocumento(Integer idpTipoDocumento) {
		this.idpTipoDocumento = idpTipoDocumento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
}
