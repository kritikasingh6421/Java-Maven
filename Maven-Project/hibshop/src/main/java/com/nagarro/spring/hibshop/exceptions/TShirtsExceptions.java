/**
 * 
 */
package com.nagarro.spring.hibshop.exceptions;

/**
 * 
 * print message when inappropriate condition occur.
 * 
 * @author kritikasingh02
 *
 */
public class TShirtsExceptions extends Exception {

	private String message; // message variable declaration

	/**
	 * Initialize message attribute
	 * 
	 * @param message
	 */

	public TShirtsExceptions(String message) {
		this.message = message;
	}

	/**
	 * Print message
	 * 
	 * @param message
	 * @return none does not return any value
	 */

	public void message() {
		System.out.println(this.message);
	}

}
