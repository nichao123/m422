package MarketManagementSys.src.com.md.smarket.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.md.smarket.dao.SupplierDao;
import com.md.smarket.dao.impl.SupplierDaoImpl;
import com.md.smarket.entity.Supplier;
import com.md.smarket.service.impl.SupplierServiceImpl;

public class DoAddProviderInfo extends HttpServlet {
   
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String txtProName=request.getParameter("proName");
		String txtProDesc=request.getParameter("proDesc");
		String txtProContact=request.getParameter("contact");
		String txtProTelephone=request.getParameter("phone");
		String txtProFax=request.getParameter("proFax");
		String txtProAddress=request.getParameter("address");
		Supplier supplier=new Supplier();
		supplier.setSupName(txtProName);
		supplier.setSupDescr(txtProDesc);
		supplier.setSupPer(txtProContact);
		supplier.setSupPhone(txtProTelephone);
		supplier.setSupFax(txtProFax);
		supplier.setSupAddress(txtProAddress);
		// 调用供应商管理中添加数据的方法
		SupplierServiceImpl supplierServiceImpl = new SupplierServiceImpl();
		SupplierDao supplierDao = new SupplierDaoImpl();
		supplierServiceImpl.setSupplierDao(supplierDao);
		boolean flag = supplierServiceImpl.add(supplier);
		if(flag){
			request.getRequestDispatcher("providerAdd.jsp").forward(request, response);
		}
		
	}

}
