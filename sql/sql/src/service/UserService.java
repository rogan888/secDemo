package service;

import java.sql.Connection;
import java.util.List;

import pojo.User;

public interface UserService {
	public User getLoginUser(User user) ;
	public List<User> getUsers();
	public int addUser(User user);
}
