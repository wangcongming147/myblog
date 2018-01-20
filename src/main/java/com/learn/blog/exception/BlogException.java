package com.learn.blog.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BlogException extends Exception{
	
	private String code;

	/**
	 * 
	 */
	private static final long serialVersionUID = -7020560015365026894L;

	public BlogException() {
		super();
	}

	public BlogException(String code,String message) {
		super(message);
		this.code = code;
	}
	
	public BlogException(String message) {
		super(message);
	}

	public BlogException(String code,String message, Throwable arg1, boolean arg2, boolean arg3) {
		super(message, arg1, arg2, arg3);
		this.code = code;
	}

	public BlogException(String code,String message, Throwable arg1) {
		super(message, arg1);
		this.code = code;
	}

	public BlogException(String code,Throwable arg0) {
		super(arg0);
		this.code = code;
	}

	public BlogException(String message, Throwable arg1, boolean arg2, boolean arg3) {
		super(message, arg1, arg2, arg3);
	}

	public BlogException(Throwable arg0) {
		super(arg0);
	}
	
}
