package mockito.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import mockito.business.TodoBusiness;
import mockito.todo.TodoService;

public class TodoBusinessMockTest {

	@Test
	public void testRetrieveTodosRelatedToSpringUsingMock() {
		 TodoService todoServiceMock = mock(TodoService.class);
		 
		 List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn Dance");
		 when(todoServiceMock.retiveTodos("Dummy")).thenReturn(todos);
		 
		 TodoBusiness todobusinessImpl = new TodoBusiness(todoServiceMock);
		List<String> filteredTodos = todobusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}

}
