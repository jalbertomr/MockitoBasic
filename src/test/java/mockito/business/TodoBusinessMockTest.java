package mockito.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.ArgumentCaptor;

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
	
	@Test
	public void mockito_usingBDD() {
		TodoService todoService = mock(TodoService.class);
	    TodoBusiness todoBusiness = new TodoBusiness(todoService);
	    List<String> allTodos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn Dance");
	    
	    //given
	    	given(todoService.retiveTodos("Beto")).willReturn(allTodos);
	    //when
	       List<String> todos = todoBusiness.retrieveTodosRelatedToSpring("Beto");
  	    //then
	       assertThat(todos.size(), is(2));
	}

	
	@Test
	public void testdeleteTodosNotRelatedToSpring() {
		TodoService todoService = mock(TodoService.class);
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn Dance");
		when(todoService.retiveTodos("Beto")).thenReturn(allTodos);
		
		TodoBusiness todobusiness = new TodoBusiness(todoService);
		todobusiness.deleteTodosNotRelatedToSpring("Beto");
		
		verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");
		verify(todoService, Mockito.never()).deleteTodo("Learn Spring");
		verify(todoService, Mockito.times(1)).deleteTodo("Learn Dance");
	}
	
	@Test
	public void captureArgument() {
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		
		TodoService todoService = mock(TodoService.class);
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn Dance");
		when(todoService.retiveTodos("Beto")).thenReturn(allTodos);
		
		TodoBusiness todoBusiness = new TodoBusiness(todoService);
		todoBusiness.deleteTodosNotRelatedToSpring("Beto");
		
		Mockito.verify(todoService).deleteTodo( argumentCaptor.capture());
		assertEquals("Learn Dance", argumentCaptor.getValue());
	}

}
