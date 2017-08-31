package com.yash.tams.service;

import java.util.List;

import com.yash.tams.exception.TamsException;
import com.yash.tams.model.User;
/**
 * This is the Interface of the User Service Layer.
 *  Add methods here then implement them to the Impl
 * @author Brian Sutton
 *
 */
public interface UserService {

	/**
	 * Returns all Users From the database
	 * @return
	 */
	public List<User> getUsers();
	
	/**
	 * Returns all Users From the database and update the Users into database
	 * @return
	 */
	public void editUser(User user);
	
	/**
	 * Returns 
	 * @return
	 */
	public void editPassword(int id,String newPassword, String oldPassword) throws TamsException;

	
}
