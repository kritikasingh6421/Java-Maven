/**
 * 
 */
package com.nagarro.spring.hibshop.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * TShirts is class which allow an application to initialize TShirts attributes
 * like id, name, color, gender, size, price, rating and availability during new
 * object creation for TShirts.
 * 
 * @author kritikasingh02
 *
 */
@Entity
@Table(name="TSHIRTS")
public class TShirts {

	@Id
	@Column(name="ID")
	private String id; // Deceleration of id attribute
	
	@Column(name="NAME")
	private String name; // Deceleration of name attribute
	
	@Column(name="COLOR")
	private String color; // Deceleration of color attribute
	
	@Column(name="GENDER")
	private String gender; // Deceleration of gender attribute
	
	@Column(name="SIZE")
	private String size; // Deceleration of size attribute
	
	@Column(name="PRICE")
	private float price; // Deceleration of price attribute
	
	@Column(name="RATING")
	private float rating; // Deceleration of rating attribute
	
	@Column(name="AVAILABILITY")
	private String availability; // Deceleration of availability attribute

	/**
	 * Default Constructor 
	 */
	public TShirts() {

	}
	
	/**
	 * Parameterized Constructor
	 * <p>
	 * Initialize class attribute with given data inputs
	 * 
	 * @param id
	 * @param name
	 * @param color
	 * @param gender
	 * @param size
	 * @param price
	 * @param rating
	 * @param availability
	 * 
	 */
	public TShirts(String id, String name, String color, String gender, String size, float price, float rating,
			String availability) {

		this.id = id; // Initialization of id attribute
		this.name = name; // Initialization of name attribute
		this.color = color; // Initialization of color attribute
		this.gender = gender; // Initialization of gender attribute
		this.size = size; // Initialization of size attribute
		this.price = price; // Initialization of price attribute
		this.rating = rating; // Initialization of rating attribute
		this.availability = availability; // Initialization of availability attribute

	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the rating
	 */
	public float getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(float rating) {
		this.rating = rating;
	}

	/**
	 * @return the availability
	 */
	public String getAvailability() {
		return availability;
	}

	/**
	 * @param availability the availability to set
	 */
	public void setAvailability(String availability) {
		this.availability = availability;
	}
}
