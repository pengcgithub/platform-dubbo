package com.tracy.web.config.exception;

/**
 * ApiException
 * @author pengc
 */
public abstract class ApiException extends RuntimeException implements ErrorCoded {

	/**
	 * 默认错误代码
	 */
	public static final String DEFAULT_ERROR_CODE = "serverEx";

	private Object[] args;

	public ApiException(Object... args) {
		this.args = args;
	}

	public Object[] getArgs() {
		return args;
	}

	@Override
	public String getMessage() {
		String customMessage = getCustomMessage();
		return customMessage == null ? super.getMessage() : customMessage;
	}

	protected String getCustomMessage() {
		return null;
	}

}
