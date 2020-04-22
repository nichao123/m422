package org.hlx.property;

/**
 * 给学生类属性赋值 1)setXXX（）方法
 * 
 * @author Administrator
 * 
 */
public class Student {
	private String name;
	private String sex;
	private Integer age;
	private Double money;
	//引用类型
	private Address address;

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + ", age=" + age
				+ ", money=" + money + ", address=" + address + "]";
	}

	

}
