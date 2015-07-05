package bbva.delivery.services.bean;

import java.math.BigDecimal;
import java.util.Map;

import commons.mapper.ResourceManager;

public class Delivery {
	
	private BigDecimal iddelivery;
	private String tipodocumento;
	private String nrodocumentocli;
	private String nombrescli;
	private String tipotarjeta;
	private String pridigtarjeta;
	private String ultdigtarjeta;
	private String nrocontrato;
	private BigDecimal mtoasoctarjeta;
	private String fecentrega;
	private String horaentrega;
	private String lugarentrega;
	private String indverificacion;
	private String direccioncli;
	private String distritocli;
	private BigDecimal latitudofi;
	private BigDecimal longitudofi;
	private String correocli;
	private String telmovilcli;
	private String ordenentrega;
	private BigDecimal idcourier;
	private BigDecimal idtercero;
	private Integer idpestado;
	private Integer idarchivo;
	private Integer idpestadocarga;
	private String mensajecarga;
	private BigDecimal grupocarga;
	
	private String correocourier;
	private String nombretercero;
	
	public Delivery(){
		
	}
	
	@SuppressWarnings("rawtypes")
	public Delivery(Map params) throws Exception {
		ResourceManager.populateDtoFromMap(this, params);
	}

	public BigDecimal getIddelivery() {
		return iddelivery;
	}

	public void setIddelivery(BigDecimal iddelivery) {
		this.iddelivery = iddelivery;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getNrodocumentocli() {
		return nrodocumentocli;
	}

	public void setNrodocumentocli(String nrodocumentocli) {
		this.nrodocumentocli = nrodocumentocli;
	}

	public String getNombrescli() {
		return nombrescli;
	}

	public void setNombrescli(String nombrescli) {
		this.nombrescli = nombrescli;
	}

	public String getTipotarjeta() {
		return tipotarjeta;
	}

	public void setTipotarjeta(String tipotarjeta) {
		this.tipotarjeta = tipotarjeta;
	}

	public String getPridigtarjeta() {
		return pridigtarjeta;
	}

	public void setPridigtarjeta(String pridigtarjeta) {
		this.pridigtarjeta = pridigtarjeta;
	}

	public String getUltdigtarjeta() {
		return ultdigtarjeta;
	}

	public void setUltdigtarjeta(String ultdigtarjeta) {
		this.ultdigtarjeta = ultdigtarjeta;
	}

	public String getNrocontrato() {
		return nrocontrato;
	}

	public void setNrocontrato(String nrocontrato) {
		this.nrocontrato = nrocontrato;
	}

	public BigDecimal getMtoasoctarjeta() {
		return mtoasoctarjeta;
	}

	public void setMtoasoctarjeta(BigDecimal mtoasoctarjeta) {
		this.mtoasoctarjeta = mtoasoctarjeta;
	}

	

	public String getFecentrega() {
		return fecentrega;
	}

	public void setFecentrega(String fecentrega) {
		this.fecentrega = fecentrega;
	}

	public String getHoraentrega() {
		return horaentrega;
	}

	public void setHoraentrega(String horaentrega) {
		this.horaentrega = horaentrega;
	}

	public String getLugarentrega() {
		return lugarentrega;
	}

	public void setLugarentrega(String lugarentrega) {
		this.lugarentrega = lugarentrega;
	}

	public String getIndverificacion() {
		return indverificacion;
	}

	public void setIndverificacion(String indverificacion) {
		this.indverificacion = indverificacion;
	}

	public String getDireccioncli() {
		return direccioncli;
	}

	public void setDireccioncli(String direccioncli) {
		this.direccioncli = direccioncli;
	}

	public String getDistritocli() {
		return distritocli;
	}

	public void setDistritocli(String distritocli) {
		this.distritocli = distritocli;
	}

	public BigDecimal getLatitudofi() {
		return latitudofi;
	}

	public void setLatitudofi(BigDecimal latitudofi) {
		this.latitudofi = latitudofi;
	}

	public BigDecimal getLongitudofi() {
		return longitudofi;
	}

	public void setLongitudofi(BigDecimal longitudofi) {
		this.longitudofi = longitudofi;
	}

	public String getCorreocli() {
		return correocli;
	}

	public void setCorreocli(String correocli) {
		this.correocli = correocli;
	}

	public String getTelmovilcli() {
		return telmovilcli;
	}

	public void setTelmovilcli(String telmovilcli) {
		this.telmovilcli = telmovilcli;
	}

	public String getOrdenentrega() {
		return ordenentrega;
	}

	public void setOrdenentrega(String ordenentrega) {
		this.ordenentrega = ordenentrega;
	}

	public BigDecimal getIdcourier() {
		return idcourier;
	}

	public void setIdcourier(BigDecimal idcourier) {
		this.idcourier = idcourier;
	}

	public BigDecimal getIdtercero() {
		return idtercero;
	}

	public void setIdtercero(BigDecimal idtercero) {
		this.idtercero = idtercero;
	}

	public Integer getIdpestado() {
		return idpestado;
	}

	public void setIdpestado(Integer idpestado) {
		this.idpestado = idpestado;
	}

	public Integer getIdarchivo() {
		return idarchivo;
	}

	public void setIdarchivo(Integer idarchivo) {
		this.idarchivo = idarchivo;
	}

	public Integer getIdpestadocarga() {
		return idpestadocarga;
	}

	public void setIdpestadocarga(Integer idpestadocarga) {
		this.idpestadocarga = idpestadocarga;
	}

	public String getMensajecarga() {
		return mensajecarga;
	}

	public void setMensajecarga(String mensajecarga) {
		this.mensajecarga = mensajecarga;
	}

	public BigDecimal getGrupocarga() {
		return grupocarga;
	}

	public void setGrupocarga(BigDecimal grupocarga) {
		this.grupocarga = grupocarga;
	}

	public String getCorreocourier() {
		return correocourier;
	}

	public void setCorreocourier(String correocourier) {
		this.correocourier = correocourier;
	}

	public String getNombretercero() {
		return nombretercero;
	}
	
	public void setNombretercero(String nombretercero) {
		this.nombretercero = nombretercero;
	}

}
