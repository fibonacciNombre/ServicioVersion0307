package bbva.delivery.services.comun.bean;

import java.io.Serializable;
import java.util.Map;

import commons.mapper.ResourceManager;

public class CboDepartamento implements Serializable {

  /**
  *
  **/
  private static final long serialVersionUID = 1L;
  
  private Integer idedepartamento;
  private String dscdepartamento;
  private String codextdepartamento;

  public CboDepartamento() {}


public CboDepartamento(Map<?, ?> map) throws Exception {
	ResourceManager.populateDtoFromMap(this, map);
  }

  public Integer getIdedepartamento() {
    return idedepartamento;
  }

  public void setIdedepartamento(Integer idedepartamento) {
    this.idedepartamento = idedepartamento;
  }

  public String getDscdepartamento() {
    return dscdepartamento;
  }

  public void setDscdepartamento(String dscdepartamento) {
    this.dscdepartamento = dscdepartamento;
  }

public String getCodextdepartamento() {
	return codextdepartamento;
}

public void setCodextdepartamento(String codextdepartamento) {
	this.codextdepartamento = codextdepartamento;
}

}

