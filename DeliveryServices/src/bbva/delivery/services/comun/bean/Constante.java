package bbva.delivery.services.comun.bean;

public class Constante  {

	
	private String ideConstante;
	private String dscConstante;
	private String idpTipoDato;
	private String valor;
	private String valorClob;
	private String usuCreacion;
	
	public Constante() {}
	
	
	public String getValorClob() {
		return valorClob;
	}
	
	public void setValorClob(String valorClob) {
		this.valorClob = valorClob;
	}

	public String getIdeConstante() {
		return ideConstante;
	}

	public void setIdeConstante(String ideConstante) {
		this.ideConstante = ideConstante;
	}

	public String getDscConstante() {
		return dscConstante;
	}

	public void setDscConstante(String dscConstante) {
		this.dscConstante = dscConstante;
	}

	public String getIdpTipoDato() {
		return idpTipoDato;
	}

	public void setIdpTipoDato(String idpTipoDato) {
		this.idpTipoDato = idpTipoDato;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getUsuCreacion() {
		return usuCreacion;
	}

	public void setUsuCreacion(String usuCreacion) {
		this.usuCreacion = usuCreacion;
	}
}

