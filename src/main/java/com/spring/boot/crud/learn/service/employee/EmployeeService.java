package com.spring.boot.crud.learn.service.employee;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.boot.crud.learn.dto.employee.EmployeeDto;
import com.spring.boot.crud.learn.entity.Employees;
import com.spring.boot.crud.learn.repository.employee.EmployeeDao;

@Service
public class EmployeeService {
    
    @Autowired
    EmployeeDao repo;
    
    public List<EmployeeDto> findAll(){
	
	List<EmployeeDto> lstEmployeeDtos = new ArrayList<EmployeeDto>();
	
	List<Employees> lstEmployee = this.repo.findAll();
	
	lstEmployee.forEach(emp->{
	    EmployeeDto dto = new EmployeeDto();
	    BeanUtils.copyProperties(emp, dto);
	    lstEmployeeDtos.add(dto);
	});
	return lstEmployeeDtos;
    }
    
    public EmployeeDto findById(int id) {
	
	Employees emp = this.repo.findById(id);
	EmployeeDto dto = new EmployeeDto();
	BeanUtils.copyProperties(emp, dto);
	return dto;
    }
    
    public EmployeeDto findByName(String name) {
	Employees emp = this.repo.findByName(name);
	EmployeeDto dto = new EmployeeDto();
	BeanUtils.copyProperties(emp, dto);
	return dto;
    }
    
    public int save(EmployeeDto dto) {
	Employees emp = new Employees();
	BeanUtils.copyProperties(dto, emp);
	return this.repo.save(emp);
    }
    
    public int update(EmployeeDto dto) {
	Employees emp = new Employees();
	BeanUtils.copyProperties(dto, emp);
	return this.repo.udate(emp);
    }
    
    public int delete(int id) {
	return this.repo.delete(id);
    }
    
    public int deleteAll() {
	return this.repo.deleteAll();
    }
}
