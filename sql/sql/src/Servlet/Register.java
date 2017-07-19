package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;
import service.UserService;
import service.UserServiceImpl;

public class Register extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println(address+"-------serviceaddress");
		User user = new User(name, password, address, age);
		UserService service = new UserServiceImpl();
		int add = service.getLoginUser(user);
	
		if(add>0){
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/ListUser");
		}else{
			String mess = "注册失败";
			request.setAttribute("mess", mess);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}
	

}
