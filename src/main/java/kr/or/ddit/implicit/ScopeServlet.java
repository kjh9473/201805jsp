package kr.or.ddit.implicit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/scopeServlet")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageScope = request.getParameter("pageScope");
		String requestScope = request.getParameter("requestScope");
		String sessionScope = request.getParameter("sessionScope");
		String applicationScope = request.getParameter("applicationScope");
		
		// 					 jsp / servlet
		
		//page      		page /    x
		//request	 	 request /  request
		//session	 	 session / request.getSession()
		//application application/ getServletContext()
		
		//속성 설정 : setAttribute(String name, Object value);
		//속성 획득 : getAttribut(String name);
		
		//page 영역 : servlet에 해당 scope 없음
		//reques 영역 
		request.setAttribute("requestScope",requestScope + "_attribute");
		
		//session 영역
		HttpSession session = request.getSession();
		session.setAttribute("sessionScope",sessionScope + "_attribute");
		
		//application 영역
		ServletContext application =  request.getServletContext();
		application.setAttribute("applicationScope",applicationScope + "_attribute");
		
		//forward로 위임(scopeResult.jsp)
		RequestDispatcher rd = request.getRequestDispatcher("/implicit/scopeResult.jsp");
		rd.forward(request, response);
		
		
		
	}

}
