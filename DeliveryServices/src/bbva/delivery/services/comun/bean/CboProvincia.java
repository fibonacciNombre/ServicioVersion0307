package bbva.delivery.services.comun.bean;

import java.io.Serializable;
import java.util.Map;

import commons.mapper.ResourceManager;

public class CboProvincia implements Serializable {

  /**
  *
  **/
  private static final long serialVersionUID = 1L;
  private Integer ideprovincia;
  private String dscprovincia;
  private String codextprovincia ;

  public CboProvincia() {}

  public CboProvincia(Map<?, ?> map) throws Exception {
		ResourceManager.populateDtoFromMap(this, map);  }

  public Integer getIdeprovincia() {
    return ideprovincia;
  }

  public void setIdeprovincia(Integer ideprovincia) {
    this.ideprovincia = ideprovincia;
  }

  public String getDscprovincia() {
    return dscprovincia;
  }

  public void setDscprovincia(String dscprovincia) {
    this.dscprovincia = dscprovincia;
  }

  public String getCodextprovincia() {
	return codextprovincia;
  }

  public void setCodextprovincia(String codextprovincia) {
	this.codextprovincia = codextprovincia;
  }
}

