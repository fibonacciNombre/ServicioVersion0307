package bbva.delivery.services.comun.bean;

import java.io.Serializable;
import java.util.Map;

import commons.mapper.ResourceManager;

public class CboPais implements Serializable {

  /**
	 * 
	 */
  private static final long serialVersionUID = 5510968140918447889L;

  
  private Integer idepais;
  private String dscpais;
  private String indexrow;

  public CboPais(){}

  public CboPais(Map<?, ?> map) throws Exception {
		ResourceManager.populateDtoFromMap(this, map);
	}

  public Integer getIdepais() {
    return idepais;
  }

  public void setIdepais(Integer idepais) {
    this.idepais = idepais;
  }

  public String getDscpais() {
    return dscpais;
  }

  public void setDscpais(String dscpais) {
    this.dscpais = dscpais;
  }

  public String getIndexrow() {
    return indexrow;
  }

  public void setIndexrow(String indexrow) {
    this.indexrow = indexrow;
  }

}

