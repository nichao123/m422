package MarketManagementSys.src.com.md.smarket.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.md.smarket.dao.BillDao;
import com.md.smarket.dao.impl.BillDaoImpl;
import com.md.smarket.entity.Bill;
import com.md.smarket.service.impl.BillMangeServiceImpl;

public class DoAddBillServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取jsp表单中的数据并封装
		request.setCharacterEncoding("UTF-8");
		String comName = request.getParameter("comName");
		int tranMoney = Integer.parseInt(request.getParameter("money"));
		String tranUnit = request.getParameter("unit");
		int tranAmount = Integer.parseInt(request.getParameter("amount"));
		String disc = request.getParameter("discription");
		String ifPayment = request.getParameter("isPay");
		String belongSupply = request.getParameter("belongsupply");
		Bill bill = new Bill();
		bill.setComName(comName);
		bill.setTranMoney(tranMoney);
		bill.setTranUnit(tranUnit);
		bill.setTranAmount(tranAmount);
		bill.setComDiscription(disc);
		bill.setIfPayment(ifPayment);
		bill.setBelongSupply(belongSupply);
		// 调用javabean中向账单管理添加数据的方法
		BillMangeServiceImpl billMangeServiceImpl = new BillMangeServiceImpl();
		BillDao billDao = new BillDaoImpl();
		billMangeServiceImpl.setBillDao(billDao);
		boolean flag = billMangeServiceImpl.add(bill);
		if (flag == true) {
			request.getRequestDispatcher("billAdd.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("billAdd.jsp").forward(request,
					response);
		}
	}

}
