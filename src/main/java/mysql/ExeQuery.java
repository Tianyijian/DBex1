package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExeQuery {

	// JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/e-commerce?useSSL=false&serverTimezone=GMT%2B8";

	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "tyj";
	static final String PASS = "tyj";

	private Connection conn = null;
	private Statement state = null;

	public ExeQuery() {
		try {
			// 注册 JDBC 驱动
			Class.forName(JDBC_DRIVER);

			// 打开链接
			System.out.println("Connect to DB...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// 执行查询
			System.out.println("Instant Statement...");
			state = conn.createStatement();

		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 执行sql语句
	 * 
	 * @param sql
	 * @return
	 */
	public ResultSet exeQuery(String sql) {
		ResultSet res = null;
		try {
			res = state.executeQuery(sql);
//			StringBuilder sb = new StringBuilder();
//			while (res.next()) {
//				sb.append(res.getString(1));
//			}
//			System.out.println(sb.toString());
//			res.close();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * 关闭连接
	 * 
	 */
	public void close() {
		try {
			state.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (state != null) {
					state.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
