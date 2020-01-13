package UnitTesting.UnitTestsTestNG;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumOfNegativeNumbersTest extends BaseTest {

	@Test(dataProvider = "dataSumOfNegative")
	public void sumOfNegativeTwoAndNegativeTwo(long firstValue, long secondValue, long expectedValue) {
		double result = calculator.sum(firstValue, secondValue);
		boolean actual = (result == expectedValue);
		Assert.assertTrue(actual,"Result should be zero!");
	}

	@DataProvider(name = "dataSumOfNegative")
	public Object[][] valuesForSumOfNegative() {
		return new Object[][] {
				{-10,-23,-33},
				{-10,-1,-11},
				{0,0,0},
				{-1,-55,-56}
		};
	}

}
