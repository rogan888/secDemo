package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;

import dao.BaseDao;
import dao.user.UserDao;
import dao.user.UserDaoImpl;
import pojo.User;
import service.UserService;
import service.UserServiceImpl;

public class Login extends HttpServlet {

private User user;
private UserService service;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		request.getSession().setAttribute("user", name);
		String password = request.getParameter("password");
		User user = new User(name,password);
		user.setName(name);
		user.setPassword(password);
		UserService service = new UserServiceImpl();
		User loginUser = service.getLoginUser(user);//测试
		String mess ="";
		boolean flag = false;
		if(loginUser!=null){
			mess = "登录成功";
			flag = true;
			request.getSession().setAttribute("user", loginUser);
		}else{
			mess = "登录失败";
		}
		List<Object> list = new ArrayList<Object>(); 
		list.add(mess);
		list.add(flag);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(JSONArray.toJSONString(list));
		
	}

	public void test(){
	
	User user = new User(name,password);
		user.setName(name);
		user.setPassword(password);
		UserService service = new UserServiceImpl();
		User loginUser = service.getLoginUser(user);//测试
	}

}
