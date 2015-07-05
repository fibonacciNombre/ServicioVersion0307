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
public class EstadoRegistro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4581211446254757303L;
	
	private String codigoEntrega;
	
	private String estado;
	
	private String motivo;
	
	private String codigo;
	
	private String mensaje;

	public String getCodigoEntrega() {
		return codigoEntrega;
	}

	public void setCodigoEntrega(String codigoEntrega) {
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
