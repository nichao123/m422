package MarketManagementSys.src.com.md.smarket.text;

import com.md.smarket.dao.impl.BillDaoImpl;

public class TextGetTotalCount {

	/**
	 * 测试获取账单总条数
	 */
	public static void main(String[] args) {
		BillDaoImpl biDaoImpl = new BillDaoImpl();
		int count = biDaoImpl.getTotalCount();
		System.out.println(count);
	}

}
