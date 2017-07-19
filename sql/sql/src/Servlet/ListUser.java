package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;
import service.UserService;
import service.UserServiceImpl;

public class ListUser extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserServiceImpl();
		List<User> users = service.getUsers();
		request.setAttribute("users", users);
//		System.out.println(users.size()+"---------");
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}

}
