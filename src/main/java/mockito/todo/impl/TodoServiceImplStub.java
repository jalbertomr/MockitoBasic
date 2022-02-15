package mockito.todo.impl;

import java.util.Arrays;
import java.util.List;

import mockito.todo.TodoService;

public class TodoServiceImplStub implements TodoService {

	public List<String> retiveTodos(String user) {
		return Arrays.asList("Learn Spring MVC","Learn Spring","Learn Dance");
	}

	public void deleteTodo(String todo) {
	}
}
