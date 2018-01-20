package com.learn.blog.exception;

public class BusinessException extends BlogException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2177615675191764758L;

	public BusinessException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessException(String code, String message, Throwable arg1,
			boolean arg2, boolean arg3) {
		super(code, message, arg1, arg2, arg3);
	}

	public BusinessException(String code, String message, Throwable arg1) {
		super(code, message, arg1);
	}

	public BusinessException(String code, String message) {
		super(code, message);
	}

	public BusinessException(String code, Throwable arg0) {
		super(code, arg0);
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(message, arg1, arg2, arg3);
	}

	public BusinessException(Throwable arg0) {
		super(arg0);
	}
	
}
