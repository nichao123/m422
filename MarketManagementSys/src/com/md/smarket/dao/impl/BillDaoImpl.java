package MarketManagementSys.src.com.md.smarket.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.md.smarket.dao.BaseDao;
import com.md.smarket.dao.BillDao;
import com.md.smarket.entity.Bill;
import com.md.smarket.entity.PageSize;

public class BillDaoImpl extends BaseDao implements BillDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	// 账单管理中添加数据
	public boolean add(Bill bill) {
		int result = -1;
		String sql = "insert into billmanagement values(billmanagement_seq.nextval,?,?,?,sysdate,?,?,?,?)";
		String[] params = { bill.getComName(), bill.getTranMoney() + "",
				bill.getTranUnit(), bill.getTranAmount() + "",
				bill.getComDiscription(), bill.getIfPayment(),
				bill.getBelongSupply() };
		result = this.executeSqlNonQuery(sql, params);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	// 根据账单编号查询账单管理页面中的账单信息
	public Bill findBillInfoById(int billId) {
		Bill bill = null;
		String sql = "select bill_id,commody_name,tran_money,tran_unit,tran_amount,ifpayment,commody_disc,belongsupply from  billmanagement  where bill_id= ?";
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, billId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bill = new Bill();
				bill.setBillId(rs.getInt("bill_id"));
				bill.setComName(rs.getString("commody_name"));
				bill.setTranMoney(rs.getInt("tran_money"));
				bill.setTranUnit(rs.getString("tran_unit"));
				bill.setTranAmount(rs.getInt("tran_amount"));
				bill.setIfPayment(rs.getString("ifpayment"));
				bill.setComDiscription(rs.getString("commody_disc"));
				bill.setBelongSupply(rs.getString("belongsupply"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}
		return bill;
	}

	// 账单管理中根据商品名称和付款状态查询当前账单信息
	public List<Bill> findBillInfoByNameandIfPay(String commodyName, int ifPay) {
		Bill bill = null;
		List<Bill> billList = new ArrayList<Bill>();
		// 未输入商品名称，只根据付款方式进行查询
		if (commodyName.length() == 0) {
			String sqlPay1 = "select *from billmanagement where ifpayment=? ";
			try {
				conn = getConn();
				ps = conn.prepareStatement(sqlPay1);
				String choosePay = null;
				if (ifPay == 1) {
					choosePay = "是";
				} else if (ifPay == 2) {
					choosePay = "否";
				}
				ps.setString(1, choosePay);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					bill = new Bill();
					bill.setIfPayment(choosePay);
					bill.setBillId(rs.getInt("bill_id"));
					bill.setComName(rs.getString("commody_name"));
					bill.setTranMoney(rs.getInt("tran_money"));
					bill.setTranUnit(rs.getString("tran_unit"));
					Date date = rs.getDate("tran_date");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String dateStr = sdf.format(date);
					bill.setTranDate(dateStr);
					bill.setTranAmount(rs.getInt("tran_amount"));
					bill.setComDiscription(rs.getString("commody_disc"));
					bill.setBelongSupply(rs.getString("belongsupply"));
					billList.add(bill);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.closeAll(conn, ps, rs);
			}
		}
		// 付款方式未选择,至根据商品名称查询
		if (ifPay == 0) {
			String sql = "select bill_id,commody_name,tran_money,tran_unit,tran_date,tran_amount,ifpayment,commody_disc,belongsupply "
					+ "from billmanagement where commody_name=? order by bill_id";
			try {
				conn = getConn();
				ps = conn.prepareStatement(sql);
				ps.setString(1, commodyName);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					bill = new Bill();
					bill.setBillId(rs.getInt("bill_id"));
					bill.setComName(rs.getString("commody_name"));
					bill.setTranMoney(rs.getInt("tran_money"));
					bill.setTranUnit(rs.getString("tran_unit"));
					Date date = rs.getDate("tran_date");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String dateStr = sdf.format(date);
					bill.setTranDate(dateStr);
					bill.setIfPayment("否");
					bill.setTranAmount(rs.getInt("tran_amount"));
					bill.setComDiscription(rs.getString("commody_disc"));
					bill.setBelongSupply(rs.getString("belongsupply"));
					billList.add(bill);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.closeAll(conn, ps, rs);
			}
		}
		// 根据商品名称和已付款为条件进行查询
		if (ifPay == 1) {
			String sql1 = "select *from billmanagement where commody_name=? and ifpayment='是'";
			try {
				conn = getConn();
				ps = conn.prepareStatement(sql1);
				ps.setString(1, commodyName);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					bill = new Bill();
					bill.setBillId(rs.getInt("bill_id"));
					bill.setComName(rs.getString("commody_name"));
					bill.setTranMoney(rs.getInt("tran_money"));
					bill.setTranUnit(rs.getString("tran_unit"));
					Date date = rs.getDate("tran_date");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String dateStr = sdf.format(date);
					bill.setIfPayment("是");
					bill.setTranDate(dateStr);
					bill.setTranAmount(rs.getInt("tran_amount"));
					bill.setComDiscription(rs.getString("commody_disc"));
					bill.setBelongSupply(rs.getString("belongsupply"));
					billList.add(bill);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.closeAll(conn, ps, rs);
			}

		}
		// 根据商品名称和未付款为条件查询
		if (ifPay == 2) {
			String sql2 = "select *from billmanagement where commody_name=? and ifpayment='否'";
			try {
				conn = getConn();
				ps = conn.prepareStatement(sql2);
				ps.setString(1, commodyName);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					bill = new Bill();
					bill.setBillId(rs.getInt("bill_id"));
					bill.setComName(rs.getString("commody_name"));
					bill.setTranMoney(rs.getInt("tran_money"));
					bill.setTranUnit(rs.getString("tran_unit"));
					Date date = rs.getDate("tran_date");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String dateStr = sdf.format(date);
					bill.setIfPayment("否");
					bill.setTranDate(dateStr);
					bill.setTranAmount(rs.getInt("tran_amount"));
					bill.setComDiscription(rs.getString("commody_disc"));
					bill.setBelongSupply(rs.getString("belongsupply"));
					billList.add(bill);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.closeAll(conn, ps, rs);
			}
		}
		return billList;
	}

	// 获取数据库账单表中的全部数据封装在集合中
	public List<Bill> getAllBillsInfo() {
		List<Bill> billList = new ArrayList<Bill>();
		String sql = "select bill_id, commody_name, tran_amount,tran_money,ifpayment,belongsupply,commody_disc,tran_date  from billmanagement order by bill_id";
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bill bill = new Bill();
				bill.setBillId(rs.getInt("bill_id"));
				bill.setComName(rs.getString("commody_name"));
				bill.setTranAmount(rs.getInt("tran_amount"));
				bill.setTranMoney(rs.getInt("tran_money"));
				bill.setIfPayment(rs.getString("ifpayment"));
				bill.setBelongSupply(rs.getString("belongsupply"));
				bill.setComDiscription(rs.getString("commody_disc"));
				bill.setTranDate(rs.getString("tran_date"));
				billList.add(bill);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}
		return billList;
	}

	// 根据账单编号修改账单管理页面中的账单信息
	public int updateBillInfo(Bill bill, int billId) {
		int result = -1;
		String sql = "update billmanagement set commody_name=?,tran_money=?,tran_unit=?,tran_amount=?,ifpayment=?,commody_disc=?,belongsupply=? where bill_id=?";
		String[] params = { bill.getComName(), bill.getTranMoney() + "",
				bill.getTranUnit(), bill.getTranAmount() + "",
				bill.getIfPayment(), bill.getComDiscription(),
				bill.getBelongSupply(), billId + "" };
		result = this.executeSqlNonQuery(sql, params);
		return result;
	}

	// 根据账单编号删除账单管理页面中相应的账单信息
	public int deleteBillInfo(int billId) {
		int result = -1;
		String sql = "delete from billmanagement where bill_id = ?";
		String[] params = { billId + "" };
		result = this.executeSqlNonQuery(sql, params);
		return result;
	}

	// 获取账单信息的总记录数
	public int getTotalCount() {
		int totalCount = 0;
		String sql = "select count(*) from billmanagement ";
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

	/*
	 * 分页获取账单信息
	 */
	public PageSize getPageBillInfo(int currPage) {
		List<Bill> billList = new ArrayList<Bill>();
		PageSize pageSize = new PageSize();
		int totalResult = this.getTotalCount();// 账单信息中的总记录数
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
		String sql = "select bill_id, commody_name, tran_money,tran_unit,tran_date,tran_amount,ifpayment,commody_disc,belongsupply"
				+ " from (select bill_id, commody_name, tran_money,tran_unit,tran_date,tran_amount,ifpayment,commody_disc,belongsupply,rownum rn "
				+ "from billmanagement) a where rn >? and rn <= ?";
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, currStartPageRow);
			ps.setInt(2, currEndPageRow);
			rs = ps.executeQuery();
			while (rs.next()) {
				int billId = rs.getInt("bill_id");
				String comName = rs.getString("commody_name");
				int money = rs.getInt("tran_money");
				String unit = rs.getString("tran_unit");
				Date date = rs.getDate("tran_date");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String tranDate = sdf.format(date);
				int amount = rs.getInt("tran_amount");
				String ifPay = rs.getString("ifpayment");
				String dis = rs.getString("commody_disc");
				String belSupply = rs.getString("belongsupply");
				Bill bill = new Bill();
				bill.setBillId(billId);
				bill.setComName(comName);
				bill.setTranUnit(unit);
				bill.setTranMoney(money);
				bill.setTranDate(tranDate);
				bill.setComDiscription(dis);
				bill.setBelongSupply(belSupply);
				bill.setTranAmount(amount);
				bill.setIfPayment(ifPay);
				billList.add(bill);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, ps, rs);
		}
		pageSize.setList(billList);
		return pageSize;

	}

}
