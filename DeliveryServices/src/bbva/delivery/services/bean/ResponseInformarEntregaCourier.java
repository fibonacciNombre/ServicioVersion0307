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
public class ResponseInformarEntregaCourier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2196498093081618668L;
	
	private Tx tx;
	
	private InformarEntregaCourier informarEntregaCourier;

	public Tx getTx() {
		return tx;
	}

	public void setTx(Tx tx) {
		this.tx = tx;
	}
	@JsonProperty("rpta")
	public InformarEntregaCourier getInformarEntregaCourier() {
		return informarEntregaCourier;
	}

	public void setInformarEntregaCourier(
			InformarEntregaCourier informarEntregaCourier) {
		this.informarEntregaCourier = informarEntregaCourier;
	}

}
