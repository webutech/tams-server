package com.yash.tams.serviceimpl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tams.dao.UserDao;
import com.yash.tams.exception.TamsException;
import com.yash.tams.model.User;
import com.yash.tams.service.UserService;

/**
 * Implementation of the User Service Layer.
 * Access the Dao Layer and business Logic Goes Here
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
		try{
		return userDao.getUsers();
		}catch (TamsException e) {
			return null;
		}
	}

}
