package kr.or.ddit.file.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize = 1024*1024*5*5)
@WebServlet("/fileUpload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/fileupload/fileUpload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//일반 text 파라미터 : request.getParameter("파라미터명");
		//파일 : request.getPart("파라미터명");
		
		System.out.println("contentType : " +request.getContentType());
		System.out.println("userId : " + request.getParameter("userId"));
		
		//profile part
		Part profilePart = request.getPart("profile");
		System.out.println("profile part: " + profilePart.getContentType());
		
		//Content-disposition 헤더 정보
		//파일과 관련된 부가정보
		System.out.println("Content-disposition: " + profilePart.getHeader("Content-disposition"));
		
		String contentDisposition = 
				profilePart.getHeader("Content-disposition");
		
		String[] array = contentDisposition.split("; ");
		String fileName = "";
		
		for(String str : array) {
			if(str.indexOf("filename=")>=0){
				System.out.println(str.substring(10,str.lastIndexOf("\"")));
				fileName = str.substring(10,str.lastIndexOf("\""));
			}
		}
		// 파일쓰기
		profilePart.write("D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" + fileName);
//							new String(fileName.getBytes(),"utf-8"));
		profilePart.delete(); //파일 업로드 과정에서 사용한 디스크 임시 영역을 정리
		
	}
}
