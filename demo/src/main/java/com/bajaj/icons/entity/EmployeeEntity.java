package com.bajaj.icons.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeEntity {
	@Id
	private int eid;
	private String name;
	private int salary;
	public EmployeeEntity()
	{
		super();
	}
	public EmployeeEntity(int eid, String name, int salary) {
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
