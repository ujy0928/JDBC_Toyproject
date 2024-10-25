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
	// 필드 
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs = null;
	
	private Properties prop; 
	
	// 메서드
	public StudentListDAOImpl() {
		try {
			
			// resources에 있는 sql 파일 경로 로드 
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

			// 학생 정보 리스트 생성
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
			
			// 학생 세부정보 객체에 할당
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

	@Override
	public int studentUpdate(Connection conn, Student std) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("studentUpdate");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, std.getStdName());
			pstmt.setInt(2, std.getStdAge());
			pstmt.setString(3, std.getStdGender());
			pstmt.setString(4, std.getStdScore());
			pstmt.setInt(5, std.getStdNo());
			
			// 수정된 student객체를 업데이트 
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	@Override
	public int studentDelete(Connection conn, int stdNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("studentDelete");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stdNo);
			
			// 학생 번호로 학생 정보 삭제
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	@Override
	public int studentAdd(Connection conn, Student student) throws Exception {
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("studentAdd");
			
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, student.getStdNo());
			pstmt.setString(1, student.getStdName());
			pstmt.setInt(2, student.getStdAge());
			pstmt.setString(3, student.getStdGender());
			pstmt.setString(4, student.getStdScore());
			
			// 추가 학생 정보 삽입
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}






