package MarketManagementSys.src.com.md.smarket.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.md.smarket.dao.SupplierDao;
import com.md.smarket.dao.impl.SupplierDaoImpl;
import com.md.smarket.entity.PageSize;
import com.md.smarket.entity.Supplier;
import com.md.smarket.service.impl.SupplierServiceImpl;

public class DoDeleSupplierInfoByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int supId = Integer.parseInt(request.getParameter("supId").trim());
		SupplierServiceImpl supplierServiceImpl = new SupplierServiceImpl();
		SupplierDao supplierDao = new SupplierDaoImpl();
		supplierServiceImpl.setSupplierDao(supplierDao);
		int result = supplierServiceImpl.deleteProInfoById(supId);
		if (result == 1) {
			List<Supplier> supList = supplierServiceImpl.getAllSupplierInfo();
			PageSize pageSize=supplierServiceImpl.getSupplierInfoByPage(1);
			pageSize.setList(supList);			
			request.setAttribute("page", pageSize);
			request.setAttribute("supList", supList);
			request.getRequestDispatcher("providerAdmin.jsp").forward(
					request, response);
		}

	}

}
