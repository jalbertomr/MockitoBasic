package mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void test() {
		List listSpyed = spy(ArrayList.class);
		// spy check if methods are or not called
		listSpyed.add("IsMethodWithParamCalled");
		verify(listSpyed).add("IsMethodWithParamCalled");
		verify(listSpyed, never()).add("CalledWithDifferentParam");
		verify(listSpyed, never()).clear();
	}

}
