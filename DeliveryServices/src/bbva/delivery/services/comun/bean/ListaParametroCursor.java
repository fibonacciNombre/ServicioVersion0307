package bbva.delivery.services.comun.bean;

import java.io.Serializable;
import java.util.Map;

import commons.mapper.ResourceManager;

public class ListaParametroCursor implements Serializable {

  /**
  *
  **/
  private static final long serialVersionUID = 1L;
  private String codigo;
  private String abreviatura;
  private Integer codigon;
  private String codigoc;
  private String descripcion;
  private String descripcion2;
  private String indexrow;

  public ListaParametroCursor() {}

  @SuppressWarnings("rawtypes")
  public ListaParametroCursor(Map map) throws Exception {
    ResourceManager.populateDtoFromMap(this, map);
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getAbreviatura() {
    return abreviatura;
  }

  public void setAbreviatura(String abreviatura) {
    this.abreviatura = abreviatura;
  }

  public Integer getCodigon() {
    return codigon;
  }

  public void setCodigon(Integer codigon) {
    this.codigon = codigon;
  }

  public String getCodigoc() {
    return codigoc;
  }

  public void setCodigoc(String codigoc) {
    this.codigoc = codigoc;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  
  public String getDescripcion2() {
    return descripcion2;
  }

  public void setDescripcion2(String descripcion2) {
    this.descripcion2 = descripcion2;
  }

  public String getIndexrow() {
    return indexrow;
  }

  public void setIndexrow(String indexrow) {
    this.indexrow = indexrow;
  }

}

