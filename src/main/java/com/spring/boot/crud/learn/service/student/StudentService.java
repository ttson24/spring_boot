package com.spring.boot.crud.learn.service.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.spring.boot.crud.learn.dto.student.StudentDto;
import com.spring.boot.crud.learn.entity.Students;
import com.spring.boot.crud.learn.repository.student.StudentDao;

@Service
public class StudentService {

    // initial repository
    private StudentDao repo;
    // create constructor of service and initial repository
    public StudentService(StudentDao dao) {
	this.repo = dao;
    }
    
    public List<StudentDto> findAll(){
	List<Students> lstStudent = new ArrayList<Students>();
	lstStudent = this.repo.findAll();
	List<StudentDto> lstStudentDto = new ArrayList<StudentDto>();
	lstStudent.forEach(student->{
	    StudentDto dto = new StudentDto();
	    BeanUtils.copyProperties(student,dto);
	    lstStudentDto.add(dto);
	});
	return lstStudentDto;
    }
    
    //save student to database
    public int save(StudentDto student) {
	Students entity = new Students();
	BeanUtils.copyProperties(student, entity);
	return this.repo.save(entity);
    }
    
    // find student with id
    public StudentDto findById(int id) {
	Students entity = new Students();
	entity = this.repo.findById(id);
	
	StudentDto dto = new StudentDto();
	BeanUtils.copyProperties(entity, dto);
	
	return dto;
    }
    
    // find student with name
    public StudentDto findByName(String name) {
	Students entity = new Students();
	entity = this.repo.findByName(name);
	
	StudentDto dto = new StudentDto();
	BeanUtils.copyProperties(entity, dto);
	
	return dto;
    }
    
    //update student with id
    public int update(StudentDto dto) {
	Students student = new Students();
	BeanUtils.copyProperties(dto, student);
	return this.repo.update(student);
    }
    
    //delete student with id
    public int delete(int id) {
	return this.repo.delete(id);
    }
    
    //delete all student
    public int deleteAll() {
	return this.repo.deleteAll();
    }
}
