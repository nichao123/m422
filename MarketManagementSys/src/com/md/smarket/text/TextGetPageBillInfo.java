package MarketManagementSys.src.com.md.smarket.text;

import java.util.List;

import com.md.smarket.dao.BillDao;
import com.md.smarket.dao.impl.BillDaoImpl;
import com.md.smarket.entity.Bill;
import com.md.smarket.entity.PageSize;
import com.md.smarket.service.impl.BillMangeServiceImpl;

public class TextGetPageBillInfo {

	/**
	 * 测试账单管理页面中的分页查询
	 */
	public static void main(String[] args) {
		BillMangeServiceImpl billMangeServiceImpl = new BillMangeServiceImpl();
		BillDao billDao = new BillDaoImpl();
		billMangeServiceImpl.setBillDao(billDao);
		PageSize billPageSize = billMangeServiceImpl.getPageBillInfo(5);
		List<Bill>  billList=billPageSize.getList();
		int totalCount=billPageSize.getTotalCount();
		int currPage=billPageSize.getCurrPage();
		int totalPage=billPageSize.getTotalPage();
		System.out.println("总页数:"+totalPage);
		System.out.println("当前页:"+currPage);
		for (Bill bill : billList) {
			System.out.println("账单编号"+"\t"+"账单时间:");
			System.out.println(bill.getBillId()+"\t"+bill.getTranDate());
			
		}
	}

}
