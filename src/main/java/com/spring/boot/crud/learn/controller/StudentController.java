package com.spring.boot.crud.learn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boot.crud.learn.constant.Constant;
import com.spring.boot.crud.learn.dto.student.StudentDto;
import com.spring.boot.crud.learn.entity.Students;
import com.spring.boot.crud.learn.service.student.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService svStudent;
    
    @GetMapping("/student")
    public String index(Model model) {
	
	List<StudentDto> lstStudent = new ArrayList<StudentDto>();
	lstStudent = this.svStudent.findAll();
	model.addAttribute("lstStudent", lstStudent);
	return Constant.STUDENT_LIST;
    }
    
    @GetMapping("student-add")
    public String save(Model model) {
	model.addAttribute("student", new Students());
	return Constant.STUDENT_ADD;
    }
    
    @PostMapping("/student-add")
    public String save(@ModelAttribute StudentDto student, Model model) {
	int result = this.svStudent.save(student);
	model.addAttribute("msgLink", "/student");
	if(result != -1) {
	    model.addAttribute("msgContent", "New student is added");
	    return Constant.SUCCESS;
	}
	model.addAttribute("msgContent", "New student is not added");
	return Constant.ERROR;
    }
    
    @GetMapping("/student-edit")
    public String edit(@RequestParam("id") Integer id, Model model) {
	
	StudentDto dto = new StudentDto();
	dto = this.svStudent.findById(id);
	model.addAttribute("student", dto);
	return Constant.STUDENT_EDIT;
    }
    
    @PostMapping("student-edit")
    public String edit(@ModelAttribute StudentDto student, Model model) {
	
	this.svStudent.update(student);
	return Constant.REDIRECT + "student";
    }
    
    @GetMapping("/student-del")
    public String del(@RequestParam("id") Integer id, Model model) {
	this.svStudent.delete(id);
	return Constant.REDIRECT + "student";
    }
}
