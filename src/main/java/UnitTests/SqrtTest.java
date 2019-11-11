package UnitTests;

import org.junit.Assert;
import org.junit.Test;

public class SqrtTest extends BaseTest {

	@Test
	public void SqrtFromTwentyFour() {
		double result = calculator.sqrt(64);
		boolean actual = (result == 8);
		Assert.assertTrue("Sqrt should be correct!", actual);
	}
}
