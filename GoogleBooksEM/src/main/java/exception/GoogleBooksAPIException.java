package exception;

public class GoogleBooksAPIException extends Exception{
	/**
	 * declaring serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public GoogleBooksAPIException() {
		super();
	}
	
	public GoogleBooksAPIException(String message) {
		super(message);
	}
	
	public GoogleBooksAPIException(String message, Throwable cause) {
		super(message,cause);
	}
	
	public GoogleBooksAPIException(Throwable cause) {
		super(cause);
	}
	
	protected GoogleBooksAPIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message,cause,enableSuppression,writableStackTrace);
	}
}
