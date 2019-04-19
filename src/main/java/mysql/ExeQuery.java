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
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * 执行删除操作
	 * 
	 * @param sql
	 * @return
	 */
	public String delete(String sql) {
		try {
			int r = state.executeUpdate(sql);
			if (r > 0) {
				return "删除成功，删除行数  " + r;
			} else {
				return "未找到该记录，删除失败";
			}
		} catch (SQLException e) {
			return "违背关系完整性约束，该记录被其它表引用";
			// e.printStackTrace();
		}
	}

	/**
	 * @param sql
	 * @return
	 */
	public String insert(String sql) {
		try {
			int r = state.executeUpdate(sql);
			return "插入成功，插入行数  " + r;
		} catch (SQLException e) {
			return e.getMessage();
		}
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
