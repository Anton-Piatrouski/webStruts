package by.epam.exceptions;

public class ConnectionException extends Exception {
	private static final long serialVersionUID = 1L;
	private String cause;
	
	public ConnectionException(String cause) {
		this.cause = cause;
	}
	
	public ConnectionException(Exception exception) {
		super(exception);
		this.cause = exception.getMessage();
	}
	
	@Override
	public String toString() {
		return cause;
	}
}
