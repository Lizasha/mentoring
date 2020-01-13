package UnitTesting.UnitTestsTestNG;


import org.testng.Assert;
import org.testng.annotations.Test;

public class SqrtTest extends BaseTest {

	@Test
	public void sqrtFromTwentyFour() {
		double result = calculator.sqrt(64);
		boolean actual = (result == 8);
		Assert.assertTrue(actual, "Sqrt should be correct!");
	}
}
