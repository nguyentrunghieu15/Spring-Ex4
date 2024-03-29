package ex4.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex4.Controller.interfaces.TodoDto;
import ex4.Model.Todo;
import ex4.Repository.TodoRepository;

@Service
public class TodoService {
	@Autowired
	TodoRepository todoRepository;

	public List<TodoDto> getAllTodo() {
		return this.todoRepository.findBy();
	}
}
