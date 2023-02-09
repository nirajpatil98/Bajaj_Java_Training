package com.bajaj.icons.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bajaj.icons.bean.EmployeeBean;
import com.bajaj.icons.entity.EmployeeEntity;

public class EmployeeDaoImpl {
	@Autowired
	private EmployeeDao employeeDao;
	public String addEmployee()
	{
		EmployeeEntity employeeEntity = new EmployeeEntity(179,"Vedant",789);
		employeeDao.save(employeeEntity);
		return "Added";
	}
	public String searchEmployee()
	{
		
		Optional<EmployeeEntity> val = employeeDao.findById(105);
		if(val.isPresent())
		{
			return val+"";
		}
			
		return "Not Found";
		
	}
	public String deleteEmployee()
	{
		employeeDao.deleteById(185);
		return "Deleted the entry";
	}
	public String updateEmployee()
	{
		EmployeeEntity employeeEntity = new EmployeeEntity(189,"Rajesh",987);
		employeeDao.save(employeeEntity);
		return "Updated Successfully";
		
	}
	public List<EmployeeEntity> allEmployee() {
		List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();
		employeeDao.findAll().forEach(EmployeeEntity->list.add(EmployeeEntity));
		return list;
	}
	public void add(int id, String name, int salary) {
		EmployeeEntity employeeEntity = new EmployeeEntity(id,name,salary);
		employeeDao.save(employeeEntity);
	}
	public String getEmpById(int eid) {
		
		var found = employeeDao.findById(eid);
		return found + "";
	}
	public void addEmployee(EmployeeBean emp) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(emp,employeeEntity);
		employeeDao.save(employeeEntity);
	}
	public String deleteEmpById(int eid) {
		employeeDao.deleteById(eid);
		return "deleted";
	}
	public Collection<EmployeeBean> getAll() {
		List<EmployeeEntity> list = employeeDao.findAll();
		List<EmployeeBean> list1 = new ArrayList<>();
		list.forEach(x->{
			EmployeeBean employeeBean = new EmployeeBean();
			BeanUtils.copyProperties(x,employeeBean);
			list1.add(employeeBean);
		});
		return list1;
	}

	public String updateEmp(int eid,EmployeeBean employeeBean) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeBean, employeeEntity);
		employeeDao.save(employeeEntity);
		return "Updated";
	}
}