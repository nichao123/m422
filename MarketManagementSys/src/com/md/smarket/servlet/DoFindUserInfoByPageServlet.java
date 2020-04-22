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

public class DoFindUserInfoByPageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int currPage = Integer.parseInt(request.getParameter("pageNo"));
		System.out.println("currPage:"+currPage);
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userServiceImpl.setuDao(userDaoImpl);
		PageSize pageSize = userServiceImpl.getUserInfoByPage(currPage);
		List<User> userList = pageSize.getList();
		pageSize.setList(userList);
		request.setAttribute("userList", userList);
		request.setAttribute("page", pageSize);
		request.getRequestDispatcher("userAdmin.jsp").forward(request,
				response);

	}

}
