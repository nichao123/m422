package MarketManagementSys.src.com.md.smarket.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.md.smarket.dao.impl.UserDaoImpl;
import com.md.smarket.entity.User;
import com.md.smarket.service.impl.UserServiceImpl;

public class DoAddUserInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
     doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        User user=new User();
        String txtUserName=request.getParameter("userName");
        String txtUserPwd=request.getParameter("userPwd");
        int sexId=Integer.parseInt(request.getParameter("sex"));
        String txtUserGender=null;
        if(sexId==0){
        	txtUserGender="男";
        }else if(sexId==1){
        	txtUserGender="女";
        }
        int txtUserAge=Integer.parseInt(request.getParameter("userAge"));
        String txtUserPhone=request.getParameter("userPhone");
        String txtUserAddress=request.getParameter("userAddress");
        int txtUserPer=Integer.parseInt(request.getParameter("auth"));
        user.setUserName(txtUserName);
        user.setUserPwd(txtUserPwd);
        user.setUserGender(txtUserGender);
        user.setUserAge(txtUserAge);
        user.setUserTelephone(txtUserPhone);
        user.setUserAddress(txtUserAddress);
        user.setUserPermission(txtUserPer);
        UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userServiceImpl.setuDao(userDaoImpl);
		boolean flag = userDaoImpl.add(user);
		if(flag){
			request.getRequestDispatcher("userAdd.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("userAdd.jsp").forward(request, response);
		}
	}

}
