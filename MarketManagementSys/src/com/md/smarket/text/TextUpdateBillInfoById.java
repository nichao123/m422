package MarketManagementSys.src.com.md.smarket.text;

import com.md.smarket.dao.BillDao;
import com.md.smarket.dao.impl.BillDaoImpl;
import com.md.smarket.entity.Bill;
import com.md.smarket.service.impl.BillMangeServiceImpl;

public class TextUpdateBillInfoById {

	/**
	 * 测试根据账单编号修改账单信息
	 */
	public static void main(String[] args) {
		Bill bill = new Bill();
		bill.setComName("sdf");
		bill.setComDiscription("123123");
		bill.setIfPayment("2");
		bill.setTranAmount(34);
		bill.setTranMoney(234);
		bill.setTranUnit("sdf");
		bill.setBelongSupply("2");
		BillMangeServiceImpl billMangeServiceImpl = new BillMangeServiceImpl();
		BillDao billDao = new BillDaoImpl();
		billMangeServiceImpl.setBillDao(billDao);
		int result = billMangeServiceImpl.updateBillInfo(bill, 575);
		if (result == 1) {
			System.out.println("修改成功！");
		} else {
			System.out.println("修改失败");
		}

	}

}
