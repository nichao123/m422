package MarketManagementSys.src.com.md.smarket.service;

import java.util.List;

import com.md.smarket.entity.PageSize;
import com.md.smarket.entity.User;

public interface UserService {
	// 判断用户登录是否成功
	public User ifLogin(String name, String password);

	// 根据用户名查询用户表中的数据
	public List<User> findUserInfoByName(String userName);

	// 获取数据库中用户表中的数据并封装在集合中
	public List<User> getAllUserInfo();

	// 向用户管理中添加用户信息
	public boolean add(User user);

	// 根据用户编号修改用户管理页面中的用户信息
	public int updateUserInfo(User user, int userId);

	// 根据用户名编号查询用户表中的数据
	public User findUserInfoById(int userId);

	// 根据用户编号删除用户管理页面中相应的用户信息
	public int deleteUserInfoById(int userId);

	// 分页获取用户信息
	public PageSize getUserInfoByPage(int currPage);

	// 修改用户密码
	public int updateUserPwdInfo(int userId, String userNewPwd);
}
