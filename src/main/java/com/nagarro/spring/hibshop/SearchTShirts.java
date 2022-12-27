/**
 * 
 */
package com.nagarro.spring.hibshop;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.nagarro.spring.hibshop.constant.Constants;
import com.nagarro.spring.hibshop.dao.SpringShopHibDBImp;
import com.nagarro.spring.hibshop.pojo.TShirts;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import org.hibernate.Session;

/**
 * 
 * This thread class is use for looking any new file at particular location
 * after some configurable time and load the provided file into database.
 * 
 * @author kritikasingh02
 * @param <implement>
 *
 */
public class SearchTShirts implements Runnable {

	SpringShopHibDBImp dbOperations = new SpringShopHibDBImp();

	/**
	 * Initialize class attribute with given data inputs
	 * 
	 * @param storeOperations
	 * @throws InterruptedException
	 */
	public SearchTShirts(SpringShopHibDBImp dbOperations) {
		this.dbOperations = dbOperations;
	}

	public void run() {
		while (true) {
			System.out.println("thread start");

			// Creating a File object for directory
			File directoryPath = new File("C:\\Users\\kritikasingh02\\eclipse-workspace\\hibshop\\assets");

			// List of all files and directories
			File filesList[] = directoryPath.listFiles();

			for (File file : filesList) {

				try {

					// create csvParser object with custom separator
					CSVParser parser = new CSVParserBuilder().withSeparator('|').build();

					// create csvReader object with parameter file reader and parser
					CSVReader fileData = new CSVReaderBuilder(new FileReader(directoryPath + "/" + file.getName()))
							.withCSVParser(parser).withSkipLines(1).build();

					// storing all data in List of type string array
					List<String[]> allData = fileData.readAll();

					//
					for (String[] row : allData) {
						if (dbOperations.count != Constants.ZERO) {
                            //System.out.println("come in count more then one");
							boolean temp = true;
							Session session = dbOperations.factoryTShirts.openSession();
							List tshirts = session.createQuery("FROM TShirts").list();

							Iterator iterator = tshirts.iterator();
							while (iterator.hasNext()) {
								TShirts shirts = (TShirts) iterator.next();
								if (shirts.getId().equals(row[0])) {
									temp = false;
									break;
								}
							}
							if (temp) {
								System.out.println("new entry");
								// storing instance of class TShirts in database via store method
								dbOperations.saveTShirts(new TShirts(row[0], row[1], row[2], row[3], row[4],
										Float.valueOf(row[5]).floatValue(), Float.valueOf(row[6]).floatValue(),
										row[7]));

							}
						}

						else {
							// storing instance of class TShirts in database via store method
							dbOperations.saveTShirts(new TShirts(row[0], row[1], row[2], row[3], row[4],
									Float.valueOf(row[5]).floatValue(), Float.valueOf(row[6]).floatValue(), row[7]));

						}

					}

				} catch (IOException e) {
					e.printStackTrace();
				} catch (CsvException e) {
					e.printStackTrace();
				}
			}

			// Increment count variable use to count SearchTShirts class Iterations
			++dbOperations.count;
			System.out.println(dbOperations.count);
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
