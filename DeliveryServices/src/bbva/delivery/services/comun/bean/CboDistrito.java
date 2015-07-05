package bbva.delivery.services.comun.bean;

import java.io.Serializable;
import java.util.Map;

import commons.mapper.ResourceManager;

public class CboDistrito implements Serializable {

  /**
  *
  **/
  private static final long serialVersionUID = 1L;
  private Integer idedistrito;
  private String dscdistrito;
  private String codextdistrito;

  public CboDistrito() {}

  @SuppressWarnings("rawtypes")
public CboDistrito(Map map) throws Exception {
    ResourceManager.populateDtoFromMap(this, map);
  }

  public Integer getIdedistrito() {
    return idedistrito;
  }

  public void setIdedistrito(Integer idedistrito) {
    this.idedistrito = idedistrito;
  }

  public String getDscdistrito() {
    return dscdistrito;
  }

  public void setDscdistrito(String dscdistrito) {
    this.dscdistrito = dscdistrito;
  }

  public String getCodextdistrito() {
	return codextdistrito;
  }
	
  public void setCodextdistrito(String codextdistrito) {
	this.codextdistrito = codextdistrito;
  }

}

