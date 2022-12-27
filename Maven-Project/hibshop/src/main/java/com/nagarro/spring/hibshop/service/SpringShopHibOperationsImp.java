/**
 * 
 */
package com.nagarro.spring.hibshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nagarro.spring.hibshop.SearchTShirts;
import com.nagarro.spring.hibshop.dao.SpringShopHibDBImp;
import com.nagarro.spring.hibshop.pojo.TShirts;
import com.nagarro.spring.hibshop.pojo.User;

/**
 * @author kritikasingh02
 *
 */
@Service
public class SpringShopHibOperationsImp implements SpringShopHibOperations {

	SpringShopHibDBImp dbOperation = new SpringShopHibDBImp();

	/**
	 * This function is use to read csv file after some interval
	 */
	public void secheduled() {

		new Thread(new SearchTShirts(dbOperation)).start();
		System.out.println("Useing scheduled method");

	}

	/**
	 * This method is use to read csv file from specific folder and store data in
	 * database.
	 */
	public void readFile() {
		dbOperation.readFile();
	}

	/**
	 * return list of preferred tshirts according to specific preference
	 * 
	 * @return
	 */
	public List<TShirts> getPreferedTShirts() {

		return dbOperation.getPreferedTShirts();
	}

	/**
	 * save given tshirt in database
	 * 
	 * @param tshirts
	 */
	public void saveTShirts(TShirts tshirts) {

		dbOperation.saveTShirts(tshirts);
	}

	/**
	 * delete given tshirt from database
	 * 
	 * @param tshirts
	 */
	public void deleteTShirts(TShirts tshirts) {

		dbOperation.deleteTShirts(tshirts);
	}

	/**
	 * update the given tshirt in database
	 * 
	 * @param tshirts
	 */
	public void updateTShirts(TShirts tshirts) {

		dbOperation.updateTShirts(tshirts);
	}

	/**
	 * return tshirt of given input id from database
	 * 
	 * @param id
	 * @return
	 */
	public TShirts getTShirtsById(String id) {

		return dbOperation.getTShirtsById(id);
	}

	/**
	 * create given user in database
	 * 
	 * @param user
	 */
	public void createUser(User user) {

		dbOperation.createUser(user);
	}

	/**
	 * delete given user from database
	 * 
	 * @param user
	 */
	public void deleteUser(User user) {

		dbOperation.deleteUser(user);
	}

	/**
	 * return specific user from database with given data input
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(String id) {

		return dbOperation.getUserById(id);

	}

	/**
	 * update user via given data input in database
	 * 
	 * @param user
	 */
	public void updateUser(User user) {

		dbOperation.updateUser(user);
	}

}
