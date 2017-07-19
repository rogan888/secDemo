package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.BaseDao;
import dao.user.UserDao;
import dao.user.UserDaoImpl;
import pojo.User;

public class UserDaoImplTest {

	@Test
	public void test() {
		User user = new User();
		user.setName("admin");
		user.setPassword("admin");
		UserDao userDao = new UserDaoImpl();
		try {
			User loginUser = userDao.getLoginUser(BaseDao.getConn(), user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
