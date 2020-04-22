package MarketManagementSys.src.com.md.smarket.text;

import com.md.smarket.dao.impl.UserDaoImpl;
import com.md.smarket.entity.User;
import com.md.smarket.service.impl.UserServiceImpl;

public class TextUpdateUserInfo {

	/**
	 * 测试修改用户信息
	 */
	public static void main(String[] args) {
		User user=new User();
		user.setUserName("小明");
		user.setUserGender("男");
		user.setUserAge(12);
		user.setUserTelephone("631231");
		user.setUserAddress("sdfsdf");
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userServiceImpl.setuDao(userDaoImpl);
		int result = userServiceImpl.updateUserInfo(user,99);
		if(result==1){
			System.out.println("修改成功！");
		}else{
			System.out.println("修改失败");
		}
	}
}