package com.yash.tams.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yash.tams.exception.TamsException;
import com.yash.tams.model.Batch;
import com.yash.tams.model.User;
import com.yash.tams.service.UserService;
/**
 * This is the User Rest Api controller for the application
 * all mappings will be proceeded by /user when accessed externally 
 * @author Brian Sutton
 *
 */
import com.yash.tams.urls.TamsServerUrls;

import io.undertow.util.BadRequestException;

@RestController
public class UserController {
	/**
	 * This is the User Service Implementation for the user controller
	 */
	@Autowired
	UserService userService;

	/**
	 * This controller method will return all users from the database Headers
	 * are added to let the browser know it is OK to receive the response.
	 * 
	 * @param responce
	 *            channges
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

	@RequestMapping(value = TamsServerUrls.USERS_BY_ID, method = RequestMethod.PUT)
	public void editUser(@PathVariable int id, @RequestBody User user) {
		// Update user into the database
		user.setId(id);
		userService.editUser(user);
	}

	@RequestMapping(value = TamsServerUrls.EDIT_PASSWORD, method = RequestMethod.PUT)
	public void editPassword(@PathVariable int id, @RequestBody Map<String, String> password) throws TamsException {
		// Update password into the database
		userService.editPassword(id, password.get("newPassword"), password.get("oldPassword"));

	}

	/**
	 * This controller method will register(insert) an user into the database. A
	 * success boolean will be sent to login page if user user name is unique,
	 * else a failure message will be sent to registration page.
	 * 
	 * @param user
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = TamsServerUrls.USERS, method = RequestMethod.POST)
	public String registerUser(@RequestBody User user) {
		return "{\"status\":" + userService.registerUser(user) + "}";
	}

	/**
	 * this controller will varify the user is registered in the database if a
	 * successful login is reached the headers will send ok = true if login is
	 * unsuccessful the hearder will send ok = false
	 * 
	 * @param responce
	 * @param user
	 * @param login
	 * @param password
	 * @return
	 */
	@RequestMapping(value = TamsServerUrls.USER_AUTHENTICATE, method = RequestMethod.POST)
	public User getAuthentication(HttpServletResponse responce, @PathVariable String login,
			@PathVariable String password) {

		User user = userService.authenticateUser(login, password);
		if (user != null) {
			responce.setStatus(200);
			responce.addHeader("ok", "true");
			responce.addHeader("Access-Control-Allow-Origin", "*");
			responce.addHeader("content-type", "application/json");
			responce.setContentType("application/json");
			return user;
		} else {
			responce.setStatus(404);
			responce.addHeader("ok", "false");
			responce.addHeader("Access-Control-Allow-Origin", "*");
			responce.addHeader("content-type", "application/json");
			responce.setContentType("application/json");
			return null;
		}
	}
	@RequestMapping(value = TamsServerUrls.RESET_PASSWORD, method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public void resetPassword(@RequestBody User user) throws BadRequestException {
		if (user.getUserName() == null) {
			throw new BadRequestException("Please provide the username.");
		} else if (user.getPassword() == null) {
			throw new BadRequestException("Password should not be null. Please check");
		}
		userService.resetPassword(user.getUserName(), user.getPassword());
	}

	@RequestMapping(value = TamsServerUrls.UPDATE_USER_STATUS, method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public Boolean updateUserStatus(@RequestBody User user) throws SQLException, BadRequestException {
		if (user.getUserName() == null) {
			throw new BadRequestException("Username is null. Please check");
		} else if (user.getStatusId() != 0 || user.getStatusId() != 1) {
			throw new BadRequestException("Invalid Status. Status can be either 0 or 1");
		}
		return userService.updateUserStatus(user.getUserName(), user.getStatusId());
	}

	@RequestMapping(value = TamsServerUrls.UPDATE_BATCH_STATUS, method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public Boolean updateBatchStatus(@RequestBody Batch batch) throws SQLException, BadRequestException {
		if (batch.getBatchName() == null) {
			throw new BadRequestException("BatchName is null. Please check");
		} else if (batch.getStatusId() != 0 || batch.getStatusId() != 1) {
			throw new BadRequestException("status is null. Please check");
		}
		return userService.updateUserStatus(batch.getBatchName(), batch.getStatusId());
	}
}
