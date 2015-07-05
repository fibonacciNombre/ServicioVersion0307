package bbva.delivery.services.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ResponseValidarCourier implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7328711843025035414L;
	
	private Tx tx;
	
	private ValidarCourier validarCourier;
	
	public Tx getTx() {
		return tx;
	}
	
	public void setTx(Tx tx) {
		this.tx = tx;
	}
	
	@JsonProperty("rpta")
	public ValidarCourier getValidarCourier() {
		return validarCourier;
	}
	
	public void setValidarCourier(ValidarCourier validarCourier) {
		this.validarCourier = validarCourier;
	}

}
