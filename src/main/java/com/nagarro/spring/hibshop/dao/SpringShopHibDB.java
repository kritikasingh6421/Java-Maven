/**
 * 
 */
package com.nagarro.spring.hibshop.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.nagarro.spring.hibshop.pojo.TShirts;
import com.nagarro.spring.hibshop.pojo.User;

/**
 * This Interface is use for defining the structure of methods for database
 * operations require to fulfill desire functionality.
 * 
 * @author kritikasingh02
 *
 */
@Component
public interface SpringShopHibDB {

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
	 * return sorted list according to price of tshirts references from database
	 * 
	 * @return
	 */
	public List<TShirts> sortAccordingToPrice();

	/**
	 * return sorted list according to rating of tshirts references from database
	 * 
	 * @return
	 */
	public List<TShirts> sortAccordingToRating();

	/**
	 * return sorted list according to price and rating both of tshirts references
	 * from database
	 * 
	 * @return
	 */
	public List<TShirts> sortAccordingToBoth();

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
