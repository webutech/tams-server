package com.yash.tams.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tams.dao.AssignmentDao;
import com.yash.tams.exception.TamsException;
import com.yash.tams.model.Assignment;
import com.yash.tams.service.AssignmentService;

@Service
public class AssignmentServiceImpl implements AssignmentService {
	@Autowired
	AssignmentDao assignmentDao;

	@Override
	public List<Assignment> getAssignments() {

		try {
			return assignmentDao.getAssignments();
		} catch (TamsException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addAssignment(Assignment assignment) {
		try {
			return assignmentDao.addAssignment(assignment);
		} catch (TamsException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateAssignment(Assignment assignment) {
		try {
			return assignmentDao.updateAssignment(assignment);
		} catch (TamsException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteAssignment(int id) {
		try {
			return assignmentDao.deleteAssignment(id);
		} catch (TamsException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Assignment getAssignmentById(int id) {
		try {
			return assignmentDao.getAssignmentById(id);
		} catch (TamsException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int assignAssignmentToBatch(int id, int batchId) {
		try {
			return assignmentDao.addAssignmentToBatch(id, batchId);
		} catch (TamsException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int assignAssignmentToUser(int id, int UserId) {
		try {
			return assignmentDao.addAssignmentToUser(id, UserId);
		} catch (TamsException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
