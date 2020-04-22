package MarketManagementSys.src.com.md.smarket.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.md.smarket.dao.impl.UserDaoImpl;
import com.md.smarket.entity.User;
import com.md.smarket.service.impl.UserServiceImpl;

public class DoUpdateUserInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User user = new User();
		String userid = request.getParameter("userId");
		Integer txtUserId = Integer.valueOf((request.getParameter("userId")
				.trim()));
		String txtUserName = request.getParameter("userName");
		int genderId = Integer.parseInt(request.getParameter("gender"));
		String txtUserGender = null;
		if (genderId == 0) {
			txtUserGender = "女";
		} else if (genderId == 1) {
			txtUserGender = "男";
		}
		int txtUserAge = (Integer.valueOf(request.getParameter("userAge")
				.trim()));
		String txtUserPhone = request.getParameter("userPhone");
		String txtUserAddress = request.getParameter("userAddress");
		user.setUserId(txtUserId);
		user.setUserName(txtUserName);
		user.setUserAge(txtUserAge);
		user.setUserGender(txtUserGender);
		user.setUserTelephone(txtUserPhone);
		user.setUserAddress(txtUserAddress);
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userServiceImpl.setuDao(userDaoImpl);
		int result = userServiceImpl.updateUserInfo(user, txtUserId);
		if (result == 1) {
			request.getRequestDispatcher("userAdd.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("userModify.jsp").forward(request,
					response);
		}
	}
}
