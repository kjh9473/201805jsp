package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVO;

public class LoginCheckFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		String uri = ((HttpServletRequest)request).getRequestURI();
		
		System.out.println("uri : " + uri);
		 
		HttpSession session = ((HttpServletRequest)request).getSession();
		UserVO userVo = (UserVO) session.getAttribute("S_USER");
		
		if(uri.equals("/") || uri.equals("/login/login.jsp") || uri.equals("/dditLogin") ||uri.startsWith("js")||uri.startsWith("css")){
			
			chain.doFilter(request, response);
			
		}else{
			if(session.getAttribute("S_USER")==null){
				request.getRequestDispatcher("/").forward(request, response);
			}else{
				chain.doFilter(request, response);
			}
			
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
