package MarketManagementSys.src.com.md.smarket.text;

import com.md.smarket.dao.impl.UserDaoImpl;
import com.md.smarket.service.impl.UserServiceImpl;

public class TextUpdateUserPwd {

	/**
	 * 测试修改用户密码
	 */
	public static void main(String[] args) {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userServiceImpl.setuDao(userDaoImpl);
		int result=userDaoImpl.updateUserPwdInfo(99, "dfgdfg");
		if(result==1){
			System.out.println("用户密码修改成功!");
		}else{
			System.out.println("用户密码修改失败!");
		}
		
		
	}

}
