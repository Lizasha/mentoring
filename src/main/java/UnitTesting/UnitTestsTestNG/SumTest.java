package UnitTesting.UnitTestsTestNG;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest extends BaseTest {

	@Test(dataProvider="dataSumTwoValues")
	public void addTwoValues(long firstValue, long secondValue, long expectedValue) {
		long result = calculator.sum(firstValue, secondValue);
		Assert.assertEquals(result, expectedValue,"Result isn't correct!");
	}

	@DataProvider(name="dataSumTwoValues")
	public Object[][] valuesForSum() {
		return new Object[][] {
				{10,23,33},
				{10,-1,9},
				{0,0,0},
				{-1,10,9},
				{100000,1000000,1100000}
		};
	}
}
