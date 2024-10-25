package edu.kh.studentList.controller;

import java.io.IOException;

import edu.kh.studentList.dto.Student;
import edu.kh.studentList.service.StudentListService;
import edu.kh.studentList.service.StudentListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/std/add")
public class AddServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/add.jsp"; // 추가 화면 페이지로 이동
		
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//int stdNo = Integer.parseInt(req.getParameter("stdNo"));
		String stdName = req.getParameter("stdName"); // 학생 이름
		int stdAge = Integer.parseInt(req.getParameter("stdAge")); // 학생 나이
		String stdGender = req.getParameter("stdGender");// 학생 성별
		String stdScore = req.getParameter("stdScore"); // 학생 점수
		
		try {
			// 전달인자 생성
			Student student = new Student();
			student.setStdName(stdName);
			student.setStdAge(stdAge);
			student.setStdGender(stdGender);
			student.setStdScore(stdScore);
			
			StudentListService service = new StudentListServiceImpl();
			
			int result = service.studentAdd(student);
			
			String url = null;
			String message = null;
			
			// 추가 성공 시 메인페이지로, 실패 시 추가 화면으로 이동
			if(result > 0) {
				url = "/";
				message = "추가 성공!!";
			} else {
				url = "/std/add";
				message = "추가 실패..";
			}
			HttpSession session = req.getSession();
			session.setAttribute("message", message);
			
			resp.sendRedirect(url);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
