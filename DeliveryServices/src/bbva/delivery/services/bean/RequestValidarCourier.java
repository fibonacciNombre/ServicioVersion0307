package bbva.delivery.services.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class RequestValidarCourier implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7245292713921375931L;

	private String courier;
	
	private String codbbva;
	
	private String dni;

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getCodbbva() {
		return codbbva;
	}
	
	public void setCodbbva(String codbbva) {
		this.codbbva = codbbva;
	}

}
