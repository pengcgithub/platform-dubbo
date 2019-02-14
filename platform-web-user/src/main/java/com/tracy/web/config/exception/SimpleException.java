package com.tracy.web.config.exception;

/**
 * 一般异常案例
 * @author pengc
 */
public class SimpleException extends ApiException {

	private final String message;

	private final String code;

	public SimpleException(String message, String code) {
		this.message = message;
		this.code = code;
	}

	@Override
	public String getErrorCode() {
		return code;
	}

	@Override
	protected String getCustomMessage() {
		return message;
	}
}
