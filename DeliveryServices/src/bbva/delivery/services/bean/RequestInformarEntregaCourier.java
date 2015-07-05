package bbva.delivery.services.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author dingan
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class RequestInformarEntregaCourier implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6915765967315202557L;
	
	private String courier;
	
	private String codbbva;
	
	private String dni;
	
	private String fechaHora;
	
	private String estado;
	
	private String observaciones;
	
	private Integer codigoEntrega;

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public String getCodbbva() {
		return codbbva;
	}

	public void setCodbbva(String codbbva) {
		this.codbbva = codbbva;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public Integer getCodigoEntrega() {
		return codigoEntrega;
	}
	
	public void setCodigoEntrega(Integer codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}
}
