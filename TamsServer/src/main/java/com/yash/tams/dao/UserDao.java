package com.yash.tams.dao;

import java.sql.SQLException;
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
	
	/**
	 * Inserts new user into database if user login name is not found and returns true,
	 * else returns false
	 * @param user
	 * @return
	 */
	public boolean insertUser(User user) throws TamsException;
	
	/**
	 * Returns true if user login name is found, else returns false
	 * @param loginName
	 * @return
	 */
	public boolean findUserByUserName(String userName);
	
	
	public User authenticateUser(String login, String password) throws TamsException;
	
	/**
	 * Resetting the user password
	 * @param 
	 * @return
	 */
	public void resetPassword(String userName, String password);
	

	/**
	 * Updating the status of the user
	 * @param 
	 * @return
	 */

	public Boolean updateUserStatus(String username, int status) throws SQLException;

	/**
	 * Updating the batch Status
	 * @param 
	 * @return
	 */
	public Boolean updateBatchStatus(String batchName, int status) throws SQLException;
}
