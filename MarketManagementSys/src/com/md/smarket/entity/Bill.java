package MarketManagementSys.src.com.md.smarket.entity;

public class Bill {
	private int billId;// 账单编号
	private String comName;// 商品名称
	private int tranMoney;// 交易金额
	private String tranUnit;// 交易单位
	private String tranDate;// 交易时间
	private int tranAmount;// 交易数量
	private String comDiscription;// 商品描述
	private String ifPayment;// 是否付款
	private String belongSupply;// 所属供应商

	public String getBelongSupply() {
		return belongSupply;
	}

	public void setBelongSupply(String belongSupply) {
		this.belongSupply = belongSupply;
	}

	public String getIfPayment() {
		return ifPayment;
	}

	public void setIfPayment(String ifPayment) {
		this.ifPayment = ifPayment;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public int getTranMoney() {
		return tranMoney;
	}

	public void setTranMoney(int tranMoney) {
		this.tranMoney = tranMoney;
	}

	public String getTranUnit() {
		return tranUnit;
	}

	public void setTranUnit(String tranUnit) {
		this.tranUnit = tranUnit;
	}

	public int getTranAmount() {
		return tranAmount;
	}

	public void setTranAmount(int tranAmount) {
		this.tranAmount = tranAmount;
	}

	public String getComDiscription() {
		return comDiscription;
	}

	public void setComDiscription(String comDiscription) {
		this.comDiscription = comDiscription;
	}

	public String getTranDate() {
		return tranDate;
	}

	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}

}
