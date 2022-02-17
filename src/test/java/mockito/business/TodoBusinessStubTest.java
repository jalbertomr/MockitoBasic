package mockito.business;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import mockito.todo.TodoService;
import mockito.todo.impl.TodoServiceImplStub;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ TodoServiceImplStub.class }) //Class that has the static method to mock
public class TodoBusinessStubTest {

	@Test
	public void testRetrieveTodosRelatedToSpringUsingStub() {
		TodoService todoService = new TodoServiceImplStub();
		TodoBusiness todobusinessImpl = new TodoBusiness(todoService);
		List<String> filteredTodos = todobusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void privateOrFinalMethodTest() throws Exception {
		
	   //ToDo Replace this mock with Mock, InjectMocks	
	   TodoService todoService = mock(TodoServiceImplStub.class);
	   
	   //when(todoService.privateRetriveTodos("X_User")).thenReturn(Arrays.asList("Private Method never seen to be mocked","or Final methods"));
	   
	  List<String> listTodos = Whitebox.invokeMethod(todoService,"privateRetriveTodos","X_user");
	   assertEquals("1 from private method", listTodos.get(0) );
	}
	
	@Test
	public void staticMethod_PowerMockedTest() {
		
		PowerMockito.mockStatic(TodoServiceImplStub.class);
		
		when(TodoServiceImplStub.staticRetrieveATodo(anyString())).thenReturn("otherTodo");
		
		assertEquals("otherTodo", TodoServiceImplStub.staticRetrieveATodo("X_user"));
		
		String todo = TodoServiceImplStub.staticRetrieveATodo("X_user");
		assertEquals("otherTodo", todo);
		
		PowerMockito.verifyStatic(Mockito.times(2));
		TodoServiceImplStub.staticRetrieveATodo("X_user");
	}
	
}
