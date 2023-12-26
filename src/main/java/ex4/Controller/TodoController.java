package ex4.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ex4.Controller.interfaces.TodoDto;
import ex4.Model.Todo;
import ex4.Service.TodoService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/todo")
public class TodoController {
	@Autowired
	TodoService todoService;

	@GetMapping("")
	public List<TodoDto> getAllTodo() {
		return this.todoService.getAllTodo();
	}

}
