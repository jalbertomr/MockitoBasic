package mockito.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import mockito.business.TodoBusiness;
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

}
