package mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void test() {
		List listSpyed = spy(ArrayList.class);
		//mocks return default value
		assertEquals(0, listSpyed.size());
		listSpyed.add("EffectonSpyed");
		assertEquals(1, listSpyed.size());
		listSpyed.remove("EffectonSpyed");
		assertEquals(0, listSpyed.size());
	}

}
