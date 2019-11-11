package UnitTests;

import org.junit.Assert;
import org.junit.Test;

public class SumTest extends BaseTest {

	@Test
	public void AddTwoValues() {
		long result = calculator.sum(565,90000000);
		boolean actual = (result == 90000565);
		Assert.assertTrue("Result isn't correct!", actual);
	}
}
