/**
 * Created on 14/03/2012
 * Copyright (c) Rimac Seguros S.A.
 */
package bbva.delivery.services.comun.bean;

import java.io.Serializable;
import java.util.Map;

import commons.mapper.ResourceManager;

/**
 * M�todo que contiene los datos de relacionados a un archivo que se
 * guarda en base de datos
 * 
 * @author Rimac Seguros - Hilmer Aliaga
 */
public class ArchivoBlob implements Serializable {

	private static final long serialVersionUID = 3633897110503568750L;
	
	private Integer idearchivoblob;
	private byte[] archivoblob;
	private String nomarchivo;
	private String nomarchivo2;
	private String extension;
	private String bytes;
	private String descripcion;
	
	private String rutaFisica;
	private String rutaArchivo;

	public ArchivoBlob() {
		super();
	}
	
	@SuppressWarnings("rawtypes")
	public ArchivoBlob(Map params) throws Exception {
		ResourceManager.populateDtoFromMap(this, params);
	}
	
	public Integer getIdearchivoblob() {
		return idearchivoblob;
	}

	public void setIdearchivoblob(Integer idearchivoblob) {
		this.idearchivoblob = idearchivoblob;
	}

	public byte[] getArchivoblob() {
		return archivoblob;
	}

	public void setArchivoblob(byte[] archivoblob) {
		this.archivoblob = archivoblob;
	}

	public String getNomarchivo() {
		return nomarchivo;
	}

	public void setNomarchivo(String nomarchivo) {
		this.nomarchivo = nomarchivo;
	}

	public String getNomarchivo2() {
		return nomarchivo2;
	}

	public void setNomarchivo2(String nomarchivo2) {
		this.nomarchivo2 = nomarchivo2;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getBytes() {
		return bytes;
	}

	public void setBytes(String bytes) {
		this.bytes = bytes;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getRutaFisica() {
		return rutaFisica;
	}

	public void setRutaFisica(String rutaFisica) {
		this.rutaFisica = rutaFisica;
	}
	
	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}
}
