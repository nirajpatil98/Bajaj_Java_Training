package com.bajaj.icons.bean;


public class EmployeeBean {
	private int eid;
	private String name;
	private int salary;
	public EmployeeBean()
	{
		super();
	}
	public EmployeeBean(int eid, String name, int salary) {
		super();
		this.eid = eid;
		this.name = name;
		this.salary = salary;
	}
	public int geteid() {
		return eid;
	}
	public void init()
	{
		System.out.println("In init");
	}
	public void destroy()
	{
		System.out.println("In destroy");
	}
	public void seteid(int eid) {
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
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", salary=" + salary + "]\n";
	}
}
