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
public class ResponseInformarActivacionBBVA implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6575026276117349153L;
	
	private Tx tx;
	
	private InformarActivacionBBVA informarActivacionBBVA;

	public Tx getTx() {
		return tx;
	}

	public void setTx(Tx tx) {
		this.tx = tx;
	}

	@JsonProperty("rpta")
	public InformarActivacionBBVA getInformarActivacionBBVA() {
		return informarActivacionBBVA;
	}
	
	public void setInformarActivacionBBVA(
			InformarActivacionBBVA informarActivacionBBVA) {
		this.informarActivacionBBVA = informarActivacionBBVA;
	}

}
