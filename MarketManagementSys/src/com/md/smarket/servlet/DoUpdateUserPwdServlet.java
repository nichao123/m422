package MarketManagementSys.src.com.md.smarket.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.md.smarket.dao.impl.UserDaoImpl;
import com.md.smarket.service.impl.UserServiceImpl;

public class DoUpdateUserPwdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int txtUserId = Integer.parseInt(request.getParameter("userId"));
		String txtUserPwd=request.getParameter("newPwd");
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userServiceImpl.setuDao(userDaoImpl);
		int result=userDaoImpl.updateUserPwdInfo(txtUserId, txtUserPwd);
		if(result==1){
		  request.getRequestDispatcher("updatePwd.jsp").forward(request, response);
		}
	}

}
