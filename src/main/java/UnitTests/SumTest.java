package UnitTests;

import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.DataProvider;

public class SumTest extends BaseTest {

	@Test() //data provider doesn't work, ask mentor
	public void AddTwoValues(long firstValue, long secondValue, long expectedValue) {
		long result = calculator.sum(firstValue,secondValue);
		boolean actual = (result == expectedValue);
		Assert.assertTrue("Result isn't correct!", actual);
	}

	@DataProvider(name = "valuesForSum")
	public Object[][] valuesForSum() {
		return new Object[][] {
				{10,23,33},
				{10,-1,9},
				{0,0,0},
				{-1,10,9}
		};
	}
}
