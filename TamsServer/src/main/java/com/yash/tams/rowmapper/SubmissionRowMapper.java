package com.yash.tams.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.yash.tams.model.Submission;
import com.yash.tams.wrapper.SubmissionWrapper;

public final class SubmissionRowMapper implements RowMapper<SubmissionWrapper> {

	/**
	 * Sets the fields of the Submission Object for each row that is returned from the database
	 */
	
	@Override
	public SubmissionWrapper mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		SubmissionWrapper sw=new SubmissionWrapper();
		sw.setId(resultSet.getInt("id"));
		sw.setAssignmentName(resultSet.getString("assignmentName"));
		sw.setTraineeName(resultSet.getString("traineeName"));
		sw.setRemarks(resultSet.getString("remarks"));
		sw.setDateOfSubmission(resultSet.getDate("dateofsubmission"));
		sw.setStatus(resultSet.getString("status"));
		return sw;
	}
	
	
	
	
}