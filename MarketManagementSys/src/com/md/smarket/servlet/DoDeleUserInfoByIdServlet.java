package MarketManagementSys.src.com.md.smarket.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.md.smarket.dao.impl.UserDaoImpl;
import com.md.smarket.entity.PageSize;
import com.md.smarket.entity.User;
import com.md.smarket.service.impl.UserServiceImpl;

public class DoDeleUserInfoByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int userId = Integer.parseInt(request.getParameter("userId").trim());
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userServiceImpl.setuDao(userDaoImpl);
		int result = userServiceImpl.deleteUserInfoById(userId);
		if (result == 1) {
			List<User> userList = userServiceImpl.getAllUserInfo();
			PageSize pageSize=userServiceImpl.getUserInfoByPage(1);
			pageSize.setList(userList);
			request.setAttribute("page", pageSize);
			request.setAttribute("userList",userList);		
			request.getRequestDispatcher("userAdmin.jsp").forward(request,
					response);
		}
	}

}
