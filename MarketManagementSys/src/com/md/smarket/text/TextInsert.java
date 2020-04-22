package MarketManagementSys.src.com.md.smarket.text;

import com.md.smarket.dao.BillDao;
import com.md.smarket.dao.impl.BillDaoImpl;
import com.md.smarket.entity.Bill;
import com.md.smarket.service.impl.BillMangeServiceImpl;

public class TextInsert {
	/*
	 * 测试向账单管理添加数据的方法
	 */
	public static void main(String[] args) {
		Bill bill = new Bill();
		bill.setComName("qwe");
		bill.setTranMoney(12);
		bill.setTranUnit("2342");
		bill.setTranAmount(3);
		bill.setComDiscription("dddd");
		bill.setIfPayment("q");
		bill.setBelongSupply("fghqq");
		BillMangeServiceImpl billMangeServiceImpl = new BillMangeServiceImpl();
		BillDao billDao = new BillDaoImpl();
		billMangeServiceImpl.setBillDao(billDao);
		boolean flag = billMangeServiceImpl.add(bill);
		if (flag) {
			System.out.println("添加成功！");
		} else {
			System.out.println("添加失败！");
		}

	}
}
