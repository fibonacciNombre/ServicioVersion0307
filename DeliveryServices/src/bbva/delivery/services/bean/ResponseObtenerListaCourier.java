package bbva.delivery.services.bean;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ResponseObtenerListaCourier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2096865025979642422L;
	
	private Tx tx;
	
	private List<Courier> listaCourier;

	public Tx getTx() {
		return tx;
	}

	public void setTx(Tx tx) {
		this.tx = tx;
	}

	@JsonProperty("rpta")
	public List<Courier> getListaCourier() {
		return listaCourier;
	}

	public void setListaCourier(List<Courier> listaCourier) {
		this.listaCourier = listaCourier;
	}
	
	

}
