package MarketManagementSys.src.com.md.smarket.text;

import java.util.Scanner;
import com.md.smarket.dao.impl.UserDaoImpl;
import com.md.smarket.entity.User;
import com.md.smarket.service.impl.UserServiceImpl;

public class TextIfLogin {
	/*
	 * 测试用户登录
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入用户名：");
		String uName = input.next();
		System.out.print("请输入密码:");
		String uPwd = input.next();
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userServiceImpl.setuDao(userDaoImpl);
		User user = userServiceImpl.ifLogin(uName, uPwd);
		if (user != null) {
			System.out.println("登录成功！");
		} else {
			System.out.println("登录失败！");
		}

	}
}
