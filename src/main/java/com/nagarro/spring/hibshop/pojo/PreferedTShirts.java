package com.nagarro.spring.hibshop.pojo;

/**
 * PreferedTShirts is class which allow an application to initialize
 * PreferedTShirts attributes like color, size and gender during new object
 * creation for TShirts.
 * 
 * @author kritikasingh02
 *
 */
public class PreferedTShirts {

	public static String color;
	public static String size;
	public static String gender;
	public static int preference;

	/**
	 * Initialize class attribute with given data inputs
	 */
	public PreferedTShirts(String color, String size2, String gender, int preference) {

		this.color = color;
		this.size = size2;
		this.gender = gender;
		this.preference = preference;
	}

	/**
	 * @return the color
	 */
	public static String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public static void setColor(String color) {
		PreferedTShirts.color = color;
	}

	/**
	 * @return the size
	 */
	public static String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public static void setSize(String size) {
		PreferedTShirts.size = size;
	}

	/**
	 * @return the gender
	 */
	public static String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public static void setGender(String gender) {
		PreferedTShirts.gender = gender;
	}
	
	/**
	 * @return the preference
	 */
	public static int getPreference() {
		return preference;
	}

	/**
	 * @param preference the preference to set
	 */
	public static void setPreference(int preference) {
		PreferedTShirts.preference = preference;
	}

}
