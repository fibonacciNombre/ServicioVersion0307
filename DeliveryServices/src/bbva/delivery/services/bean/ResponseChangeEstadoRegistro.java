package bbva.delivery.services.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ResponseChangeEstadoRegistro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9152858066284632644L;
	
	private Tx tx;
	
	private EstadoRegistro estadoRegistro;

	public Tx getTx() {
		return tx;
	}

	public void setTx(Tx tx) {
		this.tx = tx;
	}
	
	@JsonProperty("rpta")
	public EstadoRegistro getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(EstadoRegistro estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

}
