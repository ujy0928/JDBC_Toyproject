package edu.kh.studentList.service;

import static edu.kh.studentList.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.studentList.dao.StudentListDAO;
import edu.kh.studentList.dao.StudentListDAOImpl;
import edu.kh.studentList.dto.Student;

public class StudentListServletImpl implements StudentListServlet{
	
	private StudentListDAO dao = new StudentListDAOImpl();

	@Override
	public List<Student> studentListFullView() throws Exception {
		Connection conn = getConnection();
		
		List<Student> stdList = dao.studentListFullView(conn);
		
		close(conn);
		
		return stdList;
	}

	@Override
	public Student studentDetail(int stdNo) throws Exception {
		
		Connection conn = getConnection();
		
		Student student = dao.studentDetail(conn, stdNo);
		
		return student;
	}
	
	
}
