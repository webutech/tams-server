package com.yash.tams.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yash.tams.dao.SubmissionDao;
import com.yash.tams.exception.TamsException;
import com.yash.tams.model.Submission;
import com.yash.tams.model.User;
import com.yash.tams.rowmapper.SubmissionRowMapper;
import com.yash.tams.rowmapper.UserRowMapper;
import com.yash.tams.wrapper.SubmissionWrapper;

@Repository
public class SubmissionDaoImpl implements SubmissionDao {
	
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
	public List<SubmissionWrapper> getSubmissionsByAllTrainees(int trainerid) throws TamsException{
		List<SubmissionWrapper> sw=new ArrayList<SubmissionWrapper>();
		String sql="select s.id id, " + 
				"a.name assignmentName, " + 
				"u.firstname traineeName, " + 
				"s.remarks, " + 
				"s.dateofsubmission, " + 
				"s.status status " + 
				"from " + 
				"submissions s join assignments a on s.assignmentid=a.id " + 
				"join users u on s.userid=u.id " + 
				"and a.createdBy="+trainerid;
		System.out.println("sql-> "+sql);
		try {
			sw=jdbcTemplate.query(sql, new SubmissionRowMapper());
		}catch(Exception e) {
			e.printStackTrace();
			throw new TamsException(e.getMessage());
		}
		return sw;
	}

	@Override
	public List<SubmissionWrapper> getTraineeSubmissions(int traineeid) throws TamsException {
		List<SubmissionWrapper> sw=new ArrayList<SubmissionWrapper>();
		String sql="select s.id id, " + 
				"a.name assignmentName, " + 
				"u.firstname traineeName, " + 
				"s.remarks, " + 
				"s.dateofsubmission, " + 
				"s.status status " + 
				"from " + 
				"submissions s join assignments a on s.assignmentid=a.id " + 
				"join users u on s.userid=u.id " + 
				"and s.userid="+traineeid;
		System.out.println("sql-> "+sql);
		try {
			sw=jdbcTemplate.query(sql, new SubmissionRowMapper());
		}catch(Exception e) {
			e.printStackTrace();
			throw new TamsException(e.getMessage());
		}
		return sw;
	}

	@Override
	public void updateSubmissionStatus(int submissionid, String status) throws TamsException {
		String sql="update submissions set status='"+status+"' where id="+submissionid;
		System.out.println("sql-> "+sql);
		try {
			jdbcTemplate.update(sql);
		}catch(Exception e) {
			e.printStackTrace();
			throw new TamsException(e.getMessage());
		}
	}

	@Override
	public List<SubmissionWrapper> filterSubmission(int trainerid, String traineeName, String assignmentName) throws TamsException {
		List<SubmissionWrapper> sw=new ArrayList<SubmissionWrapper>();
		String sql="select s.id id, " + 
				"a.name assignmentName, " + 
				"u.firstname traineeName, " + 
				"s.remarks, " + 
				"s.dateofsubmission, " + 
				"s.status status " + 
				"from " + 
				"submissions s join assignments a on s.assignmentid=a.id " + 
				"join users u on s.userid=u.id " + 
				"and a.createdBy="+trainerid;
		if(traineeName!=null) {
			sql=sql+" and u.firstname='"+traineeName+"'";
		}
		if(assignmentName!=null) {
			sql=sql+" and a.name='"+assignmentName+"'";
		}
		System.out.println("sql-> "+sql);
		try {
			sw=jdbcTemplate.query(sql, new SubmissionRowMapper());
		}catch(Exception e) {
			e.printStackTrace();
			throw new TamsException(e.getMessage());
		}
		return sw;
		
	}
	
	
}
