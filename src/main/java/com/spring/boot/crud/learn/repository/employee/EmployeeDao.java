package com.spring.boot.crud.learn.repository.employee;

import java.util.List;

import com.spring.boot.crud.learn.entity.Employees;

public interface EmployeeDao {

    public List<Employees> findAll();
    
    public Employees findById(int id);
    
    public Employees findByName(String name);
    
    public int save(Employees emp);
    
    public int udate(Employees emp);
    
    public int delete(int id);
    
    public int deleteAll();
}
