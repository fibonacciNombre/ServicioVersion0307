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
public class ArchivoPDF  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1378242042122173286L;
	
	private Integer codigoEntrega;
	
	private String archivo;
	
	private String codigo;
	
	private String mensaje;

	public Integer getCodigoEntrega() {
		return codigoEntrega;
	}
	
	public void setCodigoEntrega(Integer codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	
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
