package MarketManagementSys.src.com.md.smarket.text;

import com.md.smarket.dao.SupplierDao;
import com.md.smarket.dao.impl.SupplierDaoImpl;
import com.md.smarket.entity.Supplier;
import com.md.smarket.service.impl.SupplierServiceImpl;

public class TextUpdateProInfo {

	/**
	 * 测试修改供应商信息
	 */
	public static void main(String[] args) {
		Supplier sup = new Supplier();
		sup.setSupId(77);
		sup.setSupName("卢铭道");
		sup.setSupAddress("天上");
		sup.setSupPer("sdf");
		sup.setSupPhone("234234");
		sup.setSupFax("aaa");
		sup.setSupDescr("aaa");
		SupplierServiceImpl supplierServiceImpl = new SupplierServiceImpl();
		SupplierDao supplierDao = new SupplierDaoImpl();
		supplierServiceImpl.setSupplierDao(supplierDao);
		int result = supplierServiceImpl.updateProInfo(sup, 2);
		if (result == 1) {
			System.out.println("修改成功！");
		} else {
			System.out.println("修改失败");
		}

	}

}
