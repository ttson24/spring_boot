package com.spring.boot.crud.learn.repository.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.crud.learn.entity.Employees;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    EntityManager manager;
    
    
    @Override
    public List<Employees> findAll() {
	
	String strQuery = " FROM Employees WHERE deleted_at <> null";
	TypedQuery<Employees> queryResult = manager.createQuery(strQuery, Employees.class);
	return queryResult.getResultList();
    }

    @Override
    public Employees findById(int id) {
	
	return manager.find(Employees.class, id);
    }

    @Override
    public Employees findByName(String name) {
	
	String strQuery ="FROM Employees WHERE firstName=:name OR lastName=:name";
	TypedQuery<Employees> queryResult = manager.createQuery(strQuery, Employees.class);
	queryResult.setParameter("name", name);
	return queryResult.getSingleResult();
    }

    @Override
    @Transactional
    public int save(Employees emp) {
	int result = 0;
	try {
	    manager.persist(emp);
	}catch (Exception e) {
	    result = -1;
	}
	return result;
    }

    @Override
    @Transactional
    public int udate(Employees emp) {
	int result =0;
	try {
	    manager.merge(emp);
	}catch (Exception e) {
	    result = -1;
	}
	return result;
    }

    @Override
    @Transactional
    public int delete(int id) {
	int result = 0;
	try {
	    Employees delEmp =  manager.find(Employees.class, id);
	    manager.detach(delEmp);
	}catch (Exception e) {
	    result = -1;
	}
	return result;
    }

    @Override
    @Transactional
    public int deleteAll() {
	int result =0;
	String strQuery ="DELETE FROM Emplaoyees";
	result = manager.createQuery(strQuery, Employees.class).executeUpdate();
	try{
	    
	}catch (Exception e) {
	    result = -1;
	}
	return result;
    }

}
