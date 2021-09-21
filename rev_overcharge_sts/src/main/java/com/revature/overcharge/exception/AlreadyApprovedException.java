package com.revature.overcharge.exception;

public class AlreadyApprovedException extends Exception {
	public AlreadyApprovedException() {
	super();
}

public AlreadyApprovedException(String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
}

public AlreadyApprovedException(String message, Throwable cause) {
	super(message, cause);
	
}

public AlreadyApprovedException(String message) {
	super(message);
	
}

public AlreadyApprovedException(Throwable cause) {
	super(cause);
	
}

}
