package MarketManagementSys.src.com.md.smarket.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.md.smarket.dao.impl.UserDaoImpl;
import com.md.smarket.entity.User;
import com.md.smarket.service.impl.UserServiceImpl;

public class DoFindUserInfoById extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int txtUserId = Integer.parseInt(request.getParameter("id"));
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userServiceImpl.setuDao(userDaoImpl);
		User user = userServiceImpl.findUserInfoById(txtUserId);
		if (user != null) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("userModify.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("userModify.jsp").forward(request,
					response);
		}
	}

}
