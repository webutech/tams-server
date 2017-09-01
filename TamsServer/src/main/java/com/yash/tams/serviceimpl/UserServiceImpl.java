package com.yash.tams.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tams.dao.UserDao;
import com.yash.tams.exception.TamsException;
import com.yash.tams.model.User;
import com.yash.tams.service.UserService;

/**
 * Implementation of the User Service Layer. Access the Dao Layer and business
 * Logic Goes Here
 * 
 * @author Brian Sutton
 *
 */
@Service
public class UserServiceImpl implements UserService {
	/**
	 * User Dao Implementation to access the database
	 */
	@Autowired
	UserDao userDao;

	@Override
	public List<User> getUsers() {
		try {
			return userDao.getUsers();
		} catch (TamsException e) {
			return null;
		}
	}

	@Override
	public void editUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void editPassword(int id, String newPassword, String oldPassword) throws TamsException {
		userDao.updatePassword(id, newPassword, oldPassword);

	}

	@Override
	public boolean registerUser(User user) {
		try {
			return userDao.insertUser(user);
		} catch (TamsException e) {
			return false;
		}

	}

	@Override
	public User authenticateUser(String login, String password) {
		try {
			User user = new User();
			user = userDao.authenticateUser(login, password);
			if (user != null) {

				return user;
			}
		} catch (TamsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public void resetPassword(String username, String password) {
		userDao.resetPassword(username, password);

	}

	@Override
	public Boolean updateUserStatus(String username, int status) throws SQLException {
		return userDao.updateUserStatus(username, status);
	}

	@Override
	public Boolean updateBatchStatus(String batchName, int status) throws SQLException {
		return userDao.updateBatchStatus(batchName, status);
	}

}
