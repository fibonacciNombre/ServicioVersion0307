package bbva.delivery.services.comun.bean;

import java.io.Serializable;
import java.util.Map;

import commons.mapper.ResourceManager;

public class CryptoWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String texto;
	private String textoencriptado;
	private String cryptokey;
	
	public CryptoWeb(){}
	
	public CryptoWeb(Map<?,?> map) throws Exception {
		ResourceManager.populateDtoFromMap(this, map);
	}

	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getTextoencriptado() {
		return textoencriptado;
	}
	public void setTextoencriptado(String textoencriptado) {
		this.textoencriptado = textoencriptado;
	}
	public String getCryptokey() {
		return cryptokey;
	}
	public void setCryptokey(String cryptokey) {
		this.cryptokey = cryptokey;
	}
	

}
