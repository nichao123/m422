package org.hlx.pojo;

import org.hlx.property.Address;

/**
 * 给学生类属性赋值 1)setXXX（）方法
 * 
 * @author Administrator
 * 
 */
public class Student {
	private String name;
	private String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", sex='" + sex + '\'' +
				'}';
	}
}
