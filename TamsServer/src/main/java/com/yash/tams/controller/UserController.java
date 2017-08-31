package com.yash.tams.controller;


import java.util.List;
import java.util.Map;

import java.util.List;  


import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
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


}
