package bbva.delivery.services.bean;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ResponseGetVisitasUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7777116188101592030L;
	
	private Tx tx;
	
	private List<VisitasUsuario> visitasUsuarios;
	
	public Tx getTx() {
		return tx;
	}
	
	public void setTx(Tx tx) {
		this.tx = tx;
	}
	@JsonProperty("rpta")
	public List<VisitasUsuario> getVisitasUsuarios() {
		return visitasUsuarios;
	}
	
	public void setVisitasUsuarios(List<VisitasUsuario> visitasUsuarios) {
		this.visitasUsuarios = visitasUsuarios;
	}
}
