package MarketManagementSys.src.com.md.smarket.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public Connection getConn() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", "smarketcreater", "tiger");
		return conn;
	}

	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int executeSqlNonQuery(String sql, String[] params) {
		int result = -1;
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setString((i + 1), params[i]);
				}
			}
			result = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}
		return result;
	}
}
