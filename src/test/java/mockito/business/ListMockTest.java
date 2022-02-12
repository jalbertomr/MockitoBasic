package mockito.business;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListMockTest {

	@Test
	public void mockListSizeOneTimeCall() {
		List<String> listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}

	@Test
	public void mockListSizeManyTimesCall() {
		List<String> listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
	}

	@Test
	public void mockListSizeManyTimesCallDifferentReturnValues() {
		List<String> listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3).thenReturn(4);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
		assertEquals(4, listMock.size());
	}

	@Test
	public void mockListget() {
		List<String> listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("getting[0] element");
		assertEquals("getting[0] element", listMock.get(0));
		assertEquals(null, listMock.get(3));
	}

	@Test
	public void mockListArgumentMatching() {
		List<String> listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn("getting[0] element");
		assertEquals("getting[0] element", listMock.get(0));
		assertEquals("getting[0] element", listMock.get(3));
		assertEquals("getting[0] element", listMock.get(1000));
	}
	
	@Test(expected=RuntimeException.class)
	public void mockListThrowException() {
		List<String> listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Exception Throwed"));
		listMock.get(0);
	}
}
