package com.springrest.TodoApp.Todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	
	private TodoService todoservice;

	public TodoController(TodoService todoservice) {
		super();
		this.todoservice = todoservice;
	}
	
	@GetMapping("/list")
	private String listAllTodos(ModelMap model) {
		List<Todo> todos = todoservice.findByUsername("kunal");
		model.put("todos", todos);
		return "listTodos";
	}
}
