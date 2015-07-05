package bbva.delivery.services.bean;

import java.io.Serializable;

public class EmbeddedImages implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3535499182520698417L;

	public EmbeddedImages(){
	}
	
	private String path;
	private String id;
	
	public String getPath() {
		return path;
	}
	public String getId() {
		return id;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setId(String id) {
		this.id = id;
	}
}
