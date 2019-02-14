package com.tracy.web.config.exception;

/**
 * 业务模块自定义异常
 * @author 2019/2/12
 */
public class SessionTimeOutException extends ApiException{

	@Override
	public String getErrorCode() {
		return "20004";
	}

}
