package bbva.delivery.services.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class RequestInformarActivacionBBVA implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4466592952689216842L;
	
	private String dni;
	
	private String codigoEntrega;
	
	private String fechaHora;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCodigoEntrega() {
		return codigoEntrega;
	}

	public void setCodigoEntrega(String codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

}
