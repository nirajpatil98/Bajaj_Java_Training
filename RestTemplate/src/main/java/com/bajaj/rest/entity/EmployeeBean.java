package com.bajaj.rest.entity;


public class EmployeeBean {
    
	private int eid;
    private String name;
    private int salary;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public EmployeeBean(int eid, String name, int salary) {
		super();
		this.eid = eid;
		this.name = name;
		this.salary = salary;
	}
	public EmployeeBean() {
		super();
	}
	@Override
	public String toString() {
		return "EmployeeBean [eid=" + eid + ", name=" + name + ", salary=" + salary + "]";
	}
    

}
