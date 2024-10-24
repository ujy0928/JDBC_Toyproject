package edu.kh.studentList.dao;

import java.sql.Connection;
import java.util.List;

import edu.kh.studentList.dto.Student;

public interface StudentListDAO {

	/** 전체 학생 리스트 조회
	 * @param conn
	 * @return
	 */
	List<Student> studentListFullView(Connection conn) throws Exception;

	Student studentDetail(Connection conn, int stdNo) throws Exception;

}
