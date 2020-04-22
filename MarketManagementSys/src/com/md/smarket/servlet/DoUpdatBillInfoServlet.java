package MarketManagementSys.src.com.md.smarket.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.md.smarket.dao.BillDao;
import com.md.smarket.dao.impl.BillDaoImpl;
import com.md.smarket.entity.Bill;
import com.md.smarket.service.impl.BillMangeServiceImpl;

public class DoUpdatBillInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Bill bill = new Bill();
		int txtBillId = Integer.parseInt(request.getParameter("billNum"));
		int txtBillMoney = Integer.parseInt(request.getParameter("money"));
		String txtBillUnit = request.getParameter("unit");
		int txtBillAmount = Integer.parseInt(request.getParameter("amount"));
		String txtBillComName = request.getParameter("comName");
		String txtBillDisc = request.getParameter("discription");
		int isPayId = Integer.parseInt(request.getParameter("isPay"));
		String txtBillIsPay = null;
		if (isPayId == 1) {
			txtBillIsPay = "是";
		} else if (isPayId == 2) {
			txtBillIsPay = "否";
		}
		int belongSupId = Integer
				.parseInt(request.getParameter("belongsupply"));
		String txtBillBelongSupply = null;
		if (belongSupId == 1) {
			txtBillBelongSupply = "京东";
		} else if (belongSupId == 2) {
			txtBillBelongSupply = "阿里巴巴";
		} else if (belongSupId == 3) {
			txtBillBelongSupply = "天猫";
		}
		bill.setComName(txtBillComName);
		bill.setTranMoney(txtBillMoney);
		bill.setTranUnit(txtBillUnit);
		bill.setTranAmount(txtBillAmount);
		bill.setIfPayment(txtBillIsPay);
		bill.setComDiscription(txtBillDisc);
		bill.setBelongSupply(txtBillBelongSupply);
		BillMangeServiceImpl billMangeServiceImpl = new BillMangeServiceImpl();
		BillDao billDao = new BillDaoImpl();
		billMangeServiceImpl.setBillDao(billDao);
		int result = billMangeServiceImpl.updateBillInfo(bill, txtBillId);
		if (result == 1) {
			request.getRequestDispatcher("billAdd.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("billModify.jsp").forward(request,
					response);
		}
	}

}
