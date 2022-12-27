/**
 * 
 */
package com.nagarro.spring.hibshop.service;

import java.util.List;

import com.nagarro.spring.hibshop.pojo.TShirts;
import com.nagarro.spring.hibshop.pojo.User;

/**
 * @author kritikasingh02
 *
 */
public interface SpringShopHibOperations {
	
	/**
	 * This function is use to read csv file after some interval
	 */
	public void secheduled();
	
	/**
	 * return list of preferred tshirts according to specific preference
	 * 
	 * @return
	 */
	public List<TShirts> getPreferedTShirts();

	/**
	 * save given tshirt in database
	 * 
	 * @param tshirts
	 */
	public void saveTShirts(TShirts tshirts);

	/**
	 * delete given tshirt from database
	 * 
	 * @param tshirts
	 */
	public void deleteTShirts(TShirts tshirts);

	/**
	 * update the given tshirt in database
	 * 
	 * @param tshirts
	 */
	public void updateTShirts(TShirts tshirts);

	/**
	 * return tshirt of given input id from database
	 * 
	 * @param id
	 * @return
	 */
	public TShirts getTShirtsById(String id);

	/**
	 * create given user in database
	 * 
	 * @param user
	 */
	public void createUser(User user);

	/**
	 * delete given user from database
	 * 
	 * @param user
	 */
	public void deleteUser(User user);

	/**
	 * return specific user from database with given data input
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(String id);

	/**
	 * update user via given data input in database
	 * 
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * This method is use to read csv file from specific folder and store data in
	 * database.
	 */
	public void readFile();

}
