package edu.kh.studentList.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.studentList.dto.Student;
import edu.kh.studentList.service.StudentListService;
import edu.kh.studentList.service.StudentListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentListService service = new StudentListServiceImpl();
		
		try {
			// 전체 학생 리스트 로드
			List<Student> StdList = service.studentListFullView();
			
			// 학생 리스트 request scope에 셋
			req.setAttribute("stdList", StdList);
			
			// 메인 페이지로 이동
			req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
