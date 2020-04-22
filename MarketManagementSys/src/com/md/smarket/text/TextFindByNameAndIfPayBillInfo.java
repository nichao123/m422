package MarketManagementSys.src.com.md.smarket.text;

import java.util.List;
import com.md.smarket.dao.BillDao;
import com.md.smarket.dao.impl.BillDaoImpl;
import com.md.smarket.entity.Bill;
import com.md.smarket.service.impl.BillMangeServiceImpl;

public class TextFindByNameAndIfPayBillInfo {
	/*
	 * 测试根据用户名和付款方式获取账单信息
	 */
	public static void main(String[] args) {
		BillMangeServiceImpl billMangeServiceImpl = new BillMangeServiceImpl();
		BillDao billDao = new BillDaoImpl();
		billMangeServiceImpl.setBillDao(billDao);
		List<Bill> billList = billMangeServiceImpl.findBillInfoByNameandIfPay("冰红茶", 2);
		for (Bill bill : billList) {
			System.out.println(bill.getComName() + "\t" + bill.getTranMoney());
		}
	}

}
