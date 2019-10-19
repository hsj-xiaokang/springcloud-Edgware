package cn.hsj.common.util.exception;

public final class HsjServiceException extends HsjException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HsjServiceException() {
		super();
	}

	public HsjServiceException(String message) {
		super(message);
	}

	public HsjServiceException(Throwable cause) {
		super(cause);
	}

	public HsjServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public HsjServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
