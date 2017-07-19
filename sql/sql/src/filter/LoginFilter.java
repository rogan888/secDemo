package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("filter----------");
		response.setHeader( "Pragma", "no-cache" );
	    response.setDateHeader("Expires", 0);
		response.addHeader( "Cache-Control", "no-cache" );
		response.addHeader( "Cache-Control", "no-store" );
		response.addHeader( "Cache-Control", "must-revalidate" );
		if(user!=null){
			arg2.doFilter(arg0, arg1);
		}else{
			response.getWriter().write("<script>alert('请登录！');window.location='"+request.getContextPath()+"/index.jsp'</script>");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
