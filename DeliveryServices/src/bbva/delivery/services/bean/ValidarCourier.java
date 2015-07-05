package bbva.delivery.services.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ValidarCourier implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7427412689648421622L;
	
	private String codigo;
	
	private String mensaje;
	
	private String idcourier;
	
	private String codbbva;
	
	private String rznsocial;
	
	private String idtercero;
	
	private String estadocourier;
	
	private String estadotercero;
	
	private String dni;
	

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
	@JsonIgnore
	public String getIdcourier() {
		return idcourier;
	}

	public void setIdcourier(String idcourier) {
		this.idcourier = idcourier;
	}
	@JsonIgnore
	public String getCodbbva() {
		return codbbva;
	}

	public void setCodbbva(String codbbva) {
		this.codbbva = codbbva;
	}
	@JsonIgnore
	public String getRznsocial() {
		return rznsocial;
	}

	public void setRznsocial(String rznsocial) {
		this.rznsocial = rznsocial;
	}
	@JsonIgnore
	public String getIdtercero() {
		return idtercero;
	}

	public void setIdtercero(String idtercero) {
		this.idtercero = idtercero;
	}
	@JsonIgnore
	public String getEstadocourier() {
		return estadocourier;
	}

	public void setEstadocourier(String estadocourier) {
		this.estadocourier = estadocourier;
	}
	@JsonIgnore
	public String getEstadotercero() {
		return estadotercero;
	}

	public void setEstadotercero(String estadotercero) {
		this.estadotercero = estadotercero;
	}
	@JsonIgnore
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
