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
public class RequestChangeEstadoRegistro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5889092716814857786L;
	
	private String courier;
	
	private String dni;
	
	private Integer codigoEntrega;
	
	private String estado;
	
	private String motivo;
	
	private String codbbva;
	
	private String codigo;
	
	private String mensaje;

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

	public Integer getCodigoEntrega() {
		return codigoEntrega;
	}

	public void setCodigoEntrega(Integer codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMotivo() {
		return motivo;
	}
	
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public String getCodbbva() {
		return codbbva;
	}
	
	public void setCodbbva(String codbbva) {
		this.codbbva = codbbva;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
