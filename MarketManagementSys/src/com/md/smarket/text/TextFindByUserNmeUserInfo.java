package MarketManagementSys.src.com.md.smarket.text;

import java.util.List;
import com.md.smarket.dao.impl.UserDaoImpl;
import com.md.smarket.entity.User;
import com.md.smarket.service.impl.UserServiceImpl;

public class TextFindByUserNmeUserInfo {
	/*
	 * 测试根据用户名获取数据库中的用户信息
	 */
	public static void main(String[] args) {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userServiceImpl.setuDao(userDaoImpl);
		List<User> billList = userServiceImpl.findUserInfoByName("东方");
		for (User user : billList) {
			System.out.println(user.getUserName() + "\t"
					+ user.getUserTelephone());
		}
	}

}
