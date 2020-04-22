package MarketManagementSys.src.com.md.smarket.service.impl;

import java.util.List;

import com.md.smarket.dao.BaseDao;
import com.md.smarket.dao.BillDao;
import com.md.smarket.entity.Bill;
import com.md.smarket.entity.PageSize;
import com.md.smarket.service.BillMangeService;

public class BillMangeServiceImpl extends BaseDao implements BillMangeService {
	private BillDao billDao;

	public BillDao getBillDao() {
		return billDao;
	}

	public void setBillDao(BillDao billDao) {
		this.billDao = billDao;
	}

	// 账单管理中添加数据
	public boolean add(Bill bill) {
		return billDao.add(bill);
	}

	// 根据账单编号查询账单管理页面中的账单信息
	public Bill findBillInfoById(int billId) {
		return billDao.findBillInfoById(billId);
	}

	// 根据账单编号查询账单管理页面中的账单信息
	public List<Bill> findBillInfoByNameandIfPay(String commodyName, int ifPay) {
		return billDao.findBillInfoByNameandIfPay(commodyName, ifPay);
	}

	// 获取数据库账单表中的全部数据封装在集合中并
	public List<Bill> getAllBillsInfo() {
		return billDao.getAllBillsInfo();
	}

	// 根据账单编号修改账单管理页面中的账单信息
	public int updateBillInfo(Bill bill, int billId) {
		return billDao.updateBillInfo(bill, billId);
	}

	// 根据账单编号删除账单管理页面中相应的账单信息
	public int deleteBillInfo(int billId) {
		return billDao.deleteBillInfo(billId);
	}

	// 获取账单信息的总条数
	public int getTotalCount() {
		return billDao.getTotalCount();
	}

	// 分页获取账单信息
	public PageSize getPageBillInfo(int currPage) {
		return billDao.getPageBillInfo(currPage);
	}
}
