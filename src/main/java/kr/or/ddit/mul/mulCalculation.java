package kr.or.ddit.mul;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mulCalculation")
public class mulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param1 = Integer.parseInt(request.getParameter("param1"));
		int param2 = Integer.parseInt(request.getParameter("param2"));
		
		int mulResult = 1;
		
		System.out.println(param1 * param2 + " 파마리터 곱한 값");
		
		
		if(param1 < param2){
			for (int i = param1; i <= param2; i++) {
				mulResult = i * mulResult;
			}
		}else{
			for (int i = param2; i <= param1; i++) {
				mulResult = i * mulResult;
			}
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("mulResult",mulResult);
		
		RequestDispatcher rd = request.getRequestDispatcher("/mul/mulResult.jsp");
		rd.forward(request, response);
		
	}

}
