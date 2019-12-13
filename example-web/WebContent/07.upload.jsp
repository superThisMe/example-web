<%@ page import="org.apache.commons.fileupload.FileItem"%>
<%@ page import="java.util.List"%>
<%@ page import="java.io.File"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"%>

<%
request.setCharacterEncoding("utf-8");

//파일 업로드를 포함한 요청인지 확인 (multipart/form-data 형식 확인)
if (ServletFileUpload.isMultipartContent(request) == false) {
	response.sendRedirect("07.upload-form.jsp");
	return;
}

//경로 문자열을 저장할 변수
//application.getRealPath('웹경로')
//--> 가상경로(웹경로) -> 물리경로(컴퓨터경로)
//--> http://..... -> C:/......
String path = application.getRealPath("/upload-files");		//최종 파일 저장 경로
String tempPath = application.getRealPath("/upload-temp");	//임시 파일 저장 경로

/* System.out.println(path);
System.out.println(tempPath); */

//전송 데이터 각 요소를 분리해서 개별 객체를 만들때 사용할 처리기
DiskFileItemFactory factory = new DiskFileItemFactory();
factory.setSizeThreshold(1024 * 1024 * 2);	//임시 파일을 만들지 결정하는 기준 설정
factory.setRepository(new File(tempPath));	//임시 파일 저장 경로 지정

//요청 정보를 읽을 파서(Parser) 생성 (요청을 읽고 요소별로 분리)
ServletFileUpload uploader = new ServletFileUpload(factory);
uploader.setFileSizeMax(1024 * 1024 * 10);//최대 파일 크기

//요청 정보를 파싱하고 개별 객체의 목록을 반환
List<FileItem> items = uploader.parseRequest(request);

////////////////////////////////////////////////////////////////////////////////

//목록에 담긴 데이터 사용
for (FileItem item : items) {
	if (item.isFormField()) { //form-data인 경우 (File이 아닌 일반 데이터인 경우)
		System.out.println("DATA " + item.getFieldName() + " : " 
								   + item.getString("utf-8"));
	} else { //file인 경우
		String fileName = item.getName(); //파일 이름 가져오기
		if (fileName != null && fileName.length() > 0) { //내용이 있는 경우
			if (fileName.contains("\\")) { // iexplore 경우
				//C:\AAA\BBB\CCC.png -> CCC.png 
				fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
			}
			item.write(new File(path, fileName)); //파일 저장
			item.delete(); //임시 파일 삭제
		}
	}
}

response.sendRedirect("07.file-list.jsp");

%>








