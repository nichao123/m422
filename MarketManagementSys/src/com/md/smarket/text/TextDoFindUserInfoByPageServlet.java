package MarketManagementSys.src.com.md.smarket.text;

import java.util.List;

import com.md.smarket.dao.impl.UserDaoImpl;
import com.md.smarket.entity.PageSize;
import com.md.smarket.entity.User;
import com.md.smarket.service.impl.UserServiceImpl;

public class TextDoFindUserInfoByPageServlet {

	/**
	 * 测试用户管理页面中的分页查询
	 */
	public static void main(String[] args) {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userServiceImpl.setuDao(userDaoImpl);
		PageSize pageSize = userServiceImpl.getUserInfoByPage(2);
		List<User> userList = pageSize.getList();
		System.out.println(pageSize.getCurrPage());
		System.out.println("记录总数:"+pageSize.getTotalCount());
		for (User user : userList) {
			System.out.println("用户名:"+user.getUserName()+"\t"+"年龄:"+user.getUserAge());
		}
	}

}
