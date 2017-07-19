package service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.user.UserDao;
import dao.user.UserDaoImpl;
import pojo.User;

public class UserServiceImpl implements UserService {
	public UserDao dao = new UserDaoImpl();
	@Override
	public User getLoginUser(User user) {
		User user2 = null;
		UserDao dao = new UserDaoImpl();
		try {
			user2 = dao.getLoginUser(xxx, user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user2;
	}
	@Override
	public List<User> getUsers() {
		List<User> list = null;
		try {
			list = dao.getUsers(BaseDao.getConn());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int addUser (User user) {
		int add = 0;
		try {
			user2 = dao.getLoginUser(xxx, user);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return add;
	}

}
