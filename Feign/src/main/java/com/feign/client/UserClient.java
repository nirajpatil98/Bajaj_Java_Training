package com.feign.client;

import java.util.Collection;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.feign.beans.EmployeeBean;

@FeignClient(url = "http://localhost:8791/employee",name = "EMPLOYEE-SERVICE")
public interface UserClient {
	@GetMapping(value = "/allEmployees")
	public Collection<EmployeeBean> getAllUserInfo();
}