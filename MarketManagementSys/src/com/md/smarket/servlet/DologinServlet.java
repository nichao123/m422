package MarketManagementSys.src.com.md.smarket.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.md.smarket.dao.impl.UserDaoImpl;
import com.md.smarket.entity.User;
import com.md.smarket.service.impl.UserServiceImpl;

public class DologinServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("passWord");
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userServiceImpl.setuDao(userDaoImpl);
		User user = userServiceImpl.ifLogin(userName, userPwd);
		if (user != null) {
			//管理员登录
			if(user.getUserPermission()==1){
				HttpSession session = request.getSession();
				session.setAttribute("name", userName);
				response.sendRedirect("admin_index.jsp");
			}
			//普通用户登录
			if(user.getUserPermission()==0){
				HttpSession session = request.getSession();
				session.setAttribute("name", userName);
				response.sendRedirect("regUser_index.jsp");
			}
		} else {
			request.setAttribute("flag", false);
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		}

	}

}
