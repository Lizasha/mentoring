package UnitTesting.UnitTestsTestNG;


import org.testng.Assert;
import org.testng.annotations.Test;

public class SubstractionTest extends BaseTest {

	@Test
	public void devisionByZero() {
		long result = calculator.div(34000,65000);
		boolean actual = (result == 0);
		Assert.assertTrue(actual, "Result should be zero");
	}

}
