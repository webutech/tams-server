package com.yash.tams.controller;


import java.util.List;
import java.util.Map;

import java.util.List;  


import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.tams.exception.TamsException;
import com.yash.tams.model.User;
import com.yash.tams.service.UserService;
/**
 * This is the User Rest Api controller for the application
 * all mappings will be proceeded by /user when accessed externally 
 * @author Brian Sutton
 *
 */
import com.yash.tams.urls.TamsServerUrls;
@RestController
public class UserController {
	/**
	 * This is the User Service Implementation for the user controller
	 */
	@Autowired
	UserService userService;
	

	/**
	 * This controller method will return all users from the database
	 * Headers are added to let the browser know it is OK to receive the response.
	 * @param responce channges
	 * @return
	 */
	@RequestMapping(TamsServerUrls.USERS)
	public List<User> getUsers(HttpServletResponse responce) {
		
		responce.setStatus(200);
		responce.addHeader("ok", "true");
		responce.addHeader("Access-Control-Allow-Origin", "*");
		responce.addHeader("content-type", "application/json");
		responce.setContentType("application/json");
		return userService.getUsers();
	}
	
	@RequestMapping(value=TamsServerUrls.USERS_BY_ID, method=RequestMethod.PUT)
	public void editUser(@PathVariable int id, @RequestBody User user) {
		//Update user into the database
		user.setId(id);
		userService.editUser(user);
	}
	
	
	@RequestMapping(value=TamsServerUrls.EDIT_PASSWORD, method=RequestMethod.PUT)
	public void editPassword(@PathVariable int id, @RequestBody Map<String, String> password ) throws TamsException {
		//Update password into the database
		userService.editPassword(id, password.get("newPassword"), password.get("oldPassword"));
		
	}
	
	/**
	 * This controller method will register(insert) an user into the database.
	 * A success message will be sent to login page if user user name is unique,
	 * else a failure message will be sent to registration page.
	 * @param user
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value=TamsServerUrls.USERS, method=RequestMethod.POST)
	public String registerUser(@RequestBody User user) {
		//Register user into the database if user name is not used
		String msg = "\"User name is already being used!\"";
		if(userService.registerUser(user)) {
			 msg = "\"User was registered successfully!\"";
		}
		
		return "{\"msg\":"+msg+"}";
	}
	
	/**
	 * this controller will varify the user is registered in the database
	 * if a successful login is reached the headers will send ok = true
	 * if login is unsuccessful the hearder will send ok = false
	 * @param responce
	 * @param user
	 * @param login
	 * @param password
	 * @return
	 */
	@RequestMapping(value=TamsServerUrls.USER_AUTHENTICATE, method=RequestMethod.POST )
	public User getAuthentication(HttpServletResponse responce, @PathVariable String login, @PathVariable String password){
		
		
		
		User user = userService.authenticateUser(login, password);
		if(user != null){
			responce.setStatus(200);
			responce.addHeader("ok", "true");
			responce.addHeader("Access-Control-Allow-Origin", "*");
			responce.addHeader("content-type", "application/json");
			responce.setContentType("application/json");
			return user;
		}else{
			responce.setStatus(404);
		responce.addHeader("ok", "false");
		responce.addHeader("Access-Control-Allow-Origin", "*");
		responce.addHeader("content-type", "application/json");
		responce.setContentType("application/json");
		return null;
		}
	}
}
