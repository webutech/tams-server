package com.yash.tams.service;

import java.sql.SQLException;
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

	/**
	 * Sends User user to userDao and returns true if user was inserted, else
	 * returns false because user login name is already in database
	 * @param user
	 * @return
	 */
	public boolean registerUser(User user);
	
	public User authenticateUser(String login, String password);
	
	public void resetPassword(String username, String password);

	public Boolean updateUserStatus(String username, int status) throws SQLException;
	
	public Boolean updateBatchStatus(String batchName, int status) throws SQLException;
}
