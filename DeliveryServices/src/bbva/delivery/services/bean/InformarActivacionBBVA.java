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
public class InformarActivacionBBVA implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5461232461398834086L;
	
	private String codigo;
	
	private String mensaje;

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
