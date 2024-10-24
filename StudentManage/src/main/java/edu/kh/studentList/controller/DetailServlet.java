package edu.kh.studentList.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.studentList.dto.Student;
import edu.kh.studentList.service.StudentListServlet;
import edu.kh.studentList.service.StudentListServletImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/std/detail")
public class DetailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentListServlet service = new StudentListServletImpl();
		
		int stdNo = Integer.parseInt(req.getParameter("stdNo"));
		
		try {

			Student student = service.studentDetail(stdNo);
			
			req.setAttribute("std", student);
			
			req.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
