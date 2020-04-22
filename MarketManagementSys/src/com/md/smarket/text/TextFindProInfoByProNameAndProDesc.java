package MarketManagementSys.src.com.md.smarket.text;

import java.util.List;
import com.md.smarket.dao.SupplierDao;
import com.md.smarket.dao.impl.SupplierDaoImpl;
import com.md.smarket.entity.Supplier;
import com.md.smarket.service.impl.SupplierServiceImpl;

public class TextFindProInfoByProNameAndProDesc {

	/**
	 * 测试根据供应商名称和供应商描述获取相应的供应商信息
	 */
	public static void main(String[] args) {
		SupplierServiceImpl supplierServiceImpl = new SupplierServiceImpl();
		SupplierDao supplierDao = new SupplierDaoImpl();
		supplierServiceImpl.setSupplierDao(supplierDao);
		List<Supplier> supList = supplierServiceImpl.findProInfoByProNameAndProDesc("百度", "全球最大的中文搜索引擎");
		for (Supplier supplier : supList) {
			System.out.println(supplier.getSupName()+"\t"+supplier.getSupAddress());
		}
	}

}
