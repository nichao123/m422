package MarketManagementSys.src.com.md.smarket.dao;

import java.util.List;

import com.md.smarket.entity.Bill;
import com.md.smarket.entity.PageSize;

public interface BillDao  {
	// 账单管理中添加数据
	public boolean add(Bill bill);

	// 获取数据库账单表中的全部数据封装在集合中并
	public List<Bill> getAllBillsInfo();

	// 账单管理中根据商品名称和付款状态查询当前账单信息
	public List<Bill> findBillInfoByNameandIfPay(String commodyName, int ifPay);

	// 根据账单编号查询账单管理页面中的账单信息
	public Bill findBillInfoById(int billId);

	// 根据账单编号修改账单管理页面中的账单信息
	public int updateBillInfo(Bill bill, int billId);
	
	//根据账单编号删除账单管理页面中相应的账单信息
	public int deleteBillInfo(int billId);
	
	//获取账单信息的总条数
	public int getTotalCount();
	
	//分页获取账单信息
	public PageSize getPageBillInfo(int currPage);
}
