package bbva.delivery.services.comun.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import commons.mapper.ResourceManager;

public class Persona implements Serializable {

	/**
  *
  **/
	private static final long serialVersionUID = 1L;
	private Integer idetercero;
	private String codtercero;
	private String fecnacimiento;
	private String idpgenero;
	private String idpestadocivil;
	private Integer idptiposangre;
	private Integer idpgiroempleador;
	private Integer idpgradoestudio;
	private String idpprofesion;
	private Integer idpsituacionlaboral;
	private Integer idpocupacion;
	private String empleador;
	private String indtrabindependiente;
	private String idpnivsocioecon;
	private Integer paisorigen;
	private Integer idenombre;
	private String nombre;
	private String apepaterno;
	private String apematerno;
	private Integer idpprefijo;
	private String saludo;
	private String apecasada;
	private String numerodoc;
	private Integer idptipodocumento;
	private Integer idetelefcasa;
	private String numtelefcasa;
	private Integer ideteleftrabajo;
	private String numteleftrabajo;
	private String anexo;
	private Integer idetelefmovil;
	private String numtelefmovil;
	private Integer ideemailpersonal;
	private String emailpersonal;
	private Integer ideemailtrabajo;
	private String emailtrabajo;
	private String usucreacion;
	private Integer idedoctercero;

	private BigDecimal codexterno;

	private String indhomonimia;
	private String idptipotercero;
	
	private List<Persona> cursor;
	
	public String getIdptipotercero() {
		return idptipotercero;
	}

	public void setIdptipotercero(String idptipotercero) {
		this.idptipotercero = idptipotercero;
	}

	public String getIndhomonimia() {
		return indhomonimia;
	}

	public void setIndhomonimia(String indhomonimia) {
		this.indhomonimia = indhomonimia;
	}

	public Persona() {
	}

	@SuppressWarnings("rawtypes")
	public Persona(Map map) throws Exception {
		ResourceManager.populateDtoFromMap(this, map);
	}

	public Integer getIdetercero() {
		return idetercero;
	}

	public void setIdetercero(Integer idetercero) {
		this.idetercero = idetercero;
	}

	public String getCodtercero() {
		return codtercero;
	}

	public void setCodtercero(String codtercero) {
		this.codtercero = codtercero;
	}

	public String getFecnacimiento() {
		return fecnacimiento;
	}

	public void setFecnacimiento(String fecnacimiento) {
		this.fecnacimiento = fecnacimiento;
	}

	public String getIdpgenero() {
		return idpgenero;
	}

	public void setIdpgenero(String idpgenero) {
		this.idpgenero = idpgenero;
	}

	public String getIdpestadocivil() {
		return idpestadocivil;
	}

	public void setIdpestadocivil(String idpestadocivil) {
		this.idpestadocivil = idpestadocivil;
	}

	public Integer getIdptiposangre() {
		return idptiposangre;
	}

	public void setIdptiposangre(Integer idptiposangre) {
		this.idptiposangre = idptiposangre;
	}

	public Integer getIdpgiroempleador() {
		return idpgiroempleador;
	}

	public void setIdpgiroempleador(Integer idpgiroempleador) {
		this.idpgiroempleador = idpgiroempleador;
	}

	public Integer getIdpgradoestudio() {
		return idpgradoestudio;
	}

	public void setIdpgradoestudio(Integer idpgradoestudio) {
		this.idpgradoestudio = idpgradoestudio;
	}

	public String getIdpprofesion() {
		return idpprofesion;
	}

	public void setIdpprofesion(String idpprofesion) {
		this.idpprofesion = idpprofesion;
	}

	public Integer getIdpsituacionlaboral() {
		return idpsituacionlaboral;
	}

	public void setIdpsituacionlaboral(Integer idpsituacionlaboral) {
		this.idpsituacionlaboral = idpsituacionlaboral;
	}

	public Integer getIdpocupacion() {
		return idpocupacion;
	}

	public void setIdpocupacion(Integer idpocupacion) {
		this.idpocupacion = idpocupacion;
	}

	public String getEmpleador() {
		return empleador;
	}

	public void setEmpleador(String empleador) {
		this.empleador = empleador;
	}

	public String getIndtrabindependiente() {
		return indtrabindependiente;
	}

	public void setIndtrabindependiente(String indtrabindependiente) {
		this.indtrabindependiente = indtrabindependiente;
	}

