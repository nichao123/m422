package MarketManagementSys.src.com.md.smarket.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.md.smarket.dao.SupplierDao;
import com.md.smarket.dao.impl.SupplierDaoImpl;
import com.md.smarket.entity.Supplier;
import com.md.smarket.service.impl.SupplierServiceImpl;

public class DoGetAllSupplierInfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SupplierServiceImpl supplierServiceImpl = new SupplierServiceImpl();
		SupplierDao supplierDao = new SupplierDaoImpl();
		supplierServiceImpl.setSupplierDao(supplierDao);
		List<Supplier> supList = supplierServiceImpl.getAllSupplierInfo();
		if (supList != null) {
			request.setAttribute("supList", supList);
			request.getRequestDispatcher("providerAdmin.jsp").forward(
					request, response);
		}		
	}
   

}
