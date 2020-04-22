package MarketManagementSys.src.com.md.smarket.service;

import java.util.List;

import com.md.smarket.entity.PageSize;
import com.md.smarket.entity.Supplier;

public interface SupplierService {
	// 获取数据库供应商列表中的全部数据并封装在集合中
	public List<Supplier> getAllSupplierInfo();

	// 向供应商管理中添加数据
	public boolean add(Supplier supplier);

	// 供应商管理根据供应商名称和供应商描述获取相应的供应商信息
	public List<Supplier> findProInfoByProNameAndProDesc(String supName,
                                                         String supDesc);

	// 根据供应商编号查询供应商信息
	public Supplier findProvideInfoById(int supId);

	// 根据供应商编号修改供应商管理页面中的供应商信息
	public int updateProInfo(Supplier sup, int supId);

	// 根据供应商编号删除供应商管理页面中相应的供应商信息
	public int deleteProInfoById(int supId);
     
	//分页获取供应商信息
	public PageSize getSupplierInfoByPage(int currPage);
}
