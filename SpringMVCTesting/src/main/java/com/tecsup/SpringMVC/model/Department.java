package com.tecsup.SpringMVC.model;

public class Department {

	String name;
	String desc;
	int departmentId;
	String city;
	
	
	
	
	
	/**
	 * 
	 * @param login
	 * @param name
	 * @param desc
	 * @param city
	 */
	
	public Department(String name, String desc, String city) {
		super();
		this.name = name;
		this.desc = desc;
		this.city = city;
	}

	public Department() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentID) {
		this.departmentId = departmentID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	@Override
	public String toString() {
		return "Department [name=" + name + ", desc=" + desc + ", departmentId=" + departmentId + ", city="
				+ city + "]";
	}


}
