package com.exampleWeb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request-param.action")
public class RequestParamServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// HttpServletRequest 전달인자에 요청과 관련된 모든 정보가 저장되어 있음
		String name = req.getParameter("name");
		String email = req.getParameter("email");

		System.out.println("NAME : " + name + " / EMAIL : " + email);

		// 응답 컨텐츠의 종류와 문자셋 지정
		resp.setContentType("text/plain; charset=UTF-8");

		PrintWriter out = resp.getWriter();
		out.println("NAME : " + name + " / EMAIL : " + email);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8"); // post 요청인 경우 데이터를 읽기 전에 encoding 지정해야 함
		
		// HttpServletRequest 전달인자에 요청과 관련된 모든 정보가 저장되어 있음
		String name = req.getParameter("name");
		String email = req.getParameter("email");

		System.out.println("NAME : " + name + " / EMAIL : " + email);

		// 응답 컨텐츠의 종류와 문자셋 지정 (한글과 같은 비ASCII 문자를 응답하려면 반드시 지정)
		resp.setContentType("text/plain; charset=UTF-8");

		PrintWriter out = resp.getWriter();
		out.println("NAME : " + name + " / EMAIL : " + email);

	}

}
