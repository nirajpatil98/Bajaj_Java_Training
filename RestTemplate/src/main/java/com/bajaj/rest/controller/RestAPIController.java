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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bajaj.rest.entity.EmployeeBean;

import java.util.Arrays;

@RestController
public class RestAPIController {


    private static RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/getEmployees")
    public static ResponseEntity<String> getEmployees() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> result = restTemplate.exchange("http://localhost:8080/allEmployees", HttpMethod.GET, entity, String.class);
        return result;
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody EmployeeBean employeeData) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<EmployeeBean> entity = new HttpEntity<EmployeeBean>(employeeData, headers);

        return restTemplate.exchange("http://localhost:8080/employeeAdd", HttpMethod.POST, entity, String.class).getBody();

    }

    @DeleteMapping("/deleteEmployee/{eid}")
    public Integer deleteEmployee(@PathVariable("eid") Integer eid) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<EmployeeBean> entity = new HttpEntity<EmployeeBean>(headers);

        return restTemplate.exchange("http://localhost:8080/deleteId/{eid}", HttpMethod.DELETE, entity, Integer.class).getBody();

    }
}
