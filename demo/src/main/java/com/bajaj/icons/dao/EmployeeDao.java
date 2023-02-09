package com.bajaj.icons.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bajaj.icons.entity.EmployeeEntity;
@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer>{

}
