package com.spring.boot.crud.learn.repository.student;

import java.util.List;

import com.spring.boot.crud.learn.entity.Students;

public interface StudentDao {
    
    int save(Students student);
    
    Students findById(Integer id);
    
    Students findByName(String name);
    
    List<Students> findAll();
    
    int update(Students student);
    
    int delete(int id);
    
    int deleteAll();

}
