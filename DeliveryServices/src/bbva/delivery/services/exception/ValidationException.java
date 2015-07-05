package bbva.delivery.services.exception;

public class ValidationException extends Exception {

	private static final long serialVersionUID = -482906251030396404L;
	
	private String codigo;

	public ValidationException() {
		super();
	}
	
	public ValidationException(String message) {
		super(message);
	}
	
	public ValidationException(Throwable t) {
		super(t);
	}
	
	public ValidationException(String message, Throwable t) {
		super(message, t);
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
