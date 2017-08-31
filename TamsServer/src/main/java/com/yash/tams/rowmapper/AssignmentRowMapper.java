package com.yash.tams.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.tams.model.Assignment;
/**
 * This is the row mapper class for the assignments
 * @author Brian Sutton
 *
 */
public class AssignmentRowMapper implements RowMapper<Assignment>{

	@Override
	public Assignment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Assignment assignment=new Assignment();
		assignment.setId(resultSet.getInt("id"));
		assignment.setName(resultSet.getString("name"));
		assignment.setBatchid(resultSet.getInt("batchid"));
		assignment.setCreatedBy(resultSet.getInt("createdBy"));
		assignment.setDescription(resultSet.getString("description"));
		assignment.setDueDate(resultSet.getDate("dueDate"));
		assignment.setUserid(resultSet.getInt("userid"));
		assignment.setCreatedDate(resultSet.getDate("createdDate"));
		assignment.setModifiedBy(resultSet.getInt("modifiedBy"));
		assignment.setModifiedDate(resultSet.getDate("modifiedDate"));
		
		return assignment;
	}
	
}
