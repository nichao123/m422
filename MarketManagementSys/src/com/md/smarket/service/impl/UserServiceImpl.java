package MarketManagementSys.src.com.md.smarket.service.impl;

import java.util.List;
import com.md.smarket.dao.BaseDao;
import com.md.smarket.dao.UserDao;
import com.md.smarket.entity.PageSize;
import com.md.smarket.entity.User;
import com.md.smarket.service.UserService;

public class UserServiceImpl extends BaseDao implements UserService {
	private UserDao uDao;

	public UserDao getuDao() {
		return uDao;
	}

	public void setuDao(UserDao uDao) {
		this.uDao = uDao;
	}

	// 向用户管理中添加用户信息
	public boolean add(User user) {
		return uDao.add(user);
	}

	// 根据用户名编号查询用户表中的数据
	public User findUserInfoById(int userId) {
		return uDao.findUserInfoById(userId);
	}

	// 根据用户名查询用户表中的数据
	public List<User> findUserInfoByName(String userName) {
		return uDao.findUserInfoByName(userName);
	}

	// 获取数据库中用户表中的数据并封装在集合中
	public List<User> getAllUserInfo() {
		return uDao.getAllUserInfo();
	}

	// 判断用户登录是否成功
	public User ifLogin(String name, String password) {
		return uDao.ifLogin(name, password);
	}

	// 根据用户编号修改用户管理页面中的用户信息
	public int updateUserInfo(User user, int userId) {
		return uDao.updateUserInfo(user, userId);
	}

	// 根据用户编号删除用户管理页面中相应的用户信息
	public int deleteUserInfoById(int userId) {
		return uDao.deleteUserInfoById(userId);
	}
    
	//分页获取用户信息
	public PageSize getUserInfoByPage(int currPage){
		return uDao.getUserInfoByPage(currPage);
	}

	// 修改用户密码
	public int updateUserPwdInfo(int userId, String userNewPwd) {
		return uDao.updateUserPwdInfo(userId, userNewPwd);
	}
}
