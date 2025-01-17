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

@WebServlet("/std/detail")
public class DetailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentListService service = new StudentListServiceImpl();
		
		int stdNo = Integer.parseInt(req.getParameter("stdNo")); // 학생 번호
		
		try {

			Student student = service.studentDetail(stdNo);
			
			req.setAttribute("std", student);
			
			// 학생 세부 정보 페이지로 이동
			req.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
