package com.gp.book.exception;

/**
 * @author ganeshpunde
 *
 */
public class BookServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BookServiceException() {
		super();
	}

	public BookServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BookServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookServiceException(String message) {
		super(message);
	}

	public BookServiceException(Throwable cause) {
		super(cause);
	}
}
