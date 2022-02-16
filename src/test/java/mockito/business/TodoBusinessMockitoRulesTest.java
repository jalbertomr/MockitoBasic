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

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import mockito.todo.TodoService;

public class TodoBusinessMockitoRulesTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule(); 
	
	@Mock
	TodoService todoServiceMock;
	
	@InjectMocks
	TodoBusiness todoBusinessImpl;
	
	@Captor
	ArgumentCaptor<String> argumentCaptor;
	
	@Test
	public void testRetrieveTodosRelatedToSpringUsingMock() {
		 
		 List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn Dance");
		 when(todoServiceMock.retiveTodos("Dummy")).thenReturn(todos);
		 
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void mockito_usingBDD() {

		List<String> allTodos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn Dance");
	    
	    //given
	    	given(todoServiceMock.retiveTodos("Beto")).willReturn(allTodos);
	    //when
	       List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Beto");
  	    //then
	       assertThat(todos.size(), is(2));
	}

	
	@Test
	public void testdeleteTodosNotRelatedToSpring() {

		List<String> allTodos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn Dance");
		when(todoServiceMock.retiveTodos("Beto")).thenReturn(allTodos);
		
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Beto");
		
		verify(todoServiceMock, Mockito.never()).deleteTodo("Learn Spring MVC");
		verify(todoServiceMock, Mockito.never()).deleteTodo("Learn Spring");
		verify(todoServiceMock, Mockito.times(1)).deleteTodo("Learn Dance");
	}
	
	@Test
	public void captureArgument() {
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn Dance");
		when(todoServiceMock.retiveTodos("Beto")).thenReturn(allTodos);
		
		TodoBusiness todoBusiness = new TodoBusiness(todoServiceMock);
		todoBusiness.deleteTodosNotRelatedToSpring("Beto");
		
		Mockito.verify(todoServiceMock).deleteTodo( argumentCaptor.capture());
		assertEquals("Learn Dance", argumentCaptor.getValue());
	}

}
