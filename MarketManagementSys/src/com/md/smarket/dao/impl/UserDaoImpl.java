package MarketManagementSys.src.com.md.smarket.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.md.smarket.dao.BaseDao;
import com.md.smarket.dao.UserDao;
import com.md.smarket.entity.PageSize;
import com.md.smarket.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	// 向用户管理中添加用户信息
	public boolean add(User user) {
		int result = -1;
		String sql = "insert into suser values(suser_seq.nextval,?,?,?,?,?,?,?)";
		String[] params = { user.getUserName(), user.getUserPwd(),
				user.getUserGender(), user.getUserAge() + "",
				user.getUserTelephone(), user.getUserAddress(),
				user.getUserPermission() + "" };
		result = this.executeSqlNonQuery(sql, params);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	// 根据用户名编号查询用户表中的用户信息
	public User findUserInfoById(int userId) {
		User user = null;
		String sql = "select user_id, name, password,gender,age,phone,address,permission from suser  where user_id= ?";
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("name"));
				user.setUserPwd(rs.getString("password"));
				user.setUserGender(rs.getString("gender"));
				user.setUserAge(rs.getInt("age"));
				user.setUserTelephone(rs.getString("phone"));
				user.setUserAddress(rs.getString("address"));
				user.setUserPermission(rs.getInt("permission"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}
		return user;
	}

	// 根据用户名查询用户表中的数据
	public List<User> findUserInfoByName(String userName) {
		List<User> userList = new ArrayList<User>();
		User user = null;
		String sql = "select user_id, name, password,gender,age,phone,address,permission from suser  where name= ?";
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("name"));
				user.setUserPwd(rs.getString("password"));
				user.setUserGender(rs.getString("gender"));
				user.setUserAge(rs.getInt("age"));
				user.setUserTelephone(rs.getString("phone"));
				user.setUserAddress(rs.getString("address"));
				user.setUserPermission(rs.getInt("permission"));
				userList.add(user);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}
		return userList;
	}

	// 获取数据库中用户表中的数据并封装在集合中
	public List<User> getAllUserInfo() {
		List<User> userList = new ArrayList<User>();
		String sql = "select user_id, name, gender,age,phone,address,permission  from suser order by user_id";
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("name"));
				user.setUserGender(rs.getString("gender"));
				user.setUserAge(rs.getInt("age"));
				user.setUserTelephone(rs.getString("phone"));
				user.setUserAddress(rs.getString("address"));
				user.setUserPermission(rs.getInt("permission"));
				userList.add(user);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}
		return userList;
	}

	// 判断用户登录是否成功
	public User ifLogin(String name, String password) {
		User user = null;
		String sql = "select user_id, name, password,permission from suser t where name=? and password=?";
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("name"));
				user.setUserPwd(rs.getString("password"));
				user.setUserPermission(rs.getInt("permission"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, ps, rs);
		}
		return user;
	}

	// 根据用户编号修改用户管理页面中的用户信息
	public int updateUserInfo(User user, int userId) {
		int result = -1;
		String sql = "update suser set name=?,gender=?,age=?,phone=?,address=? where user_id=?";
		String[] params = { user.getUserName(), user.getUserGender(),
				user.getUserAge() + "", user.getUserTelephone(),
				user.getUserAddress(), userId + "" };
		result = this.executeSqlNonQuery(sql, params);
		return result;
	}

	// 根据用户编号删除用户管理页面中相应的用户信息
	public int deleteUserInfoById(int userId) {
		int result = -1;
		String sql = "delete from suser where user_id = ?";
		String[] params = { userId + "" };
		result = this.executeSqlNonQuery(sql, params);
		return result;
	}

	// 获取用户信息的总记录数
	public int getUserInfoTotalCount() {
		int totalCount = 0;
		String sql = "select count(*) from suser ";
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				totalCount = rs.getInt(1);
			}
			return totalCount;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}
		return totalCount;
	}

	// 分页获取用户信息
	public PageSize getUserInfoByPage(int currPage) {
		List<User> userList = new ArrayList<User>();
		PageSize pageSize = new PageSize();
		int totalResult = this.getUserInfoTotalCount();// 用户信息总记录数
		int totalPages = totalResult % PageSize.PAGESIZE == 0 ? totalResult
				/ PageSize.PAGESIZE : (totalResult / PageSize.PAGESIZE) + 1;// 总页数
		int pageNo;
		if (currPage < 1) {
			pageNo = 1;
		} else if (currPage > totalPages) {
			pageNo = totalPages;
		} else {
			pageNo = currPage;
		}
		int currStartPageRow = (pageNo - 1) * PageSize.PAGESIZE;// 当前页的第一条记录的起始行号
		int currEndPageRow = pageNo * PageSize.PAGESIZE;// 当前页最后一条记录所在的行号
		pageSize.setCurrPage(pageNo);
		pageSize.setTotalCount(totalResult);
		pageSize.setTotalPage(totalPages);
		String sql = "select * from (select user_id,name,gender,age,phone,"
				+ "address,permission,rownum rn from suser) a where a.rn>=? and a.rn<?";
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, currStartPageRow);
			ps.setInt(2, currEndPageRow);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("name"));
				user.setUserGender(rs.getString("gender"));
				user.setUserAge(rs.getInt("age"));
				user.setUserTelephone(rs.getString("phone"));
				user.setUserAddress(rs.getString("address"));
				user.setUserPermission(rs.getInt("permission"));
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}
		pageSize.setList(userList);
		return pageSize;
	}

	// 修改用户密码
	public int updateUserPwdInfo(int userId, String userNewPwd) {
		int result = -1;
		String sql = "update suser set password=? where user_id=?";
		String[] params = {userNewPwd,userId+""};
		result = this.executeSqlNonQuery(sql, params);
		return result;
	}
}
