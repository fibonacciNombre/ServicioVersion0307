package bbva.delivery.services.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2801691650425163023L;
	
	
	
	//private String password;
	
	private Integer ideusuario;
	
	private String codusuario;
	
	private String contrasena;
	
	private String comentario;
	
	private Integer idtercero;
	
	private Integer idperfil;
	
	private Integer idpestado;
	
	private String historial;
	
	private String usuario;
	
	@JsonIgnore
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	@JsonIgnore
	public Integer getIdeusuario() {
		return ideusuario;
	}
	
	public void setIdeusuario(Integer ideusuario) {
		this.ideusuario = ideusuario;
	}

	public String getCodusuario() {
		return codusuario;
	}

	public void setCodusuario(String codusuario) {
		this.codusuario = codusuario;
	}

	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	@JsonIgnore
	public String getHistorial() {
		return historial;
	}

	public void setHistorial(String historial) {
		this.historial = historial;
	}
	@JsonIgnore
	public Integer getIdtercero() {
		return idtercero;
	}

	public void setIdtercero(Integer idtercero) {
		this.idtercero = idtercero;
	}
	@JsonIgnore
	public Integer getIdperfil() {
		return idperfil;
	}

	public void setIdperfil(Integer idperfil) {
		this.idperfil = idperfil;
	}
	@JsonIgnore
	public Integer getIdpestado() {
		return idpestado;
	}

	public void setIdpestado(Integer idpestado) {
		this.idpestado = idpestado;
	}
	
	
}
