package edu.kh.studentList.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.studentList.dto.Student;

import static edu.kh.studentList.common.JDBCTemplate.*;

public class StudentListDAOImpl implements StudentListDAO{
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs = null;
	
	private Properties prop;
	
	
	public StudentListDAOImpl() {
		try {
			
			String filePath = StudentListDAOImpl.class.
					getResource("/xml/sql.xml").getPath();
			
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch(Exception e) {
			System.out.println("sql.xml 로드 중 예외발생");
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> studentListFullView(Connection conn) throws Exception {
		
		List<Student> stdList = new ArrayList<Student>();

		try {
			String sql = prop.getProperty("studentListFullView");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				
				Student student = Student.builder()
						.stdNo(rs.getInt("STD_NO"))
						.stdName(rs.getString("STD_NAME"))
						.stdAge(rs.getInt("STD_AGE"))
						.stdGender(rs.getString("STD_GENDER"))
						.stdScore(rs.getString("STD_SCORE"))
						.build();
				
				stdList.add(student);
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		
		return stdList;
	}

	@Override
	public Student studentDetail(Connection conn, int stdNo) throws Exception {
		
		Student student = null;
		
		try {
			String sql = prop.getProperty("studentDetail");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stdNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				student = Student.builder()
						.stdNo(rs.getInt("STD_NO"))
						.stdName(rs.getString("STD_NAME"))
						.stdAge(rs.getInt("STD_AGE"))
						.stdGender(rs.getString("STD_GENDER"))
						.stdScore(rs.getString("STD_SCORE"))
						.build();
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return student;
	}
}