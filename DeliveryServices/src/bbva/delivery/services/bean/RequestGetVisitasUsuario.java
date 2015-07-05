package bbva.delivery.services.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class RequestGetVisitasUsuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4684697997459433185L;
	
	private String courier;
	
	private String dni;
	
	private String dia;
	
	private String mes;
	
	private String anio;
	
	private String codbbva;

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
	
	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getCodbbva() {
		return codbbva;
	}
	
	public void setCodbbva(String codbbva) {
		this.codbbva = codbbva;
	}

}
