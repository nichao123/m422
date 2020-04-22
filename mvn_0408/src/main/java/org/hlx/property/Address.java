package org.hlx.property;

public class Address {
	private String addr = "杭州市萧山区..";

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Address [addr=" + addr + "]";
	}
	
	

}
