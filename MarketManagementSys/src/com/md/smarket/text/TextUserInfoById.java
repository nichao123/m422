package MarketManagementSys.src.com.md.smarket.text;

import com.md.smarket.dao.impl.UserDaoImpl;
import com.md.smarket.entity.User;
import com.md.smarket.service.impl.UserServiceImpl;

public class TextUserInfoById {
	public static void main(String[] args) {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userServiceImpl.setuDao(userDaoImpl);
		User user = userServiceImpl.findUserInfoById(99);
		System.out.println(user.getUserName() + "\t" + user.getUserAge());
	}
}
