package by.epam.exceptions;

public class DaoException extends Exception {
	private static final long serialVersionUID = 1L;
	private String cause;
	
	public DaoException(String cause) {
		this.cause = cause;
	}
	
	@Override
	public String toString() {
		return cause;
	}
}
