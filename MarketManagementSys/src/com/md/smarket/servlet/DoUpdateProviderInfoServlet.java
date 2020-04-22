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

public class DoUpdateProviderInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Supplier sup = new Supplier();
		int txtSupId = Integer.parseInt(request.getParameter("proId"));
		String txtSupName = request.getParameter("proName");
		String txtSupDesc = request.getParameter("proDesc");
		String txtSupContact = request.getParameter("contact");
		String txtSupPhone = request.getParameter("phone");
		String txtSupProFax = request.getParameter("proFax");
		String txtSupAddress = request.getParameter("address");
		sup.setSupName(txtSupName);
		sup.setSupDescr(txtSupDesc);
		sup.setSupPer(txtSupContact);
		sup.setSupPhone(txtSupPhone);
		sup.setSupFax(txtSupProFax);
		sup.setSupAddress(txtSupAddress);
		SupplierServiceImpl supplierServiceImpl = new SupplierServiceImpl();
		SupplierDao supplierDao = new SupplierDaoImpl();
		supplierServiceImpl.setSupplierDao(supplierDao);
		int result = supplierServiceImpl.updateProInfo(sup, txtSupId);
		if (result == 1) {
			request.getRequestDispatcher("providerAdd.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("providerModify.jsp").forward(request,
					response);
		}

	}

}
