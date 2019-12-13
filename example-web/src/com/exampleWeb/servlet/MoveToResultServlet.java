package com.exampleWeb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/response.action")
public class MoveToResultServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 요청 데이터 읽기
		// 2. 데이터 처리
		// 3. 응답 컨텐츠 만들기 (HTML 만들기)
		
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter(); // 응답 컨텐츠를 전송하는 통로
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>HTML from Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>" + Math.random() + "</h2>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
