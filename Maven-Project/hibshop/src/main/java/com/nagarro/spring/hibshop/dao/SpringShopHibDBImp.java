/**
 * 
 */
package com.nagarro.spring.hibshop.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.nagarro.spring.hibshop.constant.Constants;
import com.nagarro.spring.hibshop.exceptions.TShirtsExceptions;
import com.nagarro.spring.hibshop.pojo.PreferedTShirts;
import com.nagarro.spring.hibshop.pojo.TShirts;
import com.nagarro.spring.hibshop.pojo.User;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

/**
 * This class implements interface which contain methods declaration for
 * database operations and define there body to perform that particular
 * operation.
 * 
 * @author kritikasingh02
 *
 */
@Repository
public class SpringShopHibDBImp implements SpringShopHibDB {

	// creating object for configuration class
	Configuration configuration = new Configuration();

	// creating session factory object for User class
	SessionFactory factoryUser = configuration.configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
			.buildSessionFactory();

	public SessionFactory factoryTShirts = configuration.configure("hibernate.cfg.xml").addAnnotatedClass(TShirts.class)
			.buildSessionFactory();

	/* Declaring and Initialization variables */
	public boolean flag = false;
	public int count = 0;
	public boolean check = false;

	/**
	 * create given user in database
	 * 
	 * @param user
	 */
	@Override
	public void createUser(User user) {

		Session session = factoryUser.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

	/**
	 * delete given user from database
	 * 
	 * @param user
	 */
	@Override
	public void deleteUser(User user) {
		Session session = factoryUser.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}

	}

	/**
	 * return specific user from database with given data input
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public User getUserById(String id) {

		Session session = factoryTShirts.openSession();
		Transaction tx = null;
		User user = null;
		try {
			tx = session.beginTransaction();
			user = session.get(User.class, id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return user;
	}

	/**
	 * update user via given data input in database
	 * 
	 * @param user
	 */
	@Override
	public void updateUser(User user) {

		Session session = factoryUser.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}

	}

	/**
	 * return sorted list according to price of tshirts references from database
	 * 
	 * @return
	 */
	@Override
	public List<TShirts> sortAccordingToPrice() {
		Session session = factoryTShirts.openSession();
		Transaction tx = session.beginTransaction();
		List sortPrice = session.createQuery("From TShirts Order BY Price").list();
		session.close();
		return sortPrice;
	}

	/**
	 * return sorted list according to rating of tshirts references from database
	 * 
	 * @return
	 */
	@Override
	public List<TShirts> sortAccordingToRating() {

		Session session = factoryTShirts.openSession();
		Transaction tx = session.beginTransaction();
		List sortPrice = session.createQuery("From TShirts Order BY Rating").list();
		session.close();
		return sortPrice;
	}

	/**
	 * return sorted list according to price and rating both of tshirts references
	 * from database
	 * 
	 * @return
	 */
	@Override
	public List<TShirts> sortAccordingToBoth() {
		// TODO Auto-generated method stub
		Session session = factoryTShirts.openSession();
		Transaction tx = session.beginTransaction();
		List sortPrice = session.createQuery("From TShirts Order BY Price,Rating").list();
		session.close();
		return sortPrice;

	}

	/**
	 * return list of preferred tshirts according to specific preference
	 * 
	 * @return
	 */
	@Override
	public List<TShirts> getPreferedTShirts() {
		// TODO Auto-generated method stub

		Session session = factoryTShirts.openSession();
		Transaction tx = null;
		List<TShirts> temp = null;
		ArrayList<TShirts> totalTShirts = new ArrayList<TShirts>();
		try {
			tx = session.beginTransaction();
			try {
				System.out.println("\n" + Constants.AVAILABLE + "\n");

				if (PreferedTShirts.getPreference() == Constants.ONE) {
					temp = sortAccordingToPrice();
					System.out.println(Constants.PRICE + "\n");

				} else if (PreferedTShirts.getPreference() == Constants.TWO) {

					temp = sortAccordingToRating();
					System.out.println(Constants.RATING + "\n");
				} else {

					temp = sortAccordingToBoth();
					System.out.println(Constants.PRICE_RATING + "\n");
				}
				Iterator iterator = temp.iterator();
				check = false;
				System.out.println(PreferedTShirts.color);
				System.out.println(PreferedTShirts.size);
				System.out.println(PreferedTShirts.gender);
				System.out.println(PreferedTShirts.preference);
				while (iterator.hasNext()) {

					TShirts shirts = (TShirts) iterator.next();
					System.out.println(shirts.getColor());
					System.out.println(shirts.getSize());
					System.out.println(shirts.getGender());
					System.out.println(shirts.getAvailability());

					if (shirts.getColor().equalsIgnoreCase(PreferedTShirts.color)
							&& shirts.getSize().equalsIgnoreCase(PreferedTShirts.size)
							&& shirts.getGender().equalsIgnoreCase(PreferedTShirts.gender)
							&& shirts.getAvailability().equalsIgnoreCase(Constants.YES)) {

						totalTShirts.add(shirts);
						check = true;
					}
				}
				if (!check) {
					throw new TShirtsExceptions(Constants.UNAVAILABLE);
				}

			} catch (TShirtsExceptions e) {
				e.message();
			}
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return totalTShirts;
	}

	/**
	 * save given tshirt in database
	 * 
	 * @param tshirts
	 */
	@Override
	synchronized public void saveTShirts(TShirts tshirts) {

		Session session = factoryTShirts.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(tshirts);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}

	}

	/**
	 * delete given tshirt from database
	 * 
	 * @param tshirts
	 */
	@Override
	public void deleteTShirts(TShirts tshirts) {
		Session session = factoryTShirts.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(tshirts);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}

	}

	/**
	 * update the given tshirt in database
	 * 
	 * @param tshirts
	 */
	@Override
	public void updateTShirts(TShirts tshirts) {
		Session session = factoryTShirts.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(tshirts);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}

	}

	/**
	 * return tshirt of given input id from database
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public TShirts getTShirtsById(String id) {
		Session session = factoryTShirts.openSession();
		Transaction tx = null;
		TShirts tshirts = null;
		try {
			tx = session.beginTransaction();
			tshirts = session.get(TShirts.class, id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return tshirts;
	}

	/**
	 * This method is use to read csv file from specific folder and store data in
	 * database.
	 */
	@Override
	public void readFile() {

		File directoryPath = new File("C:\\Users\\kritikasingh02\\eclipse-workspace\\hibshop\\assets");

		File filesList[] = directoryPath.listFiles();

		System.out.println(directoryPath.getTotalSpace());
		for (File file : filesList) {
			System.out.println(file.getName());
			try {

				CSVParser parser = new CSVParserBuilder().withSeparator('|').build();

				CSVReader fileData = new CSVReaderBuilder(new FileReader(directoryPath + "/" + file.getName()))
						.withCSVParser(parser).withSkipLines(1).build();

				List<String[]> allData = fileData.readAll();

				for (String[] row : allData) {

					saveTShirts(new TShirts(row[0], row[1], row[2], row[3], row[4], Float.valueOf(row[5]).floatValue(),
							Float.valueOf(row[6]).floatValue(), row[7]));

				}

			}

			catch (IOException e) {
				e.printStackTrace();
			} catch (CsvException e) {
				e.printStackTrace();
			}
		}
	}

}
