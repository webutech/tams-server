package com.yash.tams.exception;

/**
 * This is the custom exception for the Tams-Server Application
 * @author Brian Sutton
 *
 */
public class TamsException extends Exception {
	
	/**
	 * Id for the Exception class
	 */
	private static final long serialVersionUID = 1L;
/**
 * Constructor for the TamsException class
 * @param msg
 */
	public TamsException(String msg) {
		super(msg);
	}
	
}
