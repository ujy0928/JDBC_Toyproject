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

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentListServlet service = new StudentListServletImpl();
		
		try {

			List<Student> StdList = service.studentListFullView();
			
			req.setAttribute("stdList", StdList);
			
			req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
