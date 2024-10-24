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

	/** 학생 세부내용 조회
	 * @param conn
	 * @param stdNo
	 * @return
	 * @throws Exception
	 */
	Student studentDetail(Connection conn, int stdNo) throws Exception;

	/** 학생 세부내용 수정
	 * @param conn
	 * @param std
	 * @return
	 */
	int studentUpdate(Connection conn, Student std) throws Exception;

}
