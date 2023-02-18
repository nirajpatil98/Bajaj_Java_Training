package com.feign.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feign.beans.EmployeeBean;
import com.feign.client.UserClient;
@RestController
public class feignController {
	@Autowired
	private UserClient userClient;
	
	@GetMapping("/findAll")
	public ResponseEntity<?> getAllUserInfo(){
		Collection<EmployeeBean> map = userClient.getAllUserInfo();
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
