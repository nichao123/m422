package MarketManagementSys.src.com.md.smarket.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.md.smarket.dao.BillDao;
import com.md.smarket.dao.impl.BillDaoImpl;
import com.md.smarket.entity.Bill;
import com.md.smarket.entity.PageSize;
import com.md.smarket.service.impl.BillMangeServiceImpl;

public class DoFindBillInfoByPageServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
  		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int currPage = Integer.parseInt(request.getParameter("pageNo"));
		System.out.println("pageNo:"+currPage);
		BillMangeServiceImpl billMangeServiceImpl = new BillMangeServiceImpl();
		BillDao billDao = new BillDaoImpl();
		billMangeServiceImpl.setBillDao(billDao);
		PageSize pageSize=billMangeServiceImpl.getPageBillInfo(currPage);
		List<Bill> billList=pageSize.getList();
		pageSize.setList(billList);
		request.setAttribute("billList", billList);
		request.setAttribute("page", pageSize);
		request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);	
	}

}
