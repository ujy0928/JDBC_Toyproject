package edu.kh.studentList.service;

import java.util.List;

import edu.kh.studentList.dto.Student;

public interface StudentListServlet {

	/** 학생 전체 리스트 조회
	 * @throws Exception
	 */
	List<Student> studentListFullView() throws Exception;

	/** 학생 세부 조회
	 * @param stdNo
	 * @return
	 * @throws Exception
	 */
	Student studentDetail(int stdNo) throws Exception;

	/** 학생 세부내용 수정
	 * @param std
	 * @return
	 * @throws Exception
	 */
	int studentUpdate(Student std) throws Exception;

}
