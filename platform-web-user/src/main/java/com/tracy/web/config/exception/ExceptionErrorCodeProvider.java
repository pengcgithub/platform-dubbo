package com.tracy.web.config.exception;

public interface ExceptionErrorCodeProvider extends ErrorCoded {
	boolean support(Exception e);
}
