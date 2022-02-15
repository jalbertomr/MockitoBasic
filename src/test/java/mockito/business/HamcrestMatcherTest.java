package mockito.business;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Every.everyItem;


import org.junit.Test;

public class HamcrestMatcherTest {

	@Test
	public void basicHamcrestMatchers() {
		
		List<Integer> list = Arrays.asList(100, 130, 154, 97);
		//List
		assertThat(list, hasSize(4));
		assertThat(list, hasItems(100,154));
		assertThat(list, everyItem(greaterThan(90)));
		assertThat(list, everyItem(lessThan(200)));
		
		//String
		assertThat("", isEmptyString());
		assertThat(null, isEmptyOrNullString());
		
		//Array
		Integer[] arrInteger = {1, 2, 3};
		assertThat(arrInteger, arrayWithSize(3));
		assertThat(arrInteger, arrayContainingInAnyOrder(2,3,1));
		
	}

}
