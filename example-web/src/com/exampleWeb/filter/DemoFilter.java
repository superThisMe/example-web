package com.exampleWeb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
						 FilterChain chain) // 다음 처리기 호출 도구
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		System.out.println("FILTER : " + req.getRequestURI());
		
		if (req.getRequestURI().contains("01")) {
			HttpServletResponse resp = (HttpServletResponse)response;
			resp.sendRedirect("index.html");
		} else {
		chain.doFilter(request, response);
		}
		
	}

}
