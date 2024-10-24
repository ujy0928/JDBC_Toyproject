package edu.kh.studentList.service;

import java.util.List;

import edu.kh.studentList.dto.Student;

public interface StudentListServlet {

	/** 학생 전체 리스트 조회
	 * @throws Exception
	 */
	List<Student> studentListFullView() throws Exception;

	Student studentDetail(int stdNo) throws Exception;

}