	public String getIdpnivsocioecon() {
		return idpnivsocioecon;
	}

	public void setIdpnivsocioecon(String idpnivsocioecon) {
		this.idpnivsocioecon = idpnivsocioecon;
	}

	public Integer getPaisorigen() {
		return paisorigen;
	}

	public void setPaisorigen(Integer paisorigen) {
		this.paisorigen = paisorigen;
	}

	public Integer getIdenombre() {
		return idenombre;
	}

	public void setIdenombre(Integer idenombre) {
		this.idenombre = idenombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApepaterno() {
		return apepaterno;
	}

	public void setApepaterno(String apepaterno) {
		this.apepaterno = apepaterno;
	}

	public String getApematerno() {
		return apematerno;
	}

	public void setApematerno(String apematerno) {
		this.apematerno = apematerno;
	}

	public Integer getIdpprefijo() {
		return idpprefijo;
	}

	public void setIdpprefijo(Integer idpprefijo) {
		this.idpprefijo = idpprefijo;
	}

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

	public String getApecasada() {
		return apecasada;
	}

	public void setApecasada(String apecasada) {
		this.apecasada = apecasada;
	}

	public String getNumerodoc() {
		return numerodoc;
	}

	public void setNumerodoc(String numerodoc) {
		this.numerodoc = numerodoc;
	}

	public Integer getIdptipodocumento() {
		return idptipodocumento;
	}

	public void setIdptipodocumento(Integer idptipodocumento) {
		this.idptipodocumento = idptipodocumento;
	}

	public Integer getIdetelefcasa() {
		return idetelefcasa;
	}

	public void setIdetelefcasa(Integer idetelefcasa) {
		this.idetelefcasa = idetelefcasa;
	}

	public String getNumtelefcasa() {
		return numtelefcasa;
	}

	public void setNumtelefcasa(String numtelefcasa) {
		this.numtelefcasa = numtelefcasa;
	}

	public Integer getIdeteleftrabajo() {
		return ideteleftrabajo;
	}

	public void setIdeteleftrabajo(Integer ideteleftrabajo) {
		this.ideteleftrabajo = ideteleftrabajo;
	}

	public String getNumteleftrabajo() {
		return numteleftrabajo;
	}

	public void setNumteleftrabajo(String numteleftrabajo) {
		this.numteleftrabajo = numteleftrabajo;
	}

	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}

	public Integer getIdetelefmovil() {
		return idetelefmovil;
	}

	public void setIdetelefmovil(Integer idetelefmovil) {
		this.idetelefmovil = idetelefmovil;
	}

	public String getNumtelefmovil() {
		return numtelefmovil;
	}

	public void setNumtelefmovil(String numtelefmovil) {
		this.numtelefmovil = numtelefmovil;
	}

	public Integer getIdeemailpersonal() {
		return ideemailpersonal;
	}

	public void setIdeemailpersonal(Integer ideemailpersonal) {
		this.ideemailpersonal = ideemailpersonal;
	}

	public String getEmailpersonal() {
		return emailpersonal;
	}

	public void setEmailpersonal(String emailpersonal) {
		this.emailpersonal = emailpersonal;
	}

	public Integer getIdeemailtrabajo() {
		return ideemailtrabajo;
	}

	public void setIdeemailtrabajo(Integer ideemailtrabajo) {
		this.ideemailtrabajo = ideemailtrabajo;
	}

	public String getEmailtrabajo() {
		return emailtrabajo;
	}

	public void setEmailtrabajo(String emailtrabajo) {
		this.emailtrabajo = emailtrabajo;
	}

	public String getUsucreacion() {
		return usucreacion;
	}

	public void setUsucreacion(String usucreacion) {
		this.usucreacion = usucreacion;
	}

	public Integer getIdedoctercero() {
		return idedoctercero;
	}

	public void setIdedoctercero(Integer idedoctercero) {
		this.idedoctercero = idedoctercero;
	}

	public BigDecimal getCodexterno() {
		return codexterno;
	}

	public void setCodexterno(BigDecimal codexterno) {
		this.codexterno = codexterno;
	}

	public List<Persona> getCursor() {
		return cursor;
	}

	public void setCursor(List<Persona> cursor) {
		this.cursor = cursor;
	}

	
}
