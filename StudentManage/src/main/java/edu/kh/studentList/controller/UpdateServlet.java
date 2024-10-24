package edu.kh.studentList.controller;

import java.io.IOException;

import edu.kh.studentList.dto.Student;
import edu.kh.studentList.service.StudentListServlet;
import edu.kh.studentList.service.StudentListServletImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/std/update")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			int stdNo = Integer.parseInt(req.getParameter("stdNo"));
			
			StudentListServlet service = new StudentListServletImpl();
			
			Student student = service.studentDetail(stdNo);
			
			if(student == null) {
				// 메인페이지로 redirect
				resp.sendRedirect("/");
				return;
			}
			
			// request scope에 todo 객체 세팅
			req.setAttribute("std", student);
			
			// 요청발송자를 통해 forward
			String path = "/WEB-INF/views/update.jsp";
			req.getRequestDispatcher(path).forward(req, resp); // 요청 위임
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
