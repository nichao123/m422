package MarketManagementSys.src.com.md.smarket.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.md.smarket.dao.BaseDao;
import com.md.smarket.dao.SupplierDao;
import com.md.smarket.entity.Bill;
import com.md.smarket.entity.PageSize;
import com.md.smarket.entity.Supplier;

public class SupplierDaoImpl extends BaseDao implements SupplierDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	// 向供应商管理中添加数据
	public boolean add(Supplier supplier) {
		int result = -1;
		String sql = "insert into SUPPLIERMANGER values(SUPPLIERMANGER_seq.Nextval,?,?,?,?,?,?)";
		String[] params = { supplier.getSupName(), supplier.getSupDescr(),
				supplier.getSupPer(), supplier.getSupPhone(),
				supplier.getSupFax(), supplier.getSupAddress() };
		result = this.executeSqlNonQuery(sql, params);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	// 根据供应商名称和描述查询供应商信息
	public List<Supplier> findProInfoByProNameAndProDesc(String supName,
			String supDesc) {
		Supplier sup = null;
		List<Supplier> supList = new ArrayList<Supplier>();
		// 供应商描述没有输入
		if (supDesc.length() == 0) {
			String sql = "select sup_id,s_name,s_description,c_perison,phone,c_fax,address from SUPPLIERMANGER where s_name=? order by sup_id";
			try {
				conn = getConn();
				ps = conn.prepareStatement(sql);
				ps.setString(1, supName);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					sup = new Supplier();
					sup.setSupId(rs.getInt("sup_id"));
					sup.setSupName(rs.getString("s_name"));
					sup.setSupDescr(rs.getString("s_description"));
					sup.setSupPer(rs.getString("c_perison"));
					sup.setSupPhone(rs.getString("phone"));
					sup.setSupFax(rs.getString("c_fax"));
					sup.setSupAddress(rs.getString("address"));
					supList.add(sup);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.closeAll(conn, ps, rs);
			}
		}
		// 供应商名称没有输入
		if (supName.length() == 0) {
			String sql1 = "select sup_id,s_name,s_description,c_perison,phone,c_fax,address from SUPPLIERMANGER where s_description=? order by sup_id";
			try {
				conn = getConn();
				ps = conn.prepareStatement(sql1);
				ps.setString(1, supDesc);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					sup = new Supplier();
					sup.setSupId(rs.getInt("sup_id"));
					sup.setSupName(rs.getString("s_name"));
					sup.setSupDescr(rs.getString("s_description"));
					sup.setSupPer(rs.getString("c_perison"));
					sup.setSupPhone(rs.getString("phone"));
					sup.setSupFax(rs.getString("c_fax"));
					sup.setSupAddress(rs.getString("address"));
					supList.add(sup);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.closeAll(conn, ps, rs);
			}
		}
		// 供应商名称和供应商描述均有输入数据
		if (supName.length() != 0 && supDesc.length() != 0) {
			String sql2 = "select sup_id,s_name,s_description,c_perison,phone,c_fax,address from SUPPLIERMANGER where s_name=? and s_description=? order by sup_id";
			try {
				conn = getConn();
				ps = conn.prepareStatement(sql2);
				ps.setString(1, supName);
				ps.setString(2, supDesc);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					sup = new Supplier();
					sup.setSupId(rs.getInt("sup_id"));
					sup.setSupName(rs.getString("s_name"));
					sup.setSupDescr(rs.getString("s_description"));
					sup.setSupPer(rs.getString("c_perison"));
					sup.setSupPhone(rs.getString("phone"));
					sup.setSupFax(rs.getString("c_fax"));
					sup.setSupAddress(rs.getString("address"));
					supList.add(sup);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.closeAll(conn, ps, rs);
			}
		}
		return supList;
	}

	// 根据供应商编号查询供应商信息
	public Supplier findProvideInfoById(int supId) {
		Supplier sup = null;
		String sql = "select sup_id, s_name, s_description,c_perison,phone,c_fax,address from SUPPLIERMANGER  where sup_id= ?";
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, supId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sup = new Supplier();
				sup.setSupId(rs.getInt("sup_id"));
				sup.setSupName(rs.getString("s_name"));
				sup.setSupDescr(rs.getString("s_description"));
				sup.setSupPer(rs.getString("c_perison"));
				sup.setSupPhone(rs.getString("phone"));
				sup.setSupFax(rs.getString("c_fax"));
				sup.setSupAddress(rs.getString("address"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}
		return sup;
	}

	// 获取数据库供应商列表中的全部数据并封装在集合中
	public List<Supplier> getAllSupplierInfo() {
		List<Supplier> supList = new ArrayList<Supplier>();
		String sql = "select sup_id, s_name, s_description,c_perison,phone,c_fax,address  from suppliermanger order by sup_id";
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Supplier sup = new Supplier();
				sup.setSupId(rs.getInt("sup_id"));
				sup.setSupName(rs.getString("s_name"));
				sup.setSupDescr(rs.getString("s_description"));
				sup.setSupPer(rs.getString("c_perison"));
				sup.setSupPhone(rs.getString("phone"));
				sup.setSupFax(rs.getString("c_fax"));
				sup.setSupAddress(rs.getString("address"));
				supList.add(sup);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}
		return supList;
	}

	// 根据供应商编号修改供应商管理页面中的供应商信息
	public int updateProInfo(Supplier sup, int supId) {
		int result = -1;
		String sql = "update SUPPLIERMANGER set s_name=?,s_description=?,c_perison=?,phone=?,c_fax=?,address=? where sup_id=?";
		String[] params = { sup.getSupName(), sup.getSupDescr(),
				sup.getSupPer(), sup.getSupPhone(), sup.getSupFax(),
				sup.getSupAddress(), supId + "" };
		result = this.executeSqlNonQuery(sql, params);
		return result;
	}

	// 根据供应商编号删除供应商管理页面中相应的供应商信息
	public int deleteProInfoById(int supId) {
		int result = -1;
		String sql = "delete from SUPPLIERMANGER where sup_id = ?";
		String[] params = { supId + "" };
		result = this.executeSqlNonQuery(sql, params);
		return result;
	}

	// 获取供应商信息的总记录数
	public int getSupplierTotalCount() {
		int totalCount = 0;
		String sql = "select count(*) from SUPPLIERMANGER ";
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

	// 分页获取供应商信息
	public PageSize getSupplierInfoByPage(int currPage) {
		List<Supplier> supList = new ArrayList<Supplier>();
		PageSize pageSize = new PageSize();
		int totalResult = this.getSupplierTotalCount();// 供应商信息中的总记录数
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
		String sql = "select * from (select sup_id,s_name,s_description,c_perison,phone,c_fax,address,rownum rn"
				+ " from SUPPLIERMANGER) a where a.rn>? and a.rn<=?";
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, currStartPageRow);
			ps.setInt(2, currEndPageRow);
			rs = ps.executeQuery();
			while (rs.next()) {
				Supplier sup = new Supplier();
				sup.setSupId(rs.getInt("sup_id"));
				sup.setSupName(rs.getString("s_name"));
				sup.setSupDescr(rs.getString("s_description"));
				sup.setSupPer(rs.getString("c_perison"));
				sup.setSupPhone(rs.getString("phone"));
				sup.setSupFax(rs.getString("c_fax"));
				sup.setSupAddress(rs.getString("address"));
				supList.add(sup);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}
		pageSize.setList(supList);
		return pageSize;
	}

}
