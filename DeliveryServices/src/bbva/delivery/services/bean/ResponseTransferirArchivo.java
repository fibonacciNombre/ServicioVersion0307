package bbva.delivery.services.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * @author dingan
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ResponseTransferirArchivo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3362277511897616105L;
	
	private Tx tx;

	private ArchivoGenerado archivoGenerado;

	public Tx getTx() {
		return tx;
	}

	public void setTx(Tx tx) {
		this.tx = tx;
	}
	@JsonProperty("rpta")
	public ArchivoGenerado getArchivoGenerado() {
		return archivoGenerado;
	}

	public void setArchivoGenerado(ArchivoGenerado archivoGenerado) {
		this.archivoGenerado = archivoGenerado;
	}
	
}
