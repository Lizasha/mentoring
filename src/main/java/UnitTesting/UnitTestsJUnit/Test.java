package UnitTesting.UnitTestsJUnit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class Test extends BaseTestJunit {

	private long firstValue;
	private long secondValue;
	private long expectedResult;

	public Test(long firstValue, long secondValue, long expectedResult) {
		this.firstValue = firstValue;
		this.secondValue = secondValue;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> valuesForDiv() {
		return Arrays.asList(new Object[][] {
				{55,6,9},
				{10,10,0},
		}) ;
	}

	@org.junit.Test
	public void divOfTwoNumbersTest() {
		long actualResult = calculator.div(firstValue, secondValue);
		assertEquals("Test should be correct!", expectedResult, actualResult);
	}
}
