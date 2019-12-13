package com.exampleWeb.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download.action")
public class DownloadServlet extends HttpServlet { // 호출 규약 구현

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		String fileName = "index.html";
		String fileName = req.getParameter("file");
		if (fileName == null || fileName.length() == 0) {
			resp.sendRedirect("07.file-list.jsp");
			return;
		}
		
		// ServletContext : JSP의 application객체와 동일한 객체
		ServletContext application = req.getServletContext();
		String path = application.getRealPath("/upload-files/" + fileName);
		
		System.out.println(fileName);

		// 브라우저가 응답 컨텐츠를 다운로드로 처리하도록 정보 설정
		resp.setContentType("application/octet-stream;charset=utf-8");
		
		// 브라우저에게 다운로드하는 파일의 이름을 알려주는 코드
		resp.addHeader("Content-Disposition", 
//				"Attachment;filename=\"" + fileName + "\""); // firefox에서 filename에 space가 있어도 처리하도록 ""로 묶기
				"Attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\""); // UTF-8 string을 ISO-8859-1로 변환

		FileInputStream fis = new FileInputStream(path); // 파일을 읽는 도구
		OutputStream fos = resp.getOutputStream(); // 브라우저에게 전송하는 도구

		while (true) {
			int data = fis.read(); // 파일에서 1byte 읽기
			if (data == -1) { // 더 이상 읽을 데이터가 없다면 (EOF)
				break;
			}
			fos.write(data); // 응답 스트림에 1byte 쓰기
		}

		fis.close();
		fos.close();

	}

}
