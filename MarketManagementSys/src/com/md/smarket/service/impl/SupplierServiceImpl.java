package MarketManagementSys.src.com.md.smarket.service.impl;

import java.util.List;

import com.md.smarket.dao.BaseDao;
import com.md.smarket.dao.SupplierDao;
import com.md.smarket.entity.PageSize;
import com.md.smarket.entity.Supplier;
import com.md.smarket.service.SupplierService;

public class SupplierServiceImpl extends BaseDao implements SupplierService {
	private SupplierDao supplierDao;

	public SupplierDao getSupplierDao() {
		return supplierDao;
	}

	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

	// 向供应商管理中添加数据
	public boolean add(Supplier supplier) {
		return supplierDao.add(supplier);
	}

	// 供应商管理根据供应商名称和供应商描述获取相应的供应商信息
	public List<Supplier> findProInfoByProNameAndProDesc(String supName,
			String supDesc) {
		return supplierDao.findProInfoByProNameAndProDesc(supName, supDesc);
	}

	// 根据供应商编号查询供应商信息
	public Supplier findProvideInfoById(int supId) {
		return supplierDao.findProvideInfoById(supId);
	}

	// 获取数据库供应商列表中的全部数据并封装在集合中
	public List<Supplier> getAllSupplierInfo() {
		return supplierDao.getAllSupplierInfo();
	}

	// 根据供应商编号修改供应商管理页面中的供应商信息
	public int updateProInfo(Supplier sup, int supId) {
		return supplierDao.updateProInfo(sup, supId);
	}

	// 根据供应商编号删除供应商管理页面中相应的供应商信息
	public int deleteProInfoById(int supId) {
		return supplierDao.deleteProInfoById(supId);
	}

	//分页获取供应商信息
	public PageSize getSupplierInfoByPage(int currPage) {
		return supplierDao.getSupplierInfoByPage(currPage);
	}

}
