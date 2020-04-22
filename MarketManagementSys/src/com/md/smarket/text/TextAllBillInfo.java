package MarketManagementSys.src.com.md.smarket.text;

import java.util.List;

import com.md.smarket.dao.BillDao;
import com.md.smarket.dao.impl.BillDaoImpl;
import com.md.smarket.entity.Bill;
import com.md.smarket.service.impl.BillMangeServiceImpl;

public class TextAllBillInfo {
	/**
	 * 测试获取数据库billmanagement表中的数据
	 */
	public static void main(String[] args) {
		BillMangeServiceImpl billMangeServiceImpl = new BillMangeServiceImpl();
		BillDao billDao = new BillDaoImpl();
		billMangeServiceImpl.setBillDao(billDao);
		List<Bill> billList = billMangeServiceImpl.getAllBillsInfo();
		for (int i = 0; i < billList.size(); i++) {
			Bill bill = billList.get(i);
			System.out.println("biiId:" + bill.getBillId() + "\t"
					+ bill.getComName());
		}
	}

}
