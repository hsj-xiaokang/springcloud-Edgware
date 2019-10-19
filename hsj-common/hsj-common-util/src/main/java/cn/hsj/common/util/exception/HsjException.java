package cn.hsj.common.util.exception;

/**
 * 顶级异常，不允许直接抛出
 * @author hsj
 *
 */
public abstract class HsjException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected HsjException() {
		super();
	}

	protected HsjException(String message) {
		super(message);
	}

	protected HsjException(Throwable cause) {
		super(cause);
	}

	protected HsjException(String message, Throwable cause) {
		super(message, cause);
	}

	protected HsjException(String message, Throwable cause, boolean enableSuppression,
	        boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
