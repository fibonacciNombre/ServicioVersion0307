package bbva.delivery.services.comun.bean;

import java.io.Serializable;
import java.util.Map;

import bbva.delivery.services.commons.Constants;

import commons.mapper.ResourceManager;

public class TransaccionWeb implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer statustx = Constants.TRANSACCION_STATUS_OK;
	private String messagetx;
	
	
	public TransaccionWeb() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("rawtypes")
	public TransaccionWeb(Map map) throws Exception {
		ResourceManager.populateDtoFromMap(this, map);
	}

	public Integer getStatustx() {
		return statustx;
	}

	public void setStatustx(Integer statustx) {
		this.statustx = statustx;
	}

	public String getMessagetx() {
		return messagetx;
	}

	public void setMessagetx(String msjtx) {
		this.messagetx = msjtx;
	}

	
}
