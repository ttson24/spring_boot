package com.spring.boot.crud.learn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.boot.crud.learn.constant.Constant;
import com.spring.boot.crud.learn.entity.TodoEntity;

@Controller
public class TodoController {

    	List<TodoEntity> lstTodo = new ArrayList<>();
    
	@GetMapping("/todo")
	public String index(Model model) {
	    model.addAttribute("lstTodo", lstTodo);
	    return Constant.TODO_LIST;
	}
	
	@GetMapping("/todo-add")
	public String add(Model model) {
	    model.addAttribute("todo", new TodoEntity());
	    return Constant.TODO_ADD;
	}
	
	@PostMapping("/todo-add")
	public String add(@ModelAttribute TodoEntity todo, Model model) {
	    try {
		lstTodo.add(todo);
		model.addAttribute("msgContent", "New Todo Is Added");
		model.addAttribute("msgLink", "/todo");
		return Constant.SUCCESS;
	    }catch (Exception e) {
		model.addAttribute("msgContent", "New Todo Is Unsuccess");
		model.addAttribute("msgLink", "/todo");
		return Constant.ERROR;
	    }
	    
	}
	@DeleteMapping("/todo-del")
	public void delete(@ModelAttribute TodoEntity todo) {
	    lstTodo.remove(todo);
	}
}
