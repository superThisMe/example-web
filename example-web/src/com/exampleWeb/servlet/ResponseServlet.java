package com.exampleWeb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/05.move-to-result.action")
public class ResponseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 요청 데이터 읽기
		// 2. 데이터 처리
		req.setAttribute("req-data", "DATA FROM SERVLET"); // JSP에서 데이터를 읽을 수 있도록 request객체에 저장
		
		// 3. 응답 컨텐츠 만들기
		RequestDispatcher rd = req.getRequestDispatcher("05.result.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
