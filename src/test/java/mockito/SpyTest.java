package mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void test() {
		List listMocked = mock(ArrayList.class);
		//mocks return default value
		assertEquals(0, listMocked.size());
		
		stub(listMocked.size()).toReturn(5);
		listMocked.add("DontEffectonStub");
		
		assertEquals(5, listMocked.size());
	}

}
