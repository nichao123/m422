package MarketManagementSys.src.com.md.smarket.entity;

import java.util.List;

public class PageSize {
	public static final int PAGESIZE = 5;// 每页显示5条
	private int totalPage;// 总页数
	private int totalCount;// 总记录数
	private int currPage;// 当前页码
	private List list;// 当前页下的数据集合

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
