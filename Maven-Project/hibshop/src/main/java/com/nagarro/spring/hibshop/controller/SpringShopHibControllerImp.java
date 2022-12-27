/**
 * 
 */
package com.nagarro.spring.hibshop.controller;

import java.io.PrintWriter;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.spring.hibshop.dao.SpringShopHibDBImp;
import com.nagarro.spring.hibshop.pojo.PreferedTShirts;
import com.nagarro.spring.hibshop.pojo.TShirts;
import com.nagarro.spring.hibshop.pojo.User;
import com.nagarro.spring.hibshop.service.SpringShopHibOperationsImp;

/**
 * This is a controller class having methods to handle different Http requests in spring.
 * @author kritikasingh02
 *
 */
@Controller
public class SpringShopHibControllerImp {

	SpringShopHibOperationsImp shop = new SpringShopHibOperationsImp();
	SpringShopHibDBImp dbOperations = new SpringShopHibDBImp();

	/**
	 * This is use for front page.
	 * @return
	 */
	@RequestMapping("/")
	public String home() {
		return "index";
	}

	/**
	 * This controller is use to handle login process
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/authentication", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		
		User user = shop.getUserById(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				//shop.readFile();
				shop.secheduled();
				return "product";
			} else {
				return "index";
			}
		} else {
			return "index";
		}
	}

	/**
	 * This controller is use to handle logout process
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "index";
	}
	
	/**
	 * This is use to handle Http request made by tshirts page for going back.
	 * @return
	 */
	@RequestMapping(value="/back", method = RequestMethod.GET)
	public String back() {
		return "product";
	}

	/**
	 * This is use for handling http request made by product page for search specific product.
	 * @param color
	 * @param size
	 * @param gender
	 * @param preference
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@RequestParam("color") String color, @RequestParam("size") String size,
			@RequestParam("gender") String gender, @RequestParam("preference") String preference) {
		
		int preference1 = Integer.parseInt(preference);
		PreferedTShirts p = new PreferedTShirts(color, size, gender, preference1);
		List<TShirts> totalShirts = (List<TShirts>)shop.getPreferedTShirts();
		return new ModelAndView("tshirts");
	}

}
