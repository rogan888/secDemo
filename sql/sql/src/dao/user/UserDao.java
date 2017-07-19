package dao.user;

import java.sql.Connection;
import java.util.List;

import pojo.User;

public interface UserDao {
	
	/**
	 * 用户登录
	 * @param conn
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(Connection conn,User user) throws Exception;
	/**
	 * 查询列表
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<User> getUsers(Connection conn) throws Exception;
	/**
	 * 用户注册
	 * @return
	 * @throws Exception
	 */
	public int addUser(Connection conn,User user) throws Exception;
}
