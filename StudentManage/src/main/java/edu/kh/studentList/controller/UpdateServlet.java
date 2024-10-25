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

@WebServlet("/std/update")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			int stdNo = Integer.parseInt(req.getParameter("stdNo")); // 학생 번호
			
			StudentListService service = new StudentListServiceImpl();
			
			// 학생 세부 정보 로드
			Student student = service.studentDetail(stdNo);
			
			if(student == null) {
				// 조회 실페시 메인페이지로 redirect
				resp.sendRedirect("/");
				return;
			}
			
			// request scope에 std 객체 세팅
			req.setAttribute("std", student);
			
			// 요청발송자를 통해 forward
			String path = "/WEB-INF/views/update.jsp";
			req.getRequestDispatcher(path).forward(req, resp); // 요청 위임
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int stdNo = Integer.parseInt(req.getParameter("stdNo")); // 학생 번호
			String stdName = req.getParameter("stdName"); // 학생 이름
			int stdAge = Integer.parseInt(req.getParameter("stdAge")); // 학생 나이
			String stdGender = req.getParameter("stdGender"); // 학생 성별
			String stdScore = req.getParameter("stdScore"); // 학생 점수
			
			StudentListService service = new StudentListServiceImpl();
			
			// 학생 정보 update를 위해 전달 할 student 객체 생성
			Student std = new Student(stdNo, stdName, stdAge, stdGender, stdScore);
			
			int result = service.studentUpdate(std);
			String message = null;
			String url = null;

			// 수정 성공 시 메인페이지로, 실패 시 수정 화면으로 이동
			if(result > 0) {
				url = "/";
				message = "수정 성공!!";
			} else {
				url = "/std/update?stdNo=" + stdNo;
				message = "수정 실패..";
			}
			HttpSession session = req.getSession();
			session.setAttribute("message", message);
			
			resp.sendRedirect(url);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
