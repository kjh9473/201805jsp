package kr.or.ddit.sum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//기존 view 요청 get : localhost:8081/sum/suminput.jsp
		//변경 view 요청 get :  localhost:8081/kr/co/ddit/sum/sumCalculation
		//sumInput.jsp forward
		RequestDispatcher rb = request.getRequestDispatcher("/sum/suminput.jsp");
		rb.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		System.out.println("start : " + start + "end :" + end);
		
		
		CalculationLogic logic = new CalculationLogic();
		int result = logic.sumBetweenTwoNumbers(start,end);
		
		
		
		HttpSession session = request.getSession();
		
		session.setAttribute("result",result);
		
		RequestDispatcher rd = request.getRequestDispatcher("/sum/sumResult.jsp");
		rd.forward(request, response);
	}

}
