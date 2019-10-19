package cn.hsj.common.util.exception;

public final class HsjWebException extends HsjException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HsjWebException() {
		super();
	}

	public HsjWebException(String message) {
		super(message);
	}

	public HsjWebException(Throwable cause) {
		super(cause);
	}

	public HsjWebException(String message, Throwable cause) {
		super(message, cause);
	}

	public HsjWebException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	
}
