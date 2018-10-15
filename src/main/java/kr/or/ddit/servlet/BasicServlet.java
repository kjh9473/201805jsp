package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* BasicServlet.java
*
* @author pc25
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* pc25 최초 생성
*
* 현재 시간을 출력하는 html 생성하는 서블릿
* </pre>
*/
public class BasicServlet extends HttpServlet{
	
	// 요청 http 메소드에 따라 실행되는 메소드가 달라진다
	// get : doGetm 
	// post : doPost
	
	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	
	@Override
	public void destroy() {
		System.out.println("destory");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//HttpServletRequest : 요청에 대한 정보
		//HttpServletResponse : 응답에 대한 정보
		resp.setContentType("text/html; charset=utf-8"); 
		
		PrintWriter pw = resp.getWriter();
		
		//date format을 이용하여
		//년-월-일 만 화면에 출력
		//simpleDateFormat
		Date date = new Date();
		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//		pw.println("hello, world");
//		pw.print(sdate.format(date));
		
		
		pw.println("<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("		<head>");
		pw.println("			<meta charset=\"UTF-8\">");
		pw.println("			<title>Insert title here</title>");
	
		pw.println("		</head>");
		pw.println("		<body>");
		pw.println("		hello,world");
		pw.println("		<br>"+sdate.format(date));
		pw.println("		</body>");
		pw.println("	</html>");
		
		pw.flush();
		pw.close();
	}
	

	// 정적 자료 : index.html --> url
	// 동적 자료 : servlet --> url mapping 구성 필요 : web.xml
	
}
