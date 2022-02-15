package mockito.todo;

import java.util.List;

public interface TodoService {
   public List<String> retiveTodos(String user);
   public void deleteTodo(String todo);
}
