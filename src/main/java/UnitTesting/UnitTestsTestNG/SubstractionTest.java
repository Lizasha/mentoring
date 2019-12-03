package UnitTesting.UnitTestsTestNG;
import org.junit.Assert;
import org.junit.Test;

public class SubstractionTest extends BaseTest {

	@Test
	public void devisionByZero() {
		long result = calculator.div(34000,65000);
		boolean actual = (result == 0);
		Assert.assertTrue("Result should be zero", actual);
	}

}
