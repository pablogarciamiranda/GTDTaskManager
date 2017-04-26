package uo.sdi.business.exception;

import javax.xml.ws.WebFault;

@WebFault
public class BusinessException extends Exception {
	private static final long serialVersionUID = 4001710687990554589L;
	private String faultReason;

	private String faultCode;

	public BusinessException() {
	}

	public BusinessException(String message) {
		super(message);
		faultReason = message;
		faultCode = "";
	}

	public BusinessException(Throwable cause) {
		super(cause);
		faultReason = cause.getMessage();
		faultCode = "";
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		faultReason = message;
		faultCode = "";
	}
	
	public String getFaultReason() {
		return faultReason;
	}

	public String getFaultCode() {
		return faultCode;
	}

}
