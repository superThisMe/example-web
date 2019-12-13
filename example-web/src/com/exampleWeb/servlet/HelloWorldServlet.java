package com.exampleWeb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// get 요청을 처리하는 약속된 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello, Servlet Programming World !!!!!</h1>"); //브라우저에 응답
		out.println("<h2>" + new Date().toString() + "</h2>");
		out.println("</body>");
		out.println("</html>");
		
	}

	//post 요청을 처리하는 약속된 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}









