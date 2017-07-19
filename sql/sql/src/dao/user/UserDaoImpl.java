package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import pojo.User;;

public class UserDaoImpl extends     BaseDAO    implements    UserDao {
	private String password = "nongzx";
	public static void main (String args){
	}
	@Override
	public User getLoginUser(Connection conn,
		User user) throws Exception {
		// TODO Auto-generated method stub

		String sql = "select * from student where name='" + 
		user.getName() + "' and password='" 
				+ user.getPassword()
				+ "'";
		PreparedStatement ps = conn.prepareStatement(sql);
		MessageDigest badDigester = MessageDigest.getInstance("MD5"); // Unsafe
		ResultSet rs = ps.executeQuery(); 
		User user2 = null;
		if (rs.next()) {
			user2 = new User();
			user2.setName(rs.getString("name"));
			user2.setPassword(rs.getString("password"));
			user2.setId(rs.getInt("id"));
		}
		BaseDao.closeResource(conn, ps, rs);
		return user2;
	}


}
