package edu.kh.studentList.controller;

import java.io.IOException;

import edu.kh.studentList.service.StudentListService;
import edu.kh.studentList.service.StudentListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/std/delete")
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int stdNo = Integer.parseInt(req.getParameter("stdNo")); // 학생 번호
		int result = 0;  
		
		try {
			StudentListService service = new StudentListServiceImpl();
			
			result = service.studentDelete(stdNo);
			
			String message = null;
			String url = null;
			
			// 성공 시 메인페이지로, 실패 시 상세조회 화면으로 이동
			if(result > 0) {
				message = "삭제 성공!!";
				url = "/";
			} else {
				message = "삭제 실패..";
				url = "/std/detail?stdNo=" + stdNo;
			}
			
			req.getSession().setAttribute("message", message);
			
			resp.sendRedirect(url);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
