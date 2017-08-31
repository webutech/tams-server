package com.yash.tams.dao;

import java.util.List;

import com.yash.tams.exception.TamsException;
import com.yash.tams.model.User;

/**
 * This is the Interface for the User Dao
 * @author Brian Sutton
 *
 */
public interface UserDao {

	/**
	 * Returns a List of all users in the database
	 * Or returns null if there is an error fetching from the database
	 * @return
	 */
	public List<User> getUsers() throws TamsException;
	
	/**
	 * Returns users from the database
	 * Or returns null if there is an error fetching from the database
	 * @return
	 */
	public void updateUser(User user);
	
	/**
	 * Returns user password from the database
	 * Or returns null if there is an error fetching from the database
	 * @return
	 */
	public void updatePassword(int id,String newPassword, String oldPassword) throws TamsException;
	
	
	
}
