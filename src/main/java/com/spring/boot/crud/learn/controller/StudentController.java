package com.spring.boot.crud.learn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.boot.crud.learn.constant.Constant;
import com.spring.boot.crud.learn.dto.student.StudentDto;
import com.spring.boot.crud.learn.service.student.StudentService;

@Controller
public class StudentController {

    private StudentService svStudent;
    
    public StudentController(StudentService sv) {
	this.svStudent = sv;
    }
    @GetMapping("/student")
    public String index(Model model) {
	
	List<StudentDto> lstStudent = new ArrayList<StudentDto>();
	lstStudent = this.svStudent.findAll();
	model.addAttribute("lstStudent", lstStudent);
	return Constant.STUDENT_LIST;
    }
    
}
