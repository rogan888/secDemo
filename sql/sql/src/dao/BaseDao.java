package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.ConfigManager;

/**
 * 静态类，静态类，每个线程对应一个connection
 * 
 * @author lenovo
 *
 */
public class BaseDao {
	/**
	 * 获取数据库链接
	 * 
	 * @return
	 */
	 public static void main(String args){
	}
	public static Connection getConn() {
		String driver = ConfigManager.getInstance().getValue("jdbc.driver.class");
		String url = ConfigManager.getInstance().getValue("jdbc.connection.url");
		String username = ConfigManager.getInstance().getValue("jdbc.connection.user");
		String password = ConfigManager.getInstance().getValue("jdbc.connection.password");
		Connection conn = null;
		// 加载JDBC驱动
		try {
			Class.forName(driver);
			// 与数据库建立连接
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("网络异常");
		}
		return conn;
	}

	/**
	 * 关闭资源
	 * 
	 * @param conn
	 * @param ps
	 * @param rs
	 * @return
	 */
	
	public static boolean closeResource(Connection conn, PreparedStatement ps, ResultSet rs) {
		boolean flag = true;
		if (rs != null) {
			try {
				rs.close();
				rs = null;//GC回收
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
			}
		}
		if (ps != null) {
			try {
				ps.close();
				ps = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
			}
		}
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
			}
		}
		return flag;
	}

	/**
	 * 查询操作
	 * 
	 * @param conn
	 * @param ps
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet execute(Connection conn, PreparedStatement ps, ResultSet rs, String sql,
			Object[] params) throws SQLException {
		ps = conn.prepareStatement(sql);
		for (int i = 0; i < params.length; i++) {
			ps.setObject(i + 1, params[i]);
		}
		rs = ps.executeQuery();
		
		return rs;
	}
	/**
	 * 更新操作
	 * @param conn
	 * @param ps
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 *///方法重载，体现面向对象的多态
	public static int execute(Connection conn, PreparedStatement ps, String sql,
			Object[] params) throws SQLException {
		int updateRows = 0;
		ps = conn.prepareStatement(sql);
		for(int i=0;i<params.length;i++){
			ps.setObject(i+1, params[i]);
		}
		updateRows = ps.executeUpdate();
		return updateRows;
	}
}
