package MarketManagementSys.src.com.md.smarket.text;

import java.sql.Connection;

import com.md.smarket.dao.BaseDao;

public class TextCon {
	/*
	 * 测试丽连接是否成功
	 */
	public static void main(String[] args) {
		try {
			BaseDao bDao = new BaseDao();
			Connection con = bDao.getConn();
			if (con != null) {
				System.out.println("登录成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
