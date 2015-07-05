package bbva.delivery.services.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ArchivoGenerado  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7136920170054000048L;

	private String codigo;
	
	private String mensaje;
	
	private String codigoEntrega;

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

	public String getCodigoEntrega() {
		return codigoEntrega;
	}
	
	public void setCodigoEntrega(String codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}
}
