package com.yash.tams.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yash.tams.dao.UserDao;
import com.yash.tams.exception.TamsException;
import com.yash.tams.model.User;
import com.yash.tams.rowmapper.UserRowMapper;
/**
 * The User Dao Implementations will be added here
 * For proper usage see this site 
 * https://github.com/webutech/Java_Track/blob/master/SpringWS/SpringJDBC_JDBCTemplate_Ver5/src/com/yash/jdbcapp/daoimpl/EmployeeDaoImpl.java
 * @author Brian Sutton
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(this.dataSource);
	}
	
	@Override
	public List<User> getUsers() throws TamsException {
		try{
		return jdbcTemplate.query("select * from users", new UserRowMapper());
		}catch (Exception e) {
			e.printStackTrace();
			throw new TamsException(e.getMessage());
		}
	}

	@Override
	public void updateUser(User user) {
		 String sql="UPDATE users SET firstname = ?, lastname = ?, email = ?, contact = ? WHERE id = ?";
		 System.out.println(user.getId());
		jdbcTemplate.update(sql, new Object[]{user.getFirstName(),user.getLastName(),user.getEmail(),user.getContact(),user.getId()});
		System.out.println("Success :  User " + user.getFirstName() + " was updated!");
		
	}
	
	@Override
	public void updatePassword(int id,String newPassword, String oldPassword) throws TamsException {		
		try{
		String sql="UPDATE users SET password = ? WHERE id = ? and password = ?";
		jdbcTemplate.update(sql, new Object[]{newPassword,id,oldPassword});
		}catch(Exception e){
			throw new TamsException(e.getMessage());
		}
	}
	
}
