package MarketManagementSys.src.com.md.smarket.text;

import java.util.List;
import com.md.smarket.dao.impl.UserDaoImpl;
import com.md.smarket.entity.User;
import com.md.smarket.service.impl.UserServiceImpl;

public class TextGetAllUserInfo {

	/**
	 * 测试获取所有用户的信息
	 */
	public static void main(String[] args) {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userServiceImpl.setuDao(userDaoImpl);
		List<User> userList = userServiceImpl.getAllUserInfo();
		for (User user : userList) {
			System.out.println("用户名："+user.getUserName()+"\n年龄:"+user.getUserAge());
		}
	}

}
