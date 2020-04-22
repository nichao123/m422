package MarketManagementSys.src.com.md.smarket.entity;

public class Supplier {
	private int supId; //供应商编号
	private String supName;//供应商名称
	private String supDescr;//供应商描述
	private String supPer;//供应商联系人
	private String supPhone;//供应商电话
	private String supFax;//供应商传真
	private String supAddress;//供应商地址

	public int getSupId() {
		return supId;
	}

	public void setSupId(int supId) {
		this.supId = supId;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getSupDescr() {
		return supDescr;
	}

	public void setSupDescr(String supDescr) {
		this.supDescr = supDescr;
	}

	public String getSupPer() {
		return supPer;
	}

	public void setSupPer(String supPer) {
		this.supPer = supPer;
	}

	public String getSupPhone() {
		return supPhone;
	}

	public void setSupPhone(String supPhone) {
		this.supPhone = supPhone;
	}

	public String getSupFax() {
		return supFax;
	}

	public void setSupFax(String supFax) {
		this.supFax = supFax;
	}

	public String getSupAddress() {
		return supAddress;
	}

	public void setSupAddress(String supAddress) {
		this.supAddress = supAddress;
	}

}
