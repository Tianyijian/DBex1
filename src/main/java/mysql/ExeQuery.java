package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExeQuery {

	// JDBC �����������ݿ� URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/e-commerce?useSSL=false&serverTimezone=GMT%2B8";

	// ���ݿ���û��������룬��Ҫ�����Լ�������
	static final String USER = "tyj";
	static final String PASS = "tyj";

	private Connection conn = null;
	private Statement state = null;

	public ExeQuery() {
		try {
			// ע�� JDBC ����
			Class.forName(JDBC_DRIVER);

			// ������
			System.out.println("Connect to DB...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// ִ�в�ѯ
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
	 * ִ��sql���
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
	 * ִ��ɾ������
	 * 
	 * @param sql
	 * @return
	 */
	public String delete(String sql) {
		try {
			int r = state.executeUpdate(sql);
			if (r > 0) {
				return "ɾ���ɹ���ɾ������  " + r;
			} else {
				return "δ�ҵ��ü�¼��ɾ��ʧ��";
			}
		} catch (SQLException e) {
			return "Υ����ϵ������Լ�����ü�¼������������";
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
			return "����ɹ�����������  " + r;
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	/**
	 * �ر�����
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
