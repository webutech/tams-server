package com.yash.tams.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yash.tams.dao.AssignmentDao;
import com.yash.tams.exception.TamsException;
import com.yash.tams.model.Assignment;
import com.yash.tams.rowmapper.AssignmentRowMapper;

/**
 * This is the daoImpl for the asignments
 * 
 * @author Brian Sutton
 *
 */
@Repository
public class AssignmentDaoImpl implements AssignmentDao {
	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

	@Override
	public List<Assignment> getAssignments() throws TamsException {
		try {
			return jdbcTemplate.query("select * from assignments", new AssignmentRowMapper());
		} catch (Exception e) {
			throw new TamsException(e.getMessage());
		}
	}

	@Override
	public int deleteAssignment(int id) throws TamsException {
		String sql = "delete from assignments where id = ?";
		try {
			return jdbcTemplate.update(sql, id);
		} catch (Exception e) {
			throw new TamsException(e.getMessage());
		}
	}

	@Override
	public int updateAssignment(Assignment assignment) throws TamsException {
		String sql = "update assignments set name = ? where  id = ?";
		try {
			return jdbcTemplate.update(sql, new Object[] { assignment.getName(), assignment.getId() });
		} catch (Exception e) {
			throw new TamsException(e.getMessage());
		}
	}

	@Override
	public int addAssignment(Assignment assignment) throws TamsException {
		String sql = "insert into assignments (name) value(?)";
		try {
			return jdbcTemplate.update(sql, new Object[] { assignment.getName() });
		} catch (Exception e) {
			throw new TamsException(e.getMessage());
		}

	}

	@Override
	public Assignment getAssignmentById(int id) throws TamsException {
		String sql = "select * from assignments where id = ?";
		try {
			System.out.println(id);
			List assignment = jdbcTemplate.query(sql, new Object[] { id }, new AssignmentRowMapper());
			return (Assignment) assignment.get(0);
		} catch (Exception e) {
			throw new TamsException(e.getMessage());
		}
	}

	@Override
	public int addAssignmentToBatch(int assignmentId, int batchId) throws TamsException {
		try {
			String sql = "update assignments set batchid = ? where  id = ?";
			return jdbcTemplate.update(sql, batchId, assignmentId);
		} catch (Exception e) {
			throw new TamsException(e.getMessage());
		}
	}

	@Override
	public int addAssignmentToUser(int assignmentId, int userId) throws TamsException {
		try {
			String sql = "update assignments set userid = ? where  id = ?";
			
			return jdbcTemplate.update(sql, userId, assignmentId);
		} catch (Exception e) {
			throw new TamsException(e.getMessage());
		}
	}

}
