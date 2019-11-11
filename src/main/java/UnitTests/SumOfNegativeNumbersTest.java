package UnitTests;

import org.junit.Assert;
import org.junit.Test;

public class SumOfNegativeNumbersTest extends BaseTest {

	@Test
	public void SumOfNegativeTwoAndNegativeTwo() {
		double result = calculator.sum(-2, -2);
		boolean actual = (result == 0);
		Assert.assertTrue("Result should be zero!", actual);
	}

}
