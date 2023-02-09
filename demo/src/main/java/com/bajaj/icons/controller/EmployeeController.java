package com.bajaj.icons.controller;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.bajaj.icons.bean.EmployeeBean;
import com.bajaj.icons.dao.EmployeeDaoImpl;
import com.bajaj.icons.entity.EmployeeEntity;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeDaoImpl employeeDaoImpl;
	
	@GetMapping("add")
	public String add()
	{
		String message = employeeDaoImpl.addEmployee();
		return message;
	}
	@GetMapping("search")
	public String search()
	{
		String message = employeeDaoImpl.searchEmployee();
		return message;
	}
	@PostMapping(value="/employeeAdd")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeBean emp)
	{
		employeeDaoImpl.addEmployee(emp);
		return new ResponseEntity<String>("Data Entered",HttpStatus.OK);
		
	}

	@GetMapping(value="/find/{eid}")
	public ResponseEntity<String> getEmployeeById(@PathVariable int eid)
	{
		 String message = employeeDaoImpl.getEmpById(eid);
		 return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	@GetMapping(value = "/allEmployees")
	public @ResponseBody ResponseEntity<Collection<EmployeeBean>> getAll()
	{
		Collection<EmployeeBean> list = employeeDaoImpl.getAll();
		return new ResponseEntity<Collection<EmployeeBean>>(list, HttpStatus.OK);
	}
	@PutMapping(value = "/update/{eid}")
	public ResponseEntity<String> updateById(@PathVariable int eid,@RequestBody EmployeeBean employeeBean)
	{
		String message = employeeDaoImpl.updateEmp(eid,employeeBean);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	@DeleteMapping(value="/deleteId/{eid}")
	public @ResponseBody ResponseEntity<String> deleteById(@PathVariable int eid)
	{
		String message = employeeDaoImpl.deleteEmpById(eid);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@GetMapping("delete")
	public String delete()
	{
		String message = employeeDaoImpl.deleteEmployee();
		return message;
	}
	@GetMapping("update")
	public String update()
	{
		String message = employeeDaoImpl.updateEmployee();
		return message;
	}
	@GetMapping("allemployee")
	public List<EmployeeEntity> allEmployee()
	{
		List<EmployeeEntity> list = employeeDaoImpl.allEmployee();
		return list;
		
	}
	
}