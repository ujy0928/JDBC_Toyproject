package edu.kh.studentList.service;

import static edu.kh.studentList.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.studentList.dao.StudentListDAO;
import edu.kh.studentList.dao.StudentListDAOImpl;
import edu.kh.studentList.dto.Student;

public class StudentListServiceImpl implements StudentListService{
	// 필드
	private StudentListDAO dao = new StudentListDAOImpl();

	// 메서드
	@Override
	public List<Student> studentListFullView() throws Exception {
		Connection conn = getConnection(); // 커넥션 객체 생성
		
		// 전체 학생 리스트 생성
		List<Student> stdList = dao.studentListFullView(conn);
		
		close(conn); // 커넥션 객체 반환
		
		return stdList;
	}

	@Override
	public Student studentDetail(int stdNo) throws Exception {
		
		Connection conn = getConnection();
		
		// 학생 정보 생성
		Student student = dao.studentDetail(conn, stdNo);
		
		close(conn); // 커넥션 객체 반환
		
		return student;
	}

	@Override
	public int studentUpdate(Student std) throws Exception {
		int result = 0;
		
		Connection conn = getConnection();
		
		// 학생 정보 업데이트
		result = dao.studentUpdate(conn, std);
		
		if(result > 0) commit(conn); // 트랜잭션 처리
		else			rollback(conn);
		
		close(conn); // 커넥션 객체 반환
		
		return result;
	}

	@Override
	public int studentDelete(int stdNo) throws Exception {
		Connection conn = getConnection();
		int result = 0;
		
		// 학생 정보 삭제
		result = dao.studentDelete(conn, stdNo);
		
		if(result > 0) commit(conn); // 트랜잭션 처리
		else 			rollback(conn);
		
		close(conn); // 커넥션 객체 반환
		
		
		return result;
	}

	@Override
	public int studentAdd(Student student) throws Exception {
		
		int result = 0;
		
		Connection conn = getConnection();
		
		// 학생 정보 추가
		result = dao.studentAdd(conn, student);
		
		if(result > 0) commit(conn); // 트랜잭션 처리
		else 			rollback(conn);
		
		close(conn); // 커넥션 객체 반환
		
		
		return result;
	}
	
	
}









