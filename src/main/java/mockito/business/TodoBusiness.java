package mockito.business;

import java.util.ArrayList;
import java.util.List;

import mockito.todo.TodoService;

public class TodoBusiness {
   private TodoService todoService;

   public TodoBusiness(TodoService todoService) {
	this.todoService = todoService;
   }

   public List<String> retrieveTodosRelatedToSpring(String user){
	   List<String> filteredTodos = new ArrayList<String>();
	   List<String> allTodos = todoService.retiveTodos(user);
	   for( String todo: allTodos) {
		   if (todo.toUpperCase().contains("SPRING")) {
			   filteredTodos.add(todo);
		   }
	   }
	return filteredTodos;
   }
}
