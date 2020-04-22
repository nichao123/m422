package MarketManagementSys.src.com.md.smarket.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.md.smarket.dao.impl.UserDaoImpl;
import com.md.smarket.entity.User;
import com.md.smarket.service.impl.UserServiceImpl;

public class DoModifyUserInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uuuString = request.getParameter("userName");
		System.out.println(uuuString);
		String userName = request.getParameter("name");
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userServiceImpl.setuDao(userDaoImpl);
		List<User> userList = userServiceImpl.findUserInfoByName(userName);
		if (userList != null) {
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("userModify.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("userModify.jsp").forward(request,
					response);
		}

	}

}
