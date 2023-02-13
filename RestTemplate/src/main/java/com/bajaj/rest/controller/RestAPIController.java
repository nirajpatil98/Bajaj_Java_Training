package com.bajaj.rest.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bajaj.rest.entity.EmployeeBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestAPIController {


    
	public static RestTemplate restTemplate1 = new RestTemplate();
    @GetMapping("/getEmployees")
    public static List<EmployeeBean> getEmployees() {
    	  RestTemplate restTemplate = new RestTemplate();
    	  String resourceUrl = "http://localhost:8080/allEmployees";

         ResponseEntity<List> response = restTemplate.getForEntity(resourceUrl, List.class);
        
         List<EmployeeBean> result = response.getBody();
    	return result;
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody EmployeeBean employeeBean) {
    	RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<EmployeeBean> entity = new HttpEntity<EmployeeBean>(employeeBean, headers);

        return restTemplate.exchange("http://localhost:8080/employeeAdd", HttpMethod.POST, entity, String.class).getBody();
        
        
        
    }

    @DeleteMapping("/deleteEmployee/{eid}")
    public String deleteEmployee(@PathVariable(value = "eid") int eid) {
    	RestTemplate restTemplate = new RestTemplate();
    	String url = "http://localhost:8080/deleteId/{eid}";
    	Map<String, String> params = new HashMap<String,String>();
    	params.put("eid", eid+"");
    	restTemplate1.delete(url,params);
    	return "Employee Deleted";
    }
    @PutMapping("/updateEmployee/{eid}")
    public List<EmployeeBean> updateEmployee(@PathVariable(value = "eid") int eid)
    {
    	RestTemplate restTemplate = new RestTemplate();
    	String url = "http://localhost:8080/deleteId/{eid}";
		return null;
    }
}