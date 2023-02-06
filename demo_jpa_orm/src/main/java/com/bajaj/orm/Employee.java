package com.bajaj.orm;
import javax.persistence.*;  

@Entity  
@Table(name="employee")  
public class Employee {
	@Id
	private int eId;
	private String name;
	private int salary;
	public Employee() 
	{
		super();
	}
	public Employee(int eId, String name, int salary) {
		super();
		this.eId = eId;
		this.name = name;
		this.salary = salary;
	}
	public int geteId() {
		return eId;
	}
	public void init()
	{
		System.out.println("In init");
	}
	public void destroy()
	{
		System.out.println("In destroy");
	}
	public void seteId(int eId) {
		this.eId = eId;
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
		return "Employee [eId=" + eId + ", name=" + name + ", salary=" + salary + "]";
	}

}
