package com.nagarro.spring.hibshop.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * This User class is persistent class for mapping it with USER table of
 * database PRODUCTS.
 * <p>
 * User is class which allow an application to initialize User attributes
 * username and password during new object creation for User.
 * 
 * @author kritikasingh02
 *
 */
@Entity
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "USERNAME")
	private String username;// Deceleration of username attribute

	@Column(name = "PASSWORD")
	private String password;// Deceleration of password attribute

	/**
	 * Default Constructor
	 */
	public User() {
	}

	/**
	 * Parameterized Constructor
	 * <p>
	 * Initialize class attribute with given data inputs
	 * 
	 * @param userName
	 * @param password
	 */
	public User(String username, String password) {

		this.username = username;// Initialization of username attribute
		this.password = password;// Initialization of password attribute
	}

	/**
	 * @return the userName
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


}
