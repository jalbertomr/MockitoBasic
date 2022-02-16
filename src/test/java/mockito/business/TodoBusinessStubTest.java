package mockito.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import mockito.todo.TodoService;
import mockito.todo.impl.TodoServiceImplStub;

public class TodoBusinessStubTest {

	@Test
	public void testRetrieveTodosRelatedToSpringUsingStub() {
		TodoService todoService = new TodoServiceImplStub();
		TodoBusiness todobusinessImpl = new TodoBusiness(todoService);
		List<String> filteredTodos = todobusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void privateOrFinalMethod() {
	   TodoService todoService = mock(TodoServiceImplStub.class);
	   /* private of final Method cannot be seened
	   when(todoService.privateRetriveTodos("X_User")).thenReturn(Arrays.asList("Private Method never seen to be mocked","or Final methods"));
	   */
	   assertTrue(true);
	}
	
	@Test
	public void staticMethod_cannotBeMockedTest() {
		//mock returns a no static instance
		TodoService todoService = mock(TodoServiceImplStub.class);
		//to call the staticMethod the mocked instance is not static
		//when(TodoServiceImplStub.staticRetrieveATodo("X_user")).thenReturn("otherTodo");
		
		String todo = TodoServiceImplStub.staticRetrieveATodo("X_user");
		assertEquals("OriginalStaticTodo", todo);
	}
}
