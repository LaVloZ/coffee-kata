package lv.merrill.apprentissage.coffee.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class ExtendedComparableTest {

	private ExtendedComparable<Integer> zeroMock = (i) -> {
		return 0;
	};
	
	private ExtendedComparable<Integer> negativeMock = (i) -> {
		return -1;
	};
	
	private ExtendedComparable<Integer> positiveMock = (i) -> {
		return 1;
	};
	
	
	@Test
	public void oneIsBiggerThanOne() {
		
		boolean expected = false;
		boolean actual = zeroMock.isBiggerThan(1);
		
		assertThat("should be bigger", actual, is(equalTo(expected)));
	}
	
	// No time to make all unit test :(
}
