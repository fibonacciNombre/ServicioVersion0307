package bbva.delivery.services.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class VisitasUsuario implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4849941562139642557L;

	private String codigoEntrega;
	
	private String primDigitosTar;
	
	private String ultiDigitosTar;
	
	private String dni;
	
	private String nombres;
	
	private String direccion;
	
	private String distrito;
	
	private String coordenadas;
	
	private String tipoTarjeta;
	
	private String lineaCredito;
	
	private String fechaEntrega;
	
	private String horarioEntrega;
	
	private String latitud;
	
	private String longitud;

	public String getCodigoEntrega() {
		return codigoEntrega;
	}

	public void setCodigoEntrega(String codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}

	public String getPrimDigitosTar() {
		return primDigitosTar;
	}

	public void setPrimDigitosTar(String primDigitosTar) {
		this.primDigitosTar = primDigitosTar;
	}

	public String getUltiDigitosTar() {
		return ultiDigitosTar;
	}

	public void setUltiDigitosTar(String ultiDigitosTar) {
		this.ultiDigitosTar = ultiDigitosTar;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

	public String getTipoTarjeta() {
		return tipoTarjeta;
	}

	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	public String getLineaCredito() {
		return lineaCredito;
	}

	public void setLineaCredito(String lineaCredito) {
		this.lineaCredito = lineaCredito;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getHorarioEntrega() {
		return horarioEntrega;
	}

	public void setHorarioEntrega(String horarioEntrega) {
		this.horarioEntrega = horarioEntrega;
	}
	
	public String getLatitud() {
		return latitud;
	}
	
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	
	public String getLongitud() {
		return longitud;
	}
	
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	
}
