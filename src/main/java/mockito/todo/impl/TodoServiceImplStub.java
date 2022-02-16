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
	
	//This private method can not be mocked because private is not seen
	private List<String> privateRetriveTodos(String user){
		return Arrays.asList("1 from private method","1 from private method","1 from private method");
	}
	
	//This final method can not be mocked because private is not seen
	final public void finalDeleteTodo(String user) {
		
	}
	
	static public String staticRetrieveATodo(String user) {
		return "OriginalStaticTodo";
	}
}
